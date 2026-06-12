package org.infernalstudios.fabric.miningmaster.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import org.infernalstudios.miningmaster.init.MMEnchantments;
import org.infernalstudios.miningmaster.init.MMTags;

import java.util.concurrent.CompletableFuture;

public class MMEnchantmentTagProvider extends FabricTagProvider.EnchantmentTagProvider {


    public MMEnchantmentTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        getOrCreateTagBuilder(MMTags.Enchantments.MM_TEMPERATURE_ENCHANTMENTS_EXCLUSIVE_SET)
                .add(Enchantments.FLAME)
                .add(Enchantments.FIRE_ASPECT)
                .add(MMEnchantments.FREEZING)
                .setReplace(false)
        ;

        getOrCreateTagBuilder(MMTags.Enchantments.MM_MINING_DROP_ALTERATION_ENCHANTMENTS_EXCLUSIVE_SET)
                .add(Enchantments.SILK_TOUCH)
                .add(MMEnchantments.STONEBREAKER)
                .add(MMEnchantments.SMELTING)
                .setReplace(false)
        ;

    }
}
