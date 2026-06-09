package org.infernalstudios.neoforge.miningmaster.client;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.client.event.RegisterRecipeBookCategoriesEvent;
import org.infernalstudios.miningmaster.MiningMaster;
import org.infernalstudios.miningmaster.client.MiningMasterClient;
import org.infernalstudios.miningmaster.client.gui.screen.inventory.GemForgeScreen;
import org.infernalstudios.miningmaster.init.MMMenuTypes;
import org.infernalstudios.miningmaster.setup.MMClientSetup;
import org.infernalstudios.neoforge.miningmaster.RecipeCategories;

@Mod(value = MiningMaster.MOD_ID, dist = Dist.CLIENT)
public class miningMasterNeoforgeClient {
    public miningMasterNeoforgeClient(IEventBus modBus) {

        MiningMasterClient.init();
        modBus.addListener(this::registerScreens);

    }

    public void registerScreens(RegisterMenuScreensEvent event) {
        MiningMaster.LOGGER.info("Registering screens for miningmaster");
        event.register(MMMenuTypes.GEM_FORGE_MENU.get(), GemForgeScreen::new);
    }

    @SubscribeEvent
    public static void registerRecipeBookCategories(RegisterRecipeBookCategoriesEvent event) {
        RecipeCategories.init(event);
    }
}
