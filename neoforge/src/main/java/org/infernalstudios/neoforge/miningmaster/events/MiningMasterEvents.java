///*
// * Copyright 2021 Infernal Studios
// *
// * Licensed under the Apache License, Version 2.0 (the "License");
// * you may not use this file except in compliance with the License.
// * You may obtain a copy of the License at
// *
// *     http://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS,
// * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// * See the License for the specific language governing permissions and
// * limitations under the License.
// */
//
//package org.infernalstudios.neoforge.miningmaster.events;
//
//import net.minecraftforge.registries.ForgeRegistries;
//import net.minecraftforge.registries.RegisterEvent;
//import net.neoforged.bus.api.SubscribeEvent;
//import net.neoforged.fml.common.EventBusSubscriber;
//import org.infernalstudios.miningmaster.MiningMaster;
//import org.infernalstudios.miningmaster.init.MMRecipes;
//import org.infernalstudios.miningmaster.recipes.ForgingRecipe;
//
//@EventBusSubscriber(modid = MiningMaster.MOD_ID)
//public class MiningMasterEvents {
//
//    // Register the custom ore features and recipe types
//    @SubscribeEvent
//    public static void registerFeaturesAndRecipeTypes(RegisterEvent event) {
//        event.register(ForgeRegistries.Keys.RECIPE_TYPES, helper -> helper.register(ForgingRecipe.TYPE_ID, MMRecipes.FORGING_RECIPE_TYPE));
//    }
//}
