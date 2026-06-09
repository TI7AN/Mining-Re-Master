package org.infernalstudios.fabric.miningmaster.datagen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import org.infernalstudios.miningmaster.MiningMaster;
import org.infernalstudios.miningmaster.init.MMBlocks;
import org.infernalstudios.miningmaster.init.MMFeatures;

import java.util.List;

public class MMConfiguredFeatures {

    public static void configure(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceableRule = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceableRule = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreConfiguration.TargetBlockState> fireRubyOreConfig =
                List.of(
                        OreConfiguration.target(stoneReplaceableRule, MMBlocks.FIRE_RUBY_ORE.get().defaultBlockState()),
                        OreConfiguration.target(deepslateReplaceableRule, MMBlocks.FIRE_RUBY_ORE.get().defaultBlockState())
                );

        context.register(
                MMFeatures.ConfiguredFeatures.FIRE_RUBY_VEIN_CONFIGURED_KEY,
                new ConfiguredFeature<>(
                        Feature.ORE,
                        new OreConfiguration(fireRubyOreConfig, 10)
                )
        );


        List<OreConfiguration.TargetBlockState> iceSapphireOreConfig =
                List.of(
                        OreConfiguration.target(stoneReplaceableRule, MMBlocks.ICE_SAPPHIRE_ORE.get().defaultBlockState()),
                        OreConfiguration.target(deepslateReplaceableRule, MMBlocks.ICE_SAPPHIRE_ORE.get().defaultBlockState())
                );

        context.register(
                MMFeatures.ConfiguredFeatures.ICE_SAPPHIRE_VEIN_CONFIGURED_KEY,
                new ConfiguredFeature<>(
                        Feature.ORE,
                        new OreConfiguration(iceSapphireOreConfig, 10)
                )
        );


        List<OreConfiguration.TargetBlockState> spiritGarnetOreConfig =
                List.of(
                        OreConfiguration.target(stoneReplaceableRule, MMBlocks.SPIRIT_GARNET_ORE.get().defaultBlockState()),
                        OreConfiguration.target(deepslateReplaceableRule, MMBlocks.SPIRIT_GARNET_ORE.get().defaultBlockState())
                );

        context.register(
                MMFeatures.ConfiguredFeatures.SPIRIT_GARNET_VEIN_CONFIGURED_KEY,
                new ConfiguredFeature<>(
                        Feature.ORE,
                        new OreConfiguration(spiritGarnetOreConfig, 10)
                )
        );


        List<OreConfiguration.TargetBlockState> hastePeridotOreConfig =
                List.of(
                        OreConfiguration.target(stoneReplaceableRule, MMBlocks.HASTE_PERIDOT_ORE.get().defaultBlockState()),
                        OreConfiguration.target(deepslateReplaceableRule, MMBlocks.HASTE_PERIDOT_ORE.get().defaultBlockState())
                );

        context.register(
                MMFeatures.ConfiguredFeatures.HASTE_PERIDOT_VEIN_CONFIGURED_KEY,
                new ConfiguredFeature<>(
                        Feature.ORE,
                        new OreConfiguration(hastePeridotOreConfig, 10)
                )
        );


        List<OreConfiguration.TargetBlockState> luckyCitrineOreConfig =
                List.of(
                        OreConfiguration.target(stoneReplaceableRule, MMBlocks.LUCKY_CITRINE_ORE.get().defaultBlockState()),
                        OreConfiguration.target(deepslateReplaceableRule, MMBlocks.LUCKY_CITRINE_ORE.get().defaultBlockState())
                );

        context.register(
                MMFeatures.ConfiguredFeatures.LUCKY_CITRINE_VEIN_CONFIGURED_KEY,
                new ConfiguredFeature<>(
                        Feature.ORE,
                        new OreConfiguration(luckyCitrineOreConfig, 10)
                )
        );


        List<OreConfiguration.TargetBlockState> diveAquamarineOreConfig =
                List.of(
                        OreConfiguration.target(stoneReplaceableRule, MMBlocks.DIVE_AQUAMARINE_ORE.get().defaultBlockState()),
                        OreConfiguration.target(deepslateReplaceableRule, MMBlocks.DIVE_AQUAMARINE_ORE.get().defaultBlockState())
                );

        context.register(
                MMFeatures.ConfiguredFeatures.DIVE_AQUAMARINE_VEIN_CONFIGURED_KEY,
                new ConfiguredFeature<>(
                        Feature.ORE,
                        new OreConfiguration(diveAquamarineOreConfig, 10)
                )
        );


        List<OreConfiguration.TargetBlockState> divineBerylOreConfig =
                List.of(
                        OreConfiguration.target(stoneReplaceableRule, MMBlocks.DIVINE_BERYL_ORE.get().defaultBlockState()),
                        OreConfiguration.target(deepslateReplaceableRule, MMBlocks.DIVINE_BERYL_ORE.get().defaultBlockState())
                );

        context.register(
                MMFeatures.ConfiguredFeatures.DIVINE_BERYL_VEIN_CONFIGURED_KEY,
                new ConfiguredFeature<>(
                        Feature.ORE,
                        new OreConfiguration(divineBerylOreConfig, 10)
                )
        );


        List<OreConfiguration.TargetBlockState> spiderKunzitelOreConfig =
                List.of(
                        OreConfiguration.target(stoneReplaceableRule, MMBlocks.SPIDER_KUNZITE_ORE.get().defaultBlockState()),
                        OreConfiguration.target(deepslateReplaceableRule, MMBlocks.SPIDER_KUNZITE_ORE.get().defaultBlockState())
                );

        context.register(
                MMFeatures.ConfiguredFeatures.SPIDER_KUNZITE_VEIN_CONFIGURED_KEY,
                new ConfiguredFeature<>(
                        Feature.ORE,
                        new OreConfiguration(spiderKunzitelOreConfig, 10)
                )
        );


        List<OreConfiguration.TargetBlockState> unbreakingIoliteOreConfig =
                List.of(
                        OreConfiguration.target(stoneReplaceableRule, MMBlocks.UNBREAKING_IOLITE_ORE.get().defaultBlockState()),
                        OreConfiguration.target(deepslateReplaceableRule, MMBlocks.UNBREAKING_IOLITE_ORE.get().defaultBlockState())
                );

        context.register(
                MMFeatures.ConfiguredFeatures.UNBREAKING_IOLITE_VEIN_CONFIGURED_KEY,
                new ConfiguredFeature<>(
                        Feature.ORE,
                        new OreConfiguration(unbreakingIoliteOreConfig, 10)
                )
        );


        List<OreConfiguration.TargetBlockState> heartRhodoniteOreConfig =
                List.of(
                        OreConfiguration.target(stoneReplaceableRule, MMBlocks.HEART_RHODONITE_ORE.get().defaultBlockState()),
                        OreConfiguration.target(deepslateReplaceableRule, MMBlocks.HEART_RHODONITE_ORE.get().defaultBlockState())
                );

        context.register(
                MMFeatures.ConfiguredFeatures.HEART_RHODONITE_VEIN_CONFIGURED_KEY,
                new ConfiguredFeature<>(
                        Feature.ORE,
                        new OreConfiguration(heartRhodoniteOreConfig, 10)
                )
        );


        List<OreConfiguration.TargetBlockState> powerPyriteOreConfig =
                List.of(
                        OreConfiguration.target(stoneReplaceableRule, MMBlocks.POWER_PYRITE_ORE.get().defaultBlockState()),
                        OreConfiguration.target(deepslateReplaceableRule, MMBlocks.POWER_PYRITE_ORE.get().defaultBlockState())
                );

        context.register(
                MMFeatures.ConfiguredFeatures.POWER_PYRITE_VEIN_CONFIGURED_KEY,
                new ConfiguredFeature<>(
                        Feature.ORE,
                        new OreConfiguration(powerPyriteOreConfig, 10)
                )
        );


        List<OreConfiguration.TargetBlockState> kineticOpalOreConfig =
                List.of(
                        OreConfiguration.target(stoneReplaceableRule, MMBlocks.KINETIC_OPAL_ORE.get().defaultBlockState()),
                        OreConfiguration.target(deepslateReplaceableRule, MMBlocks.KINETIC_OPAL_ORE.get().defaultBlockState())
                );

        context.register(
                MMFeatures.ConfiguredFeatures.KINETIC_OPAL_VEIN_CONFIGURED_KEY,
                new ConfiguredFeature<>(
                        Feature.ORE,
                        new OreConfiguration(kineticOpalOreConfig, 10)
                )
        );


        List<OreConfiguration.TargetBlockState> airMalachiteOreConfig =
                List.of(
                        OreConfiguration.target(stoneReplaceableRule, MMBlocks.AIR_MALACHITE_ORE.get().defaultBlockState()),
                        OreConfiguration.target(deepslateReplaceableRule, MMBlocks.AIR_MALACHITE_ORE.get().defaultBlockState())
                );

        context.register(
                MMFeatures.ConfiguredFeatures.AIR_MALACHITE_VEIN_CONFIGURED_KEY,
                new ConfiguredFeature<>(
                        Feature.ORE,
                        new OreConfiguration(airMalachiteOreConfig, 10)
                )
        );
    }
}
