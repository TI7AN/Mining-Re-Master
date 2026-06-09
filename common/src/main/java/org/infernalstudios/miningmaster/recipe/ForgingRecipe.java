/*
 * Copyright 2021 Infernal Studios
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.infernalstudios.miningmaster.recipe;

import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.Level;
import org.infernalstudios.miningmaster.init.MMRecipes;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ForgingRecipe implements IForgingRecipe {
    private final Ingredient catalyst;
    private final NonNullList<Ingredient> gems;
    private final NonNullList<Pair<Holder<Enchantment>,Integer>> enchantments;
    private final ItemStack result;

    public ForgingRecipe(Ingredient catalyst, NonNullList<Ingredient> gems, NonNullList<Pair<Holder<Enchantment>,Integer>> enchantments, ItemStack result) {
        this.catalyst = catalyst;
        this.gems = gems;
        this.enchantments = enchantments;
        this.result = result;
    }

    public boolean matches(ForgingRecipeInput recipeInput, Level level) {
        boolean catalystMatches = this.catalyst.test(recipeInput.getItem(9));

        List<ItemStack> inputs = new ArrayList<>();

        for (int slot = 0; slot < 9; slot++) {
            ItemStack stack = recipeInput.getItem(slot);

            if (!stack.isEmpty()) {
                inputs.add(stack);
            }
        }

        int inputCount = inputs.size();

        return catalystMatches &&
                inputCount == this.gems.size() &&
                matchesShapeless(inputs, this.gems);
    }

    private static boolean matchesShapeless(List<ItemStack> inputs, List<Ingredient> ingredients) {
        if (inputs.size() != ingredients.size()) {
            return false;
        }

        boolean[] used = new boolean[inputs.size()];
        return matchRecursive(inputs, ingredients, used, 0);
    }

    private static boolean matchRecursive(
            List<ItemStack> inputs,
            List<Ingredient> ingredients,
            boolean[] used,
            int ingredientIndex
    ) {
        if (ingredientIndex >= ingredients.size()) {
            return true;
        }

        Ingredient ingredient = ingredients.get(ingredientIndex);

        for (int i = 0; i < inputs.size(); i++) {
            if (!used[i] && ingredient.test(inputs.get(i))) {
                used[i] = true;

                if (matchRecursive(inputs, ingredients, used, ingredientIndex + 1)) {
                    return true;
                }

                used[i] = false;
            }
        }

        return false;
    }

    public ItemStack getDefaultedOutput() {
        ItemStack itemstack = this.result.copy();

        for (var enchantment : this.enchantments) {
            itemstack.enchant(enchantment.getFirst(), enchantment.getSecond());
        }

        return itemstack;
    }

    @Override
    public ItemStack assemble(ForgingRecipeInput recipeInput, HolderLookup.Provider provider) {
        ItemStack source = recipeInput.getItem(9);
        ItemStack itemstack = this.result.copy();

        result.applyComponents(source.getComponentsPatch());

        for (var enchantment : this.enchantments) {
            itemstack.enchant(enchantment.getFirst(), enchantment.getSecond());
        }

        return itemstack;
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return width * height >= 2;
    }

    @Override
    public @NotNull ItemStack getResultItem(HolderLookup.Provider registries) {
        return this.result;
    }

//    @Override
//    public boolean isTemplateIngredient(ItemStack stack) {
//        return stack.is(Items.AIR);
//    }
//
//    @Override
//    public boolean isBaseIngredient(ItemStack stack) {
//        return !stack.is(MMTags.Items.GEM_ENCHANTING_BLACKLIST);
//    }
//
//    @Override
//    public boolean isAdditionIngredient(ItemStack stack) {
//        return stack.is(MMTags.Items.GEMS);
//    }

    @Override
    public @NotNull NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> ingredients = NonNullList.create();
        ingredients.addAll(this.gems);
        ingredients.add(this.catalyst);
        return ingredients;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return MMRecipes.FORGING_RECIPE.get();
    }

    @Override
    public @NotNull RecipeType<?> getType() {
        return MMRecipes.FORGING_RECIPE_TYPE;
    }

    public static class ForgingRecipeType implements RecipeType<ForgingRecipe> {
        @Override
        public String toString() {
            return ForgingRecipe.TYPE_ID.toString();
        }
    }

    public static class ForgingRecipeSerializer implements RecipeSerializer<ForgingRecipe> {
        public static final Codec<Pair<Holder<Enchantment>, Integer>> ENCHANTMENT_CODEC =
                RecordCodecBuilder.create(instance -> instance.group(
                        Enchantment.CODEC.fieldOf("enchantment")
                                .forGetter(Pair::getFirst),
                        Codec.INT.fieldOf("lvl")
                                .forGetter(Pair::getSecond)
                ).apply(instance, Pair::of));

        public static final StreamCodec<RegistryFriendlyByteBuf, Pair<Holder<Enchantment>, Integer>>
                ENCHANTMENT_STREAM_CODEC =
                StreamCodec.composite(
                        ByteBufCodecs.holderRegistry(Registries.ENCHANTMENT),
                        Pair::getFirst,

                        ByteBufCodecs.INT,
                        Pair::getSecond,

                        Pair::of
                );

        public static final MapCodec<ForgingRecipe> CODEC =
                RecordCodecBuilder.mapCodec(instance ->
                        instance.group(
                                Ingredient.CODEC.fieldOf("catalyst")
                                        .forGetter(r -> r.catalyst),

                                Ingredient.CODEC.listOf().fieldOf("gems")
                                        .forGetter(r -> List.copyOf(r.gems)),

                                ENCHANTMENT_CODEC.listOf().fieldOf("enchantments")
                                        .forGetter(r -> List.copyOf(r.enchantments)),

                                ItemStack.CODEC.fieldOf("result")
                                        .forGetter(r -> r.result)
                        ).apply(
                                instance,
                                (catalyst, gems, enchantments, result) -> {
                                    NonNullList<Ingredient> NN_gems_List = NonNullList.create();
                                    NN_gems_List.addAll(gems);
                                    NonNullList<Pair<Holder<Enchantment>, Integer>> NN_enchantment_List = NonNullList.create();
                                    NN_enchantment_List.addAll(enchantments);
                                    return new ForgingRecipe(catalyst, NN_gems_List, NN_enchantment_List, result);
                                }
                            )
                );

        public static final StreamCodec<RegistryFriendlyByteBuf, ForgingRecipe> STREAM_CODEC =
                StreamCodec.composite(
                        Ingredient.CONTENTS_STREAM_CODEC,
                        r -> r.catalyst,

                        Ingredient.CONTENTS_STREAM_CODEC.apply(ByteBufCodecs.list()),
                        r -> List.copyOf(r.gems),

                        ENCHANTMENT_STREAM_CODEC.apply(ByteBufCodecs.list()),
                        r -> List.copyOf(r.enchantments),

                        ItemStack.STREAM_CODEC,
                        r -> r.result,

                        (catalyst, gems, enchantments, result) -> {
                            NonNullList<Ingredient> gemList = NonNullList.create();
                            gemList.addAll(gems);

                            NonNullList<Pair<Holder<Enchantment>, Integer>> enchantmentList =
                                    NonNullList.create();
                            enchantmentList.addAll(enchantments);

                            return new ForgingRecipe(
                                    catalyst,
                                    gemList,
                                    enchantmentList,
                                    result
                            );
                        }
                );

        @Override
        public @NotNull MapCodec<ForgingRecipe> codec() {
            return CODEC;
        }

        @Override
        public @NotNull StreamCodec<RegistryFriendlyByteBuf, ForgingRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }
}
