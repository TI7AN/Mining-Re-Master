package org.infernalstudios.neoforge.miningmaster.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.registries.RegistryPatchGenerator;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import org.infernalstudios.miningmaster.MiningMaster;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = MiningMaster.MOD_ID)
public class DataGenerators {

    @SubscribeEvent // on the mod event bus
    public static void registerDataProviders(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        RegistrySetBuilder builder = new RegistrySetBuilder();
        builder.add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, BiomeModifierProvider::bootstrap);
        DatapackBuiltinEntriesProvider datapackProvider = new DatapackBuiltinEntriesProvider(packOutput, lookupProvider, builder, Set.of(MiningMaster.MOD_ID));

        generator.addProvider(event.includeServer(), datapackProvider);
    }

//    private static CompletableFuture<RegistrySetBuilder.PatchedRegistries> createLookup(final CompletableFuture<HolderLookup.Provider> lookupProvider) {
//        final var builder = new RegistrySetBuilder()
////                .add(Registries.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap)
////                .add(Registries.PLACED_FEATURE, ModPlacedFeatures::bootstrap)
////                .add(Registries.BIOME, ModBiomes::bootstrap)
//                .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, BiomeModifierProvider::bootstrap)
////                .add(Registries.JUKEBOX_SONG, TestMod3JukeboxSongs::bootstrap)
//                ;
//
//        return RegistryPatchGenerator.createLookup(lookupProvider, builder);
//    }
}
