/*
 * Copyright 2021 Infernal Studios
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
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;
//import net.minecraftforge.common.extensions.IForgeMenuType;
//import net.minecraftforge.eventbus.api.IEventBus;
//import net.minecraftforge.registries.DeferredRegister;
//import net.minecraftforge.registries.ForgeRegistries;
//import net.minecraftforge.registries.RegistryObject;
import org.infernalstudios.miningmaster.MiningMaster;
import org.infernalstudios.miningmaster.container.GemForgeMenu;

public class MMMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(MiningMaster.MOD_ID, Registries.MENU);

//    public static final RegistrySupplier<MenuType<GemForgeContainer>> GEM_FORGE_CONTAINER = CONTAINER_TYPES.register("gem_forge_container", () -> IForgeMenuType.create(((windowId, inv, data) -> new GemForgeContainer(windowId, inv))));
    public static final RegistrySupplier<MenuType<GemForgeMenu>> GEM_FORGE_MENU = MENUS.register("gem_forge_menu", () -> new MenuType<>(GemForgeMenu::new, FeatureFlags.DEFAULT_FLAGS));

    public static void init() {
        MENUS.register();
        MiningMaster.LOGGER.info("Containers registered");
    };
}
