package org.infernalstudios.neoforge.miningmaster;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.RecipeBookCategories;
import net.minecraft.world.inventory.RecipeBookType;
import net.neoforged.neoforge.client.event.RegisterRecipeBookCategoriesEvent;
import org.infernalstudios.miningmaster.init.MMRecipes;
import org.infernalstudios.miningmaster.recipe.ForgingRecipe;

public class RecipeCategories {

//    public static RecipeBookCategories GEM_FORGING = RecipeBookCategories.valueOf("MININGMASTER_GEM_FORGING_CATEGORY");

    public static void init(RegisterRecipeBookCategoriesEvent event) {
//        event.registerBookCategories(RecipeBookType.valueOf("MININGMASTER_GEM_FORGING"), ImmutableList.of(GEM_FORGING));
////        event.registerAggregateCategory(GEM_FORGING, ImmutableList.of(GEM_FORGING));
//        event.registerRecipeCategoryFinder(MMRecipes.FORGING_RECIPE_TYPE, recipe ->
//        {
//            return GEM_FORGING;
//        });
    }
}
