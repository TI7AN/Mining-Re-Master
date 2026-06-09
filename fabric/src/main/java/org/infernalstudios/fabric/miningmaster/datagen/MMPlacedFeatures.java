package org.infernalstudios.fabric.miningmaster.datagen;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.heightproviders.BiasedToBottomHeight;
import net.minecraft.world.level.levelgen.heightproviders.UniformHeight;
import net.minecraft.world.level.levelgen.placement.*;
import org.infernalstudios.miningmaster.MiningMaster;
import org.infernalstudios.miningmaster.init.MMFeatures;

import java.util.List;

public class MMPlacedFeatures {

    public static void configure(BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        List<PlacementModifier> fireRubyVeinModifiers = List.of(
                CountPlacement.of(128),
                InSquarePlacement.spread(),
                HeightRangePlacement.of(
                        UniformHeight.of(
                                VerticalAnchor.absolute(-64),
                                VerticalAnchor.absolute(320)
                        )
                ),
                BiomeFilter.biome()
        );

        context.register(
                MMFeatures.PlacedFeatures.FIRE_RUBY_VEIN_PLACED_KEY,
                new PlacedFeature(
                        configuredFeatures.getOrThrow(MMFeatures.ConfiguredFeatures.FIRE_RUBY_VEIN_CONFIGURED_KEY),
                        fireRubyVeinModifiers
                )
        );


        List<PlacementModifier> iceSapphireVeinModifiers = List.of(
                CountPlacement.of(128),
                InSquarePlacement.spread(),
                HeightRangePlacement.of(
                        UniformHeight.of(
                                VerticalAnchor.absolute(-64),
                                VerticalAnchor.absolute(320)
                        )
                ),
                BiomeFilter.biome()
        );

        context.register(
                MMFeatures.PlacedFeatures.ICE_SAPPHIRE_VEIN_PLACED_KEY,
                new PlacedFeature(
                        configuredFeatures.getOrThrow(MMFeatures.ConfiguredFeatures.ICE_SAPPHIRE_VEIN_CONFIGURED_KEY),
                        iceSapphireVeinModifiers
                )
        );


        List<PlacementModifier> spiritGarnetVeinModifiers = List.of(
                CountPlacement.of(128),
                InSquarePlacement.spread(),
                HeightRangePlacement.of(
                        UniformHeight.of(
                                VerticalAnchor.absolute(-64),
                                VerticalAnchor.absolute(320)
                        )
                ),
                BiomeFilter.biome()
        );

        context.register(
                MMFeatures.PlacedFeatures.SPIRIT_GARNET_VEIN_PLACED_KEY,
                new PlacedFeature(
                        configuredFeatures.getOrThrow(MMFeatures.ConfiguredFeatures.SPIRIT_GARNET_VEIN_CONFIGURED_KEY),
                        spiritGarnetVeinModifiers
                )
        );


        List<PlacementModifier> hastePeridotVeinModifiers = List.of(
                CountPlacement.of(128),
                InSquarePlacement.spread(),
                HeightRangePlacement.of(
                        UniformHeight.of(
                                VerticalAnchor.absolute(-64),
                                VerticalAnchor.absolute(320)
                        )
                ),
                BiomeFilter.biome()
        );

        context.register(
                MMFeatures.PlacedFeatures.HASTE_PERIDOT_VEIN_PLACED_KEY,
                new PlacedFeature(
                        configuredFeatures.getOrThrow(MMFeatures.ConfiguredFeatures.HASTE_PERIDOT_VEIN_CONFIGURED_KEY),
                        hastePeridotVeinModifiers
                )
        );


        List<PlacementModifier> luckyCitrineVeinModifiers = List.of(
                CountPlacement.of(128),
                InSquarePlacement.spread(),
                HeightRangePlacement.of(
                        UniformHeight.of(
                                VerticalAnchor.absolute(-64),
                                VerticalAnchor.absolute(320)
                        )
                ),
                BiomeFilter.biome()
        );

        context.register(
                MMFeatures.PlacedFeatures.LUCKY_CITRINE_VEIN_PLACED_KEY,
                new PlacedFeature(
                        configuredFeatures.getOrThrow(MMFeatures.ConfiguredFeatures.LUCKY_CITRINE_VEIN_CONFIGURED_KEY),
                        luckyCitrineVeinModifiers
                )
        );


        List<PlacementModifier> diveAquamarineVeinModifiers = List.of(
                CountPlacement.of(128),
                InSquarePlacement.spread(),
                HeightRangePlacement.of(
                        UniformHeight.of(
                                VerticalAnchor.absolute(-64),
                                VerticalAnchor.absolute(320)
                        )
                ),
                BiomeFilter.biome()
        );

        context.register(
                MMFeatures.PlacedFeatures.DIVE_AQUAMARINE_VEIN_PLACED_KEY,
                new PlacedFeature(
                        configuredFeatures.getOrThrow(MMFeatures.ConfiguredFeatures.DIVE_AQUAMARINE_VEIN_CONFIGURED_KEY),
                        diveAquamarineVeinModifiers
                )
        );


        List<PlacementModifier> divineBerylVeinModifiers = List.of(
                CountPlacement.of(128),
                InSquarePlacement.spread(),
                HeightRangePlacement.of(
                        UniformHeight.of(
                                VerticalAnchor.absolute(-64),
                                VerticalAnchor.absolute(320)
                        )
                ),
                BiomeFilter.biome()
        );

        context.register(
                MMFeatures.PlacedFeatures.DIVINE_BERYL_VEIN_PLACED_KEY,
                new PlacedFeature(
                        configuredFeatures.getOrThrow(MMFeatures.ConfiguredFeatures.DIVINE_BERYL_VEIN_CONFIGURED_KEY),
                        divineBerylVeinModifiers
                )
        );


        List<PlacementModifier> spiderKunziteVeinModifiers = List.of(
                CountPlacement.of(128),
                InSquarePlacement.spread(),
                HeightRangePlacement.of(
                        UniformHeight.of(
                                VerticalAnchor.absolute(-64),
                                VerticalAnchor.absolute(320)
                        )
                ),
                BiomeFilter.biome()
        );

        context.register(
                MMFeatures.PlacedFeatures.SPIDER_KUNZITE_VEIN_PLACED_KEY,
                new PlacedFeature(
                        configuredFeatures.getOrThrow(MMFeatures.ConfiguredFeatures.SPIDER_KUNZITE_VEIN_CONFIGURED_KEY),
                        spiderKunziteVeinModifiers
                )
        );


        List<PlacementModifier> unbreakingIoliteVeinModifiers = List.of(
                CountPlacement.of(128),
                InSquarePlacement.spread(),
                HeightRangePlacement.of(
                        UniformHeight.of(
                                VerticalAnchor.absolute(-64),
                                VerticalAnchor.absolute(320)
                        )
                ),
                BiomeFilter.biome()
        );

        context.register(
                MMFeatures.PlacedFeatures.UNBREAKING_IOLITE_VEIN_PLACED_KEY,
                new PlacedFeature(
                        configuredFeatures.getOrThrow(MMFeatures.ConfiguredFeatures.UNBREAKING_IOLITE_VEIN_CONFIGURED_KEY),
                        unbreakingIoliteVeinModifiers
                )
        );


        List<PlacementModifier> heartRhodoniteVeinModifiers = List.of(
                CountPlacement.of(128),
                InSquarePlacement.spread(),
                HeightRangePlacement.of(
                        UniformHeight.of(
                                VerticalAnchor.absolute(-64),
                                VerticalAnchor.absolute(320)
                        )
                ),
                BiomeFilter.biome()
        );

        context.register(
                MMFeatures.PlacedFeatures.HEART_RHODONITE_VEIN_PLACED_KEY,
                new PlacedFeature(
                        configuredFeatures.getOrThrow(MMFeatures.ConfiguredFeatures.HEART_RHODONITE_VEIN_CONFIGURED_KEY),
                        heartRhodoniteVeinModifiers
                )
        );


        List<PlacementModifier> powerPyriteVeinModifiers = List.of(
                CountPlacement.of(128),
                InSquarePlacement.spread(),
                HeightRangePlacement.of(
                        UniformHeight.of(
                                VerticalAnchor.absolute(-64),
                                VerticalAnchor.absolute(320)
                        )
                ),
                BiomeFilter.biome()
        );

        context.register(
                MMFeatures.PlacedFeatures.POWER_PYRITE_VEIN_PLACED_KEY,
                new PlacedFeature(
                        configuredFeatures.getOrThrow(MMFeatures.ConfiguredFeatures.POWER_PYRITE_VEIN_CONFIGURED_KEY),
                        powerPyriteVeinModifiers
                )
        );


        List<PlacementModifier> kineticOpalVeinModifiers = List.of(
                CountPlacement.of(128),
                InSquarePlacement.spread(),
                HeightRangePlacement.of(
                        UniformHeight.of(
                                VerticalAnchor.absolute(-64),
                                VerticalAnchor.absolute(320)
                        )
                ),
                BiomeFilter.biome()
        );

        context.register(
                MMFeatures.PlacedFeatures.KINETIC_OPAL_VEIN_PLACED_KEY,
                new PlacedFeature(
                        configuredFeatures.getOrThrow(MMFeatures.ConfiguredFeatures.KINETIC_OPAL_VEIN_CONFIGURED_KEY),
                        kineticOpalVeinModifiers
                )
        );


        List<PlacementModifier> airMalachiteVeinModifiers = List.of(
                CountPlacement.of(128),
                InSquarePlacement.spread(),
                HeightRangePlacement.of(
                        UniformHeight.of(
                                VerticalAnchor.absolute(-64),
                                VerticalAnchor.absolute(320)
                        )
                ),
                BiomeFilter.biome()
        );

        context.register(
                MMFeatures.PlacedFeatures.AIR_MALACHITE_VEIN_PLACED_KEY,
                new PlacedFeature(
                        configuredFeatures.getOrThrow(MMFeatures.ConfiguredFeatures.AIR_MALACHITE_VEIN_CONFIGURED_KEY),
                        airMalachiteVeinModifiers
                )
        );

    }
}
