package org.infernalstudios.neoforge.miningmaster.mixin;

import com.llamalad7.mixinextras.expression.Definition;
import com.llamalad7.mixinextras.expression.Expression;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.infernalstudios.miningmaster.MiningMaster;
import org.infernalstudios.miningmaster.init.MMEnchantments;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(Player.class)
public class PlayerMixin {

    @Definition(id = "hurt", method = "Lnet/minecraft/world/entity/Entity;hurt(Lnet/minecraft/world/damagesource/DamageSource;F)Z")
    @Expression("? = ?.hurt(?, ?)")
    @Inject(method = "attack", at = @At(value = "MIXINEXTRAS:EXPRESSION", shift = At.Shift.AFTER), locals = LocalCapture.CAPTURE_FAILSOFT)
    private void miningmaster$calculateEnchantEffects(
            Entity target,
            CallbackInfo ci
            , @Local(ordinal = 0) ItemStack weaponItemStack
            , @Local(ordinal = 0) float attackDamage
            , @Local(ordinal = 5) boolean wasTargetHurt
    ) {
        if (wasTargetHurt) {
            MiningMaster.LOGGER.info("wasTargetHurt Called Player.attack()");
            var registryAccess = ((Player) (Object) this).level().registryAccess();
            int leechingLevel = weaponItemStack.getEnchantments().getLevel(
                    registryAccess.lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(MMEnchantments.LEECHING)
            );
            int freezingLevel = weaponItemStack.getEnchantments().getLevel(
                    registryAccess.lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(MMEnchantments.FREEZING)
            );
            MiningMaster.LOGGER.info("freezingLevel: " + freezingLevel + " leechingLevel: " + leechingLevel);


            if (leechingLevel > 0) {
                miningmaster$applyLeechingEffects(leechingLevel, attackDamage);
            }
            if (freezingLevel > 0
//                    TODO this should be data driven
//                    && !(mainHandItemStack.getItem() instanceof BowItem || mainHandItemStack.getItem() instanceof CrossbowItem)
            )
            {
                miningmaster$applyFreezingEffects(freezingLevel, target);
            }
        }
    }

    private void miningmaster$applyFreezingEffects(int level, Entity target) {
        if (target instanceof LivingEntity livingTarget && !livingTarget.level().isClientSide() && !livingTarget.isDeadOrDying()) {
            livingTarget.setTicksFrozen(Math.max(livingTarget.getTicksFrozen(), livingTarget.getTicksRequiredToFreeze() + 120 * level));
        }
    }

    private void miningmaster$applyLeechingEffects(int level, float damageAmount) {
        ((Player) (Object) this).heal(damageAmount * 0.075F * level);
    }

}
