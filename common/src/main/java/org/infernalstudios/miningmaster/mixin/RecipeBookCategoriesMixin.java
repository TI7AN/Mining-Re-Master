package org.infernalstudios.miningmaster.mixin;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.RecipeBookCategories;
import net.minecraft.world.inventory.RecipeBookType;
import net.minecraft.world.item.ItemStack;
import org.infernalstudios.miningmaster.init.MMRecipeBookType;
import org.infernalstudios.miningmaster.init.client.MMRecipeCategories;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(RecipeBookCategories.class)
public class RecipeBookCategoriesMixin {
    @Unique
    private static final List<RecipeBookCategories> MININGMASTER_GEM_FORGING_CATEGORIES = ImmutableList.of(
            MMRecipeCategories.GEM_FORGING_SEARCH,
            MMRecipeCategories.GEM_FORGING_WEAPONS,
            MMRecipeCategories.GEM_FORGING_TOOLS,
            MMRecipeCategories.GEM_FORGING_ARMOR
    );

//    @Shadow
//    RecipeBookCategoriesMixin(ItemStack... itemIcons) {
//    }

    @Inject(method = "getCategories", at = @At("TAIL"), cancellable = true)
    private static void MM$getCustomCategories(RecipeBookType recipeBookType, CallbackInfoReturnable<List<RecipeBookCategories>> cir){
        if (recipeBookType == MMRecipeBookType.GEM_FORGING) {
            cir.setReturnValue(MININGMASTER_GEM_FORGING_CATEGORIES);
        }
    }
}
