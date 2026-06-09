package org.infernalstudios.miningmaster.client;

import dev.architectury.event.events.client.ClientLifecycleEvent;
import dev.architectury.registry.menu.MenuRegistry;
import org.infernalstudios.miningmaster.client.gui.screen.inventory.GemForgeScreen;
import org.infernalstudios.miningmaster.init.MMMenuTypes;
import org.infernalstudios.miningmaster.init.client.MMScreens;
import org.infernalstudios.miningmaster.setup.MMClientSetup;

public class MiningMasterClient {

    public static void init() {
        MMClientSetup.init();
    }
}
