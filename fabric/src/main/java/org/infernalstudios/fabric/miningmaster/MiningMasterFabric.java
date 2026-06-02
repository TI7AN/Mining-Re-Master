package org.infernalstudios.fabric.miningmaster;

import net.fabricmc.api.ModInitializer;

import org.infernalstudios.miningmaster.MiningMaster;

public final class MiningMasterFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        // Run our common setup.
        MiningMaster.init();
    }
}
