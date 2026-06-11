package org.infernalstudios.miningmaster.init.client;

import dev.architectury.event.events.common.LifecycleEvent;
import dev.architectury.platform.Platform;
import dev.architectury.registry.item.ItemPropertiesRegistry;
import net.fabricmc.api.EnvType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import org.infernalstudios.miningmaster.init.MMItems;

public class MMItemProperties {

    public static void init() {
        if(Platform.getEnv() == EnvType.CLIENT)
            LifecycleEvent.SETUP.register( () ->
                    addCustomItemProperties()
            );
    }

    private static void addCustomItemProperties() {
        makeCustomBow(MMItems.AIR_MALACHITE_BOW.get());
    }

    public static void makeCustomBow(Item item) {
        ItemPropertiesRegistry.register(item, ResourceLocation.withDefaultNamespace("pull"),
                (stack,clientLevel,livingEntity,i) -> {
            if (livingEntity == null) {
                return 0.0F;
            } else {
                return livingEntity.getUseItem() != stack ? 0.0F : (stack.getUseDuration(livingEntity) - livingEntity.getUseItemRemainingTicks()) / 20.0F;
            }
        });
        ItemPropertiesRegistry.register(
                item,
                ResourceLocation.withDefaultNamespace("pulling"),
                (itemStack, clientLevel, livingEntity, i) -> livingEntity != null && livingEntity.isUsingItem() && livingEntity.getUseItem() == itemStack ? 1.0F : 0.0F
        );
    }
}
