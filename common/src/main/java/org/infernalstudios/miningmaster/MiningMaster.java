package org.infernalstudios.miningmaster;

import dev.architectury.event.events.client.ClientLifecycleEvent;
import dev.architectury.event.events.common.LifecycleEvent;
import dev.architectury.networking.NetworkManager;
import dev.architectury.registry.menu.MenuRegistry;
import net.minecraft.resources.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.infernalstudios.miningmaster.client.gui.screen.inventory.GemForgeScreen;
import org.infernalstudios.miningmaster.init.*;
import org.infernalstudios.miningmaster.network.MMNetworkHandler;
import org.infernalstudios.miningmaster.setup.MMRegistration;

import java.util.Locale;

public final class MiningMaster {
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "miningmaster";

    public static void init() {
        MMRegistration.init();
    }

    public static ResourceLocation prefix(String name) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, name.toLowerCase(Locale.ROOT));
    }
}
