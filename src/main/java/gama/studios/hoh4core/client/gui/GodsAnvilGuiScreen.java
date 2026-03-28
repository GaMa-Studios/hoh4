package gama.studios.hoh4core.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import java.util.HashMap;

import gama.studios.hoh4core.world.inventory.GodsAnvilGuiMenu;
import gama.studios.hoh4core.network.GodsAnvilGuiButtonMessage;
import gama.studios.hoh4core.Hoh4CoreMod;

import com.mojang.blaze3d.systems.RenderSystem;

public class GodsAnvilGuiScreen extends AbstractContainerScreen<GodsAnvilGuiMenu> {
	private final static HashMap<String, Object> guistate = GodsAnvilGuiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_anvil_of_gods_gui4;

	public GodsAnvilGuiScreen(GodsAnvilGuiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 180;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("hoh_4_core:textures/screens/gods_anvil_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(new ResourceLocation("hoh_4_core:textures/screens/anvil_of_gods_gui1.png"), this.leftPos + -12, this.topPos + -14, 0, 0, 32, 32, 32, 32);

		guiGraphics.blit(new ResourceLocation("hoh_4_core:textures/screens/anvil_of_gods_gui2.png"), this.leftPos + 170, this.topPos + 2, 0, 0, 32, 32, 32, 32);

		guiGraphics.blit(new ResourceLocation("hoh_4_core:textures/screens/anvil_of_gods_gui3_1.png"), this.leftPos + 27, this.topPos + 47, 0, 0, 32, 32, 32, 32);

		guiGraphics.blit(new ResourceLocation("hoh_4_core:textures/screens/anvil_of_gods_gui3_1.png"), this.leftPos + 123, this.topPos + 47, 0, 0, 32, 32, 32, 32);

		guiGraphics.blit(new ResourceLocation("hoh_4_core:textures/screens/anvil_of_gods_gui3_1.png"), this.leftPos + 27, this.topPos + 8, 0, 0, 32, 32, 32, 32);

		guiGraphics.blit(new ResourceLocation("hoh_4_core:textures/screens/anvil_of_gods_gui3_1.png"), this.leftPos + 123, this.topPos + 8, 0, 0, 32, 32, 32, 32);

		guiGraphics.blit(new ResourceLocation("hoh_4_core:textures/screens/anvil_of_gods_gui2.png"), this.leftPos + 50, this.topPos + 48, 0, 0, 32, 32, 32, 32);

		guiGraphics.blit(new ResourceLocation("hoh_4_core:textures/screens/anvil_of_gods_gui1.png"), this.leftPos + 109, this.topPos + 33, 0, 0, 32, 32, 32, 32);

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
	}

	@Override
	public void init() {
		super.init();
		imagebutton_anvil_of_gods_gui4 = new ImageButton(this.leftPos + 76, this.topPos + 27, 32, 32, 0, 0, 32, new ResourceLocation("hoh_4_core:textures/screens/atlas/imagebutton_anvil_of_gods_gui4.png"), 32, 64, e -> {
			if (true) {
				Hoh4CoreMod.PACKET_HANDLER.sendToServer(new GodsAnvilGuiButtonMessage(0, x, y, z));
				GodsAnvilGuiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_anvil_of_gods_gui4", imagebutton_anvil_of_gods_gui4);
		this.addRenderableWidget(imagebutton_anvil_of_gods_gui4);
	}
}
