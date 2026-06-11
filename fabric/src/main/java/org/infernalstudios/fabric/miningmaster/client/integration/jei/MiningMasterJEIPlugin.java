package org.infernalstudios.fabric.miningmaster.client.integration.jei;

import java.util.Collection;
import java.util.List;

import com.google.common.collect.ImmutableList;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import org.infernalstudios.miningmaster.MiningMaster;
import org.infernalstudios.miningmaster.init.MMBlocks;
import org.infernalstudios.miningmaster.init.MMRecipes;

import net.minecraft.client.Minecraft;
import org.infernalstudios.miningmaster.recipe.GemForgingRecipe;

@JeiPlugin
public class MiningMasterJEIPlugin implements IModPlugin {
  private static final ResourceLocation UID = ResourceLocation.fromNamespaceAndPath(MiningMaster.MOD_ID, "jei_main");

  @Override
  public ResourceLocation getPluginUid() {
    return UID;
  }

  @Override
  public void registerCategories(IRecipeCategoryRegistration registration) {
    registration.addRecipeCategories(new GemForgeRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
  }

  @Override
  public void registerRecipes(IRecipeRegistration registration) {
    Collection<RecipeHolder<?>> recipes = Minecraft.getInstance().level.getRecipeManager().getRecipes();
    List<Recipe<?>> gmGemForgingRecipes = recipes.stream()
        .filter(recipe -> recipe.value().getType() == MMRecipes.GEM_FORGING_RECIPE_TYPE)
        .map(r -> r.value())
        .collect(ImmutableList.toImmutableList());
    registration.addRecipes(GemForgeRecipeCategory.RECIPE_TYPE, (List<GemForgingRecipe>) (Object) gmGemForgingRecipes);
  }

  @Override
  public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
    registration.addRecipeCatalyst(new ItemStack(MMBlocks.GEM_FORGE.get().asItem()), GemForgeRecipeCategory.RECIPE_TYPE);
  }
}
