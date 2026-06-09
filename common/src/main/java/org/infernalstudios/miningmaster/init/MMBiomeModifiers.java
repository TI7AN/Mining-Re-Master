package org.infernalstudios.miningmaster.init;

import dev.architectury.registry.level.biome.BiomeModifications;
import net.minecraft.tags.BiomeTags;
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
                            MMFeatures.PlacedFeatures.FIRE_RUBY_VEIN_PLACED_KEY
                    );
                }
        );
    }
}
