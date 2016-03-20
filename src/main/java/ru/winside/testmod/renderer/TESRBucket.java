package ru.winside.testmod.renderer;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import ru.winside.testmod.Main;

public class TESRBucket extends TileEntitySpecialRenderer {

	IModelCustom model = AdvancedModelLoader.loadModel(new ResourceLocation(Main.MODID, "models/bucket.obj"));
	ResourceLocation texture = new ResourceLocation(Main.MODID, "textures/blocks/bucket.png");

	@Override
	public void renderTileEntityAt(TileEntity entity, double x, double y, double z, float p_147500_8_) {
		bindTexture(texture);

		GL11.glPushMatrix();
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		
		GL11.glTranslatef((float) x + 0.5F, (float) y + 0.0F, (float) z + 0.5F);
		float par1 = 0.5F;
		GL11.glScalef(par1, par1, par1);

		model.renderAll();
		GL11.glPopMatrix();
	}
}
