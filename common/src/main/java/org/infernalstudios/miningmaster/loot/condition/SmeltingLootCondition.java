package org.infernalstudios.miningmaster.loot.condition;

import com.google.common.collect.ImmutableSet;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParam;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;
import org.infernalstudios.miningmaster.init.MMEnchantments;
import org.infernalstudios.miningmaster.init.MMLoot;

import java.util.Set;

public class SmeltingLootCondition implements LootItemCondition {

    private static final SmeltingLootCondition INSTANCE = new SmeltingLootCondition();
    public static final MapCodec<SmeltingLootCondition> CODEC = MapCodec.unit(INSTANCE);

    @Override
    public boolean test(LootContext context) {
        ItemStack tool = context.getParamOrNull(LootContextParams.TOOL);
        if(tool != null) {
            var smeltingHolder = context.getLevel().registryAccess()
                    .registryOrThrow(Registries.ENCHANTMENT)
                    .getHolderOrThrow(MMEnchantments.SMELTING);
            var smeltingLevel = EnchantmentHelper.getItemEnchantmentLevel(smeltingHolder, tool);

            return smeltingLevel > 0;
        }
        return false;
    }

    @Override
    public Set<LootContextParam<?>> getReferencedContextParams() {
        return ImmutableSet.of(
                LootContextParams.TOOL,
                LootContextParams.BLOCK_STATE
        );
    }

    @Override
    public LootItemConditionType getType() {
        return MMLoot.MMLootConditions.SMELTING_CONDITION.get();
    }

    public static LootItemCondition.Builder hasSmeltingEnchantment() {
        return () -> INSTANCE;
    }
}
