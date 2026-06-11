package org.infernalstudios.miningmaster.init;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.storage.loot.functions.LootItemFunctionType;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;
import org.infernalstudios.miningmaster.MiningMaster;
import org.infernalstudios.miningmaster.loot.condition.SmeltingLootCondition;
import org.infernalstudios.miningmaster.loot.condition.StonebreakerLootCondition;
import org.infernalstudios.miningmaster.loot.function.SmeltingLootFunction;
import org.infernalstudios.miningmaster.loot.function.StonebreakerLootFunction;

public class MMLoot {


    public static class MMLootFunctions {

        public static final DeferredRegister<LootItemFunctionType<?>> LOOT_FUNCTIONS =
                DeferredRegister.create(MiningMaster.MOD_ID, Registries.LOOT_FUNCTION_TYPE);

        public static final RegistrySupplier<LootItemFunctionType<StonebreakerLootFunction>> STONEBREAKER_FUNCTION =
                LOOT_FUNCTIONS.register("stonebreaker_function", () -> new LootItemFunctionType<>(StonebreakerLootFunction.CODEC));
        public static final RegistrySupplier<LootItemFunctionType<SmeltingLootFunction>> SMELTING_FUNCTION =
                LOOT_FUNCTIONS.register("smelting_function", () -> new LootItemFunctionType<>(SmeltingLootFunction.CODEC));
    }

    public static final class MMLootConditions {

        public static final DeferredRegister<LootItemConditionType> LOOT_CONDITIONS =
                DeferredRegister.create(MiningMaster.MOD_ID, Registries.LOOT_CONDITION_TYPE);

        public static final RegistrySupplier<LootItemConditionType> STONEBREAKER_CONDITION =
                LOOT_CONDITIONS.register("stonebreaker_condition", () -> new LootItemConditionType(StonebreakerLootCondition.CODEC));
        public static final RegistrySupplier<LootItemConditionType> SMELTING_CONDITION =
                LOOT_CONDITIONS.register("smelting_condition", () -> new LootItemConditionType(SmeltingLootCondition.CODEC));
    }

    public static void init() {
        MMLootFunctions.LOOT_FUNCTIONS.register();
        MMLootConditions.LOOT_CONDITIONS.register();
    }
}
