package org.infernalstudios.neoforge.miningmaster;

import net.minecraft.client.RecipeBookCategories;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.fml.common.asm.enumextension.EnumProxy;
import net.neoforged.neoforge.client.IArmPoseTransformer;
//import vectorwing.farmersdelight.client.renderer.SkilletItemRenderer;
//import vectorwing.farmersdelight.common.registry.ModItems;

import java.util.List;
import java.util.function.Supplier;

public class EnumParameters
{
    public static final EnumProxy<RecipeBookCategories> PROXY_GEM_FORGING_SEARCH = new EnumProxy<>(
            RecipeBookCategories.class, (Supplier<List<ItemStack>>) () -> List.of(new ItemStack(Items.COMPASS))
    );
    public static final EnumProxy<RecipeBookCategories> PROXY_GEM_FORGING_WEAPONS = new EnumProxy<>(
            RecipeBookCategories.class, (Supplier<List<ItemStack>>) () -> List.of(new ItemStack(Items.IRON_SWORD))
    );
    public static final EnumProxy<RecipeBookCategories> PROXY_GEM_FORGING_TOOLS = new EnumProxy<>(
            RecipeBookCategories.class, (Supplier<List<ItemStack>>) () -> List.of(new ItemStack(Items.IRON_PICKAXE))
    );
    public static final EnumProxy<RecipeBookCategories> PROXY_GEM_FORGING_ARMOR = new EnumProxy<>(
            RecipeBookCategories.class, (Supplier<List<ItemStack>>) () -> List.of(new ItemStack(Items.IRON_CHESTPLATE))
    );
}
