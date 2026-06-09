package org.infernalstudios.neoforge.miningmaster.datagen;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderSet;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import org.infernalstudios.miningmaster.MiningMaster;
import org.infernalstudios.miningmaster.init.MMFeatures;
import org.infernalstudios.miningmaster.init.MMTags;

import java.util.concurrent.CompletableFuture;

public class BiomeModifierProvider extends DataMapProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, BiomeModifierProvider::bootstrap);

    public static final ResourceKey<BiomeModifier> DIVE_AQUAMARINE_NATIVE_BIOME_MODIFIER = ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(MiningMaster.MOD_ID, "dive_aquamarine_native_biome_modifier"));
    public static final ResourceKey<BiomeModifier> DIVINE_BERYL_NATIVE_BIOME_MODIFIER = ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(MiningMaster.MOD_ID, "divine_beryl_native_biome_modifier"));
    public static final ResourceKey<BiomeModifier> FIRE_RUBY_NATIVE_BIOME_MODIFIER = ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(MiningMaster.MOD_ID, "fire_ruby_native_biome_modifier"));
    public static final ResourceKey<BiomeModifier> HASTE_PERIDOT_NATIVE_BIOME_MODIFIER = ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(MiningMaster.MOD_ID, "haste_peridot_native_biome_modifier"));
    public static final ResourceKey<BiomeModifier> HEART_RHODONITE_NATIVE_BIOME_MODIFIER = ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(MiningMaster.MOD_ID, "heart_rhodonite_native_biome_modifier"));
    public static final ResourceKey<BiomeModifier> ICE_SAPPHIRE_NATIVE_BIOME_MODIFIER = ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(MiningMaster.MOD_ID, "ice_sapphire_native_biome_modifier"));
    public static final ResourceKey<BiomeModifier> KINETIC_OPAL_NATIVE_BIOME_MODIFIER = ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(MiningMaster.MOD_ID, "kinetic_opal_native_biome_modifier"));
    public static final ResourceKey<BiomeModifier> LUCKY_CITRINE_NATIVE_BIOME_MODIFIER = ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(MiningMaster.MOD_ID, "lucky_citrine_native_biome_modifier"));
    public static final ResourceKey<BiomeModifier> POWER_PYRITE_NATIVE_BIOME_MODIFIER = ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(MiningMaster.MOD_ID, "power_pyrite_native_biome_modifier"));
    public static final ResourceKey<BiomeModifier> SPIDER_KUNZITE_NATIVE_BIOME_MODIFIER = ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(MiningMaster.MOD_ID, "spider_kunzite_native_biome_modifier"));
    public static final ResourceKey<BiomeModifier> SPIRIT_GARNET_NATIVE_BIOME_MODIFIER = ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(MiningMaster.MOD_ID, "spirit_garnet_native_biome_modifier"));
    public static final ResourceKey<BiomeModifier> UNBREAKING_IOLITE_NATIVE_BIOME_MODIFIER = ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(MiningMaster.MOD_ID, "unbreaking_iolite_native_biome_modifier"));

    protected BiomeModifierProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);
        HolderGetter<PlacedFeature> placedFeatures = context.lookup(Registries.PLACED_FEATURE);

        //DIVE_AQUAMARINE_NATIVE_BIOME_MODIFIER
        var diveAquamarineFeature = placedFeatures.getOrThrow(MMFeatures.PlacedFeatures.DIVE_AQUAMARINE_VEIN_PLACED_KEY);
        context.register(
                DIVE_AQUAMARINE_NATIVE_BIOME_MODIFIER,
                new BiomeModifiers.AddFeaturesBiomeModifier(
                    biomes.getOrThrow(BiomeTags.IS_OCEAN),
                    HolderSet.direct(diveAquamarineFeature),
                    GenerationStep.Decoration.UNDERGROUND_ORES
                )
        );

        //DIVINE_BERYL_NATIVE_BIOME_MODIFIER
        var divineBerylFeature = placedFeatures.getOrThrow(MMFeatures.PlacedFeatures.DIVINE_BERYL_VEIN_PLACED_KEY);
        context.register(
                DIVINE_BERYL_NATIVE_BIOME_MODIFIER,
                new BiomeModifiers.AddFeaturesBiomeModifier(
                        biomes.getOrThrow(MMTags.Biomes.MM_DIVINE_BERYL_BIOMES),
                        HolderSet.direct(divineBerylFeature),
                        GenerationStep.Decoration.UNDERGROUND_ORES
                )
        );

        //FIRE_RUBY_NATIVE_BIOME_MODIFIER
        var fireRubyFeature = placedFeatures.getOrThrow(MMFeatures.PlacedFeatures.FIRE_RUBY_VEIN_PLACED_KEY);
        context.register(
                FIRE_RUBY_NATIVE_BIOME_MODIFIER,
                new BiomeModifiers.AddFeaturesBiomeModifier(
                        HolderSet.direct(biomes.getOrThrow(Biomes.DESERT)),
                        HolderSet.direct(fireRubyFeature),
                        GenerationStep.Decoration.UNDERGROUND_ORES
                )
        );

        //HASTE_PERIDOT_NATIVE_BIOME_MODIFIER
        var hastePeridotFeature = placedFeatures.getOrThrow(MMFeatures.PlacedFeatures.HASTE_PERIDOT_VEIN_PLACED_KEY);
        context.register(
                HASTE_PERIDOT_NATIVE_BIOME_MODIFIER,
                new BiomeModifiers.AddFeaturesBiomeModifier(
                        biomes.getOrThrow(BiomeTags.IS_JUNGLE),
                        HolderSet.direct(hastePeridotFeature),
                        GenerationStep.Decoration.UNDERGROUND_ORES
                )
        );

        //HEART_RHODONITE_NATIVE_BIOME_MODIFIER
        var heartRhodoniteFeature = placedFeatures.getOrThrow(MMFeatures.PlacedFeatures.HEART_RHODONITE_VEIN_PLACED_KEY);
        context.register(
                HEART_RHODONITE_NATIVE_BIOME_MODIFIER,
                new BiomeModifiers.AddFeaturesBiomeModifier(
                        HolderSet.direct(biomes.getOrThrow(Biomes.SOUL_SAND_VALLEY)),
                        HolderSet.direct(heartRhodoniteFeature),
                        GenerationStep.Decoration.UNDERGROUND_ORES
                )
        );

        //ICE_SAPPHIRE_NATIVE_BIOME_MODIFIER
        var iceSapphireFeature = placedFeatures.getOrThrow(MMFeatures.PlacedFeatures.ICE_SAPPHIRE_VEIN_PLACED_KEY);
        context.register(
                ICE_SAPPHIRE_NATIVE_BIOME_MODIFIER,
                new BiomeModifiers.AddFeaturesBiomeModifier(
                        biomes.getOrThrow(MMTags.Biomes.C_IS_COLD_OVERWORLD),
                        HolderSet.direct(iceSapphireFeature),
                        GenerationStep.Decoration.UNDERGROUND_ORES
                )
        );

        //KINETIC_OPAL_NATIVE_BIOME_MODIFIER
        var kineticOpalFeature = placedFeatures.getOrThrow(MMFeatures.PlacedFeatures.KINETIC_OPAL_VEIN_PLACED_KEY);
        context.register(
                KINETIC_OPAL_NATIVE_BIOME_MODIFIER,
                new BiomeModifiers.AddFeaturesBiomeModifier(
                        HolderSet.direct(biomes.getOrThrow(Biomes.BASALT_DELTAS)),
                        HolderSet.direct(kineticOpalFeature),
                        GenerationStep.Decoration.UNDERGROUND_ORES
                )
        );

        //LUCKY_CITRINE_NATIVE_BIOME_MODIFIER
        var luckyCitrineFeature = placedFeatures.getOrThrow(MMFeatures.PlacedFeatures.LUCKY_CITRINE_VEIN_PLACED_KEY);
        context.register(
                LUCKY_CITRINE_NATIVE_BIOME_MODIFIER,
                new BiomeModifiers.AddFeaturesBiomeModifier(
                        biomes.getOrThrow(BiomeTags.IS_BADLANDS),
                        HolderSet.direct(luckyCitrineFeature),
                        GenerationStep.Decoration.UNDERGROUND_ORES
                )
        );

        //POWER_PYRITE_NATIVE_BIOME_MODIFIER
        var powerPyriteFeature = placedFeatures.getOrThrow(MMFeatures.PlacedFeatures.POWER_PYRITE_VEIN_PLACED_KEY);
        context.register(
                POWER_PYRITE_NATIVE_BIOME_MODIFIER,
                new BiomeModifiers.AddFeaturesBiomeModifier(
                        HolderSet.direct(biomes.getOrThrow(Biomes.CRIMSON_FOREST)),
                        HolderSet.direct(powerPyriteFeature),
                        GenerationStep.Decoration.UNDERGROUND_ORES
                )
        );

        //SPIDER_KUNZITE_NATIVE_BIOME_MODIFIER
        var spiderKunziteFeature = placedFeatures.getOrThrow(MMFeatures.PlacedFeatures.SPIDER_KUNZITE_VEIN_PLACED_KEY);
        context.register(
                SPIDER_KUNZITE_NATIVE_BIOME_MODIFIER,
                new BiomeModifiers.AddFeaturesBiomeModifier(
                        biomes.getOrThrow(BiomeTags.IS_FOREST),
                        HolderSet.direct(spiderKunziteFeature),
                        GenerationStep.Decoration.UNDERGROUND_ORES
                )
        );

        //SPIRIT_GARNET_NATIVE_BIOME_MODIFIER
        var spiritGarnetFeature = placedFeatures.getOrThrow(MMFeatures.PlacedFeatures.SPIRIT_GARNET_VEIN_PLACED_KEY);
        context.register(
                SPIRIT_GARNET_NATIVE_BIOME_MODIFIER,
                new BiomeModifiers.AddFeaturesBiomeModifier(
                        HolderSet.direct(
                                biomes.getOrThrow(Biomes.SUNFLOWER_PLAINS),
                                biomes.getOrThrow(Biomes.FLOWER_FOREST),
                                biomes.getOrThrow(Biomes.LUSH_CAVES)
                                ),
                        HolderSet.direct(spiritGarnetFeature),
                        GenerationStep.Decoration.UNDERGROUND_ORES
                )
        );

        //UNBREAKING_IOLITE_NATIVE_BIOME_MODIFIER
        var unbreakingIoliteFeature = placedFeatures.getOrThrow(MMFeatures.PlacedFeatures.UNBREAKING_IOLITE_VEIN_PLACED_KEY);
        context.register(
                UNBREAKING_IOLITE_NATIVE_BIOME_MODIFIER,
                new BiomeModifiers.AddFeaturesBiomeModifier(
                        biomes.getOrThrow(MMTags.Biomes.MM_UNBREAKING_IOLITE_BIOMES),
                        HolderSet.direct(unbreakingIoliteFeature),
                        GenerationStep.Decoration.UNDERGROUND_ORES
                )
        );
    }

    @Override
    public String getName() {
        return "Biome Modifier";
    }
}
