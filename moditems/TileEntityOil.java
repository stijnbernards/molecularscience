package molecularscience.moditems;

import net.minecraft.tileentity.TileEntity;

public class TileEntityOil extends TileEntity{
	
   	@Override
   	public boolean canUpdate(){
   		return true;
   	}
   	
   	@Override
   	public void updateEntity() {
   		worldObj.scheduleBlockUpdate(xCoord, yCoord, zCoord, this.getBlockType(), 1);
   	}
}