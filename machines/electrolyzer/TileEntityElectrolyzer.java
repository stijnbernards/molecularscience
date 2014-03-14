package molecularscience.machines.electrolyzer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityElectrolyzer extends TileEntity implements IInventory {

        private ItemStack[] inv;
    	private int time;
        public int progress;
        private int resultItem = 3;
        
        public TileEntityElectrolyzer(){
                inv = new ItemStack[4];
        }
        
        @Override
        public int getSizeInventory() {
                return inv.length;
        }

        @Override
        public ItemStack getStackInSlot(int slot) {
                return inv[slot];
        }
        
        @Override
        public void setInventorySlotContents(int slot, ItemStack stack) {
                inv[slot] = stack;
                if (stack != null && stack.stackSize > getInventoryStackLimit()) {
                        stack.stackSize = getInventoryStackLimit();
                }               
        }

        @Override
        public ItemStack decrStackSize(int slot, int amt) {
                ItemStack stack = getStackInSlot(slot);
                if (stack != null) {
                        if (stack.stackSize <= amt) {
                                setInventorySlotContents(slot, null);
                        } else {
                                stack = stack.splitStack(amt);
                                if (stack.stackSize == 0) {
                                        setInventorySlotContents(slot, null);
                                }
                        }
                }
                return stack;
        }
        
        @Override
    	public void updateEntity(){
    	   if(!worldObj.isRemote){
    		   int item = getAvailableSlot();
    		   if(inv[item] != null){
    			   Item type = inv[item].getItem();
    			   ItemStack result = ElectrolyzerResults.getResult(item, type);
    			   time = ElectrolyzerResults.getMaxTime(item, type);

    			   if(result != null){
    				   if(progress > time){
    						if (inv[resultItem] == null){
    							inv[resultItem] = result.copy();
    			            }
    						else if (inv[resultItem].isItemEqual(result)){
    							if(inv[resultItem].stackSize + result.stackSize <= getInventoryStackLimit()){
    								inv[resultItem].stackSize += result.stackSize;
    							}
    						}
    						if(inv[item] != null){
    							if(!((inv[item].stackSize - ElectrolyzerResults.getReduceItem(item, type)) < 0)){
    								inv[item].stackSize -= ElectrolyzerResults.getReduceItem(item, type);
    							}
    							if(inv[item].stackSize <= 0){
    								inv[item] = null;
    							}
    						}
    						progress = 0;
    				   }
    				   if(inv[resultItem] != null){
						   System.out.println("stap0");
    						   if(inv[resultItem].isItemEqual(result)){
								   System.out.println("stap1");
    							   if(inv[resultItem].stackSize < getInventoryStackLimit() || inv[resultItem].stackSize < result.getItem().getItemStackLimit()){
    								   System.out.println("stap2");
    								   if(inv[item] != null){
    									   System.out.println("stap3");
    									   if(!((inv[item].stackSize - ElectrolyzerResults.getReduceItem(item, type)) < 0)){
    										   System.out.println("stap4");
    										   if(inv[resultItem].stackSize + result.stackSize <= getInventoryStackLimit()){
    											   progress++;
    											   System.out.println("++");
    										   }
    										   else{
    											   progress = 0;
    										   }
    									   }
    									   else{
    										   progress = 0;
    									   }
    								   }
    								   else{
    									   progress = 0;
    								   }  
    							   }
    							   else{
    								   progress = 0;
    							   }
    						   }
    						   else{
    							   progress = 0;
    						   }
    					   }
    				   else{
    					   if(inv[item] != null){
    						   System.out.println("isnull");
    						   if(!((inv[item].stackSize - ElectrolyzerResults.getReduceItem(item, type)) < 0)){
    								   progress++;  
    						   }
    						   else{
    							   progress = 0;
    						   }
    					   }
    					   else{
    						   progress = 0;
    					   }
    				   }
    			   }
    			   else{
    				   progress = 0;
    			   }
    		   }
    	   }
    	   }

        @Override
        public ItemStack getStackInSlotOnClosing(int slot) {
                ItemStack stack = getStackInSlot(slot);
                if (stack != null) {
                        setInventorySlotContents(slot, null);
                }
                return stack;
        }
        
        @Override
        public int getInventoryStackLimit() {
                return 64;
        }

        @Override
        public boolean isUseableByPlayer(EntityPlayer player) {
                return worldObj.getTileEntity(xCoord, yCoord, zCoord) == this &&
                player.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) < 64;
        }

        public void openChest() {}

        public void closeChest() {}
        
        @Override
        public void readFromNBT(NBTTagCompound tagCompound) {
                super.readFromNBT(tagCompound);
                progress = tagCompound.getShort("progressTime");
                
        }

        @Override
        public void writeToNBT(NBTTagCompound tagCompound) {
                super.writeToNBT(tagCompound);
                tagCompound.setShort("progressTime", (short)progress);
                NBTTagList itemList = new NBTTagList();
                for (int i = 0; i < inv.length; i++) {
                        ItemStack stack = inv[i];
                        if (stack != null) {
                                NBTTagCompound tag = new NBTTagCompound();
                                tag.setByte("Slot", (byte) i);
                                stack.writeToNBT(tag);
                                itemList.appendTag(tag);
                        }
                }
                tagCompound.setTag("Inventory", itemList);
        }

				@Override
				public String getInventoryName() {
					return "molecularscience.tileentityelectrolyzer";
				}

			    @SideOnly(Side.CLIENT)
			    public int getCraftingProgressScaled(int par1){
			        //return this.progress * par1 / ElectrolyzerResults.getMaxTime(0, 0);
			    	return 0;
			    }
			    
				public int getAvailableSlot(){
					   for(int i = 0; i < inv.length - 1; i++){
						   if(inv[i] != null){
							   return i;
						   }
					   }
					   return 0;
					}
				public boolean isBusy(){
					return progress >= 0;
				}

				@Override
				public boolean hasCustomInventoryName() {
					// TODO Auto-generated method stub
					return false;
				}

				@Override
				public void openInventory() {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void closeInventory() {
					// TODO Auto-generated method stub
					
				}

				@Override
				public boolean isItemValidForSlot(int var1, ItemStack var2) {
					// TODO Auto-generated method stub
					return false;
				}
}