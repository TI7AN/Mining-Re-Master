package org.infernalstudios.miningmaster;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.infernalstudios.miningmaster.init.*;

public final class MiningMaster {
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "miningmaster";

    public static void init() {
//        MMBlockEntities.init();
        MMArmorMaterials.ARMOR_MATERIALS.register();
        MMBlocks.BLOCKS.register();
        MMItems.ITEMS.register();
//        MMContainerTypes.init();
        MMEnchantments.init();
        MMRecipes.RECIPE_SERIALIZERS.register();
        MMFeatures.FEATURES.register();
//        MMSounds.init();
//        MMTileEntityTypes.init();
    }
}
