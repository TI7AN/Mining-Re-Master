package org.infernalstudios.miningmaster.recipe;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ForgingRecipeInput implements RecipeInput {
    NonNullList<ItemStack> items;

    public ForgingRecipeInput(NonNullList<ItemStack> input){
        this.items = input;
    }

    public ForgingRecipeInput(NonNullList<ItemStack> gems, ItemStack catalyst) {
        if(gems.size() != 8) {
            throw new IllegalStateException("Expected 8 gem ItemStacks for ForgingRecipeInput but found " + gems.size());
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
