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
			return false;
		}
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		switch (type) {
		case EQUIPPED: {

		}
		case EQUIPPED_FIRST_PERSON: {
			GL11.glPushMatrix();
			boolean isFirstPerson = false;
			if (data[1] != null && data[1] instanceof EntityPlayer) {
				Minecraft.getMinecraft().renderEngine.bindTexture(TESRBarrel.texture);

				if (!((EntityPlayer) data[1] == Minecraft.getMinecraft().renderViewEntity
						&& Minecraft.getMinecraft().gameSettings.thirdPersonView == 0
						&& !((Minecraft.getMinecraft().currentScreen instanceof GuiInventory
								|| Minecraft.getMinecraft().currentScreen instanceof GuiContainerCreative)
								&& RenderManager.instance.playerViewY == 180.0F))) {
					GL11.glTranslatef(0.25F, 0.1F, 0.0F);
					GL11.glRotatef(30F, 1F, 0F, 0F);
					GL11.glRotatef(50F, -10F, 1F, 0F);
					GL11.glRotatef(0F, 0F, 0F, 1F);
					isFirstPerson = false;
				} else {
					isFirstPerson = true;

					GL11.glTranslatef(0.7F, 0.3F, 0.7F);

					GL11.glRotatef(-170F, 1F, 0F, 0F);
					GL11.glRotatef(10F, 0F, 1F, 0F);
					GL11.glRotatef(-90F, 0F, 0F, 1F);
				}
				float par1 = 0.045f;
				GL11.glScalef(par1, par1, par1);
				TESRBarrel.model.renderAll();
				GL11.glPopMatrix();
			}
		}
		case INVENTORY: {
			/*
			 * Minecraft.getMinecraft().renderEngine.bindTexture(TESRBarrel.
			 * texture); GL11.glPushMatrix(); GL11.glTranslatef(0.7F, 0.3F,
			 * 0.7F); GL11.glRotatef(-170F, 1F, 0F, 0F); GL11.glRotatef(10F, 0F,
			 * 1F, 0F); GL11.glRotatef(-90F, 0F, 0F, 1F);
			 * TESRBarrel.model.renderAll(); GL11.glPopMatrix();
			 */
		}

		default:
			break;

		}

	}

}
