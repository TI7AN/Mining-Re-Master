package org.infernalstudios.miningmaster.setup;

import org.infernalstudios.miningmaster.init.*;
import org.infernalstudios.miningmaster.network.MMNetworkHandler;

public class MMRegistration {

    public static void init() {
//        MMBiomeModifications.init();
//        LifecycleEvent.SERVER_BEFORE_START.register(server -> {
//            // This ensures data packs and worldgen registries are fully loaded
//        });
        MMTabs.init();
        MMBlocks.init();
        MMItems.init();
        MMMenuTypes.init();
        MMBlockEntities.init();
        MMArmorMaterials.init();
        MMEnchantments.init();
        MMRecipes.init();
        MMFeatures.init();
        MMSounds.init();
        MMNetworkHandler.init();
    }
}
