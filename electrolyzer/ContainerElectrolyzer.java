package molecularscience.electrolyzer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ContainerElectrolyzer extends Container {

        protected TileEntityElectrolyzer tileEntity;
        private int progress;

        public ContainerElectrolyzer (InventoryPlayer inventoryPlayer, TileEntityElectrolyzer te){
                tileEntity = te;
                addSlotToContainer(new Slot(tileEntity, 0, 22, 8));
                addSlotToContainer(new Slot(tileEntity, 1, 76, 8));
                addSlotToContainer(new Slot(tileEntity, 2, 49, 50));
                addSlotToContainer(new Slot(tileEntity, 3, 128, 29));
                bindPlayerInventory(inventoryPlayer);
        }
        
        @Override
        public boolean canInteractWith(EntityPlayer player) {
                return tileEntity.isUseableByPlayer(player);
        }


        protected void bindPlayerInventory(InventoryPlayer inventoryPlayer) {
                for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 9; j++) {
                                addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9,
                                                8 + j * 18, 99 + i * 18));
                        }
                }

                for (int i = 0; i < 9; i++) {
                        addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 157));
                }
        }

        @Override
        public ItemStack transferStackInSlot(EntityPlayer player, int slot) {
                ItemStack stack = null;
                Slot slotObject = (Slot) inventorySlots.get(slot);
                if (slotObject != null && slotObject.getHasStack()) {
                        ItemStack stackInSlot = slotObject.getStack();
                        stack = stackInSlot.copy();
                        if (slot < 9) {
                                if (!this.mergeItemStack(stackInSlot, 0, 35, true)) {
                                        return null;
                                }
                        }
                        else if (!this.mergeItemStack(stackInSlot, 0, 9, false)) {
                                return null;
                        }

                        if (stackInSlot.stackSize == 0) {
                                slotObject.putStack(null);
                        } else {
                                slotObject.onSlotChanged();
                        }

                        if (stackInSlot.stackSize == stack.stackSize) {
                                return null;
                        }
                        slotObject.onPickupFromSlot(player, stackInSlot);
                }
                return stack;
        }
        
    	public void addCraftingToCrafters(ICrafting crafting){
    		super.addCraftingToCrafters(crafting);
    	    crafting.sendProgressBarUpdate(this, 0, this.tileEntity.progress);
    	}
    	
    	public void detectAndSendChanges(){
    		super.detectAndSendChanges();
    		for (int i = 0; i < this.crafters.size(); ++i){
    			ICrafting icrafting = (ICrafting)this.crafters.get(i);
    			if (this.progress != this.tileEntity.progress){
    				icrafting.sendProgressBarUpdate(this, 0, this.tileEntity.progress);
    	        }
    	    }
    	    this.progress = this.tileEntity.progress;
    	}
    	
    	@SideOnly(Side.CLIENT)
    	public void updateProgressBar(int par1, int par2){
    		if (par1 == 0){
    			this.tileEntity.progress = par2;
    	    }
    	}
    	
}