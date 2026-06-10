package org.infernalstudios.miningmaster.events;

import dev.architectury.event.events.common.TickEvent;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import org.infernalstudios.miningmaster.init.MMEnchantments;
import org.infernalstudios.miningmaster.access.LivingEntityAccessor;

public class GracePlayerTickEvent {

    public static void init() {
        TickEvent.PLAYER_POST.register(GracePlayerTickEvent::onPlayerTick);
    }

    private static void onPlayerTick(Player player) {
        RandomSource rand = player.getRandom();
        ItemStack stack = player.getItemBySlot(EquipmentSlot.CHEST);

        Holder<Enchantment> graceHolder = player.level().registryAccess()
                .registryOrThrow(Registries.ENCHANTMENT)
                .getHolderOrThrow(MMEnchantments.GRACE);

        int graceLevel = EnchantmentHelper.getItemEnchantmentLevel(graceHolder, stack);

        if (player.isInWater()) {
            if (graceLevel > 0) {
                if (player.hasEffect(MobEffects.DOLPHINS_GRACE) && !player.isCreative() && rand.nextInt(80) == 0) {
                    stack.hurtAndBreak(1, player, EquipmentSlot.CHEST);
                }

                if (((LivingEntityAccessor) player).miningmaster$getGraceRecharged()) {
                    player.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 100 * graceLevel));
                    ((LivingEntityAccessor) player).miningmaster$setGraceRecharged(false);
                }
            }
        } else if (!player.isInWater() && player.onGround() && !((LivingEntityAccessor) player).miningmaster$getGraceRecharged()) {
            ((LivingEntityAccessor) player).miningmaster$setGraceRecharged(true);
        }
    }
}
