package molecularscience.moditems;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import molecularscience.MolecularScience;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class TileEntityHeatConductant extends TileEntity{

	double Temperature = 0;
	
	Block Block;
	
	public TileEntityHeatConductant(Block block) {
		this.Block = block;
	}

	@Override
   	public void writeToNBT(NBTTagCompound nbt)
   	{
   		super.writeToNBT(nbt);
      	nbt.setDouble("Temperature", Temperature);
   	}

   	@Override
   	public void readFromNBT(NBTTagCompound nbt)
   	{
   		super.readFromNBT(nbt);
      	this.Temperature = nbt.getDouble("Temperature");
   	}
   	
   	@Override
   	public boolean canUpdate(){
   		return true;
   	}
   	
   	@Override
   	public void updateEntity() {
   		checkblocks();
   		worldObj.scheduleBlockUpdate(xCoord, yCoord, zCoord, Block, 50);
   		this.worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
   	}
   	
   	public void checkblocks(){
   		if(worldObj.getBlock(xCoord+1, yCoord, zCoord).getUnlocalizedName() == "tile.lava"){
   			Temperature = Temperature + 0.1;
   			System.out.println("jaj");
   		}
   	}
}
