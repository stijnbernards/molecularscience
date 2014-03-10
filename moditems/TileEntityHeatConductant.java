package molecularscience.moditems;

import org.apache.logging.log4j.core.pattern.ConverterKeys;

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

	double Temperature = 21;
	
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
      	nbt.setInteger("Color", color);
   	}

   	@Override
   	public void readFromNBT(NBTTagCompound nbt)
   	{
   		super.readFromNBT(nbt);
      	this.Temperature = nbt.getDouble("Temperature");
      	this.color = nbt.getInteger("Color");
   	}
   	
   	@Override
   	public boolean canUpdate(){
   		return true;
   	}
   	
   	@Override
   	public void updateEntity() {
   		checkblocks(worldObj.getBlock(xCoord+1, yCoord, zCoord).getLocalizedName(), "1 0 0");
   		checkblocks(worldObj.getBlock(xCoord-1, yCoord, zCoord).getLocalizedName(), "-1 0 0");
   		checkblocks(worldObj.getBlock(xCoord, yCoord+1, zCoord).getLocalizedName(), "0 1 0");
   		checkblocks(worldObj.getBlock(xCoord, yCoord-1, zCoord).getLocalizedName(), "0 -1 0");
   		checkblocks(worldObj.getBlock(xCoord, yCoord, zCoord+1).getLocalizedName(), "0 0 1");
   		checkblocks(worldObj.getBlock(xCoord, yCoord, zCoord-1).getLocalizedName(), "0 0 -1");
   		worldObj.scheduleBlockUpdate(xCoord, yCoord, zCoord, Block, 1);
   		this.worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
   	}
   	
   	public void checkblocks(String block, String coord){
   		if(block.equals("Fire")){
   			if(Temperature <= 600.0){
   				Temperature = Temperature + 0.1;
   			}
   		}
   		if(block.equals("Lava")){
   			if(Temperature <= 700.0){
   				Temperature = Temperature + 0.5;
   			}else{
   				
   			}
   		}
   		if(block.equals("Water")){
   			if(Temperature >= 10.0){
   				Temperature = Temperature - 0.3;
   			}
   		}
   		if(block.equals("HeatConductant")){
   			int gettiletemp = 0;
   			
   			String[] coords = coord.split(" ");
   			
   	    	TileEntityHeatConductant tile = (TileEntityHeatConductant) worldObj.getTileEntity(xCoord + Integer.parseInt(coords[0]), yCoord + Integer.parseInt(coords[1]), zCoord + Integer.parseInt(coords[2]));
   	    	if (tile != null)
   	    	{
   	    		gettiletemp = (int) tile.Temperature;
   	    	}
   	    	
   	    	if(gettiletemp >= this.Temperature){
   	    		double add = gettiletemp - this.Temperature;
   	    		add = add / 1000;
   	    		Temperature = Temperature + add;
   	    	}
   		}
   	}
}
