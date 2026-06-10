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
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import org.infernalstudios.miningmaster.MiningMaster;
import org.infernalstudios.miningmaster.recipe.*;

public class MMRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(MiningMaster.MOD_ID, Registries.RECIPE_SERIALIZER);

    public static final RegistrySupplier<RecipeSerializer<GemSmithingRecipe>> GEM_SMITHING_RECIPE_SERIALIZER = RECIPE_SERIALIZERS.register(
            "gem_smithing_recipe",
            GemSmithingRecipe.GemSmithingRecipeSerializer::new
    );

    public static final RegistrySupplier<RecipeSerializer<GemForgingRecipe>> FORGING_RECIPE = RECIPE_SERIALIZERS.register("forging_recipe", GemForgingRecipe.ForgingRecipeSerializer::new);

    public static RecipeType<GemForgingRecipe> FORGING_RECIPE_TYPE = new GemForgingRecipe.ForgingRecipeType();

    public static void init() {
        RECIPE_SERIALIZERS.register();
        MiningMaster.LOGGER.info("Recipes registered");
    };
}
