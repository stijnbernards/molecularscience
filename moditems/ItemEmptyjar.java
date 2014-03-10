package molecularscience.moditems;

import molecularscience.api.MolecularApi;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
 
public class ItemEmptyjar extends Item
{	
    public ItemEmptyjar()
    {
        super();
    }
    
	@Override
	public int getItemEnchantability() {
		return 1;
	}
	
	@Override
	public String getItemStackDisplayName(ItemStack par1ItemStack) {
		return super.getItemStackDisplayName(par1ItemStack);
	}
	
	public void writeToNBT(NBTTagCompound nbt, String block, String research)
	{
	    nbt.setString(block, research);
	}
	
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
    	Block block = par3World.getBlock(par4, par5, par6);
    	String name = block.getLocalizedName();
    	ItemStack sample = new ItemStack(BlocksItems.Sample, 1);
    	
    	if(name.contains(".")){
    		String[] naam = name.split("\\.");
    		if(MolecularApi.Blockmolecules.get(naam[1]) == null)
    			return false;
    		String upper = naam[1].substring(0, 1).toUpperCase() + naam[1].substring(1);
        	sample.setStackDisplayName(upper + " Sample");
    	}else{
    		if(MolecularApi.Blockmolecules.get(name) == null)
    			return false;
    		String upper = name.substring(0, 1).toUpperCase() + name.substring(1);
        	sample.setStackDisplayName(upper + " Sample");
    	}

    	if(sample.stackTagCompound.getString("Researched") == "yes")
        	sample.stackTagCompound.setString("Researched", "yes");

    	par2EntityPlayer.inventory.consumeInventoryItem(BlocksItems.Emptyjar);
    	par2EntityPlayer.inventory.addItemStackToInventory(sample);
		return false;
    }
}