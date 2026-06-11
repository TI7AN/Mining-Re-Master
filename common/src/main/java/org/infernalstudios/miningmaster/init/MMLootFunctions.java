package org.infernalstudios.miningmaster.init;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.storage.loot.functions.LootItemFunctionType;
import org.infernalstudios.miningmaster.MiningMaster;
import org.infernalstudios.miningmaster.loot_functions.SmeltingLootFunction;
import org.infernalstudios.miningmaster.loot_functions.StonebreakerLootFunction;

public class MMLootFunctions {
    public static final DeferredRegister<LootItemFunctionType<?>> LOOT_FUNCTIONS =
            DeferredRegister.create(MiningMaster.MOD_ID, Registries.LOOT_FUNCTION_TYPE);

    public static final RegistrySupplier<LootItemFunctionType<SmeltingLootFunction>> SMELTING_DROPS =
            LOOT_FUNCTIONS.register("mm_smelting_drops", () -> new LootItemFunctionType<>(SmeltingLootFunction.CODEC));

    public static final RegistrySupplier<LootItemFunctionType<StonebreakerLootFunction>> STONEBREAKER_DROPS =
            LOOT_FUNCTIONS.register("mm_stonebreaker_drops", () -> new LootItemFunctionType<>(StonebreakerLootFunction.CODEC));

    public static void init() {
        LOOT_FUNCTIONS.register();
    }
}
