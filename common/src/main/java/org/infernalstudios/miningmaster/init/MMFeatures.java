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

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
//import net.minecraftforge.eventbus.api.IEventBus;
//import net.minecraftforge.registries.DeferredRegister;
//import net.minecraftforge.registries.ForgeRegistries;
//import net.minecraftforge.registries.RegistryObject;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import org.infernalstudios.miningmaster.MiningMaster;
import org.infernalstudios.miningmaster.world.features.MalachiteMeteoriteFeature;
import org.infernalstudios.miningmaster.world.features.GemOreFeature;
import org.infernalstudios.miningmaster.world.features.config.MalachiteMeteoriteFeatureConfig;
import org.infernalstudios.miningmaster.world.features.config.GemOreFeatureConfig;

public class MMFeatures {

    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(MiningMaster.MOD_ID, Registries.FEATURE);

    public static final RegistrySupplier<Feature<GemOreFeatureConfig>> NATIVE_GEM_ORE_FEATURE = FEATURES.register("ore_gem_feature", () -> new GemOreFeature(GemOreFeatureConfig.CODEC));
    public static final RegistrySupplier<Feature<MalachiteMeteoriteFeatureConfig>> MALACHITE_METEORITE_FEATURE = FEATURES.register("malachite_meteorite_feature", () -> new MalachiteMeteoriteFeature(MalachiteMeteoriteFeatureConfig.CODEC));

    public static class PlacedFeatures {
        public static final ResourceKey<PlacedFeature> FIRE_RUBY_VEIN_PLACED_KEY = ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(MiningMaster.MOD_ID, "ore_fire_ruby_gem_placed"));
        public static final ResourceKey<PlacedFeature> ICE_SAPPHIRE_VEIN_PLACED_KEY = ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(MiningMaster.MOD_ID, "ore_ice_sapphire_gem_placed"));
        public static final ResourceKey<PlacedFeature> SPIRIT_GARNET_VEIN_PLACED_KEY = ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(MiningMaster.MOD_ID, "ore_spirit_garnet_gem_placed"));
        public static final ResourceKey<PlacedFeature> HASTE_PERIDOT_VEIN_PLACED_KEY = ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(MiningMaster.MOD_ID, "ore_haste_peridot_gem_placed"));
        public static final ResourceKey<PlacedFeature> LUCKY_CITRINE_VEIN_PLACED_KEY = ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(MiningMaster.MOD_ID, "ore_lucky_citrine_gem_placed"));
        public static final ResourceKey<PlacedFeature> DIVE_AQUAMARINE_VEIN_PLACED_KEY = ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(MiningMaster.MOD_ID, "ore_dive_aquamarine_gem_placed"));
        public static final ResourceKey<PlacedFeature> DIVINE_BERYL_VEIN_PLACED_KEY = ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(MiningMaster.MOD_ID, "ore_divine_beryl_gem_placed"));
        public static final ResourceKey<PlacedFeature> SPIDER_KUNZITE_VEIN_PLACED_KEY = ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(MiningMaster.MOD_ID, "ore_spider_kunzite_gem_placed"));
        public static final ResourceKey<PlacedFeature> UNBREAKING_IOLITE_VEIN_PLACED_KEY = ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(MiningMaster.MOD_ID, "ore_unbreaking_iolite_gem_placed"));
        public static final ResourceKey<PlacedFeature> HEART_RHODONITE_VEIN_PLACED_KEY = ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(MiningMaster.MOD_ID, "ore_heart_rhodonite_gem_placed"));
        public static final ResourceKey<PlacedFeature> POWER_PYRITE_VEIN_PLACED_KEY = ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(MiningMaster.MOD_ID, "ore_power_pyrite_gem_placed"));
        public static final ResourceKey<PlacedFeature> KINETIC_OPAL_VEIN_PLACED_KEY = ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(MiningMaster.MOD_ID, "ore_kinetic_opal_gem_placed"));
        public static final ResourceKey<PlacedFeature> AIR_MALACHITE_VEIN_PLACED_KEY = ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(MiningMaster.MOD_ID, "ore_air_malachite_gem_placed"));
    }

    public static class ConfiguredFeatures {

        public static final ResourceKey<ConfiguredFeature<?, ?>> FIRE_RUBY_VEIN_CONFIGURED_KEY = ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(MiningMaster.MOD_ID, "ore_fire_ruby_gem"));
        public static final ResourceKey<ConfiguredFeature<?, ?>> ICE_SAPPHIRE_VEIN_CONFIGURED_KEY = ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(MiningMaster.MOD_ID, "ore_ice_sapphire_gem"));
        public static final ResourceKey<ConfiguredFeature<?, ?>> SPIRIT_GARNET_VEIN_CONFIGURED_KEY = ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(MiningMaster.MOD_ID, "ore_spirit_garnet_gem"));
        public static final ResourceKey<ConfiguredFeature<?, ?>> HASTE_PERIDOT_VEIN_CONFIGURED_KEY = ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(MiningMaster.MOD_ID, "ore_haste_peridot_gem"));
        public static final ResourceKey<ConfiguredFeature<?, ?>> LUCKY_CITRINE_VEIN_CONFIGURED_KEY = ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(MiningMaster.MOD_ID, "ore_lucky_citrine_gem"));
        public static final ResourceKey<ConfiguredFeature<?, ?>> DIVE_AQUAMARINE_VEIN_CONFIGURED_KEY = ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(MiningMaster.MOD_ID, "ore_dive_aquamarine_gem"));
        public static final ResourceKey<ConfiguredFeature<?, ?>> DIVINE_BERYL_VEIN_CONFIGURED_KEY = ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(MiningMaster.MOD_ID, "ore_divine_beryl_gem"));
        public static final ResourceKey<ConfiguredFeature<?, ?>> SPIDER_KUNZITE_VEIN_CONFIGURED_KEY = ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(MiningMaster.MOD_ID, "ore_spider_kunzite_gem"));
        public static final ResourceKey<ConfiguredFeature<?, ?>> UNBREAKING_IOLITE_VEIN_CONFIGURED_KEY = ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(MiningMaster.MOD_ID, "ore_unbreaking_iolite_gem"));
        public static final ResourceKey<ConfiguredFeature<?, ?>> HEART_RHODONITE_VEIN_CONFIGURED_KEY = ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(MiningMaster.MOD_ID, "ore_heart_rhodonite_gem"));
        public static final ResourceKey<ConfiguredFeature<?, ?>> POWER_PYRITE_VEIN_CONFIGURED_KEY = ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(MiningMaster.MOD_ID, "ore_power_pyrite_gem"));
        public static final ResourceKey<ConfiguredFeature<?, ?>> KINETIC_OPAL_VEIN_CONFIGURED_KEY = ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(MiningMaster.MOD_ID, "ore_kinetic_opal_gem"));
        public static final ResourceKey<ConfiguredFeature<?, ?>> AIR_MALACHITE_VEIN_CONFIGURED_KEY = ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(MiningMaster.MOD_ID, "ore_air_malachite_gem"));
    }

    public static void init() {
        FEATURES.register();
        MiningMaster.LOGGER.info("Features registered");
    };

}
