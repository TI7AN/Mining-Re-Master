package org.infernalstudios.miningmaster.init;

import org.infernalstudios.miningmaster.events.GracePlayerTickEvent;
import org.infernalstudios.miningmaster.events.KnightJumpClientTickEvent;
import org.infernalstudios.miningmaster.events.RunnerPlayerTickEvent;
import org.infernalstudios.miningmaster.init.client.MMClientEvents;

public class MMEvents {
    public static void init() {
        GracePlayerTickEvent.init();
        RunnerPlayerTickEvent.init();
        MMClientEvents.init();
    }
}
