package org.infernalstudios.miningmaster.init;

import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.infernalstudios.miningmaster.MiningMaster;

public class MMTabs {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(MiningMaster.MOD_ID, Registries.CREATIVE_MODE_TAB);

    public static final RegistrySupplier<CreativeModeTab> MM_TAB = TABS.register(MiningMaster.prefix("mining_master"), ()-> CreativeTabRegistry.create(Component.translatable("itemGroup.MiningMasterTab"), ()->new ItemStack(MMItems.TAB_ITEM.get())));

    public static void init()
    {
        TABS.register();
        MiningMaster.LOGGER.info("Creative Tabs registered");
    }
}
