package org.infernalstudios.miningmaster;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.infernalstudios.miningmaster.init.*;

public final class MiningMaster {
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "miningmaster";

    public static void init() {
//        MMArmorMaterials.init();
//        MMBlockEntities.init();
        MMBlocks.init();
//        MMContainerTypes.init();
//        MMEnchantments.init();
        MMItems.init();
        MMRecipes.init();
//        MMSounds.init();
//        MMTileEntityTypes.init();
    }
}
