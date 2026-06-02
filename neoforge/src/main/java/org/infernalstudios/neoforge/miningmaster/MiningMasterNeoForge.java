package org.infernalstudios.neoforge.miningmaster;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;

import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.registries.RegisterEvent;
import org.infernalstudios.miningmaster.MiningMaster;
//import org.infernalstudios.miningmaster.client.gui.screen.inventory.GemForgeScreen;
//import org.infernalstudios.miningmaster.enchantments.*;
//import org.infernalstudios.neoforge.miningmaster.events.MiningMasterClientEvents;
//import org.infernalstudios.neoforge.miningmaster.events.MiningMasterEvents;
//import org.infernalstudios.miningmaster.init.*;
//import org.infernalstudios.miningmaster.network.MMNetworkHandler;

@Mod(MiningMaster.MOD_ID)
public final class MiningMasterNeoForge {

    public MiningMasterNeoForge() {
        // Run our common setup.
//        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
//
//        modEventBus.addListener(this::commonSetup);
//        modEventBus.addListener(this::clientSetup);
//
//        MMBlocks.register(modEventBus);
//        MMItems.register(modEventBus);
//        MMItems.TABS.register(modEventBus);
//        MMEnchantments.register(modEventBus);
//        MMRecipes.register(modEventBus);
//        MMContainerTypes.register(modEventBus);
//        MMTileEntityTypes.register(modEventBus);
//        MMSounds.register(modEventBus);
//        MMLootModifiers.register(modEventBus);
//        MMFeatures.register(modEventBus);
//
//        NeoForge.EVENT_BUS.register(new MiningMasterEvents());
//        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> NeoForge.EVENT_BUS.register(new MiningMasterClientEvents()));
//        NeoForge.EVENT_BUS.addListener(RunnerEnchantment::onItemAttributeModifierCalculate);
//        NeoForge.EVENT_BUS.addListener(RunnerEnchantment::onLivingUpdate);
//        NeoForge.EVENT_BUS.addListener(HeartfeltEnchantment::onItemAttributeModifierCalculate);
//        NeoForge.EVENT_BUS.addListener(HeartfeltEnchantment::onItemUnequip);
//        NeoForge.EVENT_BUS.addListener(HeartfeltEnchantment::onLivingDamage);
//        NeoForge.EVENT_BUS.addListener(SnowpiercerEnchantment::onLivingUpdate);
//        NeoForge.EVENT_BUS.addListener(GraceEnchantment::onLivingUpdate);
//        NeoForge.EVENT_BUS.addListener(KnightJumpEnchantment::onClientTick);

    }

    @SubscribeEvent
    public static void register(RegisterEvent event) {
        //TODO use this event to register everything
        MiningMaster.init();
    }

//    private void commonSetup(final FMLCommonSetupEvent event) {
//        event.enqueueWork(MMNetworkHandler::register);
//    }
//
//    private void clientSetup(final FMLClientSetupEvent event) {
//        event.enqueueWork(() -> {
//            ItemProperties.register(MMItems.AIR_MALACHITE_BOW.get(), new ResourceLocation("pull"), (itemStack, clientWorld, livingEntity, entityId) -> {
//                if (livingEntity == null) {
//                    return 0.0F;
//                } else {
//                    return livingEntity.getUseItem() != itemStack ? 0.0F : (float) (itemStack.getUseDuration() - livingEntity.getUseItemRemainingTicks()) / 20.0F;
//                }
//            });
//
//            ItemProperties.register(MMItems.AIR_MALACHITE_BOW.get(), new ResourceLocation("pulling"), (itemStack, clientWorld, livingEntity, entityId) -> livingEntity != null && livingEntity.isUsingItem() && livingEntity.getUseItem() == itemStack ? 1.0F : 0.0F);
//
//            MenuScreens.register(MMContainerTypes.GEM_FORGE_CONTAINER.get(), GemForgeScreen::new);
//        });
//    }
}
