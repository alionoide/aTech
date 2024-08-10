package com.alionoide.atech.blocks;

import com.alionoide.atech.BlocksRegistry;
import com.alionoide.atech.menus.CrusherMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;

import javax.annotation.Nullable;

public class CrusherBlockEntity extends BlockEntity implements Container {
    public CrusherBlockEntity(BlockPos pos, BlockState state) {
        super(BlocksRegistry.CRUSHER_BE.get(), pos, state);
    }

    private final SimpleContainer items = new SimpleContainer(2); // One slot for input, one for output
    private int progress; // Track the processing progress
    private int maxProgress = 100; // Time required for processing

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        ContainerHelper.loadAllItems(tag, this.items);
        this.progress = tag.getInt("Progress");
    }

    @Override
    public void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        ContainerHelper.saveAllItems(tag, this.items);
        tag.putInt("Progress", this.progress);
    }

    public void tick() {
        if (this.items.getItem(0).isEmpty()) {
            this.progress = 0;
            return;
        }

        this.progress++;
        if (this.progress >= this.maxProgress) {
            this.progress = 0;
            this.processItem();
        }
    }

    private void processItem() {
        // Simple processing logic: turn the input item into something else (like a furnace does)
        ItemStack input = this.items.getItem(0);
        ItemStack output = this.items.getItem(1);

        // Example: input -> output conversion logic
        if (!input.isEmpty()) {
            ItemStack result = new ItemStack(Blocks.COBBLESTONE); // Example result

            if (output.isEmpty()) {
                this.items.setItem(1, result.copy());
            } else if (output.getItem() == result.getItem()) {
                output.grow(result.getCount());
            }

            input.shrink(1); // Decrease input stack size by 1
        }
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int id, Inventory playerInventory, Player player) {
        return new CrusherMenu(id, playerInventory, items, ContainerLevelAccess.create(this.level, this.worldPosition));
    }

    @Override
    public int getContainerSize() {
        return this.items.getContainerSize();
    }

    @Override
    public boolean isEmpty() {
        return this.items.isEmpty();
    }

    @Override
    public ItemStack getItem(int index) {
        return this.items.getItem(index);
    }

    @Override
    public ItemStack removeItem(int index, int count) {
        return this.items.removeItem(index, count);
    }

    @Override
    public ItemStack removeItemNoUpdate(int index) {
        return this.items.removeItemNoUpdate(index);
    }

    @Override
    public void setItem(int index, ItemStack stack) {
        this.items.setItem(index, stack);
    }

    @Override
    public boolean stillValid(Player player) {
        return true;
    }

    @Override
    public void clearContent() {
        this.items.clearContent();
    }
}
