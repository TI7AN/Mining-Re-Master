package org.infernalstudios.fabric.miningmaster.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;

public class MMDataGenerator implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator dataGenerator) {
        FabricDataGenerator.Pack pack = dataGenerator.createPack();

        pack.addProvider(MMItemTagProvider::new);
        pack.addProvider(MMBlockTagProvider::new);
        pack.addProvider(MMRecipeProvider::new);
        pack.addProvider(MMBiomeTagProvider::new);
        pack.addProvider(MMWorldgenProvider::new);
        pack.addProvider(MMEnchantmentTagProvider::new);
        pack.addProvider(MMEnchantmentProvider::new);
    }

    @Override
    public void buildRegistry(RegistrySetBuilder registryBuilder) {
        registryBuilder.add(Registries.ENCHANTMENT, MMEnchantmentProvider::bootstrap);
        registryBuilder.add(Registries.CONFIGURED_FEATURE, MMConfiguredFeatures::configure);
        registryBuilder.add(Registries.PLACED_FEATURE, MMPlacedFeatures::configure);
    }
}
