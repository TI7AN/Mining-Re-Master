package org.infernalstudios.miningmaster.datagen.builder;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.enchantment.Enchantment;
import org.infernalstudios.miningmaster.MiningMaster;
import org.infernalstudios.miningmaster.recipe.GemSmithingRecipe;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MMGemSmithingRecipeBuilder {

    private final Ingredient blacklist;
    private final Ingredient gem;
    private final List<Holder<Enchantment>> enchantments;
    private final RecipeCategory category;
    private final Map<String, Criterion<?>> criteria = new LinkedHashMap();

    public MMGemSmithingRecipeBuilder(RecipeCategory category, Ingredient blacklist, Ingredient gem, List<Holder<Enchantment>> enchantments){
        this.blacklist = blacklist;
        this.gem = gem;
        this.enchantments = enchantments;
        this.category = category;
    }


    public static MMGemSmithingRecipeBuilder smithing(RecipeCategory category, Ingredient blacklist, Ingredient gem, List<Holder<Enchantment>> enchantments){
        return new MMGemSmithingRecipeBuilder(category, blacklist, gem, enchantments);
    }

    public MMGemSmithingRecipeBuilder unlocks(String key, Criterion<?> criterion) {
        this.criteria.put(key, criterion);
        return this;
    }

    public void save(RecipeOutput recipeOutput) {
//        ResourceLocation resourceLocation = RecipeBuilder.getDefaultRecipeId(
//                Arrays.stream(this.gem.getItems()).findFirst().get().getItem())
//                .withSuffix("_gem_smithing"
//        );

        ResourceLocation itemId = BuiltInRegistries.ITEM.getKey(
                Arrays.stream(this.gem.getItems())
                        .findFirst()
                        .get()
                        .getItem()
        );

        ResourceLocation resourceLocation = ResourceLocation.fromNamespaceAndPath(
                MiningMaster.MOD_ID,
                itemId.getPath())
                .withPrefix("smithing/")
                .withSuffix("_gem_smithing")
                ;

        save(recipeOutput, resourceLocation);
    }

    public void save(RecipeOutput recipeOutput, String recipeId) {
        this.save(recipeOutput, ResourceLocation.parse(recipeId));
    }

    public void save(RecipeOutput recipeOutput, ResourceLocation recipeId) {
        this.ensureValid(recipeId);
        Advancement.Builder builder = recipeOutput.advancement()
                .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(recipeId))
                .rewards(AdvancementRewards.Builder.recipe(recipeId))
                .requirements(AdvancementRequirements.Strategy.OR);
        this.criteria.forEach(builder::addCriterion);
        GemSmithingRecipe GemSmithingRecipe = new GemSmithingRecipe(this.blacklist, this.gem, this.enchantments);
        recipeOutput.accept(recipeId, GemSmithingRecipe, builder.build(recipeId.withPrefix("recipes/" + this.category.getFolderName() + "/")));
    }

    private void ensureValid(ResourceLocation location) {
        if (this.criteria.isEmpty()) {
            throw new IllegalStateException("No way of obtaining recipe " + location);
        }
    }
}
