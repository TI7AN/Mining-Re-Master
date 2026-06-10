package org.infernalstudios.miningmaster.events;

import dev.architectury.event.events.common.TickEvent;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import org.infernalstudios.miningmaster.init.MMEnchantments;

public class RunnerPlayerTickEvent {
    public static void init() {
        TickEvent.PLAYER_POST.register(RunnerPlayerTickEvent::onPlayerTick);
    }

    private static void onPlayerTick(Player player) {
        if (player.isCreative()) return;

        RandomSource rand = player.getRandom();
        ItemStack stack = player.getItemBySlot(EquipmentSlot.FEET);

        Holder<Enchantment> runnerHolder = player.level().registryAccess()
                .registryOrThrow(Registries.ENCHANTMENT)
                .getHolderOrThrow(MMEnchantments.RUNNER);

        int runnerLevel = EnchantmentHelper.getItemEnchantmentLevel(runnerHolder, stack);

        if (player.isSprinting()) {
            if (runnerLevel > 0) {
                if (rand.nextInt(100) == 0) {
                    stack.hurtAndBreak(1, player, EquipmentSlot.FEET);
                }
            }
        }
    }
}
