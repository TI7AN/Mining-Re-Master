package org.infernalstudios.miningmaster.container;

import net.minecraft.world.SimpleContainer;
import org.infernalstudios.miningmaster.recipe.GemForgingRecipeInput;

public class SimpleGemForgeContainer extends SimpleContainer implements IGemForgeContainer {

    public SimpleGemForgeContainer() {
        super(10);
    }

    @Override
    public GemForgingRecipeInput asRecipeInput() {
        return new GemForgingRecipeInput(this.getItems())  ;
    }
}
