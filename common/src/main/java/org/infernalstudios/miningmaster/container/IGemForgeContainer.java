package org.infernalstudios.miningmaster.container;

import net.minecraft.world.Container;
import org.infernalstudios.miningmaster.recipe.ForgingRecipeInput;

public interface IGemForgeContainer extends Container {

    public ForgingRecipeInput asRecipeInput();
}
