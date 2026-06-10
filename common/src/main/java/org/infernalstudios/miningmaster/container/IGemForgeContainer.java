package org.infernalstudios.miningmaster.container;

import net.minecraft.world.Container;
import org.infernalstudios.miningmaster.recipe.GemForgingRecipeInput;

public interface IGemForgeContainer extends Container {

    public GemForgingRecipeInput asRecipeInput();
}
