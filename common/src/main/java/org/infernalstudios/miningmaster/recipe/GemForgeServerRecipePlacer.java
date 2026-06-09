/*
 * Copyright 2021 Infernal Studios
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.infernalstudios.miningmaster.recipe;

import com.google.common.collect.Lists;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntList;
import net.minecraft.network.protocol.game.ClientboundPlaceGhostRecipePacket;
import net.minecraft.recipebook.PlaceRecipe;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.StackedContents;
import net.minecraft.world.inventory.RecipeBookMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.ShapedRecipe;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Iterator;
import java.util.List;

public class GemForgeServerRecipePlacer<I extends RecipeInput, R extends Recipe<I>> implements PlaceRecipe<Integer> {
    protected static final Logger LOGGER = LogManager.getLogger();
    protected final StackedContents recipeItemHelper = new StackedContents();
    protected Inventory playerInventory;
    protected RecipeBookMenu<I, R> recipeBookMenu;

    public GemForgeServerRecipePlacer(RecipeBookMenu<I, R> recipeBookMenu) {
        this.recipeBookMenu = recipeBookMenu;
    }

    protected void clear() {
        for(int i = 0; i < 10; i++) {
            this.giveToPlayer(i);
        }

        this.recipeBookMenu.clearCraftingContent();
    }

    protected void giveToPlayer(int slotIn) {
        ItemStack itemstack = this.recipeBookMenu.getSlot(slotIn).getItem();
        if (!itemstack.isEmpty()) {
            while (itemstack.getCount() > 0) {
                int i = this.playerInventory.getSlotWithRemainingSpace(itemstack);
                if (i == -1) {
                    i = this.playerInventory.getFreeSlot();
                }

                ItemStack itemstack1 = itemstack.copy();
                itemstack1.setCount(1);
                this.playerInventory.add(i, itemstack1);
                this.recipeBookMenu.getSlot(slotIn).remove(1);
                itemstack = this.recipeBookMenu.getSlot(slotIn).getItem();
            }

        }
    }

    public void place(ServerPlayer player, RecipeHolder<R> recipe, boolean placeAll) {
        if (recipe != null && player.getRecipeBook().contains(recipe)) {
            this.playerInventory = player.getInventory();
            if (this.placeIntoInventory() || player.isCreative()) {
                this.recipeItemHelper.clear();
                player.getInventory().fillStackedContents(this.recipeItemHelper);
                this.recipeBookMenu.fillCraftSlotsStackedContents(this.recipeItemHelper);
                if (this.recipeItemHelper.canCraft(recipe.value(), null)) {
                    this.tryPlaceRecipe(recipe, placeAll);
                } else {
                    this.clear();
                    player.connection.send(new ClientboundPlaceGhostRecipePacket(player.containerMenu.containerId, recipe));
                }
                player.getInventory().setChanged();
            }
        }
    }

    protected void tryPlaceRecipe(RecipeHolder<R> recipe, boolean placeAll) {
        boolean flag = this.recipeBookMenu.recipeMatches(recipe);
        int i = this.recipeItemHelper.getBiggestCraftableStack(recipe, null);
        if (flag) {
            for (int j = 0; j < 10; ++j) {
                ItemStack itemstack = this.recipeBookMenu.getSlot(j).getItem();
                if (!itemstack.isEmpty() && Math.min(i, itemstack.getMaxStackSize()) < itemstack.getCount() + 1) {
                    return;
                }
            }
        }

        int j1 = this.getMaxAmount(placeAll, i, flag);
        IntList intlist = new IntArrayList();
        if (this.recipeItemHelper.canCraft(recipe.value(), intlist, j1)) {
            int k = j1;

            for(int l : intlist) {
                int i1 = StackedContents.fromStackingIndex(l).getMaxStackSize();
                if (i1 < k) {
                    k = i1;
                }
            }

            if (this.recipeItemHelper.canCraft(recipe.value(), intlist, k)) {
                this.clear();
                this.placeRecipe(this.recipeBookMenu.getGridWidth(), this.recipeBookMenu.getGridHeight(), this.recipeBookMenu.getResultSlotIndex(), recipe, intlist.iterator(), k);
            }
        }

    }

    protected int getMaxAmount(boolean placeAll, int maxPossible, boolean recipeMatches) {
        int i = 1;
        if (placeAll) {
            i = maxPossible;
        } else if (recipeMatches) {
            i = 64;

            for(int j = 0; j < 10; ++j) {
                if (j != this.recipeBookMenu.getResultSlotIndex()) {
                    ItemStack itemstack = this.recipeBookMenu.getSlot(j).getItem();
                    if (!itemstack.isEmpty() && i > itemstack.getCount()) {
                        i = itemstack.getCount();
                    }
                }
            }

            if (i < 64) {
                ++i;
            }
        }

        return i;
    }

    protected void consumeIngredient(Slot slotToFill, ItemStack ingredientIn) {
        int i = this.playerInventory.findSlotMatchingUnusedItem(ingredientIn);
        if (i != -1) {
            ItemStack itemstack = this.playerInventory.getItem(i).copy();
            if (!itemstack.isEmpty()) {
                if (itemstack.getCount() > 1) {
                    this.playerInventory.removeItem(i, 1);
                } else {
                    this.playerInventory.removeItemNoUpdate(i);
                }

                itemstack.setCount(1);
                if (slotToFill.getItem().isEmpty()) {
                    slotToFill.set(itemstack);
                } else {
                    slotToFill.getItem().grow(1);
                }

            }
        }
    }

    @Override
    public void placeRecipe(int width, int height, int outputSlot, RecipeHolder<?> recipe, Iterator<Integer> ingredients, int maxAmount) {
        int i = width;
        int j = height;
        if (recipe.value() instanceof ShapedRecipe shapedRecipe) {
            i = shapedRecipe.getWidth();
            j = shapedRecipe.getHeight();
        }

        int k = 0;

        for (int l = 0; l < height; l++) {
            if (k == outputSlot) {
                k++;
            }

            boolean bl = j < height / 2.0F;
            int m = Mth.floor(height / 2.0F - j / 2.0F);
            if (bl && m > l) {
                k += width;
                l++;
            }

            for (int n = 0; n < width; n++) {
                if (!ingredients.hasNext()) {
                    return;
                }

                bl = i < width / 2.0F;
                m = Mth.floor(width / 2.0F - i / 2.0F);
                int o = i;
                boolean bl2 = n < i;
                if (bl) {
                    o = m + i;
                    bl2 = m <= n && n < m + i;
                }

                if (bl2) {
                    this.addItemToSlot((Integer)ingredients.next(), k, maxAmount, n, l);
                } else if (o == n) {
                    k += width - n;
                    break;
                }

                k++;
            }
        }
    }

    @Override
    public void addItemToSlot(Integer item, int slotIndex, int maxAmount, int x, int y)
//    public void addItemToSlot(Iterator<Integer> ingredients, int slotIn, int maxAmount, int y, int x)
    {
        Slot slot = this.recipeBookMenu.getSlot(slotIndex);
        ItemStack itemStack = StackedContents.fromStackingIndex(item);

        if (!itemStack.isEmpty()) {
            for (int i = 0; i < maxAmount; i++) {
                this.consumeIngredient(slot, itemStack);
            }
        }

//        ItemStack itemstack = StackedContents.fromStackingIndex(ingredients.next());
//        Slot slot;
//
//        if (ingredients.hasNext()) {
//            slot = this.recipeBookMenu.slots.get(slotIn);
//        } else {
//            slot = this.recipeBookMenu.slots.get(this.recipeBookMenu.getResultSlotIndex());
//        }
//
//        if (!itemstack.isEmpty()) {
//            for (int i = 0; i < maxAmount; ++i) {
//                this.consumeIngredient(slot, itemstack);
//            }
//        }
    }

    private boolean placeIntoInventory() {
        List<ItemStack> list = Lists.newArrayList();
        int i = this.getEmptyPlayerSlots();

        for(int j = 0; j < 10; j++) {
                ItemStack itemstack = this.recipeBookMenu.getSlot(j).getItem().copy();
                if (!itemstack.isEmpty()) {
                    int k = this.playerInventory.getSlotWithRemainingSpace(itemstack);
                    if (k == -1 && list.size() <= i) {
                        for(ItemStack itemstack1 : list) {
                            if (ItemStack.isSameItem(itemstack1, itemstack) && itemstack1.getCount() != itemstack1.getMaxStackSize() && itemstack1.getCount() + itemstack.getCount() <= itemstack1.getMaxStackSize()) {
                                itemstack1.grow(itemstack.getCount());
                                itemstack.setCount(0);
                                break;
                            }
                        }

                        if (!itemstack.isEmpty()) {
                            if (list.size() >= i) {
                                return false;
                            }

                            list.add(itemstack);
                        }
                    } else if (k == -1) {
                        return false;
                    }
                }
        }

        return true;
    }

    private int getEmptyPlayerSlots() {
        int i = 0;

        for(ItemStack itemstack : this.playerInventory.items) {
            if (itemstack.isEmpty()) {
                ++i;
            }
        }

        return i;
    }
}
