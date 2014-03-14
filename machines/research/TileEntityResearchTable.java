package molecularscience.machines.research;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import molecularscience.api.ExtendedPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityResearchTable extends TileEntity implements IInventory {

        private ItemStack[] inv;
    	private int time;
        public int progress;
        private int resultItem = 1;
        
        public TileEntityResearchTable(){
                inv = new ItemStack[2];
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
    			   time = 50;

    				   if(progress > time){
    						if (inv[resultItem] == null){
    							inv[resultItem] = new ItemStack(type,1).copy();
    							ExtendedPlayer.Research(type.getUnlocalizedName());
    			            }
    						if(inv[item] != null){
    							if(!((inv[item].stackSize - 1) < 0)){
    								inv[item].stackSize -= 1;
    							}
    							if(inv[item].stackSize <= 0){
    								inv[item] = null;
    							}
    						}
    						progress = 0;
    				   }
    				   if(inv[resultItem] != null){
    					   progress = 0;
    					   }
    				   else{
    					   if(inv[item] != null){
    						   if(!((inv[item].stackSize - 1) < 0)){
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
			        return this.progress * par1 / 50;
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