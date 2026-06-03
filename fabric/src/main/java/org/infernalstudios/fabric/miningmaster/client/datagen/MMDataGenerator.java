package org.infernalstudios.fabric.miningmaster.client.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import org.infernalstudios.fabric.miningmaster.client.datagen.provider.MMRecipeProvider;

public class MMDataGenerator implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator dataGenerator) {
        FabricDataGenerator.Pack pack = dataGenerator.createPack();

        pack.addProvider(MMRecipeProvider::new);

    }
}
