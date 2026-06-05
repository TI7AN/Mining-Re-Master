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
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.enchantment.Enchantments;
import org.infernalstudios.miningmaster.MiningMaster;
import org.infernalstudios.miningmaster.items.*;

import java.util.List;

public class MMItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(MiningMaster.MOD_ID, Registries.ITEM);

    // GEMS
    public static final RegistrySupplier<Item> FIRE_RUBY = ITEMS.register("fire_ruby", GemItem::new);
    public static final RegistrySupplier<Item> ICE_SAPPHIRE = ITEMS.register("ice_sapphire",  GemItem::new);
    public static final RegistrySupplier<Item> SPIRIT_GARNET = ITEMS.register("spirit_garnet",  GemItem::new);
    public static final RegistrySupplier<Item> HASTE_PERIDOT = ITEMS.register("haste_peridot",  GemItem::new);
    public static final RegistrySupplier<Item> LUCKY_CITRINE = ITEMS.register("lucky_citrine",  GemItem::new);
    public static final RegistrySupplier<Item> DIVE_AQUAMARINE = ITEMS.register("dive_aquamarine",  GemItem::new);
    public static final RegistrySupplier<Item> DIVINE_BERYL = ITEMS.register("divine_beryl",  GemItem::new);
    public static final RegistrySupplier<Item> SPIDER_KUNZITE = ITEMS.register("spider_kunzite",  GemItem::new);
    public static final RegistrySupplier<Item> UNBREAKING_IOLITE = ITEMS.register("unbreaking_iolite",  GemItem::new);
    public static final RegistrySupplier<Item> HEART_RHODONITE = ITEMS.register("heart_rhodonite",  GemItem::new);
    public static final RegistrySupplier<Item> POWER_PYRITE = ITEMS.register("power_pyrite",  GemItem::new);
    public static final RegistrySupplier<Item> KINETIC_OPAL = ITEMS.register("kinetic_opal",  GemItem::new);
    public static final RegistrySupplier<Item> AIR_MALACHITE = ITEMS.register("air_malachite",  GemItem::new);

    public static final List<RegistrySupplier<Item>> LIST_GEMS = List.of(
            FIRE_RUBY,
            ICE_SAPPHIRE,
            SPIRIT_GARNET,
            HASTE_PERIDOT,
            LUCKY_CITRINE,
            DIVE_AQUAMARINE,
            DIVINE_BERYL,
            SPIDER_KUNZITE,
            UNBREAKING_IOLITE,
            HEART_RHODONITE,
            POWER_PYRITE,
            KINETIC_OPAL,
            AIR_MALACHITE
    );

    // TOOLS
    public static final RegistrySupplier<GemSwordItem> FIRE_RUBY_SWORD = ITEMS.register("fire_ruby_sword",() -> new GemSwordItem(MMItemTiers.SUPRA, Ingredient.of(FIRE_RUBY.get()), 3, -2.4F, new Item.Properties(), new Pair<>(Enchantments.FIRE_ASPECT, 3)));
    public static final RegistrySupplier<GemSwordItem> ICE_SAPPHIRE_SWORD = ITEMS.register("ice_sapphire_sword",() -> new GemSwordItem(MMItemTiers.SUPRA, Ingredient.of(ICE_SAPPHIRE.get()), 3, -2.4F, new Item.Properties(), new Pair<>(MMEnchantments.FREEZING, 3)));
    public static final RegistrySupplier<GemSwordItem> SPIRIT_GARNET_SWORD = ITEMS.register("spirit_garnet_sword",() -> new GemSwordItem(MMItemTiers.SUPRA, Ingredient.of(SPIRIT_GARNET.get()), 3, -2.4F, new Item.Properties(), new Pair<>(MMEnchantments.LEECHING, 2)));
    public static final RegistrySupplier<GemSwordItem> LUCKY_CITRINE_SWORD = ITEMS.register("lucky_citrine_sword",() -> new GemSwordItem(MMItemTiers.SUPRA, Ingredient.of(LUCKY_CITRINE.get()), 3, -2.4F, new Item.Properties(), new Pair<>(Enchantments.LOOTING, 3)));
    public static final RegistrySupplier<GemSwordItem> POWER_PYRITE_SWORD = ITEMS.register("power_pyrite_sword",() -> new GemSwordItem(MMItemTiers.SUPRA, Ingredient.of(POWER_PYRITE.get()), 3, -2.4F, new Item.Properties(), new Pair<>(Enchantments.SHARPNESS, 6)));
    public static final RegistrySupplier<GemSwordItem> ULTIMA_SWORD = ITEMS.register("ultima_sword",() -> new GemSwordItem(MMItemTiers.ULTIMA, Ingredient.of(FIRE_RUBY.get(), ICE_SAPPHIRE.get(), SPIRIT_GARNET.get(), LUCKY_CITRINE.get()), 3, -2.4F, new Item.Properties(), new Pair<>(Enchantments.FIRE_ASPECT, 3), new Pair<>(MMEnchantments.FREEZING, 3), new Pair<>(Enchantments.LOOTING, 3), new Pair<>(MMEnchantments.LEECHING, 1)));

    public static final RegistrySupplier<GemAxeItem> HASTE_PERIDOT_AXE = ITEMS.register("haste_peridot_axe",() -> new GemAxeItem(MMItemTiers.SUPRA, Ingredient.of(HASTE_PERIDOT.get()), 5, -3.0F, new Item.Properties(), new Pair<>(Enchantments.EFFICIENCY, 6)));
    public static final RegistrySupplier<GemAxeItem> POWER_PYRITE_AXE = ITEMS.register("power_pyrite_axe",() -> new GemAxeItem(MMItemTiers.SUPRA, Ingredient.of(POWER_PYRITE.get()), 5, -3.0F, new Item.Properties(), new Pair<>(Enchantments.SHARPNESS, 6)));
    public static final RegistrySupplier<GemAxeItem> KINETIC_OPAL_AXE = ITEMS.register("kinetic_opal_axe",() -> new GemAxeItem(MMItemTiers.SUPRA, Ingredient.of(KINETIC_OPAL.get()), 5, -3.0F, new Item.Properties(), new Pair<>(Enchantments.KNOCKBACK, 3)));
    public static final RegistrySupplier<GemAxeItem> ULTIMA_AXE = ITEMS.register("ultima_axe",() -> new GemAxeItem(MMItemTiers.ULTIMA, Ingredient.of(POWER_PYRITE.get(), KINETIC_OPAL.get(), HASTE_PERIDOT.get()), 5, -3.0F, new Item.Properties(), new Pair<>(Enchantments.SHARPNESS, 5), new Pair<>(Enchantments.EFFICIENCY, 5), new Pair<>(Enchantments.KNOCKBACK, 3)));

    public static final RegistrySupplier<GemPickaxeItem> HASTE_PERIDOT_PICKAXE = ITEMS.register("haste_peridot_pickaxe",() -> new GemPickaxeItem(MMItemTiers.SUPRA, Ingredient.of(HASTE_PERIDOT.get()), 1, -2.8F, new Item.Properties(), new Pair<>(Enchantments.EFFICIENCY, 6)));
    public static final RegistrySupplier<GemPickaxeItem> LUCKY_CITRINE_PICKAXE = ITEMS.register("lucky_citrine_pickaxe",() -> new GemPickaxeItem(MMItemTiers.SUPRA, Ingredient.of(LUCKY_CITRINE.get()), 1, -2.8F, new Item.Properties(), new Pair<>(Enchantments.FORTUNE, 3)));
    public static final RegistrySupplier<GemPickaxeItem> UNBREAKING_IOLITE_PICKAXE = ITEMS.register("unbreaking_iolite_pickaxe",() -> new GemPickaxeItem(MMItemTiers.SUPRA, Ingredient.of(UNBREAKING_IOLITE.get()), 1, -2.8F, new Item.Properties(), new Pair<>(Enchantments.UNBREAKING, 4)));
    public static final RegistrySupplier<GemPickaxeItem> ULTIMA_PICKAXE = ITEMS.register("ultima_pickaxe",() -> new GemPickaxeItem(MMItemTiers.ULTIMA, Ingredient.of(KINETIC_OPAL.get(), LUCKY_CITRINE.get(), HASTE_PERIDOT.get(), UNBREAKING_IOLITE.get()), 1, -2.8F, new Item.Properties(), new Pair<>(Enchantments.EFFICIENCY, 6), new Pair<>(Enchantments.FORTUNE, 3), new Pair<>(Enchantments.UNBREAKING, 3), new Pair<>(MMEnchantments.SMELTING, 1)));

//    public static final GemBowItem AIR_MALACHITE_BOW = (GemBowItem) register("air_malachite_bow", new GemBowItem(new Item.Properties().durability(753), new Pair<>(MMEnchantments.FLOATATION, 5)));

    // ARMOR
    public static final RegistrySupplier<GemArmorItem> PARAGON_HELMET = ITEMS.register("paragon_helmet",() -> new GemArmorItem(MMArmorMaterials.PARAGON, Ingredient.of(FIRE_RUBY.get(), KINETIC_OPAL.get(), SPIRIT_GARNET.get()), ArmorItem.Type.HELMET, new Item.Properties(), new Pair<>(Enchantments.THORNS, 3), new Pair<>(Enchantments.FIRE_PROTECTION, 3), new Pair<>(Enchantments.BLAST_PROTECTION, 3)));
    public static final RegistrySupplier<GemArmorItem> PARAGON_CHESTPLATE = ITEMS.register("paragon_chestplate",() -> new GemArmorItem(MMArmorMaterials.PARAGON, Ingredient.of(DIVE_AQUAMARINE.get(), HEART_RHODONITE.get()), ArmorItem.Type.CHESTPLATE, new Item.Properties(), new Pair<>(MMEnchantments.GRACE, 5), new Pair<>(MMEnchantments.HEARTFELT, 4)));
    public static final RegistrySupplier<GemArmorItem> PARAGON_LEGGINGS = ITEMS.register("paragon_leggings",() -> new GemArmorItem(MMArmorMaterials.PARAGON, Ingredient.of(AIR_MALACHITE.get(), ICE_SAPPHIRE.get()), ArmorItem.Type.LEGGINGS, new Item.Properties(), new Pair<>(MMEnchantments.KNIGHT_JUMP, 4), new Pair<>(MMEnchantments.SNOWPIERCER, 1)));
    public static final RegistrySupplier<GemArmorItem> PARAGON_BOOTS = ITEMS.register("paragon_boots",() -> new GemArmorItem(MMArmorMaterials.PARAGON, Ingredient.of(KINETIC_OPAL.get(), ICE_SAPPHIRE.get(), AIR_MALACHITE.get()), ArmorItem.Type.BOOTS, new Item.Properties(), new Pair<>(MMEnchantments.RUNNER, 3), new Pair<>(Enchantments.FEATHER_FALLING, 3), new Pair<>(Enchantments.FROST_WALKER, 2)));

    // ICON
    public static final RegistrySupplier<Item> TAB_ITEM = ITEMS.register("mm_tab_icon",() -> new Item(new Item.Properties()));

    public static void init() {
        MiningMaster.LOGGER.info("Items registered");
//        ITEMS.register();
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
