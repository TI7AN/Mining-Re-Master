package org.infernalstudios.miningmaster.mixin.accessor;

import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.recipebook.RecipeBookComponent;
import net.minecraft.client.gui.screens.recipebook.RecipeBookPage;
import net.minecraft.client.gui.screens.recipebook.RecipeBookTabButton;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.List;

@Mixin(RecipeBookComponent.class)
public interface RecipeBookComponentAccessor {

    @Accessor("width")
    public int getWidth();

    @Accessor("height")
    public int getHeight();

    @Accessor("xOffset")
    public int getXOffset();

    @Accessor("searchBox")
    public EditBox getSearchBox();

    @Accessor("tabButtons")
    public List<RecipeBookTabButton> getTabButtons();

    @Accessor("recipeBookPage")
    public RecipeBookPage getRecipeBookPage();
}
