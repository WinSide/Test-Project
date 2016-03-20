package ru.winside.testmod.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import ru.winside.testmod.Main;

public class Galil extends Item {
	public Galil() {
		super();
		setCreativeTab(CreativeTabs.tabMisc);
		setTextureName(Main.MODID + ":item_techne");
		setUnlocalizedName("galil");
		isFull3D();
	}
}
