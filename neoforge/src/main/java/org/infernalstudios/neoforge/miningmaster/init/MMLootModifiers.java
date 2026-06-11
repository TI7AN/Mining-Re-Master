package org.infernalstudios.neoforge.miningmaster.init;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import org.infernalstudios.miningmaster.MiningMaster;
import org.infernalstudios.neoforge.miningmaster.loot_modifiers.DropModifyingEnchantmentLootModifier;

import java.util.function.Supplier;

public class MMLootModifiers {
    public static final DeferredRegister<MapCodec<? extends IGlobalLootModifier>> LOOT_MODIFIERS = DeferredRegister.create(NeoForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, MiningMaster.MOD_ID);

    public static final DeferredHolder<MapCodec<? extends IGlobalLootModifier>, MapCodec<DropModifyingEnchantmentLootModifier>> DROP_MODIFYING_ENCHANTMENT_LOOT_MODIFIER = LOOT_MODIFIERS.register("drop_modifying_enchantment_loot_modifier", () -> DropModifyingEnchantmentLootModifier.CODEC);

    public static void init(IEventBus bus) {
        LOOT_MODIFIERS.register(bus);
        MiningMaster.LOGGER.info("(NEOFORGE): Registered Global Loot Modifiers (GLMs)");
    }
}
