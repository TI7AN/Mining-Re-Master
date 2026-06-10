package org.infernalstudios.miningmaster.events;

import dev.architectury.event.events.client.ClientTickEvent;
import net.minecraft.client.Minecraft;
import org.infernalstudios.miningmaster.access.LivingEntityAccessor;

public class KnightJumpClientTickEvent {
    private static boolean jumpPrevPressed = false;

    public static void init() {
        ClientTickEvent.CLIENT_POST.register(KnightJumpClientTickEvent::onTick);
    }

    private static void onTick(Minecraft mc) {
        if (mc.options.keyJump.isDown()) {
            if (!jumpPrevPressed) {
                assert mc.player != null;
                ((LivingEntityAccessor) mc.player).miningmaster$useKnightJump();
            }
            jumpPrevPressed = true;
        } else {
            jumpPrevPressed = false;
        }
    }
}
