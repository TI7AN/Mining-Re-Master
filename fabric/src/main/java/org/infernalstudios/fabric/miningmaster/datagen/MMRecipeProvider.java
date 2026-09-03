package org.infernalstudios.fabric.miningmaster.datagen;

import com.mojang.datafixers.util.Pair;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import org.infernalstudios.miningmaster.MiningMaster;
import org.infernalstudios.miningmaster.datagen.builder.MMGemForgingRecipeBuilder;
import org.infernalstudios.miningmaster.datagen.builder.MMGemSmithingRecipeBuilder;
import org.infernalstudios.miningmaster.init.MMBlocks;
import org.infernalstudios.miningmaster.init.MMEnchantments;
import org.infernalstudios.miningmaster.init.MMItems;
import org.infernalstudios.miningmaster.init.MMTags;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MMRecipeProvider extends FabricRecipeProvider {

    private final CompletableFuture<HolderLookup.Provider> registriesFuture;
    private HolderLookup<Enchantment> enchantments;

    public MMRecipeProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
        this.registriesFuture = registriesFuture;
        this.enchantments = this.registriesFuture.join().lookupOrThrow(Registries.ENCHANTMENT);
    }

    private void saveShaped(RecipeOutput exporter, ShapedRecipeBuilder builder, String name) {
        builder.save(exporter, ResourceLocation.fromNamespaceAndPath(MiningMaster.MOD_ID, "shaped/" + name));
    }

    private void saveShapeless(RecipeOutput exporter, ShapelessRecipeBuilder builder, String name) {
        builder.save(exporter, ResourceLocation.fromNamespaceAndPath(MiningMaster.MOD_ID, "shapeless/" + name));
    }

    @Override
    public void buildRecipes(RecipeOutput recipeExporter) {

        //<editor-fold desc="Example recipe">
//        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.ENCHANTED_GOLDEN_APPLE, 1)
//                .pattern("ggg")
//                .pattern("gag")
//                .pattern("ggg")
//                .define('g', Items.GOLD_BLOCK)
//                .define('a', Items.APPLE)
//                .unlockedBy(RecipeProvider.getHasName(Items.APPLE), has(Items.APPLE))
//                .save(recipeExporter)
//        ;
        //</editor-fold>

        //<editor-fold desc="Smithing table enchanting recipes">
        MMGemSmithingRecipeBuilder.smithing(
                        RecipeCategory.MISC,
                        Ingredient.of(MMTags.Items.MM_GEM_ENCHANTING_BLACKLIST),
                        Ingredient.of(Items.EMERALD),
                        List.of(
                                enchantments.getOrThrow(Enchantments.LOOTING),
                                enchantments.getOrThrow(Enchantments.FORTUNE)
                        )
                ).unlocks(getHasName(Items.EMERALD), has(Items.EMERALD))
                .save(recipeExporter)
        ;

        MMGemSmithingRecipeBuilder.smithing(
                        RecipeCategory.MISC,
                        Ingredient.of(MMTags.Items.MM_GEM_ENCHANTING_BLACKLIST),
                        Ingredient.of(Items.IRON_INGOT),
                        List.of(
                                enchantments.getOrThrow(Enchantments.PROTECTION)
                        )
                ).unlocks(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                .save(recipeExporter)
        ;

        MMGemSmithingRecipeBuilder.smithing(
                        RecipeCategory.MISC,
                        Ingredient.of(MMTags.Items.MM_GEM_ENCHANTING_BLACKLIST),
                        Ingredient.of(MMItems.AIR_MALACHITE.get()),
                        List.of(
                                enchantments.getOrThrow(Enchantments.FEATHER_FALLING),
                                enchantments.getOrThrow(Enchantments.RESPIRATION),
                                enchantments.getOrThrow(MMEnchantments.FLOATATION),
                                enchantments.getOrThrow(MMEnchantments.KNIGHT_JUMP)
                        )
                ).unlocks(getHasName(MMItems.AIR_MALACHITE.get()), has(MMItems.AIR_MALACHITE.get()))
                .save(recipeExporter)
        ;

        MMGemSmithingRecipeBuilder.smithing(
                        RecipeCategory.MISC,
                        Ingredient.of(MMTags.Items.MM_GEM_ENCHANTING_BLACKLIST),
                        Ingredient.of(MMItems.DIVE_AQUAMARINE.get()),
                        List.of(
                                enchantments.getOrThrow(Enchantments.AQUA_AFFINITY),
                                enchantments.getOrThrow(Enchantments.RIPTIDE),
                                enchantments.getOrThrow(MMEnchantments.GRACE)
                        )
                ).unlocks(getHasName(MMItems.DIVE_AQUAMARINE.get()), has(MMItems.DIVE_AQUAMARINE.get()))
                .save(recipeExporter)
        ;

        MMGemSmithingRecipeBuilder.smithing(
                        RecipeCategory.MISC,
                        Ingredient.of(MMTags.Items.MM_GEM_ENCHANTING_BLACKLIST),
                        Ingredient.of(MMItems.DIVINE_BERYL.get()),
                        List.of(
                                enchantments.getOrThrow(Enchantments.SMITE),
                                enchantments.getOrThrow(Enchantments.CHANNELING),
                                enchantments.getOrThrow(Enchantments.PIERCING)
                        )
                ).unlocks(getHasName(MMItems.DIVINE_BERYL.get()), has(MMItems.DIVINE_BERYL.get()))
                .save(recipeExporter)
        ;

        MMGemSmithingRecipeBuilder.smithing(
                        RecipeCategory.MISC,
                        Ingredient.of(MMTags.Items.MM_GEM_ENCHANTING_BLACKLIST),
                        Ingredient.of(MMItems.FIRE_RUBY.get()),
                        List.of(
                                enchantments.getOrThrow(Enchantments.FIRE_ASPECT),
                                enchantments.getOrThrow(Enchantments.FLAME),
                                enchantments.getOrThrow(Enchantments.FIRE_PROTECTION),
                                enchantments.getOrThrow(MMEnchantments.SMELTING)
                        )
                ).unlocks(getHasName(MMItems.FIRE_RUBY.get()), has(MMItems.FIRE_RUBY.get()))
                .save(recipeExporter)
        ;

        MMGemSmithingRecipeBuilder.smithing(
                        RecipeCategory.MISC,
                        Ingredient.of(MMTags.Items.MM_GEM_ENCHANTING_BLACKLIST),
                        Ingredient.of(MMItems.HASTE_PERIDOT.get()),
                        List.of(
                                enchantments.getOrThrow(Enchantments.EFFICIENCY),
                                enchantments.getOrThrow(Enchantments.LURE),
                                enchantments.getOrThrow(Enchantments.QUICK_CHARGE),
                                enchantments.getOrThrow(MMEnchantments.RUNNER)
                        )
                ).unlocks(getHasName(MMItems.HASTE_PERIDOT.get()), has(MMItems.HASTE_PERIDOT.get()))
                .save(recipeExporter)
        ;

        MMGemSmithingRecipeBuilder.smithing(
                        RecipeCategory.MISC,
                        Ingredient.of(MMTags.Items.MM_GEM_ENCHANTING_BLACKLIST),
                        Ingredient.of(MMItems.HEART_RHODONITE.get()),
                        List.of(
                                enchantments.getOrThrow(MMEnchantments.HEARTFELT)
                        )
                ).unlocks(getHasName(MMItems.HEART_RHODONITE.get()), has(MMItems.HEART_RHODONITE.get()))
                .save(recipeExporter)
        ;

        MMGemSmithingRecipeBuilder.smithing(
                        RecipeCategory.MISC,
                        Ingredient.of(MMTags.Items.MM_GEM_ENCHANTING_BLACKLIST),
                        Ingredient.of(MMItems.ICE_SAPPHIRE.get()),
                        List.of(
                                enchantments.getOrThrow(Enchantments.FROST_WALKER),
                                enchantments.getOrThrow(MMEnchantments.FREEZING),
                                enchantments.getOrThrow(MMEnchantments.SNOWPIERCER)
                        )
                ).unlocks(getHasName(MMItems.ICE_SAPPHIRE.get()), has(MMItems.ICE_SAPPHIRE.get()))
                .save(recipeExporter)
        ;

        MMGemSmithingRecipeBuilder.smithing(
                        RecipeCategory.MISC,
                        Ingredient.of(MMTags.Items.MM_GEM_ENCHANTING_BLACKLIST),
                        Ingredient.of(MMItems.KINETIC_OPAL.get()),
                        List.of(
                                enchantments.getOrThrow(Enchantments.BLAST_PROTECTION),
                                enchantments.getOrThrow(Enchantments.KNOCKBACK),
                                enchantments.getOrThrow(Enchantments.PUNCH)
                        )
                ).unlocks(getHasName(MMItems.KINETIC_OPAL.get()), has(MMItems.KINETIC_OPAL.get()))
                .save(recipeExporter)
        ;

        MMGemSmithingRecipeBuilder.smithing(
                        RecipeCategory.MISC,
                        Ingredient.of(MMTags.Items.MM_GEM_ENCHANTING_BLACKLIST),
                        Ingredient.of(MMItems.LUCKY_CITRINE.get()),
                        List.of(
                                enchantments.getOrThrow(Enchantments.FORTUNE),
                                enchantments.getOrThrow(Enchantments.LOOTING),
                                enchantments.getOrThrow(Enchantments.LUCK_OF_THE_SEA),
                                enchantments.getOrThrow(Enchantments.PROJECTILE_PROTECTION)
                        )
                ).unlocks(getHasName(MMItems.LUCKY_CITRINE.get()), has(MMItems.LUCKY_CITRINE.get()))
                .save(recipeExporter)
        ;

        MMGemSmithingRecipeBuilder.smithing(
                        RecipeCategory.MISC,
                        Ingredient.of(MMTags.Items.MM_GEM_ENCHANTING_BLACKLIST),
                        Ingredient.of(MMItems.POWER_PYRITE.get()),
                        List.of(
                                enchantments.getOrThrow(Enchantments.SHARPNESS),
                                enchantments.getOrThrow(Enchantments.POWER),
                                enchantments.getOrThrow(Enchantments.IMPALING),
                                enchantments.getOrThrow(MMEnchantments.STONEBREAKER)
                        )
                ).unlocks(getHasName(MMItems.POWER_PYRITE.get()), has(MMItems.POWER_PYRITE.get()))
                .save(recipeExporter)
        ;

        MMGemSmithingRecipeBuilder.smithing(
                        RecipeCategory.MISC,
                        Ingredient.of(MMTags.Items.MM_GEM_ENCHANTING_BLACKLIST),
                        Ingredient.of(MMItems.SPIDER_KUNZITE.get()),
                        List.of(
                                enchantments.getOrThrow(Enchantments.BANE_OF_ARTHROPODS),
                                enchantments.getOrThrow(Enchantments.SILK_TOUCH)
                        )
                ).unlocks(getHasName(MMItems.SPIDER_KUNZITE.get()), has(MMItems.SPIDER_KUNZITE.get()))
                .save(recipeExporter)
        ;

        MMGemSmithingRecipeBuilder.smithing(
                        RecipeCategory.MISC,
                        Ingredient.of(MMTags.Items.MM_GEM_ENCHANTING_BLACKLIST),
                        Ingredient.of(MMItems.SPIRIT_GARNET.get()),
                        List.of(
                                enchantments.getOrThrow(Enchantments.THORNS),
                                enchantments.getOrThrow(Enchantments.LOYALTY),
                                enchantments.getOrThrow(Enchantments.MULTISHOT),
                                enchantments.getOrThrow(MMEnchantments.LEECHING)
                        )
                ).unlocks(getHasName(MMItems.SPIRIT_GARNET.get()), has(MMItems.SPIRIT_GARNET.get()))
                .save(recipeExporter)
        ;

        MMGemSmithingRecipeBuilder.smithing(
                        RecipeCategory.MISC,
                        Ingredient.of(MMTags.Items.MM_GEM_ENCHANTING_BLACKLIST),
                        Ingredient.of(MMItems.UNBREAKING_IOLITE.get()),
                        List.of(
                                enchantments.getOrThrow(Enchantments.UNBREAKING)
                        )
                ).unlocks(getHasName(MMItems.UNBREAKING_IOLITE.get()), has(MMItems.UNBREAKING_IOLITE.get()))
                .save(recipeExporter)
        ;
        //</editor-fold>

        //<editor-fold desc="Compacted gem blocks crafting recipes">
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, MMBlocks.AIR_MALACHITE_BLOCK.get().asItem(), 1)
                .pattern("##")
                .pattern("##")
                .define('#', MMItems.AIR_MALACHITE.get())
                .unlockedBy(getHasName(MMItems.AIR_MALACHITE.get()), has(MMItems.AIR_MALACHITE.get()))
                .save(recipeExporter)
        ;

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, MMBlocks.DIVE_AQUAMARINE_BLOCK.get().asItem(), 1)
                .pattern("##")
                .pattern("##")
                .define('#', MMItems.DIVE_AQUAMARINE.get())
                .unlockedBy(getHasName(MMItems.DIVE_AQUAMARINE.get()), has(MMItems.DIVE_AQUAMARINE.get()))
                .save(recipeExporter)
        ;

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, MMBlocks.DIVINE_BERYL_BLOCK.get().asItem(), 1)
                .pattern("##")
                .pattern("##")
                .define('#', MMItems.DIVINE_BERYL.get())
                .unlockedBy(getHasName(MMItems.DIVINE_BERYL.get()), has(MMItems.DIVINE_BERYL.get()))
                .save(recipeExporter)
        ;

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, MMBlocks.FIRE_RUBY_BLOCK.get().asItem(), 1)
                .pattern("##")
                .pattern("##")
                .define('#', MMItems.FIRE_RUBY.get())
                .unlockedBy(getHasName(MMItems.FIRE_RUBY.get()), has(MMItems.FIRE_RUBY.get()))
                .save(recipeExporter)
        ;

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, MMBlocks.HASTE_PERIDOT_BLOCK.get().asItem(), 1)
                .pattern("##")
                .pattern("##")
                .define('#', MMItems.HASTE_PERIDOT.get())
                .unlockedBy(getHasName(MMItems.HASTE_PERIDOT.get()), has(MMItems.HASTE_PERIDOT.get()))
                .save(recipeExporter)
        ;

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, MMBlocks.HEART_RHODONITE_BLOCK.get().asItem(), 1)
                .pattern("##")
                .pattern("##")
                .define('#', MMItems.HEART_RHODONITE.get())
                .unlockedBy(getHasName(MMItems.HEART_RHODONITE.get()), has(MMItems.HEART_RHODONITE.get()))
                .save(recipeExporter)
        ;

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, MMBlocks.ICE_SAPPHIRE_BLOCK.get().asItem(), 1)
                .pattern("##")
                .pattern("##")
                .define('#', MMItems.ICE_SAPPHIRE.get())
                .unlockedBy(getHasName(MMItems.ICE_SAPPHIRE.get()), has(MMItems.ICE_SAPPHIRE.get()))
                .save(recipeExporter)
        ;

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, MMBlocks.KINETIC_OPAL_BLOCK.get().asItem(), 1)
                .pattern("##")
                .pattern("##")
                .define('#', MMItems.KINETIC_OPAL.get())
                .unlockedBy(getHasName(MMItems.KINETIC_OPAL.get()), has(MMItems.KINETIC_OPAL.get()))
                .save(recipeExporter)
        ;

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, MMBlocks.LUCKY_CITRINE_BLOCK.get().asItem(), 1)
                .pattern("##")
                .pattern("##")
                .define('#', MMItems.LUCKY_CITRINE.get())
                .unlockedBy(getHasName(MMItems.LUCKY_CITRINE.get()), has(MMItems.LUCKY_CITRINE.get()))
                .save(recipeExporter)
        ;

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, MMBlocks.POWER_PYRITE_BLOCK.get().asItem(), 1)
                .pattern("##")
                .pattern("##")
                .define('#', MMItems.POWER_PYRITE.get())
                .unlockedBy(getHasName(MMItems.POWER_PYRITE.get()), has(MMItems.POWER_PYRITE.get()))
                .save(recipeExporter)
        ;

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, MMBlocks.SPIDER_KUNZITE_BLOCK.get().asItem(), 1)
                .pattern("##")
                .pattern("##")
                .define('#', MMItems.SPIDER_KUNZITE.get())
                .unlockedBy(getHasName(MMItems.SPIDER_KUNZITE.get()), has(MMItems.SPIDER_KUNZITE.get()))
                .save(recipeExporter)
        ;

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, MMBlocks.SPIRIT_GARNET_BLOCK.get().asItem(), 1)
                .pattern("##")
                .pattern("##")
                .define('#', MMItems.SPIRIT_GARNET.get())
                .unlockedBy(getHasName(MMItems.SPIRIT_GARNET.get()), has(MMItems.SPIRIT_GARNET.get()))
                .save(recipeExporter)
        ;

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, MMBlocks.UNBREAKING_IOLITE_BLOCK.get().asItem(), 1)
                .pattern("##")
                .pattern("##")
                .define('#', MMItems.UNBREAKING_IOLITE.get())
                .unlockedBy(getHasName(MMItems.UNBREAKING_IOLITE.get()), has(MMItems.UNBREAKING_IOLITE.get()))
                .save(recipeExporter)
        ;
        //</editor-fold>

        //<editor-fold desc="Compacted gem block uncrafting recipes">
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, MMItems.AIR_MALACHITE.get(), 4)
                .requires(MMBlocks.AIR_MALACHITE_BLOCK.get().asItem(), 1)
                .unlockedBy(getHasName(MMItems.AIR_MALACHITE.get()), has(MMItems.AIR_MALACHITE.get()))
                .save(recipeExporter);
        ;

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, MMItems.DIVE_AQUAMARINE.get(), 4)
                .requires(Ingredient.of(MMBlocks.DIVE_AQUAMARINE_BLOCK.get().asItem()))
                .unlockedBy(getHasName(MMItems.DIVE_AQUAMARINE.get()), has(MMItems.DIVE_AQUAMARINE.get()))
                .save(recipeExporter);
        ;

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, MMItems.DIVINE_BERYL.get(), 4)
                .requires(Ingredient.of(MMBlocks.DIVINE_BERYL_BLOCK.get().asItem()), 1)
                .unlockedBy(getHasName(MMItems.DIVINE_BERYL.get()), has(MMItems.DIVINE_BERYL.get()))
                .save(recipeExporter);
        ;

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, MMItems.FIRE_RUBY.get(), 4)
                .requires(Ingredient.of(MMBlocks.FIRE_RUBY_BLOCK.get().asItem()), 1)
                .unlockedBy(getHasName(MMItems.FIRE_RUBY.get()), has(MMItems.FIRE_RUBY.get()))
                .save(recipeExporter);
        ;

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, MMItems.HASTE_PERIDOT.get(), 4)
                .requires(Ingredient.of(MMBlocks.HASTE_PERIDOT_BLOCK.get().asItem()), 1)
                .unlockedBy(getHasName(MMItems.HASTE_PERIDOT.get()), has(MMItems.HASTE_PERIDOT.get()))
                .save(recipeExporter);
        ;

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, MMItems.HEART_RHODONITE.get(), 4)
                .requires(Ingredient.of(MMBlocks.HEART_RHODONITE_BLOCK.get().asItem()), 1)
                .unlockedBy(getHasName(MMItems.HEART_RHODONITE.get()), has(MMItems.HEART_RHODONITE.get()))
                .save(recipeExporter);
        ;

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, MMItems.ICE_SAPPHIRE.get(), 4)
                .requires(Ingredient.of(MMBlocks.ICE_SAPPHIRE_BLOCK.get().asItem()), 1)
                .unlockedBy(getHasName(MMItems.ICE_SAPPHIRE.get()), has(MMItems.ICE_SAPPHIRE.get()))
                .save(recipeExporter);

        ;

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, MMItems.KINETIC_OPAL.get(), 4)
                .requires(Ingredient.of(MMBlocks.KINETIC_OPAL_BLOCK.get().asItem()), 1)
                .unlockedBy(getHasName(MMItems.KINETIC_OPAL.get()), has(MMItems.KINETIC_OPAL.get()))
                .save(recipeExporter);
        ;

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, MMItems.LUCKY_CITRINE.get(), 4)
                .requires(Ingredient.of(MMBlocks.LUCKY_CITRINE_BLOCK.get().asItem()), 1)
                .unlockedBy(getHasName(MMItems.LUCKY_CITRINE.get()), has(MMItems.LUCKY_CITRINE.get()))
                .save(recipeExporter);
        ;

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, MMItems.POWER_PYRITE.get(), 4)
                .requires(Ingredient.of(MMBlocks.POWER_PYRITE_BLOCK.get().asItem()), 1)
                .unlockedBy(getHasName(MMItems.POWER_PYRITE.get()), has(MMItems.POWER_PYRITE.get()))
                .save(recipeExporter);
        ;

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, MMItems.SPIDER_KUNZITE.get(), 4)
                .requires(Ingredient.of(MMBlocks.SPIDER_KUNZITE_BLOCK.get().asItem()), 1)
                .unlockedBy(getHasName(MMItems.SPIDER_KUNZITE.get()), has(MMItems.SPIDER_KUNZITE.get()))
                .save(recipeExporter);
        ;


        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, MMItems.SPIRIT_GARNET.get(), 4)
                .requires(Ingredient.of(MMBlocks.SPIRIT_GARNET_BLOCK.get().asItem()), 1)
                .unlockedBy(getHasName(MMItems.SPIRIT_GARNET.get()), has(MMItems.SPIRIT_GARNET.get()))
                .save(recipeExporter);
        ;


        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, MMItems.UNBREAKING_IOLITE.get(), 4)
                .requires(Ingredient.of(MMBlocks.UNBREAKING_IOLITE_BLOCK.get().asItem()), 1)
                .unlockedBy(getHasName(MMItems.UNBREAKING_IOLITE.get()), has(MMItems.UNBREAKING_IOLITE.get()))
                .save(recipeExporter);
        ;
        //</editor-fold>

        //<editor-fold desc="Gem Forge crafting recipe">
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, MMBlocks.GEM_FORGE.get().asItem(), 1)
                .pattern("III")
                .pattern("BLB")
                .pattern("BBB")
                .define('I', Items.IRON_INGOT)
                .define('B', Items.BLACKSTONE)
                .define('L', Items.LAVA_BUCKET)
                .unlockedBy(getHasName(Items.LAVA_BUCKET), has(Items.LAVA_BUCKET))
                .save(recipeExporter)
        ;
        //</editor-fold>

        MMGemForgingRecipeBuilder.forging(RecipeCategory.MISC, Ingredient.of(Items.BOW), MMItems.AIR_MALACHITE_BOW.get())
                .requires(MMItems.AIR_MALACHITE.get(), 5)
                .unlocks(getHasName(MMItems.AIR_MALACHITE.get()), has(MMItems.AIR_MALACHITE.get()))
                .withEnchantment(enchantments.getOrThrow(MMEnchantments.FLOATATION),5)
                .save(recipeExporter)
        ;

        MMGemForgingRecipeBuilder.forging(RecipeCategory.MISC, Ingredient.of(Items.DIAMOND_SWORD), MMItems.FIRE_RUBY_SWORD.get())
                .requires(MMItems.FIRE_RUBY.get(), 3)
                .unlocks(getHasName(MMItems.FIRE_RUBY.get()), has(MMItems.FIRE_RUBY.get()))
                .withEnchantment(enchantments.getOrThrow(Enchantments.FIRE_ASPECT),3)
                .save(recipeExporter)
        ;

        MMGemForgingRecipeBuilder.forging(RecipeCategory.MISC, Ingredient.of(Items.DIAMOND_AXE), MMItems.HASTE_PERIDOT_AXE.get())
                .requires(MMItems.HASTE_PERIDOT.get(), 5)
                .unlocks(getHasName(MMItems.HASTE_PERIDOT.get()), has(MMItems.HASTE_PERIDOT.get()))
                .withEnchantment(enchantments.getOrThrow(Enchantments.EFFICIENCY),6)
                .save(recipeExporter)
        ;

        MMGemForgingRecipeBuilder.forging(RecipeCategory.MISC, Ingredient.of(Items.DIAMOND_PICKAXE), MMItems.HASTE_PERIDOT_PICKAXE.get())
                .requires(MMItems.HASTE_PERIDOT.get(), 3)
                .unlocks(getHasName(MMItems.HASTE_PERIDOT.get()), has(MMItems.HASTE_PERIDOT.get()))
                .withEnchantment(enchantments.getOrThrow(Enchantments.EFFICIENCY),6)
                .save(recipeExporter)
        ;

        MMGemForgingRecipeBuilder.forging(RecipeCategory.MISC, Ingredient.of(Items.DIAMOND_SWORD), MMItems.ICE_SAPPHIRE_SWORD.get())
                .requires(MMItems.ICE_SAPPHIRE.get(), 3)
                .unlocks(getHasName(MMItems.ICE_SAPPHIRE.get()), has(MMItems.ICE_SAPPHIRE.get()))
                .withEnchantment(enchantments.getOrThrow(MMEnchantments.FREEZING),3)
                .save(recipeExporter)
        ;

        MMGemForgingRecipeBuilder.forging(RecipeCategory.MISC, Ingredient.of(Items.DIAMOND_AXE), MMItems.KINETIC_OPAL_AXE.get())
                .requires(MMItems.KINETIC_OPAL.get(), 3)
                .unlocks(getHasName(MMItems.KINETIC_OPAL.get()), has(MMItems.KINETIC_OPAL.get()))
                .withEnchantment(enchantments.getOrThrow(Enchantments.KNOCKBACK),3)
                .save(recipeExporter)
        ;

        MMGemForgingRecipeBuilder.forging(RecipeCategory.MISC, Ingredient.of(Items.DIAMOND_PICKAXE), MMItems.LUCKY_CITRINE_PICKAXE.get())
                .requires(MMItems.LUCKY_CITRINE.get(), 3)
                .unlocks(getHasName(MMItems.LUCKY_CITRINE.get()), has(MMItems.LUCKY_CITRINE.get()))
                .withEnchantment(enchantments.getOrThrow(Enchantments.FORTUNE),4)
                .save(recipeExporter)
        ;

        MMGemForgingRecipeBuilder.forging(RecipeCategory.MISC, Ingredient.of(Items.DIAMOND_SWORD), MMItems.LUCKY_CITRINE_SWORD.get())
                .requires(MMItems.LUCKY_CITRINE.get(), 3)
                .unlocks(getHasName(MMItems.LUCKY_CITRINE.get()), has(MMItems.LUCKY_CITRINE.get()))
                .withEnchantment(enchantments.getOrThrow(Enchantments.LOOTING),4)
                .save(recipeExporter)
        ;

        MMGemForgingRecipeBuilder.forging(RecipeCategory.MISC, Ingredient.of(Items.DIAMOND_BOOTS), MMItems.PARAGON_BOOTS.get())
                .requires(MMItems.KINETIC_OPAL.get(), 2)
                .requires(MMItems.ICE_SAPPHIRE.get(), 2)
                .requires(MMItems.AIR_MALACHITE.get(), 2)
                .unlocks(getHasName(MMItems.KINETIC_OPAL.get()), has(MMItems.KINETIC_OPAL.get()))
                .unlocks(getHasName(MMItems.ICE_SAPPHIRE.get()), has(MMItems.ICE_SAPPHIRE.get()))
                .unlocks(getHasName(MMItems.AIR_MALACHITE.get()), has(MMItems.AIR_MALACHITE.get()))
                .withEnchantment(enchantments.getOrThrow(MMEnchantments.RUNNER),3)
                .withEnchantment(enchantments.getOrThrow(Enchantments.FEATHER_FALLING),5)
                .withEnchantment(enchantments.getOrThrow(Enchantments.FROST_WALKER),2)
                .save(recipeExporter)
        ;

        MMGemForgingRecipeBuilder.forging(RecipeCategory.MISC, Ingredient.of(Items.DIAMOND_CHESTPLATE), MMItems.PARAGON_CHESTPLATE.get())
                .requires(MMItems.DIVE_AQUAMARINE.get(), 4)
                .requires(MMItems.HEART_RHODONITE.get(), 4)
                .unlocks(getHasName(MMItems.DIVE_AQUAMARINE.get()), has(MMItems.DIVE_AQUAMARINE.get()))
                .unlocks(getHasName(MMItems.HEART_RHODONITE.get()), has(MMItems.HEART_RHODONITE.get()))
                .withEnchantment(enchantments.getOrThrow(MMEnchantments.GRACE),5)
                .withEnchantment(enchantments.getOrThrow(MMEnchantments.HEARTFELT),4)
                .save(recipeExporter)
        ;

        MMGemForgingRecipeBuilder.forging(RecipeCategory.MISC, Ingredient.of(Items.DIAMOND_HELMET), MMItems.PARAGON_HELMET.get())
                .requires(MMItems.FIRE_RUBY.get(), 2)
                .requires(MMItems.KINETIC_OPAL.get(), 2)
                .requires(MMItems.SPIRIT_GARNET.get(), 2)
                .unlocks(getHasName(MMItems.FIRE_RUBY.get()), has(MMItems.FIRE_RUBY.get()))
                .unlocks(getHasName(MMItems.KINETIC_OPAL.get()), has(MMItems.KINETIC_OPAL.get()))
                .unlocks(getHasName(MMItems.SPIRIT_GARNET.get()), has(MMItems.SPIRIT_GARNET.get()))
                .withEnchantment(enchantments.getOrThrow(Enchantments.THORNS),3)
                .withEnchantment(enchantments.getOrThrow(Enchantments.FIRE_PROTECTION),4)
                .withEnchantment(enchantments.getOrThrow(Enchantments.BLAST_PROTECTION),4)
                .save(recipeExporter)
        ;

        MMGemForgingRecipeBuilder.forging(RecipeCategory.MISC, Ingredient.of(Items.DIAMOND_LEGGINGS), MMItems.PARAGON_LEGGINGS.get())
                .requires(MMItems.AIR_MALACHITE.get(), 3)
                .requires(MMItems.ICE_SAPPHIRE.get(), 1)
                .unlocks(getHasName(MMItems.AIR_MALACHITE.get()), has(MMItems.AIR_MALACHITE.get()))
                .unlocks(getHasName(MMItems.ICE_SAPPHIRE.get()), has(MMItems.ICE_SAPPHIRE.get()))
                .withEnchantment(enchantments.getOrThrow(MMEnchantments.KNIGHT_JUMP),4)
                .withEnchantment(enchantments.getOrThrow(MMEnchantments.SNOWPIERCER),1)
                .save(recipeExporter)
        ;

        MMGemForgingRecipeBuilder.forging(RecipeCategory.MISC, Ingredient.of(Items.DIAMOND_AXE), MMItems.POWER_PYRITE_AXE.get())
                .requires(MMItems.POWER_PYRITE.get(), 5)
                .unlocks(getHasName(MMItems.POWER_PYRITE.get()), has(MMItems.POWER_PYRITE.get()))
                .withEnchantment(enchantments.getOrThrow(Enchantments.SHARPNESS),6)
                .save(recipeExporter)
        ;

        MMGemForgingRecipeBuilder.forging(RecipeCategory.MISC, Ingredient.of(Items.DIAMOND_SWORD), MMItems.POWER_PYRITE_SWORD.get())
                .requires(MMItems.POWER_PYRITE.get(), 5)
                .unlocks(getHasName(MMItems.POWER_PYRITE.get()), has(MMItems.POWER_PYRITE.get()))
                .withEnchantment(enchantments.getOrThrow(Enchantments.SHARPNESS),6)
                .save(recipeExporter)
        ;

        MMGemForgingRecipeBuilder.forging(RecipeCategory.MISC, Ingredient.of(Items.DIAMOND_SWORD), MMItems.UNBREAKING_IOLITE_PICKAXE.get())
                .requires(MMItems.UNBREAKING_IOLITE.get(), 5)
                .unlocks(getHasName(MMItems.UNBREAKING_IOLITE.get()), has(MMItems.UNBREAKING_IOLITE.get()))
                .withEnchantment(enchantments.getOrThrow(Enchantments.UNBREAKING),4)
                .save(recipeExporter)
        ;

        MMGemForgingRecipeBuilder.forging(RecipeCategory.MISC, Ingredient.of(Items.DIAMOND_AXE), MMItems.ULTIMA_AXE.get())
                .requires(MMItems.POWER_PYRITE.get(), 3)
                .requires(MMItems.HASTE_PERIDOT.get(), 3)
                .requires(MMItems.KINETIC_OPAL.get(), 2)
                .unlocks(getHasName(MMItems.POWER_PYRITE.get()), has(MMItems.POWER_PYRITE.get()))
                .unlocks(getHasName(MMItems.HASTE_PERIDOT.get()), has(MMItems.HASTE_PERIDOT.get()))
                .unlocks(getHasName(MMItems.KINETIC_OPAL.get()), has(MMItems.KINETIC_OPAL.get()))
                .withEnchantment(enchantments.getOrThrow(Enchantments.SHARPNESS),6)
                .withEnchantment(enchantments.getOrThrow(Enchantments.EFFICIENCY),6)
                .withEnchantment(enchantments.getOrThrow(Enchantments.KNOCKBACK),3)
                .save(recipeExporter, "ultima_axe_1")
        ;

        MMGemForgingRecipeBuilder.forging(RecipeCategory.MISC, Ingredient.of(MMItems.POWER_PYRITE_AXE.get()), MMItems.ULTIMA_AXE.get())
                .requires(MMItems.HASTE_PERIDOT.get(), 3)
                .requires(MMItems.KINETIC_OPAL.get(), 2)
                .unlocks(getHasName(MMItems.HASTE_PERIDOT.get()), has(MMItems.HASTE_PERIDOT.get()))
                .unlocks(getHasName(MMItems.KINETIC_OPAL.get()), has(MMItems.KINETIC_OPAL.get()))
                .unlocks(getHasName(MMItems.POWER_PYRITE_AXE.get()), has(MMItems.POWER_PYRITE_AXE.get()))
                .withEnchantment(enchantments.getOrThrow(Enchantments.SHARPNESS),6)
                .withEnchantment(enchantments.getOrThrow(Enchantments.EFFICIENCY),6)
                .withEnchantment(enchantments.getOrThrow(Enchantments.KNOCKBACK),3)
                .save(recipeExporter, "ultima_axe_2")
        ;

        MMGemForgingRecipeBuilder.forging(RecipeCategory.MISC, Ingredient.of(MMItems.HASTE_PERIDOT_AXE.get()), MMItems.ULTIMA_AXE.get())
                .requires(MMItems.POWER_PYRITE.get(), 3)
                .requires(MMItems.KINETIC_OPAL.get(), 2)
                .unlocks(getHasName(MMItems.POWER_PYRITE.get()), has(MMItems.POWER_PYRITE.get()))
                .unlocks(getHasName(MMItems.KINETIC_OPAL.get()), has(MMItems.KINETIC_OPAL.get()))
                .unlocks(getHasName(MMItems.HASTE_PERIDOT_AXE.get()), has(MMItems.HASTE_PERIDOT_AXE.get()))
                .withEnchantment(enchantments.getOrThrow(Enchantments.SHARPNESS),6)
                .withEnchantment(enchantments.getOrThrow(Enchantments.EFFICIENCY),6)
                .withEnchantment(enchantments.getOrThrow(Enchantments.KNOCKBACK),3)
                .save(recipeExporter, "ultima_axe_3")
        ;

        MMGemForgingRecipeBuilder.forging(RecipeCategory.MISC, Ingredient.of(MMItems.KINETIC_OPAL_AXE.get()), MMItems.ULTIMA_AXE.get())
                .requires(MMItems.POWER_PYRITE.get(), 3)
                .requires(MMItems.HASTE_PERIDOT.get(), 3)
                .unlocks(getHasName(MMItems.POWER_PYRITE.get()), has(MMItems.POWER_PYRITE.get()))
                .unlocks(getHasName(MMItems.HASTE_PERIDOT.get()), has(MMItems.HASTE_PERIDOT.get()))
                .unlocks(getHasName(MMItems.KINETIC_OPAL_AXE.get()), has(MMItems.KINETIC_OPAL_AXE.get()))
                .withEnchantment(enchantments.getOrThrow(Enchantments.SHARPNESS),6)
                .withEnchantment(enchantments.getOrThrow(Enchantments.EFFICIENCY),6)
                .withEnchantment(enchantments.getOrThrow(Enchantments.KNOCKBACK),3)
                .save(recipeExporter, "ultima_axe_4")
        ;

        MMGemForgingRecipeBuilder.forging(RecipeCategory.MISC, Ingredient.of(Items.DIAMOND_PICKAXE), MMItems.ULTIMA_PICKAXE.get())
                .requires(MMItems.UNBREAKING_IOLITE.get(), 2)
                .requires(MMItems.LUCKY_CITRINE.get(), 2)
                .requires(MMItems.HASTE_PERIDOT.get(), 4)
                .unlocks(getHasName(MMItems.UNBREAKING_IOLITE.get()), has(MMItems.UNBREAKING_IOLITE.get()))
                .unlocks(getHasName(MMItems.LUCKY_CITRINE.get()), has(MMItems.LUCKY_CITRINE.get()))
                .unlocks(getHasName(MMItems.HASTE_PERIDOT.get()), has(MMItems.HASTE_PERIDOT.get()))
                .withEnchantment(enchantments.getOrThrow(Enchantments.EFFICIENCY),6)
                .withEnchantment(enchantments.getOrThrow(Enchantments.FORTUNE),4)
                .withEnchantment(enchantments.getOrThrow(Enchantments.UNBREAKING),3)
                .withEnchantment(enchantments.getOrThrow(MMEnchantments.SMELTING),1)
                .save(recipeExporter, "ultima_pickaxe_1")
        ;

        MMGemForgingRecipeBuilder.forging(RecipeCategory.MISC, Ingredient.of(MMItems.LUCKY_CITRINE_PICKAXE.get()), MMItems.ULTIMA_PICKAXE.get())
                .requires(MMItems.UNBREAKING_IOLITE.get(), 2)
                .requires(MMItems.FIRE_RUBY.get(), 1)
                .requires(MMItems.HASTE_PERIDOT.get(), 4)
                .unlocks(getHasName(MMItems.UNBREAKING_IOLITE.get()), has(MMItems.UNBREAKING_IOLITE.get()))
                .unlocks(getHasName(MMItems.FIRE_RUBY.get()), has(MMItems.FIRE_RUBY.get()))
                .unlocks(getHasName(MMItems.HASTE_PERIDOT.get()), has(MMItems.HASTE_PERIDOT.get()))
                .unlocks(getHasName(MMItems.LUCKY_CITRINE_PICKAXE.get()), has(MMItems.LUCKY_CITRINE_PICKAXE.get()))
                .withEnchantment(enchantments.getOrThrow(Enchantments.EFFICIENCY),6)
                .withEnchantment(enchantments.getOrThrow(Enchantments.FORTUNE),4)
                .withEnchantment(enchantments.getOrThrow(Enchantments.UNBREAKING),3)
                .withEnchantment(enchantments.getOrThrow(MMEnchantments.SMELTING),1)
                .save(recipeExporter, "ultima_pickaxe_2")
        ;

        MMGemForgingRecipeBuilder.forging(RecipeCategory.MISC, Ingredient.of(MMItems.HASTE_PERIDOT_PICKAXE.get()), MMItems.ULTIMA_PICKAXE.get())
                .requires(MMItems.UNBREAKING_IOLITE.get(), 2)
                .requires(MMItems.LUCKY_CITRINE.get(), 2)
                .requires(MMItems.FIRE_RUBY.get(), 1)
                .unlocks(getHasName(MMItems.UNBREAKING_IOLITE.get()), has(MMItems.UNBREAKING_IOLITE.get()))
                .unlocks(getHasName(MMItems.LUCKY_CITRINE.get()), has(MMItems.LUCKY_CITRINE.get()))
                .unlocks(getHasName(MMItems.FIRE_RUBY.get()), has(MMItems.FIRE_RUBY.get()))
                .unlocks(getHasName(MMItems.HASTE_PERIDOT_PICKAXE.get()), has(MMItems.HASTE_PERIDOT_PICKAXE.get()))
                .withEnchantment(enchantments.getOrThrow(Enchantments.EFFICIENCY),6)
                .withEnchantment(enchantments.getOrThrow(Enchantments.FORTUNE),4)
                .withEnchantment(enchantments.getOrThrow(Enchantments.UNBREAKING),3)
                .withEnchantment(enchantments.getOrThrow(MMEnchantments.SMELTING),1)
                .save(recipeExporter, "ultima_pickaxe_3")
        ;

        MMGemForgingRecipeBuilder.forging(RecipeCategory.MISC, Ingredient.of(MMItems.UNBREAKING_IOLITE_PICKAXE.get()), MMItems.ULTIMA_PICKAXE.get())
                .requires(MMItems.FIRE_RUBY.get(), 1)
                .requires(MMItems.LUCKY_CITRINE.get(), 2)
                .requires(MMItems.HASTE_PERIDOT.get(), 4)
                .unlocks(getHasName(MMItems.FIRE_RUBY.get()), has(MMItems.FIRE_RUBY.get()))
                .unlocks(getHasName(MMItems.LUCKY_CITRINE.get()), has(MMItems.LUCKY_CITRINE.get()))
                .unlocks(getHasName(MMItems.HASTE_PERIDOT.get()), has(MMItems.HASTE_PERIDOT.get()))
                .unlocks(getHasName(MMItems.UNBREAKING_IOLITE_PICKAXE.get()), has(MMItems.UNBREAKING_IOLITE_PICKAXE.get()))
                .withEnchantment(enchantments.getOrThrow(Enchantments.EFFICIENCY),6)
                .withEnchantment(enchantments.getOrThrow(Enchantments.FORTUNE),4)
                .withEnchantment(enchantments.getOrThrow(Enchantments.UNBREAKING),3)
                .withEnchantment(enchantments.getOrThrow(MMEnchantments.SMELTING),1)
                .save(recipeExporter, "ultima_pickaxe_4")
        ;

        MMGemForgingRecipeBuilder.forging(RecipeCategory.MISC, Ingredient.of(Items.DIAMOND_SWORD), MMItems.ULTIMA_SWORD.get())
                .requires(MMItems.FIRE_RUBY.get(), 3)
                .requires(MMItems.ICE_SAPPHIRE.get(), 3)
                .requires(MMItems.SPIRIT_GARNET.get(), 2)
                .requires(MMItems.LUCKY_CITRINE.get(), 1)
                .unlocks(getHasName(MMItems.FIRE_RUBY.get()), has(MMItems.FIRE_RUBY.get()))
                .unlocks(getHasName(MMItems.ICE_SAPPHIRE.get()), has(MMItems.ICE_SAPPHIRE.get()))
                .unlocks(getHasName(MMItems.SPIRIT_GARNET.get()), has(MMItems.SPIRIT_GARNET.get()))
                .unlocks(getHasName(MMItems.LUCKY_CITRINE.get()), has(MMItems.LUCKY_CITRINE.get()))
                .withEnchantment(enchantments.getOrThrow(Enchantments.FIRE_ASPECT),3)
                .withEnchantment(enchantments.getOrThrow(MMEnchantments.FREEZING),3)
                .withEnchantment(enchantments.getOrThrow(Enchantments.LOOTING),4)
                .withEnchantment(enchantments.getOrThrow(MMEnchantments.LEECHING),1)
                .save(recipeExporter, "ultima_sword_1")
        ;

        MMGemForgingRecipeBuilder.forging(RecipeCategory.MISC, Ingredient.of(MMItems.FIRE_RUBY_SWORD.get()), MMItems.ULTIMA_SWORD.get())
                .requires(MMItems.ICE_SAPPHIRE.get(), 3)
                .requires(MMItems.SPIRIT_GARNET.get(), 2)
                .requires(MMItems.LUCKY_CITRINE.get(), 1)
                .unlocks(getHasName(MMItems.ICE_SAPPHIRE.get()), has(MMItems.ICE_SAPPHIRE.get()))
                .unlocks(getHasName(MMItems.SPIRIT_GARNET.get()), has(MMItems.SPIRIT_GARNET.get()))
                .unlocks(getHasName(MMItems.LUCKY_CITRINE.get()), has(MMItems.LUCKY_CITRINE.get()))
                .unlocks(getHasName(MMItems.FIRE_RUBY_SWORD.get()), has(MMItems.FIRE_RUBY_SWORD.get()))
                .withEnchantment(enchantments.getOrThrow(Enchantments.FIRE_ASPECT),3)
                .withEnchantment(enchantments.getOrThrow(MMEnchantments.FREEZING),3)
                .withEnchantment(enchantments.getOrThrow(Enchantments.LOOTING),4)
                .withEnchantment(enchantments.getOrThrow(MMEnchantments.LEECHING),1)
                .save(recipeExporter, "ultima_sword_2")
        ;

        MMGemForgingRecipeBuilder.forging(RecipeCategory.MISC, Ingredient.of(MMItems.ICE_SAPPHIRE_SWORD.get()), MMItems.ULTIMA_SWORD.get())
                .requires(MMItems.FIRE_RUBY.get(), 3)
                .requires(MMItems.SPIRIT_GARNET.get(), 2)
                .requires(MMItems.LUCKY_CITRINE.get(), 1)
                .unlocks(getHasName(MMItems.FIRE_RUBY.get()), has(MMItems.FIRE_RUBY.get()))
                .unlocks(getHasName(MMItems.SPIRIT_GARNET.get()), has(MMItems.SPIRIT_GARNET.get()))
                .unlocks(getHasName(MMItems.LUCKY_CITRINE.get()), has(MMItems.LUCKY_CITRINE.get()))
                .unlocks(getHasName(MMItems.ICE_SAPPHIRE_SWORD.get()), has(MMItems.ICE_SAPPHIRE_SWORD.get()))
                .withEnchantment(enchantments.getOrThrow(Enchantments.FIRE_ASPECT),3)
                .withEnchantment(enchantments.getOrThrow(MMEnchantments.FREEZING),3)
                .withEnchantment(enchantments.getOrThrow(Enchantments.LOOTING),4)
                .withEnchantment(enchantments.getOrThrow(MMEnchantments.LEECHING),1)
                .save(recipeExporter, "ultima_sword_3")
        ;

        MMGemForgingRecipeBuilder.forging(RecipeCategory.MISC, Ingredient.of(MMItems.SPIRIT_GARNET_SWORD.get()), MMItems.ULTIMA_SWORD.get())
                .requires(MMItems.FIRE_RUBY.get(), 3)
                .requires(MMItems.ICE_SAPPHIRE.get(), 3)
                .requires(MMItems.LUCKY_CITRINE.get(), 1)
                .unlocks(getHasName(MMItems.FIRE_RUBY.get()), has(MMItems.FIRE_RUBY.get()))
                .unlocks(getHasName(MMItems.ICE_SAPPHIRE.get()), has(MMItems.ICE_SAPPHIRE.get()))
                .unlocks(getHasName(MMItems.LUCKY_CITRINE.get()), has(MMItems.LUCKY_CITRINE.get()))
                .unlocks(getHasName(MMItems.SPIRIT_GARNET_SWORD.get()), has(MMItems.SPIRIT_GARNET_SWORD.get()))
                .withEnchantment(enchantments.getOrThrow(Enchantments.FIRE_ASPECT),3)
                .withEnchantment(enchantments.getOrThrow(MMEnchantments.FREEZING),3)
                .withEnchantment(enchantments.getOrThrow(Enchantments.LOOTING),4)
                .withEnchantment(enchantments.getOrThrow(MMEnchantments.LEECHING),1)
                .save(recipeExporter, "ultima_sword_4")
        ;

        MMGemForgingRecipeBuilder.forging(RecipeCategory.MISC, Ingredient.of(MMItems.LUCKY_CITRINE_SWORD.get()), MMItems.ULTIMA_SWORD.get())
                .requires(MMItems.FIRE_RUBY.get(), 3)
                .requires(MMItems.ICE_SAPPHIRE.get(), 3)
                .requires(MMItems.SPIRIT_GARNET.get(), 2)
                .unlocks(getHasName(MMItems.FIRE_RUBY.get()), has(MMItems.FIRE_RUBY.get()))
                .unlocks(getHasName(MMItems.ICE_SAPPHIRE.get()), has(MMItems.ICE_SAPPHIRE.get()))
                .unlocks(getHasName(MMItems.SPIRIT_GARNET.get()), has(MMItems.SPIRIT_GARNET.get()))
                .unlocks(getHasName(MMItems.LUCKY_CITRINE_SWORD.get()), has(MMItems.LUCKY_CITRINE_SWORD.get()))
                .withEnchantment(enchantments.getOrThrow(Enchantments.FIRE_ASPECT),3)
                .withEnchantment(enchantments.getOrThrow(MMEnchantments.FREEZING),3)
                .withEnchantment(enchantments.getOrThrow(Enchantments.LOOTING),4)
                .withEnchantment(enchantments.getOrThrow(MMEnchantments.LEECHING),1)
                .save(recipeExporter, "ultima_sword_5")
        ;

    }
}
