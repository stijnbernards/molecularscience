package molecularscience.moditems;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class TileEntityHeatConductant extends TileEntity{

	int Temperature;

	@Override
   	public void writeToNBT(NBTTagCompound nbt)
   	{
   		System.out.println("update");
   		super.writeToNBT(nbt);
      	nbt.setInteger("Temperature", 1);
   	}

   	@Override
   	public void readFromNBT(NBTTagCompound nbt)
   	{
   		System.out.println("update");
   		super.readFromNBT(nbt);
      	this.Temperature = nbt.getInteger("Temperature");
   	}
   	
   	@Override
   	public boolean canUpdate(){
   		return true;
   	}
   	
   	@Override
   	public void updateEntity() {
   		System.out.println("update");
   	}
}
