//package org.infernalstudios.miningmaster.recipes;
//
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.item.crafting.RecipeInput;
//
//public record ForgingRecipeInput(ItemStack catalyst, ItemStack gems) implements RecipeInput {
//
//    @Override
//    public ItemStack getItem(int index) {
//        return switch (index) {
//            case 0 -> catalyst;
//            case 1 -> gems;
//            default -> ItemStack.EMPTY;
//        };
//    }
//
//    @Override
//    public int size() {
//        return 2;
//    }
//}
