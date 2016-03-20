package ru.winside.testmod.proxies;

import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraft.item.Item;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import ru.winside.testmod.Main;
import ru.winside.testmod.renderer.GalilItemRenderer;
import ru.winside.testmod.renderer.ItemRenderer;
import ru.winside.testmod.renderer.TESRBarrel;
import ru.winside.testmod.renderer.TESRBucket;
import ru.winside.testmod.tileentites.TEBarrel;
import ru.winside.testmod.tileentites.TEBucket;

public class ClientProxy extends CommonProxy{
	public static void init(){
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(barrelBlock), new ItemRenderer());
		MinecraftForgeClient.registerItemRenderer(Main.Galil,(IItemRenderer) new GalilItemRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TEBarrel.class, new TESRBarrel());
		ClientRegistry.bindTileEntitySpecialRenderer(TEBucket.class, new TESRBucket());
	}
}
