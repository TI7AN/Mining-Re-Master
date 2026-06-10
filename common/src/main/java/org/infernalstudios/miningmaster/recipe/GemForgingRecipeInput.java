package org.infernalstudios.miningmaster.recipe;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;
import org.jetbrains.annotations.NotNull;

public class GemForgingRecipeInput implements RecipeInput {
    NonNullList<ItemStack> items;

    //TODO stop using this and start using (NonNullList<ItemStack> gems, ItemStack catalyst)
    public GemForgingRecipeInput(NonNullList<ItemStack> input){
        this.items = input;
    }

    public GemForgingRecipeInput(NonNullList<ItemStack> gems, ItemStack catalyst) {
        if(gems.size() != 8) {
            throw new IllegalStateException("Expected 8 gems for ForgingRecipeInput but found " + gems.size());
        }

        gems.add(catalyst);
        this.items = gems;
    }

    @Override
    public @NotNull ItemStack getItem(int index) {
        if (index >= 0 && index < items.size()) {
            return items.get(index);
        }

        return ItemStack.EMPTY;
    }

    @Override
    public int size() {
        return items.size();
    }
}
