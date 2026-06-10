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

package org.infernalstudios.miningmaster.block.entity;

import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.minecraft.core.*;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.StackedContents;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.StackedContentsCompatible;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
//import net.minecraftforge.common.capabilities.Capability;
//import net.minecraftforge.common.capabilities.CapabilityManager;
//import net.minecraftforge.common.capabilities.ForgeCapabilities;
//import net.minecraftforge.common.util.LazyOptional;
//import net.minecraftforge.items.IItemHandler;
//import net.minecraftforge.items.ItemHandlerHelper;
//import net.minecraftforge.items.ItemStackHandler;
//import net.minecraftforge.items.wrapper.SidedInvWrapper;
import org.infernalstudios.miningmaster.MiningMaster;
import org.infernalstudios.miningmaster.block.GemForgeBlock;
//import org.infernalstudios.miningmaster.container.GemForgeContainer;
import org.infernalstudios.miningmaster.container.GemForgeMenu;
import org.infernalstudios.miningmaster.container.IGemForgeContainer;
import org.infernalstudios.miningmaster.init.MMBlockEntities;
import org.infernalstudios.miningmaster.init.MMRecipes;
import org.infernalstudios.miningmaster.init.MMSounds;
import org.infernalstudios.miningmaster.init.MMTags;
import org.infernalstudios.miningmaster.recipe.GemForgingRecipe;
import org.infernalstudios.miningmaster.recipe.GemForgingRecipeInput;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


public class GemForgeBlockEntity extends BaseContainerBlockEntity implements WorldlyContainer, StackedContentsCompatible, IGemForgeContainer {

    @Nullable
    protected Component customName;
    private NonNullList<ItemStack> inventory = NonNullList.withSize(10, ItemStack.EMPTY);

    private final Object2IntOpenHashMap<ResourceLocation> recipes = new Object2IntOpenHashMap<>();


    //<editor-fold desc="ContainerData">
    private static final int FORGE_TIME_TOTAL = 300;
    private int forgeTime = 0;
    private boolean forgeActive;
    private boolean recipeValid;
    // I know this is sloppy, but Containers can only track Int Arrays
    protected final ContainerData forgeData = new ContainerData() {
        public int get(int index) {
            return switch (index) {
                case 0 -> GemForgeBlockEntity.this.forgeActive ? 1 : 0;
                case 1 -> GemForgeBlockEntity.this.recipeValid ? 1 : 0;
                case 2 -> GemForgeBlockEntity.this.forgeTime;
                case 3 -> FORGE_TIME_TOTAL;
                default -> 0;
            };
        }

        public void set(int index, int k) {
            switch(index) {
                case 0:
                    GemForgeBlockEntity.this.forgeActive = k == 1;
                    if (!GemForgeBlockEntity.this.level.isClientSide()) {
                        GemForgeBlockEntity.this.level.playSound(null, GemForgeBlockEntity.this.worldPosition, MMSounds.GEM_FORGE_COOK.get(), SoundSource.BLOCKS, 1.0F, GemForgeBlockEntity.this.level.getRandom().nextFloat() * 0.4F + 1.0F);
                    }
                    break;
                case 1:
                    GemForgeBlockEntity.this.recipeValid = k == 1;
                case 2:
                    GemForgeBlockEntity.this.forgeTime = k;
            }
        }

        public int getCount() {
            return 4;
        }
    };
    //</editor-fold>

    private static final int[] SLOTS_UP = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8};
    private static final int[] SLOTS_DOWN = new int[]{9};
    private static final int[] SLOTS_HORIZONTAL = new int[]{9};

    public GemForgeBlockEntity(BlockPos pos, BlockState state) {
        super(MMBlockEntities.GEM_FORGE_BLOCK_ENTITY.get(), pos, state);
    }

    public static void tickForge(Level level, BlockPos pos, BlockState state, GemForgeBlockEntity gemForge) {
        boolean flag = gemForge.isForging();
        boolean flag1 = false;
        if (gemForge.isForging()) {
            ++gemForge.forgeTime;
        }

        if (!level.isClientSide) {
            RecipeHolder<GemForgingRecipe> recipe = level.getRecipeManager()
                    .getRecipeFor(
                            MMRecipes.FORGING_RECIPE_TYPE,
                            new GemForgingRecipeInput(gemForge.inventory),
                            level)
                    .orElse(null);

            gemForge.recipeValid = gemForge.canForge(recipe);

            if (gemForge.recipeValid && gemForge.forgeActive) {
                ++gemForge.forgeTime;

                if (gemForge.forgeTime >= FORGE_TIME_TOTAL) {
                    gemForge.forgeTime = 0;
                    gemForge.forge(recipe);
                    flag1 = true;
                }
            } else {
                gemForge.forgeActive = false;
                gemForge.forgeTime = 0;
            }

            if (flag != gemForge.isForging()) {
                flag1 = true;
                level.setBlock(pos, state.setValue(GemForgeBlock.LIT, gemForge.isForging()), 3);
            }
        }

        if (flag1) {
            gemForge.setChanged();
        }
    }

    private boolean isForging() {
        return this.forgeTime > 0;
    }

    @Override
    public Component getCustomName() {
//        this.customName = name;
        return this.customName;
    }

    @Override
    public void loadAdditional(CompoundTag nbt, HolderLookup.Provider registries) {
        super.loadAdditional(nbt, registries);
//        inventory.deserializeNBT(nbt.getCompound("inv"));
        ContainerHelper.loadAllItems(
                nbt,
                this.inventory,
                registries
        );

        CompoundTag recipesUsedTag = nbt.getCompound("RecipesUsed");

        this.forgeActive = nbt.getBoolean("ForgeActive");
        this.recipeValid = nbt.getBoolean("RecipeValid");

        for(String key : recipesUsedTag.getAllKeys()) {
            this.recipes.put(ResourceLocation.parse(key), recipesUsedTag.getInt(key));
        }

    }

//    @Override
//    public void saveAdditional(CompoundTag compound, HolderLookup.Provider registries) {
//        super.saveAdditional(compound);
//        compound.put("inv", inventory.serializeNBT());
//        CompoundTag compoundnbt = new CompoundTag();
//        this.recipes.forEach((recipeId, craftedAmount) -> {
//            compoundnbt.putInt(recipeId.toString(), craftedAmount);
//        });
//        compound.put("RecipesUsed", compoundnbt);
//        compound.putBoolean("ForgeActive", this.forgeActive);
//        compound.putBoolean("RecipeValid", this.recipeValid);
//    }

    @Override
    protected void saveAdditional(CompoundTag nbt, HolderLookup.Provider registries) {
        super.saveAdditional(nbt, registries);

        ContainerHelper.saveAllItems(
                nbt,
                this.inventory,
                registries
        );

        nbt.putBoolean("ForgeActive", forgeActive);
        nbt.putBoolean("RecipeValid", recipeValid);

        CompoundTag recipesTag = new CompoundTag();

        recipes.forEach((id, count) ->
                recipesTag.putInt(id.toString(), count));

        nbt.put("RecipesUsed", recipesTag);
    }

    protected @NotNull AbstractContainerMenu createMenu(int id, Inventory inv) {
        return new GemForgeMenu(
                id,
                inv,
                this,
                forgeData
        );
    }

    public Component getDisplayName() {
        return this.customName != null ? this.customName : Component.translatable(MiningMaster.MOD_ID + ':' + "container.gem_forge");
    }

    public void setCustomName(Component customName) {
        this.customName = customName;
    }

    @Override
    protected Component getDefaultName() {
        return this.customName;
    }

    protected boolean canForge(@Nullable RecipeHolder<GemForgingRecipe> recipe) {
        if (recipe != null) {
            ItemStack result = recipe.value().assemble(
                    this.asRecipeInput(),
                    this.level.registryAccess());

            return !result.isEmpty();
        } else {
            return false;
        }
    }

    private void forge(@Nullable RecipeHolder<GemForgingRecipe> recipe) {
        if (recipe != null && this.canForge(recipe)) {
            ItemStack result = recipe.value().assemble(
                    this.asRecipeInput(),
                    this.level.registryAccess());

            this.setItem(9, result.copy());

            if (!this.level.isClientSide) {
                this.setRecipeUsed(recipe);
            }

            for(int i = 0; i < 9; ++i) {
                this.removeItem(i, 1);
            }

            this.forgeActive = false;

            if (!GemForgeBlockEntity.this.level.isClientSide()) {
                GemForgeBlockEntity.this.level.playSound(null, GemForgeBlockEntity.this.worldPosition, MMSounds.GEM_FORGE_COMPLETE.get(), SoundSource.BLOCKS, 1.0F, GemForgeBlockEntity.this.level.getRandom().nextFloat() * 0.8F + 0.25F);
            }
        }
    }

    //<editor-fold desc="WorldlyContainer Implementation">
    @Override
    public int[] getSlotsForFace(Direction side) {
        if (side == Direction.DOWN) {
            return SLOTS_DOWN;
        } else {
            return side == Direction.UP ? SLOTS_UP : SLOTS_HORIZONTAL;
        }
    }

    public boolean canPlaceItemThroughFace(int index, ItemStack itemStackIn, @Nullable Direction direction) {
        return this.canPlaceItem(index, itemStackIn);
    }

    public boolean canTakeItemThroughFace(int index, ItemStack stack, Direction direction) {
        return !stack.is(MMTags.Items.MM_GEMS) && !stack.is(MMTags.Items.MM_CATALYSTS);
    }
    //</editor-fold>

    public void setRecipeUsed(@Nullable RecipeHolder<?> recipe) {
        if (recipe != null) {
            ResourceLocation resourcelocation = recipe.id();
            this.recipes.addTo(resourcelocation, 1);
        }
    }

    @Nullable
    public Recipe<?> getRecipeUsed() {
        return null;
    }

    //<editor-fold desc="IGemForgeContainer Implementation">
    @Override
    public int getMaxStackSize() {
        return 1;
    }

    @Override
    public int getContainerSize() {
        return this.inventory.size();
    }

    @Override
    public boolean isEmpty() {
        for(int i = 0; i < 10; i++) {
            if (!this.getItem(i).isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public @NotNull ItemStack getItem(int index) {
        return index >= this.getContainerSize() ? ItemStack.EMPTY : this.inventory.get(index);
    }

    @Override
    protected @NotNull NonNullList<ItemStack> getItems() {
        return this.inventory;
    }

    @Override
    protected void setItems(NonNullList<ItemStack> items) {
        this.inventory = items;
    }

    @Override
    public void setItem(int index, ItemStack stack) {
        this.inventory.set(index, stack);
        if (stack.getCount() > this.getMaxStackSize()) {
            stack.setCount(this.getMaxStackSize());
        }
        this.setChanged();
    }

    @Override
    public @NotNull ItemStack removeItem(int index, int count) {
        return !this.getItem(index).isEmpty() && count > 0 ? this.getItem(index).split(count) : ItemStack.EMPTY;
    }

    @Override
    public @NotNull ItemStack removeItemNoUpdate(int index) {
        ItemStack itemStack = this.getItem(index);
        this.setItem(index, ItemStack.EMPTY);
        return itemStack;
    }

    @Override
    public boolean stillValid(Player player) {
        if (this.level.getBlockEntity(this.worldPosition) != this) {
            System.out.println(false);
            return false;
        } else {
            System.out.println(true);
            return player.distanceToSqr((double)this.worldPosition.getX() + 0.5D, (double)this.worldPosition.getY() + 0.5D, (double)this.worldPosition.getZ() + 0.5D) <= 64.0D;
        }
    }

    @Override
    public boolean canPlaceItem(int index, ItemStack stack) {
        if (this.getItem(index).getCount() != 0) {
            return false;
        } else if (index < 9) {
            return stack.is(MMTags.Items.MM_GEMS);
        } else {
            return stack.is(MMTags.Items.MM_CATALYSTS);
        }
    }

    @Override
    public void clearContent() {
        this.inventory.clear();
    }

    public void fillStackedContents(StackedContents helper) {
        for(int i = 0; i < 10; i++) {
            helper.accountStack(this.getItem(i));
        }
    }

    @Override
    public GemForgingRecipeInput asRecipeInput() {
        return new GemForgingRecipeInput(
                this.inventory
        );
    }
    //</editor-fold>
}
