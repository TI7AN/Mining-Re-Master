package org.infernalstudios.miningmaster.loot_functions;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.item.crafting.SmeltingRecipe;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.functions.LootItemConditionalFunction;
import net.minecraft.world.level.storage.loot.functions.LootItemFunctionType;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import org.infernalstudios.miningmaster.init.MMEnchantments;
import org.infernalstudios.miningmaster.init.MMLootFunctions;
import org.infernalstudios.miningmaster.init.MMTags;

import java.util.List;
import java.util.Optional;

public class StonebreakerLootFunction extends LootItemConditionalFunction {

    public static final MapCodec<StonebreakerLootFunction> CODEC = RecordCodecBuilder.mapCodec(instance ->
            commonFields(instance).apply(instance, StonebreakerLootFunction::new)
    );

    protected StonebreakerLootFunction(List<LootItemCondition> conditions) {
        super(conditions);
    }

    @Override
    public LootItemFunctionType<? extends LootItemConditionalFunction> getType() {
        return MMLootFunctions.STONEBREAKER_DROPS.get();
    }

    public static Builder<?> builder() {
        return simpleBuilder(StonebreakerLootFunction::new);
    }

    @Override
    protected ItemStack run(ItemStack stack, LootContext context) {
        ItemStack tool = context.getParamOrNull(LootContextParams.TOOL);

        if (tool == null || tool.isEmpty()) {
            return stack;
        }

        Holder<Enchantment> stonebreakerHolder = context.getLevel().registryAccess()
                .registryOrThrow(Registries.ENCHANTMENT)
                .getHolderOrThrow(MMEnchantments.STONEBREAKER);

        int stonebreakerLevel = EnchantmentHelper.getItemEnchantmentLevel(stonebreakerHolder, tool);

        if (stonebreakerLevel > 0) {
            if (stack.isEmpty()) {
                return stack;
            } else if (stack.getItem() instanceof BlockItem blockItem) {
                    if (blockItem.getBlock().defaultBlockState().is(MMTags.Blocks.C_STONES) ||
                            blockItem.getBlock().defaultBlockState().is(BlockTags.BASE_STONE_NETHER)
                    ) {
                        return ItemStack.EMPTY;
                    }
            }
            return stack;
        }
        return stack;
    }
}
