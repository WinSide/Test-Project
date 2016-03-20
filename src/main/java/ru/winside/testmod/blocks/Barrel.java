package ru.winside.testmod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import ru.winside.testmod.tileentites.TEBucket;
import ru.winside.testmod.tileentites.TEBarrel;

public class Barrel extends BlockContainer implements ITileEntityProvider {

	private static int renderID = -1;

	public Barrel(Material p_i45394_1_) {
		super(p_i45394_1_);
	}

	@Override
	public boolean shouldSideBeRendered(IBlockAccess world, int x, int y, int z, int side) {
		return false;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public int getRenderType() {
		return renderID;
	}

	public void onBlockPlacedBy(World world, int x, int y, int z,
			net.minecraft.entity.EntityLivingBase EntityLivingBase, net.minecraft.item.ItemStack ItemStack) {
		int l = MathHelper.floor_double((double) (EntityLivingBase.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
		world.setBlockMetadataWithNotify(x, y, z, l, 2);
	};

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TEBarrel();
	}
}
