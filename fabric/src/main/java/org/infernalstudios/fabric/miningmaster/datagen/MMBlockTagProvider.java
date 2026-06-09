package org.infernalstudios.fabric.miningmaster.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.infernalstudios.miningmaster.init.MMBlocks;
import org.infernalstudios.miningmaster.init.MMTags;

import java.util.concurrent.CompletableFuture;

public class MMBlockTagProvider extends FabricTagProvider<Block> {

    public MMBlockTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, Registries.BLOCK, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {

        getOrCreateTagBuilder(MMTags.Blocks.MM_SNOWPIERCER_BLOCKS)
                .add(Blocks.ICE)
                .add(Blocks.PACKED_ICE)
                .add(Blocks.BLUE_ICE)
                .add(Blocks.FROSTED_ICE)
                .add(Blocks.SNOW_BLOCK)
                .add(Blocks.SNOW)
                .add(Blocks.POWDER_SNOW)
                .setReplace(false)
        ;

        getOrCreateTagBuilder(MMTags.Blocks.C_ORES)
                .add(MMBlocks.FIRE_RUBY_ORE.get())
                .add(MMBlocks.ICE_SAPPHIRE_ORE.get())
                .add(MMBlocks.SPIRIT_GARNET_ORE.get())
                .add(MMBlocks.HASTE_PERIDOT_ORE.get())
                .add(MMBlocks.LUCKY_CITRINE_ORE.get())
                .add(MMBlocks.DIVE_AQUAMARINE_ORE.get())
                .add(MMBlocks.DIVINE_BERYL_ORE.get())
                .add(MMBlocks.SPIDER_KUNZITE_ORE.get())
                .add(MMBlocks.UNBREAKING_IOLITE_ORE.get())
                .add(MMBlocks.HEART_RHODONITE_ORE.get())
                .add(MMBlocks.POWER_PYRITE_ORE.get())
                .add(MMBlocks.KINETIC_OPAL_ORE.get())
                .add(MMBlocks.AIR_MALACHITE_ORE.get())

                .add(MMBlocks.DEEPSLATE_FIRE_RUBY_ORE.get())
                .add(MMBlocks.DEEPSLATE_ICE_SAPPHIRE_ORE.get())
                .add(MMBlocks.DEEPSLATE_SPIRIT_GARNET_ORE.get())
                .add(MMBlocks.DEEPSLATE_HASTE_PERIDOT_ORE.get())
                .add(MMBlocks.DEEPSLATE_LUCKY_CITRINE_ORE.get())
                .add(MMBlocks.DEEPSLATE_DIVE_AQUAMARINE_ORE.get())
                .add(MMBlocks.DEEPSLATE_DIVINE_BERYL_ORE.get())
                .add(MMBlocks.DEEPSLATE_SPIDER_KUNZITE_ORE.get())
                .add(MMBlocks.DEEPSLATE_UNBREAKING_IOLITE_ORE.get())
                .setReplace(false)
        ;
    }
}
