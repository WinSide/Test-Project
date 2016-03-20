package ru.winside.testmod.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class Galil extends Item {
	public Galil() {
		setMaxStackSize(1);
		setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName("galil");
		isFull3D();
	}
}
