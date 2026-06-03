package org.infernalstudios.miningmaster.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.SmithingRecipe;
import org.infernalstudios.miningmaster.recipe.GemSmithingRecipe;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SmithingMenu.class)
public abstract class SmithingMenuMixin extends ItemCombinerMenu {
    //This is a complete mess, but it is the easiest way to consume more gems when enchanting with the smithing talbe


    @Shadow
    @Nullable
    private RecipeHolder<SmithingRecipe> selectedRecipe;


    public SmithingMenuMixin(@Nullable MenuType<?> menuType, int i, Inventory inventory, ContainerLevelAccess containerLevelAccess) {
        super(menuType, i, inventory, containerLevelAccess);
    }


    @Inject(method = "onTake", at = @At("HEAD"))
    protected void onTake(Player player, ItemStack itemStack, CallbackInfo ci) {
        assert this.selectedRecipe != null;
        if (this.selectedRecipe.value() instanceof GemSmithingRecipe gemSmithingRecipe) {
            int cost = gemSmithingRecipe.getGemCost(this.inputSlots.getItem(2), this.inputSlots.getItem(1));
            for(int i = 1; i < cost; i++) {
                this.shrinkStackInSlot(2);
            }
        }
    }

    @Shadow
    private void shrinkStackInSlot(int i) {

    }
}
