/*
 * Copyright 2021 Infernal Studios
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.infernalstudios.miningmaster.client.gui.recipebook;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.ChatFormatting;
import net.minecraft.client.RecipeBookCategories;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.screens.recipebook.RecipeBookComponent;
import net.minecraft.client.gui.screens.recipebook.RecipeBookTabButton;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.crafting.Ingredient;
//import net.minecraftforge.api.distmarker.Dist;
//import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.ShapedRecipe;
import org.infernalstudios.miningmaster.MiningMaster;
import org.infernalstudios.miningmaster.mixin.accessor.RecipeBookComponentAccessor;

import java.util.Iterator;
import java.util.List;

//@OnlyIn(Dist.CLIENT)
public class GemForgeRecipeGui extends RecipeBookComponent {
    protected static final ResourceLocation RECIPE_BOOK_GEM_FORGE = ResourceLocation.fromNamespaceAndPath(MiningMaster.MOD_ID, "textures/gui/recipe_book_gem_forge.png");
    private static final WidgetSprites RECIPE_BOOK_GEM_FORGE_SPRITE = new WidgetSprites(RECIPE_BOOK_GEM_FORGE, RECIPE_BOOK_GEM_FORGE);
    private static final Component translationKeyForgable = Component.translatable(MiningMaster.MOD_ID + ".gui.recipebook.toggleRecipes.forgable");

    private static final Component SEARCH_HINT = Component.translatable("gui.recipebook.search_hint")
            .withStyle(ChatFormatting.ITALIC)
            .withStyle(ChatFormatting.GRAY);

    protected Component getRecipeFilterName() {
        return translationKeyForgable;
    }

    protected void initFilterButtonTextures() {
//        this.filterButton.initTextureValues(152, 41, 28, 18, RECIPE_BOOK_GEM_FORGE);
        this.filterButton.initTextureValues(RECIPE_BOOK_GEM_FORGE_SPRITE);
    }

    @Override
    public void setupGhostRecipe(RecipeHolder<?> recipe, List<Slot> slots) {
        this.ghostRecipe.setRecipe(recipe);
        this.placeRecipe(this.menu.getGridWidth(), this.menu.getGridHeight(), this.menu.getResultSlotIndex(), recipe, recipe.value().getIngredients().iterator(), 0);
    }

    @Override
//    public void addItemToSlot(Iterator<Ingredient> ingredients, int slotIn, int maxAmount, int y, int x)
    public void addItemToSlot(Ingredient item, int slot, int maxAmount, int x, int y) {
//        Ingredient ingredient = ingredients.next();
        if (!item.isEmpty()) {
            Slot slot2 = this.menu.slots.get(slot);

//            if (ingredients.hasNext()) {
//                slot = this.menu.slots.get(slotIn);
//            } else {
//                slot = this.menu.slots.get(this.menu.getResultSlotIndex());
//            }

            this.ghostRecipe.addIngredient(item, slot2.x, slot2.y);
        }
    }

    @Override
    public void placeRecipe(int width, int height, int outputSlot, RecipeHolder<?> recipe, Iterator<Ingredient> ingredients, int maxAmount) {
        int i = width;
        int j = height;
        if (recipe.value() instanceof ShapedRecipe shapedRecipe) {
            i = shapedRecipe.getWidth();
            j = shapedRecipe.getHeight();
        }

        int k = 0;

        for (int l = 0; l < height; l++) {
            if (k == outputSlot) {
                k++;
            }

            boolean bl = j < height / 2.0F;
            int m = Mth.floor(height / 2.0F - j / 2.0F);
            if (bl && m > l) {
                k += width;
                l++;
            }

            for (int n = 0; n < width; n++) {
                if (!ingredients.hasNext()) {
                    return;
                }

                bl = i < width / 2.0F;
                m = Mth.floor(width / 2.0F - i / 2.0F);
                int o = i;
                boolean bl2 = n < i;
                if (bl) {
                    o = m + i;
                    bl2 = m <= n && n < m + i;
                }

                if (bl2) {
                    this.addItemToSlot(ingredients.next(), k, maxAmount, n, l);
                } else if (o == n) {
                    k += width - n;
                    break;
                }

                k++;
            }
        }
    }

    @Override
    public void renderGhostRecipe(GuiGraphics graphics, int xOffset, int yOffset, boolean displayOutputSquare, float time) {
        super.renderGhostRecipe(graphics, xOffset, yOffset, false, time);
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTicks) {
        var thisObject = (RecipeBookComponentAccessor) this;

        if (this.isVisible()) {
            graphics.pose().pushPose();
            graphics.pose().translate(0.0F, 0.0F, 100.0F);
            RenderSystem.setShader(GameRenderer::getPositionTexShader);
            RenderSystem.setShaderTexture(0, RECIPE_BOOK_GEM_FORGE);
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
            int i = (thisObject.getWidth() - 147) / 2 - thisObject.getXOffset();
            int j = (((RecipeBookComponentAccessor) this).getHeight() - 166) / 2;
            graphics.blit(RECIPE_BOOK_GEM_FORGE, i, j, 1, 1, 147, 166);
            if (!thisObject.getSearchBox().isFocused() && thisObject.getSearchBox().getValue().isEmpty()) {
                graphics.drawString(this.minecraft.font, SEARCH_HINT, i + 25, j + 14, -1);
            } else {
                thisObject.getSearchBox().render(graphics, mouseX, mouseY, partialTicks);
            }

            for (RecipeBookTabButton recipetabtogglewidget : thisObject.getTabButtons()) {
                recipetabtogglewidget.render(graphics, mouseX, mouseY, partialTicks);
            }

            this.filterButton.render(graphics, mouseX, mouseY, partialTicks);
            thisObject.getRecipeBookPage().render(graphics, i, j, mouseX, mouseY, partialTicks);
            graphics.pose().popPose();
        }
    }
}
