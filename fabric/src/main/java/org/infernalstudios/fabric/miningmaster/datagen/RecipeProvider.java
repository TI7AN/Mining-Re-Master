package org.infernalstudios.fabric.miningmaster.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import org.infernalstudios.miningmaster.datagen.builder.MMGemSmithingRecipeBuilder;
import org.infernalstudios.miningmaster.init.MMEnchantments;
import org.infernalstudios.miningmaster.init.MMItems;
import org.infernalstudios.miningmaster.init.MMTags;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class RecipeProvider extends FabricRecipeProvider {

    private final CompletableFuture<HolderLookup.Provider> registriesFuture;
    private HolderLookup<Enchantment> enchantments;

    public RecipeProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
        this.registriesFuture = registriesFuture;
        this.enchantments = this.registriesFuture.join().lookupOrThrow(Registries.ENCHANTMENT);
    }

    @Override
    public void buildRecipes(RecipeOutput recipeExporter) {

        //Example recipe
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.ENCHANTED_GOLDEN_APPLE, 1)
                .pattern("ggg")
                .pattern("gag")
                .pattern("ggg")
                .define('g', Items.GOLD_BLOCK)
                .define('a', Items.APPLE)
                .unlockedBy(net.minecraft.data.recipes.RecipeProvider.getHasName(Items.APPLE), net.minecraft.data.recipes.RecipeProvider.has(Items.APPLE))
                .save(recipeExporter)
        ;
        //End example

        MMGemSmithingRecipeBuilder.smithing(
                        RecipeCategory.MISC,
                        Ingredient.of(MMTags.Items.GEM_ENCHANTING_BLACKLIST),
                        Ingredient.of(Items.EMERALD),
                        List.of(
                                enchantments.getOrThrow(Enchantments.LOOTING),
                                enchantments.getOrThrow(Enchantments.FORTUNE)
                        )
                ).unlocks(net.minecraft.data.recipes.RecipeProvider.getHasName(Items.EMERALD), net.minecraft.data.recipes.RecipeProvider.has(Items.EMERALD))
                .save(recipeExporter)
        ;

        MMGemSmithingRecipeBuilder.smithing(
                        RecipeCategory.MISC,
                        Ingredient.of(MMTags.Items.GEM_ENCHANTING_BLACKLIST),
                        Ingredient.of(Items.IRON_INGOT),
                        List.of(
                                enchantments.getOrThrow(Enchantments.PROTECTION)
                        )
                ).unlocks(net.minecraft.data.recipes.RecipeProvider.getHasName(Items.IRON_INGOT), net.minecraft.data.recipes.RecipeProvider.has(Items.IRON_INGOT))
                .save(recipeExporter)
        ;

        MMGemSmithingRecipeBuilder.smithing(
                        RecipeCategory.MISC,
                        Ingredient.of(MMTags.Items.GEM_ENCHANTING_BLACKLIST),
                        Ingredient.of(MMItems.AIR_MALACHITE.get()),
                        List.of(
                                enchantments.getOrThrow(Enchantments.FEATHER_FALLING),
                                enchantments.getOrThrow(Enchantments.RESPIRATION),
                                enchantments.getOrThrow(MMEnchantments.FLOATATION),
                                enchantments.getOrThrow(MMEnchantments.KNIGHT_JUMP)
                        )
                ).unlocks(net.minecraft.data.recipes.RecipeProvider.getHasName(MMItems.AIR_MALACHITE.get()), net.minecraft.data.recipes.RecipeProvider.has(MMItems.AIR_MALACHITE.get()))
                .save(recipeExporter)
        ;

        MMGemSmithingRecipeBuilder.smithing(
                        RecipeCategory.MISC,
                        Ingredient.of(MMTags.Items.GEM_ENCHANTING_BLACKLIST),
                        Ingredient.of(MMItems.DIVE_AQUAMARINE.get()),
                        List.of(
                                enchantments.getOrThrow(Enchantments.AQUA_AFFINITY),
                                enchantments.getOrThrow(Enchantments.RIPTIDE),
                                enchantments.getOrThrow(MMEnchantments.GRACE)
                        )
                ).unlocks(net.minecraft.data.recipes.RecipeProvider.getHasName(MMItems.DIVE_AQUAMARINE.get()), net.minecraft.data.recipes.RecipeProvider.has(MMItems.DIVE_AQUAMARINE.get()))
                .save(recipeExporter)
        ;

        MMGemSmithingRecipeBuilder.smithing(
                        RecipeCategory.MISC,
                        Ingredient.of(MMTags.Items.GEM_ENCHANTING_BLACKLIST),
                        Ingredient.of(MMItems.DIVINE_BERYL.get()),
                        List.of(
                                enchantments.getOrThrow(Enchantments.SMITE),
                                enchantments.getOrThrow(Enchantments.CHANNELING),
                                enchantments.getOrThrow(Enchantments.PIERCING)
                        )
                ).unlocks(net.minecraft.data.recipes.RecipeProvider.getHasName(MMItems.DIVINE_BERYL.get()), net.minecraft.data.recipes.RecipeProvider.has(MMItems.DIVINE_BERYL.get()))
                .save(recipeExporter)
        ;

        MMGemSmithingRecipeBuilder.smithing(
                        RecipeCategory.MISC,
                        Ingredient.of(MMTags.Items.GEM_ENCHANTING_BLACKLIST),
                        Ingredient.of(MMItems.FIRE_RUBY.get()),
                        List.of(
                                enchantments.getOrThrow(Enchantments.FIRE_ASPECT),
                                enchantments.getOrThrow(Enchantments.FLAME),
                                enchantments.getOrThrow(Enchantments.FIRE_PROTECTION),
                                enchantments.getOrThrow(MMEnchantments.SMELTING)
                        )
                ).unlocks(net.minecraft.data.recipes.RecipeProvider.getHasName(MMItems.FIRE_RUBY.get()), net.minecraft.data.recipes.RecipeProvider.has(MMItems.FIRE_RUBY.get()))
                .save(recipeExporter)
        ;

        MMGemSmithingRecipeBuilder.smithing(
                        RecipeCategory.MISC,
                        Ingredient.of(MMTags.Items.GEM_ENCHANTING_BLACKLIST),
                        Ingredient.of(MMItems.HASTE_PERIDOT.get()),
                        List.of(
                                enchantments.getOrThrow(Enchantments.EFFICIENCY),
                                enchantments.getOrThrow(Enchantments.LURE),
                                enchantments.getOrThrow(Enchantments.QUICK_CHARGE),
                                enchantments.getOrThrow(MMEnchantments.RUNNER)
                        )
                ).unlocks(net.minecraft.data.recipes.RecipeProvider.getHasName(MMItems.HASTE_PERIDOT.get()), net.minecraft.data.recipes.RecipeProvider.has(MMItems.HASTE_PERIDOT.get()))
                .save(recipeExporter)
        ;

        MMGemSmithingRecipeBuilder.smithing(
                        RecipeCategory.MISC,
                        Ingredient.of(MMTags.Items.GEM_ENCHANTING_BLACKLIST),
                        Ingredient.of(MMItems.HEART_RHODONITE.get()),
                        List.of(
                                enchantments.getOrThrow(MMEnchantments.HEARTFELT)
                        )
                ).unlocks(net.minecraft.data.recipes.RecipeProvider.getHasName(MMItems.HEART_RHODONITE.get()), net.minecraft.data.recipes.RecipeProvider.has(MMItems.HEART_RHODONITE.get()))
                .save(recipeExporter)
        ;

        MMGemSmithingRecipeBuilder.smithing(
                        RecipeCategory.MISC,
                        Ingredient.of(MMTags.Items.GEM_ENCHANTING_BLACKLIST),
                        Ingredient.of(MMItems.ICE_SAPPHIRE.get()),
                        List.of(
                                enchantments.getOrThrow(Enchantments.FROST_WALKER),
                                enchantments.getOrThrow(MMEnchantments.FREEZING),
                                enchantments.getOrThrow(MMEnchantments.SNOWPIERCER)
                        )
                ).unlocks(net.minecraft.data.recipes.RecipeProvider.getHasName(MMItems.ICE_SAPPHIRE.get()), net.minecraft.data.recipes.RecipeProvider.has(MMItems.ICE_SAPPHIRE.get()))
                .save(recipeExporter)
        ;

        MMGemSmithingRecipeBuilder.smithing(
                        RecipeCategory.MISC,
                        Ingredient.of(MMTags.Items.GEM_ENCHANTING_BLACKLIST),
                        Ingredient.of(MMItems.KINETIC_OPAL.get()),
                        List.of(
                                enchantments.getOrThrow(Enchantments.BLAST_PROTECTION),
                                enchantments.getOrThrow(Enchantments.KNOCKBACK),
                                enchantments.getOrThrow(Enchantments.PUNCH)
                        )
                ).unlocks(net.minecraft.data.recipes.RecipeProvider.getHasName(MMItems.KINETIC_OPAL.get()), net.minecraft.data.recipes.RecipeProvider.has(MMItems.KINETIC_OPAL.get()))
                .save(recipeExporter)
        ;

        MMGemSmithingRecipeBuilder.smithing(
                        RecipeCategory.MISC,
                        Ingredient.of(MMTags.Items.GEM_ENCHANTING_BLACKLIST),
                        Ingredient.of(MMItems.LUCKY_CITRINE.get()),
                        List.of(
                                enchantments.getOrThrow(Enchantments.FORTUNE),
                                enchantments.getOrThrow(Enchantments.LOOTING),
                                enchantments.getOrThrow(Enchantments.LUCK_OF_THE_SEA),
                                enchantments.getOrThrow(Enchantments.PROJECTILE_PROTECTION)
                        )
                ).unlocks(net.minecraft.data.recipes.RecipeProvider.getHasName(MMItems.LUCKY_CITRINE.get()), net.minecraft.data.recipes.RecipeProvider.has(MMItems.LUCKY_CITRINE.get()))
                .save(recipeExporter)
        ;

        MMGemSmithingRecipeBuilder.smithing(
                        RecipeCategory.MISC,
                        Ingredient.of(MMTags.Items.GEM_ENCHANTING_BLACKLIST),
                        Ingredient.of(MMItems.POWER_PYRITE.get()),
                        List.of(
                                enchantments.getOrThrow(Enchantments.SHARPNESS),
                                enchantments.getOrThrow(Enchantments.POWER),
                                enchantments.getOrThrow(Enchantments.IMPALING),
                                enchantments.getOrThrow(MMEnchantments.STONEBREAKER)
                        )
                ).unlocks(net.minecraft.data.recipes.RecipeProvider.getHasName(MMItems.POWER_PYRITE.get()), net.minecraft.data.recipes.RecipeProvider.has(MMItems.POWER_PYRITE.get()))
                .save(recipeExporter)
        ;

        MMGemSmithingRecipeBuilder.smithing(
                        RecipeCategory.MISC,
                        Ingredient.of(MMTags.Items.GEM_ENCHANTING_BLACKLIST),
                        Ingredient.of(MMItems.SPIDER_KUNZITE.get()),
                        List.of(
                                enchantments.getOrThrow(Enchantments.BANE_OF_ARTHROPODS),
                                enchantments.getOrThrow(Enchantments.SILK_TOUCH)
                        )
                ).unlocks(net.minecraft.data.recipes.RecipeProvider.getHasName(MMItems.SPIDER_KUNZITE.get()), net.minecraft.data.recipes.RecipeProvider.has(MMItems.SPIDER_KUNZITE.get()))
                .save(recipeExporter)
        ;

        MMGemSmithingRecipeBuilder.smithing(
                        RecipeCategory.MISC,
                        Ingredient.of(MMTags.Items.GEM_ENCHANTING_BLACKLIST),
                        Ingredient.of(MMItems.SPIRIT_GARNET.get()),
                        List.of(
                                enchantments.getOrThrow(Enchantments.THORNS),
                                enchantments.getOrThrow(Enchantments.LOYALTY),
                                enchantments.getOrThrow(Enchantments.MULTISHOT),
                                enchantments.getOrThrow(MMEnchantments.LEECHING)
                        )
                ).unlocks(net.minecraft.data.recipes.RecipeProvider.getHasName(MMItems.SPIRIT_GARNET.get()), net.minecraft.data.recipes.RecipeProvider.has(MMItems.SPIRIT_GARNET.get()))
                .save(recipeExporter)
        ;

        MMGemSmithingRecipeBuilder.smithing(
                        RecipeCategory.MISC,
                        Ingredient.of(MMTags.Items.GEM_ENCHANTING_BLACKLIST),
                        Ingredient.of(MMItems.UNBREAKING_IOLITE.get()),
                        List.of(
                                enchantments.getOrThrow(Enchantments.UNBREAKING)
                        )
                ).unlocks(net.minecraft.data.recipes.RecipeProvider.getHasName(MMItems.UNBREAKING_IOLITE.get()), net.minecraft.data.recipes.RecipeProvider.has(MMItems.UNBREAKING_IOLITE.get()))
                .save(recipeExporter)
        ;
    }
}
