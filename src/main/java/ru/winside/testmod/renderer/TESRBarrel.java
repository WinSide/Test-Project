package ru.winside.testmod.renderer;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import ru.winside.testmod.Main;

public class TESRBarrel extends TileEntitySpecialRenderer {

	public static IModelCustom model = AdvancedModelLoader
			.loadModel(new ResourceLocation(Main.MODID, "models/Barrel.obj"));
	public static ResourceLocation texture = new ResourceLocation(Main.MODID, "textures/blocks/wood.jpg");

	@Override
	public void renderTileEntityAt(TileEntity entity, double x, double y, double z, float p_147500_8_) {
		int dir = entity.getWorldObj().getBlockMetadata(entity.xCoord, entity.yCoord, entity.zCoord);

		bindTexture(texture);

		GL11.glPushMatrix();
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

		GL11.glTranslatef((float) x + 0.5F, (float) y + 0.8F, (float) z - 0.8F);
		float par1 = 0.07F;
		GL11.glScalef(par1, par1, par1);
		GL11.glRotatef(90.0f, 1.0F, 0.0f, 0.0f);
		GL11.glRotatef(entity.getBlockMetadata() * 90, 0F, 1F, 0F);

		model.renderAll();
		GL11.glPopMatrix();
	}

}
