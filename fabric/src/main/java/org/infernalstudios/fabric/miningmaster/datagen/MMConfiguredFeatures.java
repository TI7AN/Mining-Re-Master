package org.infernalstudios.fabric.miningmaster.datagen;

import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import org.infernalstudios.miningmaster.init.MMBlocks;
import org.infernalstudios.miningmaster.init.MMFeatures;
import org.infernalstudios.miningmaster.world.features.config.GemOreConfiguration;
import org.infernalstudios.miningmaster.world.features.config.MalachiteMeteoriteConfiguration;

import java.util.List;

public class MMConfiguredFeatures {

    public static void configure(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceableRule = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceableRule = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplaceableRule = new TagMatchTest(BlockTags.BASE_STONE_NETHER);

        int size = 3;

        List<GemOreConfiguration.TargetWeightedState> randomOreConfig =
                List.of(
                        GemOreConfiguration.target(
                                stoneReplaceableRule,
                                List.of(
                                    GemOreConfiguration.state(MMBlocks.ICE_SAPPHIRE_ORE.get().defaultBlockState(), 2),
                                    GemOreConfiguration.state(MMBlocks.SPIRIT_GARNET_ORE.get().defaultBlockState(), 2),
                                    GemOreConfiguration.state(MMBlocks.DIVE_AQUAMARINE_ORE.get().defaultBlockState(), 2),
                                    GemOreConfiguration.state(MMBlocks.DIVINE_BERYL_ORE.get().defaultBlockState(), 2),
                                    GemOreConfiguration.state(MMBlocks.SPIDER_KUNZITE_ORE.get().defaultBlockState(), 2),
                                    GemOreConfiguration.state(MMBlocks.FIRE_RUBY_ORE.get().defaultBlockState(), 2),
                                    GemOreConfiguration.state(MMBlocks.HASTE_PERIDOT_ORE.get().defaultBlockState(), 1),
                                    GemOreConfiguration.state(MMBlocks.LUCKY_CITRINE_ORE.get().defaultBlockState(), 1),
                                    GemOreConfiguration.state(MMBlocks.UNBREAKING_IOLITE_ORE.get().defaultBlockState(), 1)
                                )
                        ),
                        GemOreConfiguration.target(
                                stoneReplaceableRule,
                                List.of(
                                        GemOreConfiguration.state(MMBlocks.DEEPSLATE_ICE_SAPPHIRE_ORE.get().defaultBlockState(), 2),
                                        GemOreConfiguration.state(MMBlocks.DEEPSLATE_SPIRIT_GARNET_ORE.get().defaultBlockState(), 2),
                                        GemOreConfiguration.state(MMBlocks.DEEPSLATE_DIVE_AQUAMARINE_ORE.get().defaultBlockState(), 2),
                                        GemOreConfiguration.state(MMBlocks.DEEPSLATE_DIVINE_BERYL_ORE.get().defaultBlockState(), 2),
                                        GemOreConfiguration.state(MMBlocks.DEEPSLATE_SPIDER_KUNZITE_ORE.get().defaultBlockState(), 2),
                                        GemOreConfiguration.state(MMBlocks.DEEPSLATE_FIRE_RUBY_ORE.get().defaultBlockState(), 2),
                                        GemOreConfiguration.state(MMBlocks.DEEPSLATE_HASTE_PERIDOT_ORE.get().defaultBlockState(), 1),
                                        GemOreConfiguration.state(MMBlocks.DEEPSLATE_LUCKY_CITRINE_ORE.get().defaultBlockState(), 1),
                                        GemOreConfiguration.state(MMBlocks.DEEPSLATE_UNBREAKING_IOLITE_ORE.get().defaultBlockState(), 1)
                                )
                        ),
                        GemOreConfiguration.target(
                                netherrackReplaceableRule,
                                List.of(
                                        GemOreConfiguration.state(MMBlocks.POWER_PYRITE_ORE.get().defaultBlockState(), 1),
                                        GemOreConfiguration.state(MMBlocks.KINETIC_OPAL_ORE.get().defaultBlockState(), 1),
                                        GemOreConfiguration.state(MMBlocks.HEART_RHODONITE_ORE.get().defaultBlockState(), 1)
                                )
                        )
                );

        context.register(
                MMFeatures.ConfiguredFeatures.RANDOM_GEM_VEIN_CONFIGURED_KEY,
                new ConfiguredFeature<>(
                        MMFeatures.MM_GEM_ORE_FEATURE.get(),
                        new GemOreConfiguration(randomOreConfig, 0, size)
                )
        );

        List<OreConfiguration.TargetBlockState> fireRubyOreConfig =
                List.of(
                        OreConfiguration.target(stoneReplaceableRule, MMBlocks.FIRE_RUBY_ORE.get().defaultBlockState()),
                        OreConfiguration.target(deepslateReplaceableRule, MMBlocks.DEEPSLATE_FIRE_RUBY_ORE.get().defaultBlockState())
                );

        context.register(
                MMFeatures.ConfiguredFeatures.FIRE_RUBY_VEIN_CONFIGURED_KEY,
                new ConfiguredFeature<>(
                        Feature.ORE,
                        new OreConfiguration(fireRubyOreConfig, size)
                )
        );


        List<OreConfiguration.TargetBlockState> iceSapphireOreConfig =
                List.of(
                        OreConfiguration.target(stoneReplaceableRule, MMBlocks.ICE_SAPPHIRE_ORE.get().defaultBlockState()),
                        OreConfiguration.target(deepslateReplaceableRule, MMBlocks.DEEPSLATE_ICE_SAPPHIRE_ORE.get().defaultBlockState())
                );

        context.register(
                MMFeatures.ConfiguredFeatures.ICE_SAPPHIRE_VEIN_CONFIGURED_KEY,
                new ConfiguredFeature<>(
                        Feature.ORE,
                        new OreConfiguration(iceSapphireOreConfig, size)
                )
        );


        List<OreConfiguration.TargetBlockState> spiritGarnetOreConfig =
                List.of(
                        OreConfiguration.target(stoneReplaceableRule, MMBlocks.SPIRIT_GARNET_ORE.get().defaultBlockState()),
                        OreConfiguration.target(deepslateReplaceableRule, MMBlocks.DEEPSLATE_SPIRIT_GARNET_ORE.get().defaultBlockState())
                );

        context.register(
                MMFeatures.ConfiguredFeatures.SPIRIT_GARNET_VEIN_CONFIGURED_KEY,
                new ConfiguredFeature<>(
                        Feature.ORE,
                        new OreConfiguration(spiritGarnetOreConfig, size)
                )
        );


        List<OreConfiguration.TargetBlockState> hastePeridotOreConfig =
                List.of(
                        OreConfiguration.target(stoneReplaceableRule, MMBlocks.HASTE_PERIDOT_ORE.get().defaultBlockState()),
                        OreConfiguration.target(deepslateReplaceableRule, MMBlocks.DEEPSLATE_HASTE_PERIDOT_ORE.get().defaultBlockState())
                );

        context.register(
                MMFeatures.ConfiguredFeatures.HASTE_PERIDOT_VEIN_CONFIGURED_KEY,
                new ConfiguredFeature<>(
                        Feature.ORE,
                        new OreConfiguration(hastePeridotOreConfig, size)
                )
        );


        List<OreConfiguration.TargetBlockState> luckyCitrineOreConfig =
                List.of(
                        OreConfiguration.target(stoneReplaceableRule, MMBlocks.LUCKY_CITRINE_ORE.get().defaultBlockState()),
                        OreConfiguration.target(deepslateReplaceableRule, MMBlocks.DEEPSLATE_LUCKY_CITRINE_ORE.get().defaultBlockState())
                );

        context.register(
                MMFeatures.ConfiguredFeatures.LUCKY_CITRINE_VEIN_CONFIGURED_KEY,
                new ConfiguredFeature<>(
                        Feature.ORE,
                        new OreConfiguration(luckyCitrineOreConfig, size)
                )
        );


        List<OreConfiguration.TargetBlockState> diveAquamarineOreConfig =
                List.of(
                        OreConfiguration.target(stoneReplaceableRule, MMBlocks.DIVE_AQUAMARINE_ORE.get().defaultBlockState()),
                        OreConfiguration.target(deepslateReplaceableRule, MMBlocks.DEEPSLATE_DIVE_AQUAMARINE_ORE.get().defaultBlockState())
                );

        context.register(
                MMFeatures.ConfiguredFeatures.DIVE_AQUAMARINE_VEIN_CONFIGURED_KEY,
                new ConfiguredFeature<>(
                        Feature.ORE,
                        new OreConfiguration(diveAquamarineOreConfig, size)
                )
        );


        List<OreConfiguration.TargetBlockState> divineBerylOreConfig =
                List.of(
                        OreConfiguration.target(stoneReplaceableRule, MMBlocks.DIVINE_BERYL_ORE.get().defaultBlockState()),
                        OreConfiguration.target(deepslateReplaceableRule, MMBlocks.DEEPSLATE_DIVINE_BERYL_ORE.get().defaultBlockState())
                );

        context.register(
                MMFeatures.ConfiguredFeatures.DIVINE_BERYL_VEIN_CONFIGURED_KEY,
                new ConfiguredFeature<>(
                        Feature.ORE,
                        new OreConfiguration(divineBerylOreConfig, size)
                )
        );


        List<OreConfiguration.TargetBlockState> spiderKunzitelOreConfig =
                List.of(
                        OreConfiguration.target(stoneReplaceableRule, MMBlocks.SPIDER_KUNZITE_ORE.get().defaultBlockState()),
                        OreConfiguration.target(deepslateReplaceableRule, MMBlocks.DEEPSLATE_SPIDER_KUNZITE_ORE.get().defaultBlockState())
                );

        context.register(
                MMFeatures.ConfiguredFeatures.SPIDER_KUNZITE_VEIN_CONFIGURED_KEY,
                new ConfiguredFeature<>(
                        Feature.ORE,
                        new OreConfiguration(spiderKunzitelOreConfig, size)
                )
        );


        List<OreConfiguration.TargetBlockState> unbreakingIoliteOreConfig =
                List.of(
                        OreConfiguration.target(stoneReplaceableRule, MMBlocks.UNBREAKING_IOLITE_ORE.get().defaultBlockState()),
                        OreConfiguration.target(deepslateReplaceableRule, MMBlocks.DEEPSLATE_UNBREAKING_IOLITE_ORE.get().defaultBlockState())
                );

        context.register(
                MMFeatures.ConfiguredFeatures.UNBREAKING_IOLITE_VEIN_CONFIGURED_KEY,
                new ConfiguredFeature<>(
                        Feature.ORE,
                        new OreConfiguration(unbreakingIoliteOreConfig, size)
                )
        );


        List<OreConfiguration.TargetBlockState> heartRhodoniteOreConfig =
                List.of(
                        OreConfiguration.target(netherrackReplaceableRule, MMBlocks.HEART_RHODONITE_ORE.get().defaultBlockState())
                );

        context.register(
                MMFeatures.ConfiguredFeatures.HEART_RHODONITE_VEIN_CONFIGURED_KEY,
                new ConfiguredFeature<>(
                        Feature.ORE,
                        new OreConfiguration(heartRhodoniteOreConfig, size)
                )
        );


        List<OreConfiguration.TargetBlockState> powerPyriteOreConfig =
                List.of(
                        OreConfiguration.target(netherrackReplaceableRule, MMBlocks.POWER_PYRITE_ORE.get().defaultBlockState())
                );

        context.register(
                MMFeatures.ConfiguredFeatures.POWER_PYRITE_VEIN_CONFIGURED_KEY,
                new ConfiguredFeature<>(
                        Feature.ORE,
                        new OreConfiguration(powerPyriteOreConfig, size)
                )
        );


        List<OreConfiguration.TargetBlockState> kineticOpalOreConfig =
                List.of(
                        OreConfiguration.target(netherrackReplaceableRule, MMBlocks.KINETIC_OPAL_ORE.get().defaultBlockState())
                );

        context.register(
                MMFeatures.ConfiguredFeatures.KINETIC_OPAL_VEIN_CONFIGURED_KEY,
                new ConfiguredFeature<>(
                        Feature.ORE,
                        new OreConfiguration(kineticOpalOreConfig, size)
                )
        );


        context.register(
                MMFeatures.ConfiguredFeatures.MALACHITE_METEORITE_CONFIGURED_KEY,
                new ConfiguredFeature<>(
                        MMFeatures.MALACHITE_METEORITE_FEATURE.get(),
                        new MalachiteMeteoriteConfiguration(15, 24, 1)
                )
        );
    }
}
