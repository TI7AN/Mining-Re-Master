/*
 * Copyright 2022 Infernal Studios
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

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.RegistryFixedCodec;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import net.minecraft.world.level.Level;
import org.infernalstudios.miningmaster.MiningMaster;
import org.infernalstudios.miningmaster.init.MMRecipes;
import org.infernalstudios.miningmaster.init.MMTags;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class GemSmithingRecipe implements SmithingRecipe {

    final Ingredient blacklist;
    final Ingredient gem;
    final List<Holder<Enchantment>> enchantments;

    public GemSmithingRecipe(Ingredient blacklist, Ingredient gem, List<Holder<Enchantment>> enchantments) {
        this.blacklist = blacklist;
        this.gem = gem;
        this.enchantments = enchantments;
    }

    @Override
    public boolean matches(SmithingRecipeInput recipeInput, Level level) {
        if (level.isClientSide()) return false;

        return !this.blacklist.test(recipeInput.getItem(1)) &&
                this.gem.test(recipeInput.getItem(2)) &&
                assemble(recipeInput, level.registryAccess()) != null;
    }

    @Override
    public @NotNull ItemStack assemble(SmithingRecipeInput input, HolderLookup.Provider provider) {

        ItemStack result = input.getItem(1).copy();
        int gem_count = input.getItem(2).getCount();

        if (result.isEmpty()) {
            return ItemStack.EMPTY;
        }

        boolean enchanted = false;

        for (Holder<Enchantment> enchantment : enchantments) {
            if (!enchantment.value().canEnchant(result)) continue;
            if (!areEnchantsCompatible(result, enchantment)) continue;

            ItemEnchantments current = EnchantmentHelper.getEnchantmentsForCrafting(result);
            int level = current.getLevel(enchantment);

            if (level >= enchantment.value().getMaxLevel()) break;
            int upgraded_level = Math.min(level + gem_count, enchantment.value().getMaxLevel());
            ItemEnchantments.Mutable mutable = new ItemEnchantments.Mutable(current);
            mutable.set(enchantment, upgraded_level);
            EnchantmentHelper.setEnchantments(
                    result,
                    mutable.toImmutable()
            );
            enchanted = true;
        }

        return enchanted ? result : ItemStack.EMPTY;
    }

    public int getGemCost(ItemStack gemStack, ItemStack input) {
        int gem_count = gemStack.getCount();
        int cost = 0;
        for (Holder<Enchantment> enchantment : enchantments) {
            if (!enchantment.value().canEnchant(input)) continue;
            if (!areEnchantsCompatible(input, enchantment)) continue;

            ItemEnchantments current = EnchantmentHelper.getEnchantmentsForCrafting(input);
            int level = current.getLevel(enchantment);

            if (level >= enchantment.value().getMaxLevel()) break;
            int upgraded_level = Math.min(level + gem_count, enchantment.value().getMaxLevel());
            cost = Math.max(cost, upgraded_level - level);
        }

        return cost;
    }

//    private boolean areEnchantsCompatible(ItemStack itemStack, Enchantment enchant) {
//        Map<Enchantment, Integer> map = EnchantmentHelper.getEnchantments(itemStack);
//        for (Enchantment e : map.keySet()) {
//            if (enchant != e && !enchant.isCompatibleWith(e)) {
//                return false;
//            }
//        }
//
//        return true;
//    }

    private boolean areEnchantsCompatible(ItemStack stack, Holder<Enchantment> enchantment) {
        ItemEnchantments enchantments = EnchantmentHelper.getEnchantmentsForCrafting(stack);

        for (Holder<Enchantment> existing : enchantments.keySet()) {
            if (!existing.equals(enchantment)
                    && !Enchantment.areCompatible(existing, enchantment)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return width * height >= 2;
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider provider) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean isTemplateIngredient(ItemStack stack) {
        return stack.is(Items.AIR);
    }

    @Override
    public boolean isBaseIngredient(ItemStack stack) {
        return true;
//        return !stack.is(MMTags.Items.GEM_ENCHANTING_BLACKLIST);
    }

    @Override
    public boolean isAdditionIngredient(ItemStack stack) {
        return true;
//        return stack.is(MMTags.Items.GEMS);
    }

    @Override
    public @NotNull RecipeSerializer<?> getSerializer() {
        return MMRecipes.GEM_SMITHING_RECIPE_SERIALIZER.get();
    }

    @Override
    public @NotNull RecipeType<?> getType() {
        return RecipeType.SMITHING;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    public static class GemSmithingRecipeSerializer implements RecipeSerializer<GemSmithingRecipe> {

        public static final MapCodec<GemSmithingRecipe> CODEC =
                RecordCodecBuilder.mapCodec(instance ->
                        instance.group(
                                Ingredient.CODEC.fieldOf("blacklist")
                                        .forGetter(r -> r.blacklist),

                                Ingredient.CODEC.fieldOf("gem")
                                        .forGetter(r -> r.gem),

                                RegistryFixedCodec.create(Registries.ENCHANTMENT)
                                        .listOf()
                                        .fieldOf("enchantments")
                                        .forGetter(r -> r.enchantments)
                        ).apply(instance, GemSmithingRecipe::new)
                );

        public static final StreamCodec<RegistryFriendlyByteBuf, GemSmithingRecipe> STREAM_CODEC =
                StreamCodec.composite(
                        Ingredient.CONTENTS_STREAM_CODEC,
                        r -> r.blacklist,

                        Ingredient.CONTENTS_STREAM_CODEC,
                        r -> r.gem,

                        ByteBufCodecs.holderRegistry(Registries.ENCHANTMENT)
                                .apply(ByteBufCodecs.list()),
                        r -> r.enchantments,

                        GemSmithingRecipe::new
                );

        @Override
        public @NotNull MapCodec<GemSmithingRecipe> codec() {
            return CODEC;
        }

        @Override
        public @NotNull StreamCodec<RegistryFriendlyByteBuf, GemSmithingRecipe> streamCodec() {
            return STREAM_CODEC;
        }

    }
}
