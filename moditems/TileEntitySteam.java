package molecularscience.moditems;

import net.minecraft.tileentity.TileEntity;

public class TileEntitySteam extends TileEntity{
	
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
   		worldObj.scheduleBlockUpdate(xCoord, yCoord, zCoord, this.getBlockType(), 1);
   	}
   	
   	public void checkblocks(String block, String coord){
   		if(block.contains("HeatConductant")){
   			String[] coords = coord.split(" ");
   			int gettiletemp = 0;
   			
   	    	TileEntityHeatConductant tile = (TileEntityHeatConductant) worldObj.getTileEntity(xCoord + Integer.parseInt(coords[0]), yCoord + Integer.parseInt(coords[1]), zCoord + Integer.parseInt(coords[2]));
   	    	if(tile != null)
   	    	{
   	    		gettiletemp = (int) tile.Temperature;
   	    	}
   	    	if(gettiletemp <= 21){
   	    		if(this.getBlockType().getLocalizedName().contains("Pine Steam")){
   	    			worldObj.setBlock(xCoord, yCoord, zCoord, BlocksItems.PineOil);
   	   	    		//worldObj.setBlockToAir(xCoord, yCoord, zCoord);
   	    		}
   	    	}
   		}
   	}
}
