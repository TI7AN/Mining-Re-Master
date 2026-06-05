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

import java.util.List;
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
    public static final ResourceKey<Enchantment> FREEZING = of("freezing");
    public static final ResourceKey<Enchantment> LEECHING = of("leeching");
    public static final ResourceKey<Enchantment> SMELTING = of("smelting");
    public static final ResourceKey<Enchantment> STONEBREAKER = of( "stonebreaker");
    public static final ResourceKey<Enchantment> RUNNER = of( "runner");
    public static final ResourceKey<Enchantment> HEARTFELT = of( "heartfelt");
    public static final ResourceKey<Enchantment> FLOATATION = of( "floatation");
    public static final ResourceKey<Enchantment> KNIGHT_JUMP = of( "knight_jump");
    public static final ResourceKey<Enchantment> SNOWPIERCER = of( "snowpiercer");
    public static final ResourceKey<Enchantment> GRACE = of( "grace");

    public static final List<ResourceKey<Enchantment>> ENCHANTMENTS_LIST = List.of(
            FREEZING,
            LEECHING,
            SMELTING,
            STONEBREAKER,
            RUNNER,
            HEARTFELT,
            FLOATATION,
            KNIGHT_JUMP,
            SNOWPIERCER,
            GRACE
    );

    public static void init() {
        MiningMaster.LOGGER.info("Enchantments registered");
    };

    private static ResourceKey<Enchantment> of(String id) {
        return ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.fromNamespaceAndPath(MiningMaster.MOD_ID, id));
    }
}
