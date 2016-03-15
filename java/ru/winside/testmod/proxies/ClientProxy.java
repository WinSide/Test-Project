package ru.winside.testmod.proxies;

import cpw.mods.fml.client.registry.ClientRegistry;
import ru.winside.testmod.renderer.TESRBarrel;
import ru.winside.testmod.renderer.TESRBucket;
import ru.winside.testmod.tileentites.TEBarrel;
import ru.winside.testmod.tileentites.TEBucket;

public class ClientProxy extends CommonProxy{
	public static void init(){
		ClientRegistry.bindTileEntitySpecialRenderer(TEBarrel.class, new TESRBarrel());
		ClientRegistry.bindTileEntitySpecialRenderer(TEBucket.class, new TESRBucket());
	}
}
