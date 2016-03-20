package ru.winside.testmod.renderer;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;
import net.minecraftforge.client.IItemRenderer.ItemRendererHelper;
import ru.winside.testmod.utils.GalilModel;

public class GalilItemRenderer implements IItemRenderer {

	private static final ResourceLocation texture = new ResourceLocation("winsidemods", "texture/models/Galil.png");
	protected GalilModel model = new GalilModel();
	
	public GalilItemRenderer(){
		
	}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		switch(type){
		case EQUIPPED: return true;
		default : return false;
		}
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return false;
	}

	public void renderGalil(float x, float y, float z, float rotateX, float rotateY, float rotateZ, float scaleXYZ, Object... data) {
		GL11.glPushMatrix();
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		GL11.glTranslatef(x, y, z);
		GL11.glRotatef(rotateX, 1F, 0F, 0F);
		GL11.glRotatef(rotateY, 0F, 1F, 0F);
		GL11.glRotatef(rotateZ, 0F, 0F, 1F);
		GL11.glScalef(scaleXYZ, scaleXYZ, scaleXYZ);
		model.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		switch (type) {
		case EQUIPPED: {
			Minecraft.getMinecraft().renderEngine.bindTexture(texture);
			model.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
			return;
		}
		case EQUIPPED_FIRST_PERSON: {
			renderGalil(0.8f, 0.4f, 0.0f, -20f, -10f, 70f, 0.02f);
			return;
		}
		case INVENTORY: {
			renderGalil(3.0f, 3.0f, 0.0f, 50f, 30f, -60f, 0.36f);
			return;
		}

		default:
			break;
		}

	}

}
