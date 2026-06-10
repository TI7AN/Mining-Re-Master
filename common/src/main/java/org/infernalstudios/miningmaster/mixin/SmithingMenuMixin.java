package org.infernalstudios.miningmaster.mixin;

import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.SmithingRecipe;
import org.infernalstudios.miningmaster.recipe.GemSmithingRecipe;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SmithingMenu.class)
public abstract class SmithingMenuMixin extends ItemCombinerMenu {

    @Shadow
    @Nullable
    private RecipeHolder<SmithingRecipe> selectedRecipe;

    @Unique
    private ItemStack miningmaster$cachedAdditionItem = ItemStack.EMPTY;


    public SmithingMenuMixin(@Nullable MenuType<?> menuType, int i, Inventory inventory, ContainerLevelAccess containerLevelAccess) {
        super(menuType, i, inventory, containerLevelAccess);
    }

    @Inject(method = "onTake", at = @At("HEAD"))
    private void miningmaster$captureItems(Player player, ItemStack stack, CallbackInfo ci) {
        this.miningmaster$cachedAdditionItem = this.inputSlots.getItem(1).copy();
    }

    @WrapWithCondition(method = "onTake", at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/world/inventory/SmithingMenu;shrinkStackInSlot(I)V"
    ))
    protected boolean miningmaster$onTake(SmithingMenu instance, int index) {
        assert this.selectedRecipe != null;
        if (this.selectedRecipe.value() instanceof GemSmithingRecipe gemSmithingRecipe && index == 2) {
            int cost = gemSmithingRecipe.getGemCost(this.inputSlots.getItem(2), this.miningmaster$cachedAdditionItem);
            this.miningmaster$shrinkStackInSlot(2, cost);
            return false;
        }

        return true;
    }

    @Unique
    private void miningmaster$shrinkStackInSlot(int index, int amount) {
        ItemStack itemStack = this.inputSlots.getItem(index);
        int realAmount = Math.min(itemStack.getCount(), amount);
        if (!itemStack.isEmpty()) {
            itemStack.shrink(realAmount);
            this.inputSlots.setItem(index, itemStack);
        }
    }
}
