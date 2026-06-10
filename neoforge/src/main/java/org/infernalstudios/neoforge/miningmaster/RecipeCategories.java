package org.infernalstudios.neoforge.miningmaster;

import net.neoforged.neoforge.client.event.RegisterRecipeBookCategoriesEvent;

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
