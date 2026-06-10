/*
 * Copyright 2022 Infernal Studios
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.infernalstudios.miningmaster.mixin;

import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import org.infernalstudios.miningmaster.init.MMEnchantments;
import org.infernalstudios.miningmaster.access.LivingEntityAccessor;
import org.infernalstudios.miningmaster.network.DamageKnightJumpPacket;
import org.infernalstudios.miningmaster.network.MMNetworkHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class MixinLivingEntity extends Entity implements LivingEntityAccessor {
    @Shadow
    public abstract void jumpFromGround();

    @Shadow public abstract ItemStack getItemBySlot(EquipmentSlot slotIn);

    @Unique
    private int knightJumpsUsed = 0;

    @Unique
    private static final EntityDataAccessor<Boolean> GRACE_RECHARGED = SynchedEntityData.defineId(LivingEntity.class, EntityDataSerializers.BOOLEAN);

    @Inject(method = "aiStep", at = @At(value = "HEAD"))
    private void miningmaster$countTicksFalling(CallbackInfo ci) {
        if (this.onGround()) {
            this.knightJumpsUsed = 0;
        }
    }

    public MixinLivingEntity(EntityType<?> entityTypeIn, Level level) {
        super(entityTypeIn, level);
    }

    public void miningmaster$useKnightJump() {
        if (!this.onGround()) {
            var registryAccess = this.level().registryAccess();

            ItemStack stack = this.getItemBySlot(EquipmentSlot.LEGS);
            if (stack.is(Items.AIR)) {
                return;
            }

            int knightJumpLevel = stack.getEnchantments().getLevel(
                    registryAccess.lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(MMEnchantments.KNIGHT_JUMP)
            );

            if (knightJumpLevel > 0 && this.knightJumpsUsed < knightJumpLevel) {
                this.knightJumpsUsed++;

                MMNetworkHandler.sendToServer(new DamageKnightJumpPacket(1));

                this.jumpFromGround();
            }
        }
    }

    @Inject(at = @At("RETURN"), method = "defineSynchedData")
    private void miningmaster$registerData(SynchedEntityData.Builder builder, CallbackInfo ci) {
        builder.define(GRACE_RECHARGED, true);
    }

    @Inject(at = @At("RETURN"), method = "addAdditionalSaveData")
    private void miningmaster$writeAdditionalData(CompoundTag compound, CallbackInfo ci) {
        compound.putBoolean("GraceRecharged", ((LivingEntity) (Object) this).getEntityData().get(GRACE_RECHARGED));
    }

    @Inject(at = @At("RETURN"), method = "readAdditionalSaveData")
    private void miningmaster$readAdditionalData(CompoundTag compound, CallbackInfo ci) {
        miningmaster$setGraceRecharged(compound.getBoolean("GraceRecharged"));
    }

    @Override
    public void miningmaster$setGraceRecharged(boolean isGraceRecharged) {
        ((LivingEntity) (Object) this).getEntityData().set(GRACE_RECHARGED, isGraceRecharged);
    }

    @Override
    public boolean miningmaster$getGraceRecharged() {
        return ((LivingEntity) (Object) this).getEntityData().get(GRACE_RECHARGED);
    }
}
