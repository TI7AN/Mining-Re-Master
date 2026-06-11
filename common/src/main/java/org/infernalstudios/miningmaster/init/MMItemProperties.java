package org.infernalstudios.miningmaster.init;

import dev.architectury.registry.item.ItemPropertiesRegistry;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

public class MMItemProperties {

    public static void init() {
        addCustomItemProperties();
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
