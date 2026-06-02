package org.infernalstudios.miningmaster.items;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class GemItem extends Item {
    public GemItem() {
        super(new Item.Properties());
    }

    @Override
    public void appendHoverText(
            ItemStack stack,
            Item.TooltipContext context,
            List<Component> tooltipComponents,
            TooltipFlag tooltipFlag
    ) {
        if (Screen.hasShiftDown()) {
            tooltipComponents.add(Component.literal("\u00A7dCombine with an item in a smithing table to enchant!"));
        } else {
            tooltipComponents.add(Component.literal("\u00A78Hold Shift for Instructions"));
        }
    }
}
