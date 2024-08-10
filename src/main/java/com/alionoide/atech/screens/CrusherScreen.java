package com.alionoide.atech.screens;

import com.alionoide.atech.ATech;
import com.alionoide.atech.menus.CrusherMenu;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.inventory.AbstractContainerMenu;
import com.mojang.blaze3d.systems.RenderSystem;

public class CrusherScreen extends AbstractContainerScreen<CrusherMenu> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(ATech.MODID, "textures/gui/crusher.png");

    public CrusherScreen(CrusherMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
        this.imageHeight = 166;
        this.imageWidth = 176;
    }

    @Override
    protected void renderBg(GuiGraphics matrixStack, float partialTicks, int x, int y) {
        RenderSystem.setShaderTexture(0, TEXTURE);
        this.blit(matrixStack, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight);

        // Render progress arrow (Example)
        if (this.menu.getProgress() > 0) {
            int progress = this.menu.getProgress() * 24 / this.menu.getMaxProgress();
            this.blit(matrixStack, this.leftPos + 79, this.topPos + 35, 176, 14, progress + 1, 16);
        }
    }

    @Override
    protected void renderLabels(GuiGraphics matrixStack, int mouseX, int mouseY) {
        this.font.draw(matrixStack, this.title, (float)this.titleLabelX, (float)this.titleLabelY, 4210752);
        this.font.draw(matrixStack, this.playerInventoryTitle, 8.0F, (float)(this.imageHeight - 94), 4210752);
    }

    @Override
    public void render(GuiGraphics matrixStack, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrixStack);
        super.render(matrixStack, mouseX, mouseY, delta);
        this.renderTooltip(matrixStack, mouseX, mouseY);
    }
}
