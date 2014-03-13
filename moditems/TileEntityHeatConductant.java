package molecularscience.moditems;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityHeatConductant extends TileEntity{

	double Temperature = 21;
	
	int color = 0x555555;

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
   	
   	public int getColor(){
   		int intcolor = 0;
   		int green = (int) ((64.0 / 700.0) * this.Temperature);
   		int red = (int) ((255.0 / 700.0) * this.Temperature);
   		return ((green*256) + (red*65536));
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
   		this.color = getColor();
   		this.worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
   	}
   	
   	public void checkblocks(String block, String coord){
   		boolean aircool = true;
			
		String[] coords = coord.split(" ");
   		if(block.equals("Fire")){
   			if(Temperature <= 600.0){
   				Temperature = Temperature + 0.1;
   			}
   			aircool = false;
   		}
   		if(block.equals("Lava")){
   			if(Temperature <= 700.0){
   				Temperature = Temperature + 0.5;
   			}else{
   				
   			}
   			aircool = false;
   		}
   		if(block.equals("Water")){
   			if(Temperature >= 10.0){
   				Temperature = Temperature - 20;
   				if(Temperature >= 100){
   					//worldObj.setBlockToAir(xCoord + Integer.parseInt(coords[0]), yCoord + Integer.parseInt(coords[1]), zCoord + Integer.parseInt(coords[2]));
   				}
   			}
   			aircool = false;
   		}
   		if(block.contains("HeatConductant")){
   			int gettiletemp = 0;
   			
   	    	TileEntityHeatConductant tile = (TileEntityHeatConductant) worldObj.getTileEntity(xCoord + Integer.parseInt(coords[0]), yCoord + Integer.parseInt(coords[1]), zCoord + Integer.parseInt(coords[2]));
   	    	if (tile != null)
   	    	{
   	    		gettiletemp = (int) tile.Temperature;
   	    	}
   	    	if(gettiletemp >= this.Temperature){
   	    		int conductiveness = 0;
   	    		String[] test = this.getBlockType().getLocalizedName().split(" ");
   	    		if(test[0].equals("Fast")){
   	    			conductiveness = 5;
   	    		}
   	    		double add = gettiletemp - this.Temperature;
   	    		add = add / conductiveness;
   	    		Temperature = Temperature + add;
   	    	}
   	    	aircool = false;
   		}
   		if(aircool == true){
   			if(Temperature >= 20){
   				Temperature = Temperature - 0.3;
   			}
   		}
   	}
   	
   	@Override
   	public Packet getDescriptionPacket() {
   		NBTTagCompound tag = new NBTTagCompound();
   		this.writeToNBT(tag);
   		return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 1, tag);
   	}

   	@Override
   	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet) {
   		readFromNBT(packet.func_148857_g());
   	}
}
