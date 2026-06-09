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

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import org.infernalstudios.miningmaster.MiningMaster;

public class MMTags {

    public static class Items {
        public static final TagKey<Item> MM_GEM_ENCHANTING_BLACKLIST = tag("gem_enchanting_blacklist");
        public static final TagKey<Item> MM_STONEBREAKER_ITEMS = tag("stonebreaker_items");
        public static final TagKey<Item> MM_GEMS = tag("gems");
        public static final TagKey<Item> C_GEMS = commonTag("gems");
        public static final TagKey<Item> C_ORES = commonTag("ores");
        public static final TagKey<Item> MM_CATALYSTS = tag("catalysts");

        private static TagKey<Item> tag(String name) {
            return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(MiningMaster.MOD_ID, name));
        }

        private static TagKey<Item> commonTag(String name) {
            return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("c", name));
        }
    }

    public static class Blocks {
        public static final TagKey<Block> MM_SNOWPIERCER_BLOCKS = tag("snowpiercer_blocks");
        public static final TagKey<Block> C_ORES = commonTag("ores");

        private static TagKey<Block> tag(String name) {
            return TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(MiningMaster.MOD_ID, name));
        }

        private static TagKey<Block> commonTag(String name) {
            return TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("c", name));
        }
    }

    public static class Biomes {
        public static final TagKey<Biome> MM_DIVINE_BERYL_BIOMES = tag("divine_beryl_biomes");
        public static final TagKey<Biome> MM_UNBREAKING_IOLITE_BIOMES = tag("unbreaking_iolite_biomes");
        public static final TagKey<Biome> C_IS_COLD_OVERWORLD = commonTag("is_cold/overworld");
        public static final TagKey<Biome> C_IS_SWAMP = commonTag("is_swamp");
        public static final TagKey<Biome> C_IS_MUSHROOM = commonTag("is_mushroom");

        private static TagKey<Biome> tag(String name) {
            return TagKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(MiningMaster.MOD_ID, name));
        }

        private static TagKey<Biome> commonTag(String name) {
            return TagKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath("c", name));
        }
    }

}
