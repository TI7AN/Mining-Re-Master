package org.infernalstudios.miningmaster.container;

import net.minecraft.world.SimpleContainer;
import org.infernalstudios.miningmaster.recipe.ForgingRecipeInput;

public class SimpleGemForgeContainer extends SimpleContainer implements IGemForgeContainer {

    public SimpleGemForgeContainer() {
        super(10);
    }

    @Override
    public ForgingRecipeInput asRecipeInput() {
        return new ForgingRecipeInput(this.getItems())  ;
    }
}
