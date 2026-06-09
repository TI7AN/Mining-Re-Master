package org.infernalstudios.fabric.miningmaster.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import org.infernalstudios.miningmaster.init.MMBlocks;
import org.infernalstudios.miningmaster.init.MMItems;
import org.infernalstudios.miningmaster.init.MMTags;

import java.util.concurrent.CompletableFuture;

public class MMItemTagProvider extends FabricTagProvider<Item> {

    public MMItemTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, Registries.ITEM, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        getOrCreateTagBuilder(MMTags.Items.MM_CATALYSTS)
                .add(Items.DIAMOND_SWORD)
                .add(MMItems.FIRE_RUBY_SWORD.get())
                .add(MMItems.ICE_SAPPHIRE_SWORD.get())
                .add(MMItems.SPIRIT_GARNET_SWORD.get())
                .add(Items.DIAMOND_AXE)
                .add(MMItems.POWER_PYRITE_AXE.get())
                .add(MMItems.HASTE_PERIDOT_AXE.get())
                .add(MMItems.KINETIC_OPAL_AXE.get())
                .add(Items.DIAMOND_PICKAXE)
                .add(MMItems.LUCKY_CITRINE_PICKAXE.get())
                .add(MMItems.HASTE_PERIDOT_PICKAXE.get())
                .add(MMItems.UNBREAKING_IOLITE_PICKAXE.get())
                .add(Items.BOW)
                .add(Items.DIAMOND_HELMET)
                .add(Items.DIAMOND_CHESTPLATE)
                .add(Items.DIAMOND_LEGGINGS)
                .add(Items.DIAMOND_BOOTS)
                .setReplace(false)
        ;

        getOrCreateTagBuilder(MMTags.Items.MM_GEM_ENCHANTING_BLACKLIST)
                .setReplace(false)
        ;

        getOrCreateTagBuilder(MMTags.Items.MM_GEMS)
                .add(MMItems.FIRE_RUBY.get())
                .add(MMItems.ICE_SAPPHIRE.get())
                .add(MMItems.SPIRIT_GARNET.get())
                .add(MMItems.LUCKY_CITRINE.get())
                .add(MMItems.HASTE_PERIDOT.get())
                .add(MMItems.DIVE_AQUAMARINE.get())
                .add(MMItems.DIVINE_BERYL.get())
                .add(MMItems.SPIDER_KUNZITE.get())
                .add(MMItems.UNBREAKING_IOLITE.get())
                .add(MMItems.POWER_PYRITE.get())
                .add(MMItems.HEART_RHODONITE.get())
                .add(MMItems.KINETIC_OPAL.get())
                .add(MMItems.AIR_MALACHITE.get())
                .add(Items.IRON_INGOT) //This one is for testing
                .setReplace(false)
        ;

        getOrCreateTagBuilder(MMTags.Items.MM_STONEBREAKER_ITEMS)
                .add(Items.STONE)
                .add(Items.COBBLESTONE)
                .add(Items.DIORITE)
                .add(Items.ANDESITE)
                .add(Items.GRANITE)
                .add(Items.GRAVEL)
                .add(Items.GRASS_BLOCK)
                .add(Items.DIRT)
                .add(Items.COARSE_DIRT)
                .add(Items.NETHERRACK)
                .add(Items.DEEPSLATE)
                .add(Items.COBBLED_DEEPSLATE)
                .setReplace(false)
        ;

        getOrCreateTagBuilder(MMTags.Items.C_GEMS)
                .add(MMItems.FIRE_RUBY.get())
                .add(MMItems.ICE_SAPPHIRE.get())
                .add(MMItems.SPIRIT_GARNET.get())
                .add(MMItems.HASTE_PERIDOT.get())
                .add(MMItems.LUCKY_CITRINE.get())
                .add(MMItems.DIVE_AQUAMARINE.get())
                .add(MMItems.DIVINE_BERYL.get())
                .add(MMItems.SPIDER_KUNZITE.get())
                .add(MMItems.UNBREAKING_IOLITE.get())
                .add(MMItems.HEART_RHODONITE.get())
                .add(MMItems.POWER_PYRITE.get())
                .add(MMItems.KINETIC_OPAL.get())
                .add(MMItems.AIR_MALACHITE.get())

                .setReplace(false)
        ;

        getOrCreateTagBuilder(MMTags.Items.C_ORES)
                .add(MMBlocks.FIRE_RUBY_ORE.get().asItem())
                .add(MMBlocks.ICE_SAPPHIRE_ORE.get().asItem())
                .add(MMBlocks.SPIRIT_GARNET_ORE.get().asItem())
                .add(MMBlocks.HASTE_PERIDOT_ORE.get().asItem())
                .add(MMBlocks.LUCKY_CITRINE_ORE.get().asItem())
                .add(MMBlocks.DIVE_AQUAMARINE_ORE.get().asItem())
                .add(MMBlocks.DIVINE_BERYL_ORE.get().asItem())
                .add(MMBlocks.SPIDER_KUNZITE_ORE.get().asItem())
                .add(MMBlocks.UNBREAKING_IOLITE_ORE.get().asItem())
                .add(MMBlocks.HEART_RHODONITE_ORE.get().asItem())
                .add(MMBlocks.POWER_PYRITE_ORE.get().asItem())
                .add(MMBlocks.KINETIC_OPAL_ORE.get().asItem())
                .add(MMBlocks.AIR_MALACHITE_ORE.get().asItem())

                .add(MMBlocks.DEEPSLATE_FIRE_RUBY_ORE.get().asItem())
                .add(MMBlocks.DEEPSLATE_ICE_SAPPHIRE_ORE.get().asItem())
                .add(MMBlocks.DEEPSLATE_SPIRIT_GARNET_ORE.get().asItem())
                .add(MMBlocks.DEEPSLATE_HASTE_PERIDOT_ORE.get().asItem())
                .add(MMBlocks.DEEPSLATE_LUCKY_CITRINE_ORE.get().asItem())
                .add(MMBlocks.DEEPSLATE_DIVE_AQUAMARINE_ORE.get().asItem())
                .add(MMBlocks.DEEPSLATE_DIVINE_BERYL_ORE.get().asItem())
                .add(MMBlocks.DEEPSLATE_SPIDER_KUNZITE_ORE.get().asItem())
                .add(MMBlocks.DEEPSLATE_UNBREAKING_IOLITE_ORE.get().asItem())
                .setReplace(false)
        ;

    }
}
