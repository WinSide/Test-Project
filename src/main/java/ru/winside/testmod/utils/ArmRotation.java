package ru.winside.testmod.utils;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.RenderLivingEvent;
import ru.winside.testmod.Main;
import ru.winside.testmod.proxies.ClientProxy;

public class ArmRotation {
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void lanternHolding(RenderLivingEvent.Pre event) {
		if ((!event.isCanceled()) && ((event.entity instanceof EntityPlayer))) {
			ItemStack item = event.entity.getHeldItem();
			if (item == null) {
				return;
			}
			if (item.getItem() == Main.justItem || item.getItem() == Main.Galil) {
				RenderPlayer rp = (RenderPlayer) event.renderer;

				rp.modelArmorChestplate.aimedBow = rp.modelArmor.aimedBow = rp.modelBipedMain.aimedBow = true;
			}
		}
	}
}