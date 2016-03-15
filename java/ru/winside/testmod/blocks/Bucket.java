package ru.winside.testmod.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import ru.winside.testmod.tileentites.TEBucket;

public class Bucket extends BlockContainer{

	public Bucket(Material p_i45386_1_) {
		super(p_i45386_1_);
	}
	
	@Override
	public boolean shouldSideBeRendered(IBlockAccess world, int x, int y, int z, int side)
	{
	return false;
	}
	 
	@Override
	public boolean isOpaqueCube()
	{
	return false;
	}
	 
	@Override
	public boolean renderAsNormalBlock()
	{
	return false;
	}
	 
	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		// TODO Auto-generated method stub
		return new TEBucket();
	}
}
