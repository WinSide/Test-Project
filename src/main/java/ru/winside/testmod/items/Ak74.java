package ru.winside.testmod.items;

import java.util.Random;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import ru.winside.testmod.Main;
import ru.winside.testmod.entitys.EntityBullet;
import ru.winside.testmod.entitys.EntityBullet1;

public class Ak74 extends Item {
	Random rand;
	public Ak74() {
		super();
		setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName("ak74");
		isFull3D();
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
		Vec3 vec3 = player.getLookVec(); // returns a normalized vector, which is what you want in this case

		// add one of each vector coordinate to the player's position to get a position just in front of the player
		double x = player.posX + vec3.xCoord;
		double y = player.posY + vec3.yCoord;
		double z = player.posZ + vec3.zCoord;
		
		if (!world.isRemote) {
			world.spawnParticle("flame", x, y, z, 0.0d, 0.0d, 0.0d);
			world.spawnEntityInWorld(new EntityBullet(world, player, 10.0f, 0.0f, 2));
			player.addChatComponentMessage(new ChatComponentText(" " + player.rotationYaw));
		}
		return itemStack;
	}
}
