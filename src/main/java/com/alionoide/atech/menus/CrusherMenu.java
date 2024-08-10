package com.alionoide.atech.menus;

import com.alionoide.atech.BlocksRegistry;
import com.alionoide.atech.MenuRegistry;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;

public class CrusherMenu extends AbstractContainerMenu {
    // Client menu constructor
    public CrusherMenu(int containerId, Inventory playerInventory) {
        this(containerId, playerInventory, new SimpleContainer(2), ContainerLevelAccess.NULL);
    }
    // Server menu constructor
    public CrusherMenu(int containerId, Inventory playerInventory, Container container, ContainerLevelAccess access) {
        super(MenuRegistry.CRUSHER_MENU.get(), containerId);

        this.access = access;
        this.container = container;


        this.addSlot(new Slot(container, 0, 56, 17)); // Input slot
        this.addSlot(new Slot(container, 1, 116, 35)); // Output slot

        // Player inventory slots
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        // Player hotbar slots
        for (int k = 0; k < 9; ++k) {
            this.addSlot(new Slot(playerInventory, k, 8 + k * 18, 142));
        }
    }

    private final Container container;
    private final ContainerLevelAccess access;

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        Slot slot = this.slots.get(index);
        if (slot != null && slot.hasItem()) {
            ItemStack itemstack = slot.getItem();
            ItemStack itemstack1 = itemstack.copy();
            if (index < this.container.getContainerSize()) {
                if (!this.moveItemStackTo(itemstack, this.container.getContainerSize(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(itemstack, 0, this.container.getContainerSize(), false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }

            if (itemstack.getCount() == itemstack1.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(player, itemstack);
        }

        return ItemStack.EMPTY;
    }

    @Override
    public boolean stillValid(Player player) {
        return  AbstractContainerMenu.stillValid(this.access, player, BlocksRegistry.CRUSHER.get());
    }
}
