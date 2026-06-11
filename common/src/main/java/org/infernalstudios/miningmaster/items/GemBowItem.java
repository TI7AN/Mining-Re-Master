/*
 * Copyright 2021 Infernal Studios
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

package org.infernalstudios.miningmaster.items;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.Unit;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import org.infernalstudios.miningmaster.init.MMEnchantments;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Supplier;

public class GemBowItem extends BowItem {
    private final Pair<ResourceKey<Enchantment>, Integer>[] enchantments;

    @SafeVarargs
    public GemBowItem(Properties builder,  Pair<ResourceKey<Enchantment>, Integer>... enchantments) {
        super(builder);
        this.enchantments = enchantments;
    }

    @Override
    public void releaseUsing(ItemStack weaponStack, Level level, LivingEntity livingEntity, int timeCharged) {
        if (livingEntity instanceof Player player) {
            var speedMultiplier = 4.5f;

            Holder<Enchantment> infinityHolder = level.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getHolderOrThrow(Enchantments.INFINITY);
            boolean hasInfinity = player.getAbilities().instabuild || EnchantmentHelper.getItemEnchantmentLevel(infinityHolder, weaponStack) > 0;
            ItemStack itemStack = player.getProjectile(weaponStack);

            if (!itemStack.isEmpty() || hasInfinity) {
                if (itemStack.isEmpty()) {
                    itemStack = new ItemStack(Items.ARROW);
                }
            }

            if (!itemStack.isEmpty()) {
                int useDuration = this.getUseDuration(weaponStack, livingEntity) - timeCharged;
                float velocity = getPowerForTime(useDuration);
                if (!(velocity < 0.1)) {
                    List<ItemStack> list = draw(weaponStack, itemStack, player);
                    if (level instanceof ServerLevel serverLevel && !list.isEmpty()) {
                        this.shoot(serverLevel, player, player.getUsedItemHand(), weaponStack, list, velocity * speedMultiplier, 1.0F, velocity >= 1.0F, null);
                    }

                    level.playSound(
                            null,
                            player.getX(),
                            player.getY(),
                            player.getZ(),
                            SoundEvents.ARROW_SHOOT,
                            SoundSource.PLAYERS,
                            1.0F,
                            1.0F / (level.getRandom().nextFloat() * 0.4F + 1.2F) + velocity * 0.5F
                    );
                    player.awardStat(Stats.ITEM_USED.get(this));
                }
            }
        }
    }

    @Override
    protected void shoot(
            ServerLevel level,
            LivingEntity shooter,
            InteractionHand hand,
            ItemStack weapon,
            List<ItemStack> projectileItems,
            float velocity,
            float inaccuracy,
            boolean isCrit,
            @Nullable LivingEntity target
    ) {
        float projectileSpread = EnchantmentHelper.processProjectileSpread(level, weapon, shooter, 0.0F);
        float g = projectileItems.size() == 1 ? 0.0F : 2.0F * projectileSpread / (projectileItems.size() - 1);
        float h = (projectileItems.size() - 1) % 2 * g / 2.0F;
        float i = 1.0F;

        for (int j = 0; j < projectileItems.size(); j++) {
            ItemStack itemStack = (ItemStack) projectileItems.get(j);
            if (!itemStack.isEmpty()) {
                float angle = h + i * ((j + 1) / 2) * g;
                i = -i;
                Projectile projectile = this.createProjectile(level, shooter, weapon, itemStack, isCrit);
                this.shootProjectile(shooter, projectile, j, velocity, inaccuracy, angle, target);
                level.addFreshEntity(projectile);
                weapon.hurtAndBreak(this.getDurabilityUse(itemStack), shooter, LivingEntity.getSlotForHand(hand));
                if (weapon.isEmpty()) {
                    break;
                }
            }
        }
    }

    @Override
    protected Projectile createProjectile(Level level, LivingEntity shooter, ItemStack weaponStack, ItemStack ammo, boolean isCrit) {
        ArrowItem arrowItem2 = ammo.getItem() instanceof ArrowItem arrowItem ? arrowItem : (ArrowItem)Items.ARROW;
        AbstractArrow abstractArrow = arrowItem2.createArrow(level, ammo, shooter, weaponStack);
        abstractArrow.setBaseDamage((abstractArrow.getBaseDamage() / 1.5D) + 0.1D);
        if (isCrit) {
            abstractArrow.setCritArrow(true);
        }

        return abstractArrow;
    }

}
