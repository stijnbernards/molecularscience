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
	
	int color = 0x000000;
	
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
   		checkblocks(worldObj.getBlock(xCoord+1, yCoord, zCoord).getLocalizedName());
   		worldObj.scheduleBlockUpdate(xCoord, yCoord, zCoord, Block, 50);
   		this.worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
   	}
   	
   	public void checkblocks(String block){
   		if(block == "Fire"){
   			if(Temperature != 600){
   				Temperature = Temperature + 0.1;
   			}
   		}
   		if(block == "Lava"){
   			if(Temperature != 700){
   				Temperature = Temperature + 0.5;
   			}else{
   				System.out.println("BOOM");
   			}
   		}
   	}
}
