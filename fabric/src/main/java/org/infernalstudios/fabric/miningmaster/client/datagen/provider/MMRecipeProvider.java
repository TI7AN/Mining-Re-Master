package org.infernalstudios.fabric.miningmaster.client.datagen.provider;

import java.util.concurrent.CompletableFuture;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;

public class MMRecipeProvider extends FabricRecipeProvider {
    public MMRecipeProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void buildRecipes(RecipeOutput recipeExporter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.ENCHANTED_GOLDEN_APPLE, 1)
                .pattern("ggg")
                .pattern("gag")
                .pattern("ggg")
                .define('g', Items.GOLD_BLOCK)
                .define('a', Items.APPLE)
                .unlockedBy(FabricRecipeProvider.getHasName(Items.APPLE), FabricRecipeProvider.has(Items.APPLE))
                .save(recipeExporter);
    }
}
