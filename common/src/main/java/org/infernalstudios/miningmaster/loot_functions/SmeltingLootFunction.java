package org.infernalstudios.miningmaster.loot_functions;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.item.crafting.SmeltingRecipe;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.functions.LootItemConditionalFunction;
import net.minecraft.world.level.storage.loot.functions.LootItemFunction;
import net.minecraft.world.level.storage.loot.functions.LootItemFunctionType;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import org.infernalstudios.miningmaster.init.MMEnchantments;
import org.infernalstudios.miningmaster.init.MMLootFunctions;

import java.util.List;
import java.util.Optional;

public class SmeltingLootFunction extends LootItemConditionalFunction {

    public static final MapCodec<SmeltingLootFunction> CODEC = RecordCodecBuilder.mapCodec(instance ->
            commonFields(instance).apply(instance, SmeltingLootFunction::new)
    );

    protected SmeltingLootFunction(List<LootItemCondition> conditions) {
        super(conditions);
    }

    @Override
    public LootItemFunctionType<? extends LootItemConditionalFunction> getType() {
        return MMLootFunctions.SMELTING_DROPS.get();
    }

    public static SmeltingLootFunction.Builder<?> builder() {
        return simpleBuilder(SmeltingLootFunction::new);
    }

    @Override
    protected ItemStack run(ItemStack stack, LootContext context) {
        ItemStack tool = context.getParamOrNull(LootContextParams.TOOL);

        if (tool == null || tool.isEmpty()) {
            return stack;
        }

        Holder<Enchantment> smeltingHolder = context.getLevel().registryAccess()
                .registryOrThrow(Registries.ENCHANTMENT)
                .getHolderOrThrow(MMEnchantments.SMELTING);

        int smeltingLevel = EnchantmentHelper.getItemEnchantmentLevel(smeltingHolder, tool);

        if (smeltingLevel > 0) {
            if (stack.isEmpty()) {
                return stack;
            } else {
                Optional<RecipeHolder<SmeltingRecipe>> optional = context.getLevel()
                        .getRecipeManager()
                        .getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput(stack), context.getLevel());
                if (optional.isPresent()) {
                    ItemStack itemStack = ((SmeltingRecipe)((RecipeHolder)optional.get()).value()).getResultItem(context.getLevel().registryAccess());
                    if (!itemStack.isEmpty()) {
                        return itemStack.copyWithCount(stack.getCount());
                    }
                }

                return stack;
            }
        }

        return stack;
    }
}
