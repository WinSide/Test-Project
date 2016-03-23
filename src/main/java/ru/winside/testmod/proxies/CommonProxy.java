package ru.winside.testmod.proxies;

import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.EntityRegistry.EntityRegistration;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import ru.winside.testmod.Main;
import ru.winside.testmod.blocks.Barrel;
import ru.winside.testmod.blocks.Bucket;
import ru.winside.testmod.entitys.EntityBullet;
import ru.winside.testmod.entitys.EntityBullet1;
import ru.winside.testmod.tileentites.TEBarrel;
import ru.winside.testmod.tileentites.TEBucket;

public class CommonProxy {
	
	public static Block barrelBlock = new Barrel(Material.wood).setBlockName("barrelBlock").setCreativeTab(CreativeTabs.tabBlock);
	public static Block bukkitBlock = new Bucket(Material.wood).setBlockName("bucketBlock").setCreativeTab(CreativeTabs.tabBlock);
	
	public static void init(){
		GameRegistry.registerBlock(barrelBlock, "barrelBlock");
		GameRegistry.registerTileEntity(TEBarrel.class, "barrelBlock");
		
		GameRegistry.registerBlock(bukkitBlock, "bukkitBlock");
		GameRegistry.registerTileEntity(TEBucket.class, "bukkitBlock");
		
		EntityRegistry.registerModEntity(EntityBullet.class, "bullet", 4, Main.instance, 250, 5, true);
		EntityRegistry.registerModEntity(EntityBullet1.class, "bullet1", 5, Main.instance, 64, 20, true);
	}
}
