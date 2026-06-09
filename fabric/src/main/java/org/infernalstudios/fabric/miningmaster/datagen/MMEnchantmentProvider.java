package org.infernalstudios.fabric.miningmaster.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.item.enchantment.Enchantment;
import org.infernalstudios.miningmaster.MiningMaster;
import org.infernalstudios.miningmaster.init.MMEnchantments;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class MMEnchantmentProvider extends FabricDynamicRegistryProvider {

    public MMEnchantmentProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    public static void bootstrap(BootstrapContext<Enchantment> context) {

        register(context, MMEnchantments.FLOATATION, Enchantment.enchantment(Enchantment.definition(
                context.lookup(Registries.ITEM).getOrThrow(ItemTags.CROSSBOW_ENCHANTABLE),
                2,
                3,
                Enchantment.constantCost(20),
                Enchantment.constantCost(50),
                8,
                EquipmentSlotGroup.MAINHAND))
        );

        register(context, MMEnchantments.FREEZING, Enchantment.enchantment(Enchantment.definition(
                //TODO this should apply to every weapon not just melees, create a custom tag
                context.lookup(Registries.ITEM).getOrThrow(ItemTags.WEAPON_ENCHANTABLE),
                2,
                2,
                Enchantment.constantCost(20),
                Enchantment.constantCost(50),
                8,
                EquipmentSlotGroup.MAINHAND))
        );

        register(context, MMEnchantments.GRACE, Enchantment.enchantment(Enchantment.definition(
                context.lookup(Registries.ITEM).getOrThrow(ItemTags.CHEST_ARMOR_ENCHANTABLE),
                2,
                5,
                Enchantment.constantCost(20),
                Enchantment.constantCost(50),
                8,
                EquipmentSlotGroup.CHEST))
        );

        register(context, MMEnchantments.HEARTFELT, Enchantment.enchantment(Enchantment.definition(
                context.lookup(Registries.ITEM).getOrThrow(ItemTags.ARMOR_ENCHANTABLE),
                2,
                2,
                Enchantment.constantCost(20),
                Enchantment.constantCost(50),
                8,
                EquipmentSlotGroup.ARMOR))
        );

        register(context, MMEnchantments.KNIGHT_JUMP, Enchantment.enchantment(Enchantment.definition(
                context.lookup(Registries.ITEM).getOrThrow(ItemTags.LEG_ARMOR_ENCHANTABLE),
                2,
                3,
                Enchantment.constantCost(20),
                Enchantment.constantCost(50),
                8,
                EquipmentSlotGroup.LEGS))
        );

        register(context, MMEnchantments.LEECHING, Enchantment.enchantment(Enchantment.definition(
                context.lookup(Registries.ITEM).getOrThrow(ItemTags.WEAPON_ENCHANTABLE),
                2,
                1,
                Enchantment.constantCost(20),
                Enchantment.constantCost(50),
                8,
                EquipmentSlotGroup.MAINHAND))
        );

        register(context, MMEnchantments.RUNNER, Enchantment.enchantment(Enchantment.definition(
                context.lookup(Registries.ITEM).getOrThrow(ItemTags.FOOT_ARMOR_ENCHANTABLE),
                2,
                3,
                Enchantment.constantCost(20),
                Enchantment.constantCost(50),
                8,
                EquipmentSlotGroup.FEET))
        );

        register(context, MMEnchantments.SMELTING, Enchantment.enchantment(Enchantment.definition(
                context.lookup(Registries.ITEM).getOrThrow(ItemTags.MINING_ENCHANTABLE),
                2,
                1,
                Enchantment.constantCost(20),
                Enchantment.constantCost(50),
                8,
                EquipmentSlotGroup.MAINHAND))
        );

        register(context, MMEnchantments.SNOWPIERCER, Enchantment.enchantment(Enchantment.definition(
                context.lookup(Registries.ITEM).getOrThrow(ItemTags.LEG_ARMOR_ENCHANTABLE),
                2,
                1,
                Enchantment.constantCost(20),
                Enchantment.constantCost(50),
                8,
                EquipmentSlotGroup.LEGS))
        );

        register(context, MMEnchantments.STONEBREAKER, Enchantment.enchantment(Enchantment.definition(
                context.lookup(Registries.ITEM).getOrThrow(ItemTags.MINING_ENCHANTABLE),
                2,
                1,
                Enchantment.constantCost(20),
                Enchantment.constantCost(50),
                8,
                EquipmentSlotGroup.MAINHAND))
        );
    }

    @Override
    protected void configure(HolderLookup.Provider registries, Entries entries) {
        entries.addAll(registries.lookupOrThrow(Registries.ENCHANTMENT));
    }

    private static void register(BootstrapContext<Enchantment> context, ResourceKey<Enchantment> key, Enchantment.Builder builder) {
        context.register(key, builder.build(key.location()));
    }

    @Override
    public @NotNull String getName() {
        return (MiningMaster.MOD_ID + " Enchantments");
    }
}
