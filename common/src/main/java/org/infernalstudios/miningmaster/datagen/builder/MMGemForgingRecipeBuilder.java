package org.infernalstudios.miningmaster.datagen.builder;

import com.mojang.datafixers.util.Pair;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.core.Holder;
import net.minecraft.core.NonNullList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.ItemLike;
import org.infernalstudios.miningmaster.MiningMaster;
import org.infernalstudios.miningmaster.recipe.GemForgingRecipe;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MMGemForgingRecipeBuilder {

    private final RecipeCategory category;
    private final Ingredient catalyst;
    private final NonNullList<Ingredient> gems = NonNullList.create();
    private final List<Pair<Holder<Enchantment>,Integer>> enchantments = NonNullList.create();
    private final Item result;
    private final Map<String, Criterion<?>> criteria = new LinkedHashMap();

    private MMGemForgingRecipeBuilder(RecipeCategory category, Ingredient catalyst, ItemLike result){
        this.category = category;
        this.catalyst = catalyst;
        this.result = result.asItem();
    }

    public static MMGemForgingRecipeBuilder forging(RecipeCategory category, Ingredient catalyst, ItemLike result){
        return new MMGemForgingRecipeBuilder(category, catalyst, result);
    }

    public MMGemForgingRecipeBuilder requires(TagKey<Item> tag) {
        return this.requires(Ingredient.of(tag));
    }

    public MMGemForgingRecipeBuilder requires(ItemLike gem) {
        return this.requires(gem, 1);
    }

    public MMGemForgingRecipeBuilder requires(ItemLike gem, int quantity) {
        for (int i = 0; i < quantity; i++) {
            this.requires(Ingredient.of(gem));
        }
        return this;
    }

    public MMGemForgingRecipeBuilder requires(Ingredient gem) {
        return this.requires(gem, 1);
    }

    public MMGemForgingRecipeBuilder requires(Ingredient gem, int quantity) {
        for (int i = 0; i < quantity; i++) {
            this.gems.add(gem);
        }
        return this;
    }

    public MMGemForgingRecipeBuilder withEnchantment(Holder<Enchantment> enchantment, int level) {
        this.enchantments.add(Pair.of(enchantment, level));
        return this;
    }

    public MMGemForgingRecipeBuilder unlocks(String key, Criterion<?> criterion) {
        this.criteria.put(key, criterion);
        return this;
    }

    public void save(RecipeOutput recipeOutput) {

        ResourceLocation itemId = BuiltInRegistries.ITEM.getKey(result.asItem());

        ResourceLocation resourceLocation = ResourceLocation.fromNamespaceAndPath(
                        MiningMaster.MOD_ID,
                        itemId.getPath())
                .withPrefix("gem_forging/")
                .withSuffix("_gem_forging")
                ;

        save(recipeOutput, resourceLocation);
    }

    public void save(RecipeOutput recipeOutput, String recipeId) {
        ResourceLocation resourceLocation = ResourceLocation.fromNamespaceAndPath(
                        MiningMaster.MOD_ID,
                        recipeId)
                .withPrefix("gem_forging/")
                .withSuffix("_gem_forging")
                ;

        this.save(recipeOutput, resourceLocation);
    }

    public void save(RecipeOutput recipeOutput, ResourceLocation recipeId) {
        this.ensureValid(recipeId);
        Advancement.Builder builder = recipeOutput.advancement()
                .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(recipeId))
                .rewards(AdvancementRewards.Builder.recipe(recipeId))
                .requirements(AdvancementRequirements.Strategy.OR);
        this.criteria.forEach(builder::addCriterion);
        GemForgingRecipe gemForgingRecipe = new GemForgingRecipe(
                this.catalyst,
                this.gems,
                this.enchantments,
                new ItemStack(this.result)
        );
        recipeOutput.accept(recipeId, gemForgingRecipe, builder.build(recipeId.withPrefix("recipes/" + this.category.getFolderName() + "/")));
    }

    private void ensureValid(ResourceLocation location) {
        if (this.criteria.isEmpty()) {
            throw new IllegalStateException("No way of obtaining recipe " + location);
        }
    }
}
