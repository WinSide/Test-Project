package ru.winside.testmod.proxies;

import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraft.item.Item;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import ru.winside.testmod.Main;
import ru.winside.testmod.items.Galil;
import ru.winside.testmod.renderer.MagicStickItemRenderer;
import ru.winside.testmod.renderer.ItemRenderer;
import ru.winside.testmod.renderer.TESRBarrel;
import ru.winside.testmod.renderer.TESRBucket;
import ru.winside.testmod.tileentites.TEBarrel;
import ru.winside.testmod.tileentites.TEBucket;

public class ClientProxy extends CommonProxy{
	public static void init(){
		
		MinecraftForgeClient.registerItemRenderer(Main.Galil, new MagicStickItemRenderer());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(barrelBlock), new ItemRenderer());
		
		ClientRegistry.bindTileEntitySpecialRenderer(TEBarrel.class, new TESRBarrel());
		ClientRegistry.bindTileEntitySpecialRenderer(TEBucket.class, new TESRBucket());
	}
}
