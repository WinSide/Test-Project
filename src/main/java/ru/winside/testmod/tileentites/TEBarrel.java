package ru.winside.testmod.tileentites;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

public class TEBarrel extends TileEntity {
	public AxisAlignedBB getRenderBoundingBox() {
        double d0 = 5.0D;
        AxisAlignedBB axisalignedbb = AxisAlignedBB.getBoundingBox((double)xCoord, (double)yCoord, (double)zCoord, (double)xCoord + 1.0D, (double)yCoord + 1.0D, (double)zCoord + 1.0D).expand(d0, d0, d0);
        return axisalignedbb;    
    }
}
