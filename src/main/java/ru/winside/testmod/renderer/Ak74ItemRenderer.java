package ru.winside.testmod.renderer;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.event.world.WorldEvent;
import ru.winside.testmod.models.MagicStick;
import ru.winside.testmod.models.ModelLeftArm;

public class Ak74ItemRenderer implements IItemRenderer {
	
	public static final MagicStick model = new MagicStick();
	public static final ModelLeftArm leftArm = new ModelLeftArm();
	public static final ResourceLocation texture = new ResourceLocation("winsidemods", "textures/models/ak74.png");
	
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		if (type == ItemRenderType.INVENTORY) return false;
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		if (type == ItemRenderType.INVENTORY) return false;
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		switch(type){
		case EQUIPPED_FIRST_PERSON:{
			EntityClientPlayerMP player = Minecraft.getMinecraft().thePlayer;
			GL11.glPushMatrix();
			GL11.glTranslatef(-0.5F, 0.07F, -0.5F);
			GL11.glRotatef(90F, 1.0F, 0.0F, 0.0F);
			GL11.glRotatef(38F, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(-70F, 0.0F, 0.0F, 1.0F);
			Minecraft.getMinecraft().renderEngine.bindTexture(player.getLocationSkin());
			//leftArm.render((Entity) data[1], 0.0f, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
			GL11.glPopMatrix();
			
			GL11.glPushMatrix();
			GL11.glTranslatef(0.8F, 0.5F, 0.4F);
			GL11.glRotatef(180F, 1.0F, 0.0F, 0.0F);
			GL11.glRotatef(-30F, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(0F, 0.0F, 0.0F, 1.0F);
			Minecraft.getMinecraft().renderEngine.bindTexture(texture);
			model.render((Entity) data[1], 0.0f, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
			GL11.glPopMatrix();
			return;
		}
		case EQUIPPED: 
			GL11.glPushMatrix();
			GL11.glTranslatef(0.8F, 0.5F, 0.4F);
			GL11.glRotatef(180F, 1.0F, 0.0F, 0.0F);
			GL11.glRotatef(-30F, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(3F, 0.0F, 0.0F, 1.0F);
			Minecraft.getMinecraft().renderEngine.bindTexture(texture);
			model.render((Entity) data[1], 0.0f, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
			GL11.glPopMatrix();
			return;
		default:
			GL11.glPushMatrix();
			GL11.glTranslatef(-0.5F, 0.5F, 0.5F);
			GL11.glRotatef(180F, 1.0F, 0.0F, 0.0F);
			GL11.glRotatef(-30F, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(0F, 0.0F, 0.0F, 1.0F);
			Minecraft.getMinecraft().renderEngine.bindTexture(texture);
			model.render((Entity) data[1], 0.0f, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
			GL11.glPopMatrix();
			return;
		}
	}

}
