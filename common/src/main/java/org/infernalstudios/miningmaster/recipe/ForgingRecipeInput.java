package org.infernalstudios.miningmaster.recipe;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public record ForgingRecipeInput(
        ItemStack catalyst,
        List<ItemStack> gems
) implements RecipeInput {

    @Override
    public @NotNull ItemStack getItem(int index) {
        if (index >= 0 && index < gems.size()) {
            return gems.get(index);
        }

        if (index == 9) {
            return catalyst;
        }

        return ItemStack.EMPTY;
    }

    @Override
    public int size() {
        return gems.size() + 1;
    }
}
