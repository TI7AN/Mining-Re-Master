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

package org.infernalstudios.miningmaster.init;

//import dev.architectury.registry.registries.DeferredRegister;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
//import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import org.infernalstudios.miningmaster.MiningMaster;
//import org.infernalstudios.miningmaster.enchantments.FloatationEnchantment;
//import org.infernalstudios.miningmaster.enchantments.FreezingEnchantment;
//import org.infernalstudios.miningmaster.enchantments.GraceEnchantment;
//import org.infernalstudios.miningmaster.enchantments.HeartfeltEnchantment;
//import org.infernalstudios.miningmaster.enchantments.KnightJumpEnchantment;
//import org.infernalstudios.miningmaster.enchantments.LeechingEnchantment;
//import org.infernalstudios.miningmaster.enchantments.RunnerEnchantment;
//import org.infernalstudios.miningmaster.enchantments.SmeltingEnchantment;
//import org.infernalstudios.miningmaster.enchantments.SnowpiercerEnchantment;
//import org.infernalstudios.miningmaster.enchantments.StonebreakerEnchantment;

public class MMEnchantments {
//    public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, MiningMaster.MOD_ID);

    public static final ResourceKey<Enchantment> FREEZING =
            ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.fromNamespaceAndPath(MiningMaster.MOD_ID, "freezing"));
//            ENCHANTMENTS.register("freezing", () -> new FreezingEnchantment(Enchantment.Rarity.RARE, EquipmentSlot.MAINHAND));
    public static final ResourceKey<Enchantment> LEECHING =
        ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.fromNamespaceAndPath(MiningMaster.MOD_ID, "leeching"));
//        ENCHANTMENTS.register("leeching", () -> new LeechingEnchantment(Enchantment.Rarity.RARE, EquipmentSlot.MAINHAND));
    public static final ResourceKey<Enchantment> SMELTING =
        ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.fromNamespaceAndPath(MiningMaster.MOD_ID, "smelting"));
//            ENCHANTMENTS.register("smelting", () -> new SmeltingEnchantment(Enchantment.Rarity.RARE, EquipmentSlot.MAINHAND));
    public static final ResourceKey<Enchantment> STONEBREAKER =
        ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.fromNamespaceAndPath(MiningMaster.MOD_ID, "stonebreaker"));
//            ENCHANTMENTS.register("stonebreaker", () -> new StonebreakerEnchantment(Enchantment.Rarity.RARE, EquipmentSlot.MAINHAND));
    public static final ResourceKey<Enchantment> RUNNER =
        ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.fromNamespaceAndPath(MiningMaster.MOD_ID, "runner"));
//            ENCHANTMENTS.register("runner", () -> new RunnerEnchantment(Enchantment.Rarity.RARE, EquipmentSlot.FEET));
    public static final ResourceKey<Enchantment> HEARTFELT =
        ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.fromNamespaceAndPath(MiningMaster.MOD_ID, "heartfelt"));
//            ENCHANTMENTS.register("heartfelt", () -> new HeartfeltEnchantment(Enchantment.Rarity.RARE, EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET));
    public static final ResourceKey<Enchantment> FLOATATION =
        ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.fromNamespaceAndPath(MiningMaster.MOD_ID, "floatation"));
//            ENCHANTMENTS.register("floatation", () -> new FloatationEnchantment(Enchantment.Rarity.RARE, EquipmentSlot.MAINHAND));
    public static final ResourceKey<Enchantment> KNIGHT_JUMP =
        ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.fromNamespaceAndPath(MiningMaster.MOD_ID, "knight_jump"));
//            ENCHANTMENTS.register("knight_jump", () -> new KnightJumpEnchantment(Enchantment.Rarity.RARE, EquipmentSlot.LEGS));
    public static final ResourceKey<Enchantment> SNOWPIERCER =
        ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.fromNamespaceAndPath(MiningMaster.MOD_ID, "snowpiercer"));
//            ENCHANTMENTS.register("snowpiercer", () -> new SnowpiercerEnchantment(Enchantment.Rarity.RARE, EquipmentSlot.LEGS));
    public static final ResourceKey<Enchantment> GRACE =
        ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.fromNamespaceAndPath(MiningMaster.MOD_ID, "grace"));
//            ENCHANTMENTS.register("grace", () -> new GraceEnchantment(Enchantment.Rarity.RARE, EquipmentSlot.CHEST));

    public static void init() {
        MiningMaster.LOGGER.info("Enchantments registered");
    };
}
