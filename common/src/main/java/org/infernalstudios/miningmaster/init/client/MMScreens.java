package org.infernalstudios.miningmaster.init.client;

import dev.architectury.event.events.client.ClientLifecycleEvent;
import dev.architectury.event.events.common.EntityEvent;
import dev.architectury.registry.menu.MenuRegistry;
import org.infernalstudios.miningmaster.client.gui.screen.inventory.GemForgeScreen;
import org.infernalstudios.miningmaster.init.MMMenuTypes;

public class MMScreens {

    public static void init() {
        //This does not work on neoforge 1.21.1, TODO check compatibility on newer versions
//        MenuRegistry.registerScreenFactory(
//                MMMenuTypes.GEM_FORGE_MENU.get(),
//                GemForgeScreen::new
//        );
    }
}
