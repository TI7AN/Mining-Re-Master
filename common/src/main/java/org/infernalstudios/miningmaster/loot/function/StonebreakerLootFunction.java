package org.infernalstudios.miningmaster.loot.function;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.functions.LootItemConditionalFunction;
import net.minecraft.world.level.storage.loot.functions.LootItemFunctionType;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import org.infernalstudios.miningmaster.MiningMaster;
import org.infernalstudios.miningmaster.init.MMEnchantments;
import org.infernalstudios.miningmaster.init.MMLoot;
import org.infernalstudios.miningmaster.init.MMTags;

import java.util.List;

public class StonebreakerLootFunction extends LootItemConditionalFunction {

    public static final MapCodec<StonebreakerLootFunction> CODEC = RecordCodecBuilder.mapCodec(instance ->
            commonFields(instance).apply(instance, StonebreakerLootFunction::new)
    );

    protected StonebreakerLootFunction(List<LootItemCondition> conditions) {
        super(conditions);
    }

    @Override
    public LootItemFunctionType<? extends LootItemConditionalFunction> getType() {
        return MMLoot.MMLootFunctions.STONEBREAKER_FUNCTION.get();
    }

    public static Builder<?> builder() {
        return simpleBuilder(StonebreakerLootFunction::new);
    }

    @Override
    protected ItemStack run(ItemStack stack, LootContext context) {
        ItemStack tool = context.getParamOrNull(LootContextParams.TOOL);
        BlockState blockState = context.getParamOrNull(LootContextParams.BLOCK_STATE);

        if (tool == null || tool.isEmpty()) {
            return stack;
        }

        MiningMaster.LOGGER.info("stone in tag: {}",
                Blocks.STONE.defaultBlockState().is(MMTags.Blocks.C_STONES));

        Holder<Enchantment> stonebreakerHolder = context.getLevel().registryAccess()
                .registryOrThrow(Registries.ENCHANTMENT)
                .getHolderOrThrow(MMEnchantments.STONEBREAKER);

        int stonebreakerLevel = EnchantmentHelper.getItemEnchantmentLevel(stonebreakerHolder, tool);

        if (stonebreakerLevel > 0) {
            if (stack.isEmpty()) {
                return stack;
            } else if (stack.getItem() instanceof BlockItem blockItem) {
                    if (blockState.is(MMTags.Blocks.C_STONES) ||
                            blockState.is(BlockTags.BASE_STONE_NETHER)
                    ) {
                        return ItemStack.EMPTY;
                    }
            }
            return stack;
        }
        return stack;
    }
}
