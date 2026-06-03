/*
 * Copyright 2022 Infernal Studios
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.infernalstudios.miningmaster.init;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.enchantment.Enchantments;
import org.infernalstudios.miningmaster.MiningMaster;
//import org.infernalstudios.miningmaster.items.GemArmorItem;
import org.infernalstudios.miningmaster.items.GemAxeItem;
import org.infernalstudios.miningmaster.items.GemItem;
import org.infernalstudios.miningmaster.items.GemPickaxeItem;
import org.infernalstudios.miningmaster.items.GemSwordItem;
//import org.infernalstudios.miningmaster.items.GemArmorItem;
//import org.infernalstudios.miningmaster.items.GemAxeItem;
//import org.infernalstudios.miningmaster.items.GemBowItem;
//import org.infernalstudios.miningmaster.items.GemPickaxeItem;
//import org.infernalstudios.miningmaster.items.GemSwordItem;

import java.util.function.Supplier;

public class MMItems {

    // GEMS
    public static final Item FIRE_RUBY = register("fire_ruby",new GemItem());
    public static final Item ICE_SAPPHIRE = register("ice_sapphire", new GemItem());
    public static final Item SPIRIT_GARNET = register("spirit_garnet", new GemItem());
    public static final Item HASTE_PERIDOT = register("haste_peridot", new GemItem());
    public static final Item LUCKY_CITRINE = register("lucky_citrine", new GemItem());
    public static final Item DIVE_AQUAMARINE = register("dive_aquamarine", new GemItem());
    public static final Item DIVINE_BERYL = register("divine_beryl", new GemItem());
    public static final Item SPIDER_KUNZITE = register("spider_kunzite", new GemItem());
    public static final Item UNBREAKING_IOLITE = register("unbreaking_iolite", new GemItem());
    public static final Item HEART_RHODONITE = register("heart_rhodonite", new GemItem());
    public static final Item POWER_PYRITE = register("power_pyrite", new GemItem());
    public static final Item KINETIC_OPAL = register("kinetic_opal", new GemItem());
    public static final Item AIR_MALACHITE = register("air_malachite", new GemItem());

    // TOOLS
    public static final GemSwordItem FIRE_RUBY_SWORD = (GemSwordItem) register("fire_ruby_sword", new GemSwordItem(MMItemTiers.SUPRA, Ingredient.of(FIRE_RUBY), 3, -2.4F, new Item.Properties(), new Pair<>(Enchantments.FIRE_ASPECT, 3)));
//    public static final GemSwordItem ICE_SAPPHIRE_SWORD = (GemSwordItem) register("ice_sapphire_sword", new GemSwordItem(MMItemTiers.SUPRA, Ingredient.of(ICE_SAPPHIRE), 3, -2.4F, new Item.Properties(), new Pair<>(MMEnchantments.FREEZING, 3)));
//    public static final GemSwordItem SPIRIT_GARNET_SWORD = (GemSwordItem) register("spirit_garnet_sword", new GemSwordItem(MMItemTiers.SUPRA, Ingredient.of(SPIRIT_GARNET), 3, -2.4F, new Item.Properties(), new Pair<>(MMEnchantments.LEECHING, 2)));
    public static final GemSwordItem LUCKY_CITRINE_SWORD = (GemSwordItem) register("lucky_citrine_sword", new GemSwordItem(MMItemTiers.SUPRA, Ingredient.of(LUCKY_CITRINE), 3, -2.4F, new Item.Properties(), new Pair<>(Enchantments.LOOTING, 3)));
    public static final GemSwordItem POWER_PYRITE_SWORD = (GemSwordItem) register("power_pyrite_sword", new GemSwordItem(MMItemTiers.SUPRA, Ingredient.of(POWER_PYRITE), 3, -2.4F, new Item.Properties(), new Pair<>(Enchantments.SHARPNESS, 6)));
//    public static final GemSwordItem ULTIMA_SWORD = (GemSwordItem) register("ultima_sword", new GemSwordItem(MMItemTiers.ULTIMA, Ingredient.of(FIRE_RUBY, ICE_SAPPHIRE, SPIRIT_GARNET, LUCKY_CITRINE), 3, -2.4F, new Item.Properties(), new Pair<>(Enchantments.FIRE_ASPECT, 3), new Pair<>(MMEnchantments.FREEZING, 3), new Pair<>(Enchantments.LOOTING, 3), new Pair<>(MMEnchantments.LEECHING, 1)));

    public static final GemAxeItem HASTE_PERIDOT_AXE = (GemAxeItem) register("haste_peridot_axe", new GemAxeItem(MMItemTiers.SUPRA, Ingredient.of(HASTE_PERIDOT), 5, -3.0F, new Item.Properties(), new Pair<>(Enchantments.EFFICIENCY, 6)));
    public static final GemAxeItem POWER_PYRITE_AXE = (GemAxeItem) register("power_pyrite_axe", new GemAxeItem(MMItemTiers.SUPRA, Ingredient.of(POWER_PYRITE), 5, -3.0F, new Item.Properties(), new Pair<>(Enchantments.SHARPNESS, 6)));
    public static final GemAxeItem KINETIC_OPAL_AXE = (GemAxeItem) register("kinetic_opal_axe", new GemAxeItem(MMItemTiers.SUPRA, Ingredient.of(KINETIC_OPAL), 5, -3.0F, new Item.Properties(), new Pair<>(Enchantments.KNOCKBACK, 3)));
    public static final GemAxeItem ULTIMA_AXE = (GemAxeItem) register("ultima_axe", new GemAxeItem(MMItemTiers.ULTIMA, Ingredient.of(POWER_PYRITE, KINETIC_OPAL, HASTE_PERIDOT), 5, -3.0F, new Item.Properties(), new Pair<>(Enchantments.SHARPNESS, 5), new Pair<>(Enchantments.EFFICIENCY, 5), new Pair<>(Enchantments.KNOCKBACK, 3)));

    public static final GemPickaxeItem HASTE_PERIDOT_PICKAXE = (GemPickaxeItem) register("haste_peridot_pickaxe", new GemPickaxeItem(MMItemTiers.SUPRA, Ingredient.of(HASTE_PERIDOT), 1, -2.8F, new Item.Properties(), new Pair<>(Enchantments.EFFICIENCY, 6)));
    public static final GemPickaxeItem LUCKY_CITRINE_PICKAXE = (GemPickaxeItem) register("lucky_citrine_pickaxe", new GemPickaxeItem(MMItemTiers.SUPRA, Ingredient.of(LUCKY_CITRINE), 1, -2.8F, new Item.Properties(), new Pair<>(Enchantments.FORTUNE, 3)));
    public static final GemPickaxeItem UNBREAKING_IOLITE_PICKAXE = (GemPickaxeItem) register("unbreaking_iolite_pickaxe", new GemPickaxeItem(MMItemTiers.SUPRA, Ingredient.of(UNBREAKING_IOLITE), 1, -2.8F, new Item.Properties(), new Pair<>(Enchantments.UNBREAKING, 4)));
//    public static final GemPickaxeItem ULTIMA_PICKAXE = (GemPickaxeItem) register("ultima_pickaxe", new GemPickaxeItem(MMItemTiers.ULTIMA, Ingredient.of(KINETIC_OPAL, LUCKY_CITRINE, HASTE_PERIDOT, UNBREAKING_IOLITE), 1, -2.8F, new Item.Properties(), new Pair<>(Enchantments.EFFICIENCY, 6), new Pair<>(Enchantments.FORTUNE, 3), new Pair<>(Enchantments.UNBREAKING, 3), new Pair<>(MMEnchantments.SMELTING, 1)));

//    public static final GemBowItem AIR_MALACHITE_BOW = (GemBowItem) register("air_malachite_bow", new GemBowItem(new Item.Properties().durability(753), new Pair<>(MMEnchantments.FLOATATION, 5)));
//
//    // ARMOR
//    public static final GemArmorItem PARAGON_HELMET = register("paragon_helmet", new GemArmorItem(MMArmorMaterials.PARAGON, Ingredient.of(FIRE_RUBY, KINETIC_OPAL, SPIRIT_GARNET), ArmorItem.Type.HELMET, new Item.Properties(), new Pair<>(() -> Enchantments.THORNS, 3), new Pair<>(() -> Enchantments.FIRE_PROTECTION, 3), new Pair<>(() -> Enchantments.BLAST_PROTECTION, 3)));
//    public static final GemArmorItem PARAGON_CHESTPLATE = register("paragon_chestplate", new GemArmorItem(MMArmorMaterials.PARAGON, Ingredient.of(DIVE_AQUAMARINE, HEART_RHODONITE), ArmorItem.Type.CHESTPLATE, new Item.Properties(), new Pair<>(MMEnchantments.GRACE, 5), new Pair<>(MMEnchantments.HEARTFELT, 4)));
//    public static final GemArmorItem PARAGON_LEGGINGS = register("paragon_leggings", new GemArmorItem(MMArmorMaterials.PARAGON, Ingredient.of(AIR_MALACHITE, ICE_SAPPHIRE), ArmorItem.Type.LEGGINGS, new Item.Properties(), new Pair<>(MMEnchantments.KNIGHT_JUMP, 4), new Pair<>(MMEnchantments.SNOWPIERCER, 1)));
//    public static final GemArmorItem PARAGON_BOOTS = register("paragon_boots", new GemArmorItem(MMArmorMaterials.PARAGON, Ingredient.of(KINETIC_OPAL, ICE_SAPPHIRE, AIR_MALACHITE), ArmorItem.Type.BOOTS, new Item.Properties(), new Pair<>(MMEnchantments.RUNNER, 3), new Pair<>(() -> Enchantments.FALL_PROTECTION, 3), new Pair<>(() -> Enchantments.FROST_WALKER, 2)));

    // ICON
    public static final Item TAB_ITEM = register("mm_tab_icon", new Item(new Item.Properties()));

    public static void init() {
        MiningMaster.LOGGER.info("Items registered");
    }

    public static Item register(String id, Item item) {
        ResourceLocation itemID = ResourceLocation.fromNamespaceAndPath(MiningMaster.MOD_ID, id);

        return Registry.register(BuiltInRegistries.ITEM, itemID, item);
    }


    // TAB
    public static final ResourceKey<CreativeModeTab> TABS = ResourceKey.create(BuiltInRegistries.CREATIVE_MODE_TAB.key(), ResourceLocation.fromNamespaceAndPath(MiningMaster.MOD_ID, "item_group"));


    //TODO Init tabs in each loader
//    public static final RegistryObject<CreativeModeTab> TAB = TABS.register("mining_master",
//            () -> CreativeModeTab.builder()
//                    .icon(new ItemStack(TAB_ITEM.get()))
//                    .title(Component.literal("Mining Master"))
//                    .displayItems((features, output) -> {
//                        for (Item item : ITEMS.getEntries()) {
//                            if (item != TAB_ITEM) output.accept(item.get());
//                        }
//                    })
//            .build());
}
