package molecularscience.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityOil extends TileEntity{
	
	public boolean hasdust = false;
	
	@Override
   	public void writeToNBT(NBTTagCompound nbt)
   	{
   		super.writeToNBT(nbt);
      	nbt.setBoolean("hasdust", hasdust);
   	}

   	@Override
   	public void readFromNBT(NBTTagCompound nbt)
   	{
   		super.readFromNBT(nbt);
      	this.hasdust = nbt.getBoolean("hasdust");
   	}
	
   	@Override
   	public boolean canUpdate(){
   		return true;
   	}
   	
   	@Override
   	public void updateEntity() {
   		worldObj.scheduleBlockUpdate(xCoord, yCoord, zCoord, this.getBlockType(), 4);
   	}
}