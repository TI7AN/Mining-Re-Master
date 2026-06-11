package org.infernalstudios.fabric.miningmaster.datagen;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.random.WeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.util.valueproviders.WeightedListInt;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.heightproviders.BiasedToBottomHeight;
import net.minecraft.world.level.levelgen.heightproviders.TrapezoidHeight;
import net.minecraft.world.level.levelgen.heightproviders.UniformHeight;
import net.minecraft.world.level.levelgen.placement.*;
import org.infernalstudios.miningmaster.MiningMaster;
import org.infernalstudios.miningmaster.init.MMFeatures;

import java.util.List;

public class MMPlacedFeatures {

    public static void configure(BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        int commonCount = 5;
        int uncommonCount = 3;
        int rareCount = 1;

        List<PlacementModifier> rareOverworldGemVeinModifiers = List.of(
                CountPlacement.of(rareCount),
                InSquarePlacement.spread(),
                HeightRangePlacement.of(
                        TrapezoidHeight.of(
                                VerticalAnchor.absolute(-3),
                                VerticalAnchor.absolute(0)
                        )
                ),
                BiomeFilter.biome()
        );

        List<PlacementModifier> uncommonOverworldGemVeinModifiers = List.of(
                CountPlacement.of(uncommonCount),
                InSquarePlacement.spread(),
                HeightRangePlacement.of(
                        TrapezoidHeight.of(
                                VerticalAnchor.absolute(-40),
                                VerticalAnchor.absolute(30)
                        )
                ),
                BiomeFilter.biome()
        );

        List<PlacementModifier> commonOverworldGemVeinModifiers = List.of(
                CountPlacement.of(commonCount),
                InSquarePlacement.spread(),
                HeightRangePlacement.of(
                        TrapezoidHeight.of(
                                VerticalAnchor.absolute(-50),
                                VerticalAnchor.absolute(10)
                        )
                ),
                BiomeFilter.biome()
        );

        List<PlacementModifier> rareNetherGemVeinModifiers = List.of(
                CountPlacement.of(rareCount),
                InSquarePlacement.spread(),
                HeightRangePlacement.of(
                        TrapezoidHeight.of(
                                VerticalAnchor.absolute(0),
                                VerticalAnchor.absolute(10)
                        )
                ),
                BiomeFilter.biome()
        );

        List<PlacementModifier> uncommonNetherGemVeinModifiers = List.of(
                CountPlacement.of(uncommonCount),
                InSquarePlacement.spread(),
                HeightRangePlacement.of(
                        TrapezoidHeight.of(
                                VerticalAnchor.absolute(0),
                                VerticalAnchor.absolute(60)
                        )
                ),
                BiomeFilter.biome()
        );

        List<PlacementModifier> commonNetherGemVeinModifiers = List.of(
                CountPlacement.of(commonCount),
                InSquarePlacement.spread(),
                HeightRangePlacement.of(
                        TrapezoidHeight.of(
                                VerticalAnchor.absolute(0),
                                VerticalAnchor.absolute(80)
                        )
                ),
                BiomeFilter.biome()
        );

        List<PlacementModifier> malachiteMeteoriteModifiers = List.of(
                RarityFilter.onAverageOnceEvery(28),
                CountPlacement.of(
                        new WeightedListInt(
                                SimpleWeightedRandomList.<IntProvider>builder()
                                        .add(ConstantInt.of(1), 3)
                                        .add(ConstantInt.of(2), 1)
                                        .build()
                        )
                ),
                InSquarePlacement.spread(),
                HeightRangePlacement.of(
                        UniformHeight.of(
                                VerticalAnchor.absolute(55),
                                VerticalAnchor.absolute(70)
                        )
                ),
                BiomeFilter.biome()
        );

        context.register(
                MMFeatures.PlacedFeatures.RANDOM_GEM_OVERWORLD_VEIN_PLACED_KEY,
                new PlacedFeature(
                        configuredFeatures.getOrThrow(MMFeatures.ConfiguredFeatures.RANDOM_GEM_VEIN_CONFIGURED_KEY),
                        uncommonOverworldGemVeinModifiers
                )
        );

        context.register(
                MMFeatures.PlacedFeatures.RANDOM_GEM_NETHER_VEIN_PLACED_KEY,
                new PlacedFeature(
                        configuredFeatures.getOrThrow(MMFeatures.ConfiguredFeatures.RANDOM_GEM_VEIN_CONFIGURED_KEY),
                        uncommonNetherGemVeinModifiers
                )
        );

        context.register(
                MMFeatures.PlacedFeatures.FIRE_RUBY_VEIN_PLACED_KEY,
                new PlacedFeature(
                        configuredFeatures.getOrThrow(MMFeatures.ConfiguredFeatures.FIRE_RUBY_VEIN_CONFIGURED_KEY),
                        uncommonOverworldGemVeinModifiers
                )
        );


        context.register(
                MMFeatures.PlacedFeatures.ICE_SAPPHIRE_VEIN_PLACED_KEY,
                new PlacedFeature(
                        configuredFeatures.getOrThrow(MMFeatures.ConfiguredFeatures.ICE_SAPPHIRE_VEIN_CONFIGURED_KEY),
                        commonOverworldGemVeinModifiers
                )
        );


        context.register(
                MMFeatures.PlacedFeatures.SPIRIT_GARNET_VEIN_PLACED_KEY,
                new PlacedFeature(
                        configuredFeatures.getOrThrow(MMFeatures.ConfiguredFeatures.SPIRIT_GARNET_VEIN_CONFIGURED_KEY),
                        commonOverworldGemVeinModifiers
                )
        );


        context.register(
                MMFeatures.PlacedFeatures.HASTE_PERIDOT_VEIN_PLACED_KEY,
                new PlacedFeature(
                        configuredFeatures.getOrThrow(MMFeatures.ConfiguredFeatures.HASTE_PERIDOT_VEIN_CONFIGURED_KEY),
                        uncommonOverworldGemVeinModifiers
                )
        );


        context.register(
                MMFeatures.PlacedFeatures.LUCKY_CITRINE_VEIN_PLACED_KEY,
                new PlacedFeature(
                        configuredFeatures.getOrThrow(MMFeatures.ConfiguredFeatures.LUCKY_CITRINE_VEIN_CONFIGURED_KEY),
                        uncommonOverworldGemVeinModifiers
                )
        );

        context.register(
                MMFeatures.PlacedFeatures.DIVE_AQUAMARINE_VEIN_PLACED_KEY,
                new PlacedFeature(
                        configuredFeatures.getOrThrow(MMFeatures.ConfiguredFeatures.DIVE_AQUAMARINE_VEIN_CONFIGURED_KEY),
                        commonOverworldGemVeinModifiers
                )
        );

        context.register(
                MMFeatures.PlacedFeatures.DIVINE_BERYL_VEIN_PLACED_KEY,
                new PlacedFeature(
                        configuredFeatures.getOrThrow(MMFeatures.ConfiguredFeatures.DIVINE_BERYL_VEIN_CONFIGURED_KEY),
                        commonOverworldGemVeinModifiers
                )
        );

        context.register(
                MMFeatures.PlacedFeatures.SPIDER_KUNZITE_VEIN_PLACED_KEY,
                new PlacedFeature(
                        configuredFeatures.getOrThrow(MMFeatures.ConfiguredFeatures.SPIDER_KUNZITE_VEIN_CONFIGURED_KEY),
                        commonOverworldGemVeinModifiers
                )
        );


        context.register(
                MMFeatures.PlacedFeatures.UNBREAKING_IOLITE_VEIN_PLACED_KEY,
                new PlacedFeature(
                        configuredFeatures.getOrThrow(MMFeatures.ConfiguredFeatures.UNBREAKING_IOLITE_VEIN_CONFIGURED_KEY),
                        uncommonOverworldGemVeinModifiers
                )
        );

        context.register(
                MMFeatures.PlacedFeatures.HEART_RHODONITE_VEIN_PLACED_KEY,
                new PlacedFeature(
                        configuredFeatures.getOrThrow(MMFeatures.ConfiguredFeatures.HEART_RHODONITE_VEIN_CONFIGURED_KEY),
                        rareNetherGemVeinModifiers
                )
        );

        context.register(
                MMFeatures.PlacedFeatures.POWER_PYRITE_VEIN_PLACED_KEY,
                new PlacedFeature(
                        configuredFeatures.getOrThrow(MMFeatures.ConfiguredFeatures.POWER_PYRITE_VEIN_CONFIGURED_KEY),
                        rareNetherGemVeinModifiers
                )
        );

        context.register(
                MMFeatures.PlacedFeatures.KINETIC_OPAL_VEIN_PLACED_KEY,
                new PlacedFeature(
                        configuredFeatures.getOrThrow(MMFeatures.ConfiguredFeatures.KINETIC_OPAL_VEIN_CONFIGURED_KEY),
                        rareNetherGemVeinModifiers
                )
        );

        context.register(
                MMFeatures.PlacedFeatures.MALACHITE_METEORITE_PLACED_KEY,
                new PlacedFeature(
                        configuredFeatures.getOrThrow(MMFeatures.ConfiguredFeatures.MALACHITE_METEORITE_CONFIGURED_KEY),
                        malachiteMeteoriteModifiers
                )
        );

    }
}
