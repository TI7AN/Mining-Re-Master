package org.infernalstudios.miningmaster.mixin;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import org.infernalstudios.miningmaster.init.MMEnchantments;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(LivingEntity.class)
public class HeartfeltLivingEntityMixin {

    @Inject(method = "hurt", at = @At("RETURN"))
    private void miningmaster$onEntityDamaged(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        if (cir.getReturnValue()) {
            if ((LivingEntity)((Object)this) instanceof ServerPlayer serverPlayer) {
                List<Pair<ItemStack, EquipmentSlot>> equipment = List.of(
                        new Pair(serverPlayer.getItemBySlot(EquipmentSlot.HEAD), EquipmentSlot.HEAD),
                        new Pair(serverPlayer.getItemBySlot(EquipmentSlot.CHEST), EquipmentSlot.CHEST),
                        new Pair(serverPlayer.getItemBySlot(EquipmentSlot.LEGS), EquipmentSlot.LEGS),
                        new Pair(serverPlayer.getItemBySlot(EquipmentSlot.FEET), EquipmentSlot.FEET)
                );
                for (Pair<ItemStack, EquipmentSlot> stack : equipment) {
                    Holder<Enchantment> heartfeltHolder = serverPlayer.level().registryAccess()
                            .registryOrThrow(Registries.ENCHANTMENT)
                            .getHolderOrThrow(MMEnchantments.HEARTFELT);

                    int heartfeltLevel = EnchantmentHelper.getItemEnchantmentLevel(heartfeltHolder, stack.getFirst());
                    if (heartfeltLevel > 0) {
                        stack.getFirst().hurtAndBreak(heartfeltLevel, serverPlayer, stack.getSecond());
                    }
                }
            }
        }
    }
}
