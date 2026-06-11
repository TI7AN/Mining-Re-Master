package org.infernalstudios.miningmaster.init;

import dev.architectury.registry.level.biome.BiomeModifications;
import net.minecraft.core.HolderSet;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import org.infernalstudios.miningmaster.MiningMaster;

public class MMBiomeModifiers {

    public static void init() {
        MiningMaster.LOGGER.info("Init BiomeModifications");

        //This does not work on neoforge (works on fabric) 1.21.1, TODO check compatibility on newer versions
        BiomeModifications.addProperties(context -> context.hasTag(BiomeTags.IS_OVERWORLD),
                (biomeContext, mutable) -> {
                    mutable.getGenerationProperties().addFeature(
                            GenerationStep.Decoration.UNDERGROUND_ORES,
                            MMFeatures.PlacedFeatures.RANDOM_GEM_OVERWORLD_VEIN_PLACED_KEY
                    );
                }
        );

        BiomeModifications.addProperties(context -> context.hasTag(BiomeTags.IS_NETHER),
                (biomeContext, mutable) -> {
                    mutable.getGenerationProperties().addFeature(
                            GenerationStep.Decoration.UNDERGROUND_ORES,
                            MMFeatures.PlacedFeatures.RANDOM_GEM_NETHER_VEIN_PLACED_KEY
                    );
                }
        );

        BiomeModifications.addProperties(context -> context.hasTag(BiomeTags.IS_OCEAN),
                (biomeContext, mutable) -> {
                    mutable.getGenerationProperties().addFeature(
                            GenerationStep.Decoration.UNDERGROUND_ORES,
                            MMFeatures.PlacedFeatures.DIVE_AQUAMARINE_VEIN_PLACED_KEY
                    );
                }
        );

        BiomeModifications.addProperties(context -> context.hasTag(MMTags.Biomes.MM_DIVINE_BERYL_BIOMES),
                (biomeContext, mutable) -> {
                    mutable.getGenerationProperties().addFeature(
                            GenerationStep.Decoration.UNDERGROUND_ORES,
                            MMFeatures.PlacedFeatures.DIVINE_BERYL_VEIN_PLACED_KEY
                    );
                }
        );

        BiomeModifications.addProperties(context -> {
                    if (context.getKey().isEmpty())     {
                        return false;
                    } else {
                        return context.getKey().get().equals(Biomes.DESERT.location());
                    }
                },
                (biomeContext, mutable) -> {
                    mutable.getGenerationProperties().addFeature(
                            GenerationStep.Decoration.UNDERGROUND_ORES,
                            MMFeatures.PlacedFeatures.FIRE_RUBY_VEIN_PLACED_KEY
                    );
                }
        );

        BiomeModifications.addProperties(context -> context.hasTag(BiomeTags.IS_JUNGLE),
                (biomeContext, mutable) -> {
                    mutable.getGenerationProperties().addFeature(
                            GenerationStep.Decoration.UNDERGROUND_ORES,
                            MMFeatures.PlacedFeatures.HASTE_PERIDOT_VEIN_PLACED_KEY
                    );
                }
        );

        BiomeModifications.addProperties(context -> {
                    if (context.getKey().isEmpty())     {
                        return false;
                    } else {
                        return context.getKey().get().equals(Biomes.SOUL_SAND_VALLEY.location());
                    }
                },
                (biomeContext, mutable) -> {
                    mutable.getGenerationProperties().addFeature(
                            GenerationStep.Decoration.UNDERGROUND_ORES,
                            MMFeatures.PlacedFeatures.HEART_RHODONITE_VEIN_PLACED_KEY
                    );
                }
        );

        BiomeModifications.addProperties(context -> context.hasTag(MMTags.Biomes.C_IS_COLD_OVERWORLD),
                (biomeContext, mutable) -> {
                    mutable.getGenerationProperties().addFeature(
                            GenerationStep.Decoration.UNDERGROUND_ORES,
                            MMFeatures.PlacedFeatures.ICE_SAPPHIRE_VEIN_PLACED_KEY
                    );
                }
        );

        BiomeModifications.addProperties(context -> {
                    if (context.getKey().isEmpty())     {
                        return false;
                    } else {
                        return context.getKey().get().equals(Biomes.BASALT_DELTAS.location());
                    }
                },
                (biomeContext, mutable) -> {
                    mutable.getGenerationProperties().addFeature(
                            GenerationStep.Decoration.UNDERGROUND_ORES,
                            MMFeatures.PlacedFeatures.KINETIC_OPAL_VEIN_PLACED_KEY
                    );
                }
        );

        BiomeModifications.addProperties(context -> {
                    if (context.getKey().isEmpty())     {
                        return false;
                    } else {
                        return context.getKey().get().equals(Biomes.CRIMSON_FOREST.location());
                    }
                }
                ,(biomeContext, mutable) -> {
                    mutable.getGenerationProperties().addFeature(
                            GenerationStep.Decoration.UNDERGROUND_ORES,
                            MMFeatures.PlacedFeatures.LUCKY_CITRINE_VEIN_PLACED_KEY
                    );
                }
        );

        BiomeModifications.addProperties(context -> context.hasTag(BiomeTags.IS_FOREST),
                (biomeContext, mutable) -> {
                    mutable.getGenerationProperties().addFeature(
                            GenerationStep.Decoration.UNDERGROUND_ORES,
                            MMFeatures.PlacedFeatures.SPIDER_KUNZITE_VEIN_PLACED_KEY
                    );
                }
        );

        BiomeModifications.addProperties(context -> {
                    if (context.getKey().isEmpty())     {
                        return false;
                    } else {
                       return context.getKey().get().equals(Biomes.SUNFLOWER_PLAINS.location()) ||
                                context.getKey().get().equals(Biomes.FLOWER_FOREST.location()) ||
                                context.getKey().get().equals(Biomes.LUSH_CAVES.location());
                    }
                },(biomeContext, mutable) -> {
                        mutable.getGenerationProperties().addFeature(
                                GenerationStep.Decoration.UNDERGROUND_ORES,
                                MMFeatures.PlacedFeatures.SPIRIT_GARNET_VEIN_PLACED_KEY
                        );
                }
        );

        BiomeModifications.addProperties(context -> context.hasTag(MMTags.Biomes.MM_UNBREAKING_IOLITE_BIOMES),
                (biomeContext, mutable) -> {
                    mutable.getGenerationProperties().addFeature(
                            GenerationStep.Decoration.UNDERGROUND_ORES,
                            MMFeatures.PlacedFeatures.UNBREAKING_IOLITE_VEIN_PLACED_KEY
                    );
                }
        );

        BiomeModifications.addProperties(context -> context.hasTag(BiomeTags.IS_END),
                (biomeContext, mutable) -> {
                    mutable.getGenerationProperties().addFeature(
                            GenerationStep.Decoration.UNDERGROUND_ORES,
                            MMFeatures.PlacedFeatures.MALACHITE_METEORITE_PLACED_KEY
                    );
                }
        );
    }
}
