package org.infernalstudios.miningmaster.init.client;

import net.minecraft.client.RecipeBookCategories;
import org.infernalstudios.miningmaster.MiningMaster;

public class MMRecipeCategories {

    public static final RecipeBookCategories GEM_FORGING_SEARCH =
            RecipeBookCategories.valueOf("MININGMASTER_GEM_FORGING_SEARCH");
    public static final RecipeBookCategories GEM_FORGING_WEAPONS =
            RecipeBookCategories.valueOf("MININGMASTER_GEM_FORGING_WEAPONS");
    public static final RecipeBookCategories GEM_FORGING_TOOLS =
            RecipeBookCategories.valueOf("MININGMASTER_GEM_FORGING_TOOLS");
    public static final RecipeBookCategories GEM_FORGING_ARMOR =
            RecipeBookCategories.valueOf("MININGMASTER_GEM_FORGING_ARMOR");

    public static void init() {
        MiningMaster.LOGGER.info("Initialized custom RecipeBookCategories");
    }
}
