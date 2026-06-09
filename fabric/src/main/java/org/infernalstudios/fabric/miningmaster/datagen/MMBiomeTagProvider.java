package org.infernalstudios.fabric.miningmaster.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import org.infernalstudios.miningmaster.init.MMTags;

import java.util.concurrent.CompletableFuture;

public class MMBiomeTagProvider extends FabricTagProvider<Biome> {

    public MMBiomeTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, Registries.BIOME, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {

        getOrCreateTagBuilder(MMTags.Biomes.MM_DIVINE_BERYL_BIOMES)
                .addOptionalTag(MMTags.Biomes.C_IS_SWAMP)
                .add(Biomes.DARK_FOREST)
                .setReplace(false);

        getOrCreateTagBuilder(MMTags.Biomes.MM_UNBREAKING_IOLITE_BIOMES)
                .addOptionalTag(MMTags.Biomes.C_IS_MUSHROOM)
                .add(Biomes.DEEP_DARK)
                .setReplace(false);
    }
}
