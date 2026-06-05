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

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.infernalstudios.miningmaster.MiningMaster;
import org.infernalstudios.miningmaster.block.GemOreBlock;
//import org.infernalstudios.miningmaster.block.GemForgeBlock;
//import org.infernalstudios.miningmaster.block.GemOreBlock;

import java.util.function.Supplier;

public class MMBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(MiningMaster.MOD_ID, Registries.BLOCK);

    // ORES
    public static final RegistrySupplier<Block> FIRE_RUBY_ORE = register("fire_ruby_ore",() -> new GemOreBlock(getProperties(Blocks.DIAMOND_ORE)), true);
    public static final RegistrySupplier<Block> ICE_SAPPHIRE_ORE = register("ice_sapphire_ore",() -> new GemOreBlock(getProperties(Blocks.DIAMOND_ORE)), true);
    public static final RegistrySupplier<Block> SPIRIT_GARNET_ORE = register("spirit_garnet_ore",() -> new GemOreBlock(getProperties(Blocks.DIAMOND_ORE)), true);
    public static final RegistrySupplier<Block> HASTE_PERIDOT_ORE = register("haste_peridot_ore",() -> new GemOreBlock(getProperties(Blocks.DIAMOND_ORE)), true);
    public static final RegistrySupplier<Block> LUCKY_CITRINE_ORE = register("lucky_citrine_ore",() -> new GemOreBlock(getProperties(Blocks.DIAMOND_ORE)), true);
    public static final RegistrySupplier<Block> DIVE_AQUAMARINE_ORE = register("dive_aquamarine_ore",() -> new GemOreBlock(getProperties(Blocks.DIAMOND_ORE)), true);
    public static final RegistrySupplier<Block> DIVINE_BERYL_ORE = register("divine_beryl_ore",() -> new GemOreBlock(getProperties(Blocks.DIAMOND_ORE)), true);
    public static final RegistrySupplier<Block> SPIDER_KUNZITE_ORE = register("spider_kunzite_ore",() -> new GemOreBlock(getProperties(Blocks.DIAMOND_ORE)), true);
    public static final RegistrySupplier<Block> UNBREAKING_IOLITE_ORE = register("unbreaking_iolite_ore",() -> new GemOreBlock(getProperties(Blocks.DIAMOND_ORE)), true);


    public static final RegistrySupplier<Block> DEEPSLATE_FIRE_RUBY_ORE = register("deepslate_fire_ruby_ore",() -> new GemOreBlock(getProperties(Blocks.DEEPSLATE_DIAMOND_ORE)), true);
    public static final RegistrySupplier<Block> DEEPSLATE_ICE_SAPPHIRE_ORE = register("deepslate_ice_sapphire_ore",() -> new GemOreBlock(getProperties(Blocks.DEEPSLATE_DIAMOND_ORE)), true);
    public static final RegistrySupplier<Block> DEEPSLATE_SPIRIT_GARNET_ORE = register("deepslate_spirit_garnet_ore",() -> new GemOreBlock(getProperties(Blocks.DEEPSLATE_DIAMOND_ORE)), true);
    public static final RegistrySupplier<Block> DEEPSLATE_HASTE_PERIDOT_ORE = register("deepslate_haste_peridot_ore",() -> new GemOreBlock(getProperties(Blocks.DEEPSLATE_DIAMOND_ORE)), true);
    public static final RegistrySupplier<Block> DEEPSLATE_LUCKY_CITRINE_ORE = register("deepslate_lucky_citrine_ore",() -> new GemOreBlock(getProperties(Blocks.DEEPSLATE_DIAMOND_ORE)), true);
    public static final RegistrySupplier<Block> DEEPSLATE_DIVE_AQUAMARINE_ORE = register("deepslate_dive_aquamarine_ore",() -> new GemOreBlock(getProperties(Blocks.DEEPSLATE_DIAMOND_ORE)), true);
    public static final RegistrySupplier<Block> DEEPSLATE_DIVINE_BERYL_ORE = register("deepslate_divine_beryl_ore",() -> new GemOreBlock(getProperties(Blocks.DEEPSLATE_DIAMOND_ORE)), true);
    public static final RegistrySupplier<Block> DEEPSLATE_SPIDER_KUNZITE_ORE = register("deepslate_spider_kunzite_ore",() -> new GemOreBlock(getProperties(Blocks.DEEPSLATE_DIAMOND_ORE)), true);
    public static final RegistrySupplier<Block> DEEPSLATE_UNBREAKING_IOLITE_ORE = register("deepslate_unbreaking_iolite_ore",() -> new GemOreBlock(getProperties(Blocks.DEEPSLATE_DIAMOND_ORE)), true);

    public static final RegistrySupplier<Block> HEART_RHODONITE_ORE = register("heart_rhodonite_ore",() -> new GemOreBlock(getProperties(Blocks.NETHER_GOLD_ORE)), true);
    public static final RegistrySupplier<Block> POWER_PYRITE_ORE = register("power_pyrite_ore",() -> new GemOreBlock(getProperties(Blocks.NETHER_GOLD_ORE)), true);
    public static final RegistrySupplier<Block> KINETIC_OPAL_ORE = register("kinetic_opal_ore",() -> new GemOreBlock(getProperties(Blocks.NETHER_GOLD_ORE)), true);
    public static final RegistrySupplier<Block> AIR_MALACHITE_ORE = register("air_malachite_ore",() -> new GemOreBlock(getProperties(Blocks.NETHER_GOLD_ORE)), true);

    // GEM BLOCKS
    public static final RegistrySupplier<Block> FIRE_RUBY_BLOCK = register("fire_ruby_block",() -> new Block(getProperties(Blocks.DIAMOND_BLOCK)), true);
    public static final RegistrySupplier<Block> ICE_SAPPHIRE_BLOCK = register("ice_sapphire_block",() -> new Block(getProperties(Blocks.DIAMOND_BLOCK)), true);
    public static final RegistrySupplier<Block> SPIRIT_GARNET_BLOCK = register("spirit_garnet_block",() -> new Block(getProperties(Blocks.DIAMOND_BLOCK)), true);
    public static final RegistrySupplier<Block> HASTE_PERIDOT_BLOCK = register("haste_peridot_block",() -> new Block(getProperties(Blocks.DIAMOND_BLOCK)), true);
    public static final RegistrySupplier<Block> LUCKY_CITRINE_BLOCK = register("lucky_citrine_block",() -> new Block(getProperties(Blocks.DIAMOND_BLOCK)), true);
    public static final RegistrySupplier<Block> DIVE_AQUAMARINE_BLOCK = register("dive_aquamarine_block",() -> new Block(getProperties(Blocks.DIAMOND_BLOCK)), true);
    public static final RegistrySupplier<Block> DIVINE_BERYL_BLOCK = register("divine_beryl_block",() -> new Block(getProperties(Blocks.DIAMOND_BLOCK)), true);
    public static final RegistrySupplier<Block> SPIDER_KUNZITE_BLOCK = register("spider_kunzite_block",() -> new Block(getProperties(Blocks.DIAMOND_BLOCK)), true);
    public static final RegistrySupplier<Block> UNBREAKING_IOLITE_BLOCK = register("unbreaking_iolite_block",() -> new Block(getProperties(Blocks.DIAMOND_BLOCK)), true);
    public static final RegistrySupplier<Block> HEART_RHODONITE_BLOCK = register("heart_rhodonite_block",() -> new Block(getProperties(Blocks.DIAMOND_BLOCK)), true);
    public static final RegistrySupplier<Block> POWER_PYRITE_BLOCK = register("power_pyrite_block",() -> new Block(getProperties(Blocks.DIAMOND_BLOCK)), true);
    public static final RegistrySupplier<Block> KINETIC_OPAL_BLOCK = register("kinetic_opal_block",() -> new Block(getProperties(Blocks.DIAMOND_BLOCK)), true);
    public static final RegistrySupplier<Block> AIR_MALACHITE_BLOCK = register("air_malachite_block",() -> new Block(getProperties(Blocks.DIAMOND_BLOCK)), true);

    //MISC BLOCKS
    public static final RegistrySupplier<Block> MALACORE = register("malacore", () -> new Block(getProperties(Blocks.END_STONE)), true);
    public static final RegistrySupplier<Block> MALACRUST = register("malacrust", () -> new Block(getProperties(Blocks.DEEPSLATE).strength(22.5F)), true);
//    public static final RegistrySupplier<Block> GEM_FORGE = register("gem_forge", () -> new GemForgeBlock(getProperties(Blocks.FURNACE)), true);

    public static void init() {
        MiningMaster.LOGGER.info("Blocks registered");
    };

    public static BlockBehaviour.Properties getProperties(Block block) {
        return BlockBehaviour.Properties.ofFullCopy(block);
    }

//    public static Block register(String name, Block block, boolean shouldRegisterItem) {
//
//        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(MiningMaster.MOD_ID, name);
//
//        if (shouldRegisterItem) {
//            BlockItem blockItem = new BlockItem(block, new Item.Properties());
//            Registry.register(BuiltInRegistries.ITEM, id, blockItem);
//        }
//
//        return Registry.register(BuiltInRegistries.BLOCK, id, block);
//    }

    public static RegistrySupplier<Block> register(String name, Supplier<Block> block, boolean shouldRegisterItem) {

        RegistrySupplier<Block> block_supplier = BLOCKS.register(name, block);

        if (shouldRegisterItem) {
            MMItems.ITEMS.register(name,() -> new BlockItem(block_supplier.get(), new Item.Properties()));
        }

        return block_supplier;
    }
}
