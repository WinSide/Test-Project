package ru.winside.testmod.renderer;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainerCreative;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

public class ItemRenderer implements IItemRenderer {
	public ItemRenderer() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		switch (type) {
		case EQUIPPED_FIRST_PERSON:
			return true;
		case EQUIPPED:
			return true;
		case INVENTORY:
			return true;
		default:
			return true;
		}
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return false;
	}
	
	public void renderBarrel(float x, float y, float z, float rotateX, float rotateY, float rotateZ, float scaleXYZ){
		GL11.glPushMatrix();
		Minecraft.getMinecraft().renderEngine.bindTexture(TESRBarrel.texture);
		GL11.glTranslatef(x, y, z);
		GL11.glRotatef(rotateX, 1F, 0F, 0F);
		GL11.glRotatef(rotateY, 0F, 1F, 0F);
		GL11.glRotatef(rotateZ, 0F, 0F, 1F);
		GL11.glScalef(scaleXYZ, scaleXYZ, scaleXYZ);
		TESRBarrel.model.renderAll();
		GL11.glPopMatrix();
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		switch (type) {
		case EQUIPPED: {
			renderBarrel(0.5f, -0.3f, 0.3f, 0f, 0f, 0f, 0.03f);
			return;
		}
		case EQUIPPED_FIRST_PERSON: {
			renderBarrel(0.8f, 0.4f, 0.0f, -20f, -10f, 70f, 0.02f);
			return;
		}
		case INVENTORY: {
			renderBarrel(3.0f, 3.0f, 0.0f, 50f, 30f, -60f, 0.36f);
			return;
		}

		default:
			renderBarrel(0.0f, 0.5f, 0.0f, 0f, 0f, 0f, 0.04f);
			return;
		}

	}

}
