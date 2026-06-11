package org.infernalstudios.neoforge.miningmaster.loot_modifiers;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.functions.LootItemFunction;
import net.minecraft.world.level.storage.loot.functions.LootItemFunctions;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;

public class DropModifyingEnchantmentLootModifier extends LootModifier {
    private final LootItemFunction function;

    public static final MapCodec<DropModifyingEnchantmentLootModifier> CODEC =
            RecordCodecBuilder.mapCodec(instance ->
                    codecStart(instance)
                            .and(
                                    LootItemFunctions.ROOT_CODEC
                                            .fieldOf("function")
                                            .forGetter(m -> m.function)
                            )
                            .apply(instance, DropModifyingEnchantmentLootModifier::new)
            );

    protected DropModifyingEnchantmentLootModifier(LootItemCondition[] conditions, LootItemFunction function) {
        super(conditions);
        this.function = function;
    }

    @Override
    protected ObjectArrayList<ItemStack> doApply(
            ObjectArrayList<ItemStack> generatedLoot,
            LootContext context
    ) {
        for (int i = 0; i < generatedLoot.size(); i++) {
            generatedLoot.set(
                    i,
                    this.function.apply(generatedLoot.get(i), context)
            );
        }
        return generatedLoot;
    }

    @Override
    public MapCodec<? extends IGlobalLootModifier> codec() {
        return CODEC;
    }
}
