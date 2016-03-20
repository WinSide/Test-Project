package ru.winside.testmod.renderer;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.event.world.WorldEvent;
import ru.winside.testmod.models.MagicStick;

public class MagicStickItemRenderer implements IItemRenderer {
	
	public static final MagicStick model = new MagicStick();
	public static final ResourceLocation texture = new ResourceLocation("winsidemods", "texture/models/Galil.png");
	
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
		GL11.glPushMatrix();
		GL11.glTranslatef(0.5F, 1.5F, 0.5F);
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		model.render((Entity) data[1], 0.0f, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
	}

}
