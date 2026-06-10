package org.infernalstudios.miningmaster.setup;

import org.infernalstudios.miningmaster.init.MMBiomeModifiers;
import org.infernalstudios.miningmaster.init.MMEvents;

public class MMCommonSetup {

    public static void init() {
        MMBiomeModifiers.init();
        MMEvents.init();
    }
}
