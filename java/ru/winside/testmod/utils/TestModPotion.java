package ru.winside.testmod.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;

public class TestModPotion extends Potion {

	public TestModPotion(int par1, boolean par2, int par3) {
		super(par1, par2, par3);
	}

	public Potion setIconIndex(int par1, int par2) {
		super.setIconIndex(par1, par2);
		return this;
	}

	@Override
	public int getStatusIconIndex() {
		ResourceLocation r = new ResourceLocation("winsidemods", "textures/gui/inventory.png");

		ITextureObject texture = Minecraft.getMinecraft().renderEngine.getTexture(r);
		Minecraft.getMinecraft().renderEngine.bindTexture(r);

		return super.getStatusIconIndex();
	}
}