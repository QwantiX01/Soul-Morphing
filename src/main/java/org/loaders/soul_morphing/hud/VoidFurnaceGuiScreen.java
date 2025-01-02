package org.loaders.soul_morphing.hud;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import java.util.HashMap;

public class VoidFurnaceGuiScreen extends AbstractContainerScreen<VoidFurnaceGuiMenu> {

    private final static HashMap<String, Object> guistate = VoidFurnaceGuiMenu.guistate;
    private Button button_fuse;
    private final Level world;
    private final int x, y, z;
    private final Player entity;

    public VoidFurnaceGuiScreen(VoidFurnaceGuiMenu container, Inventory inventory, Component text) {
        super(container, inventory, text);
        this.world = container.world;
        this.x = container.x;
        this.y = container.y;
        this.z = container.z;
        this.entity = container.entity;
        this.imageWidth = 176;
        this.imageHeight = 166;
    }

    private static final ResourceLocation texture = ResourceLocation.parse("soul_morphing:textures/screens/void_furnace_gui.png");

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);

        super.render(guiGraphics, mouseX, mouseY, partialTicks);

        this.renderTooltip(guiGraphics, mouseX, mouseY);

    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
        RenderSystem.setShaderColor(1, 1, 1, 1);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();

        guiGraphics.blit(resourceLocation -> RenderType.guiTextured(texture), texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

        RenderSystem.disableBlend();
    }

    @Override
    public boolean keyPressed(int key, int b, int c) {
        if (key == 256) {
            this.minecraft.player.closeContainer();
            return true;
        }

        return super.keyPressed(key, b, c);
    }

    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        guiGraphics.drawString(this.font, Component.literal("Lilpidapopi"), 15, 18, -12829636, false);
    }

    @Override
    public void init() {
        super.init();


        button_fuse = Button.builder(Component.translatable("gui.sus.void_furnace_gui.button_fuse"), e -> {
        }).bounds(this.leftPos + 122, this.topPos + 60, 46, 20).build();

        guistate.put("button:button_fuse", button_fuse);
        this.addRenderableWidget(button_fuse);
    }

}