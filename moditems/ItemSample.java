package molecularscience.moditems;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import molecularscience.Config;
import molecularscience.MolecularScience;
import molecularscience.api.ExtendedPlayer;
import molecularscience.api.MolecularApi;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;


public class ItemSample extends Item {
	
    public ItemSample()
    {
        super();
        this.setHasSubtypes(true);
        this.setCreativeTab(MolecularScience.Molecules);
    }
    
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		
		String Itemname = par1ItemStack.getDisplayName();
		Itemname = StringUtils.removeEnd(Itemname, " Sample");
		
		Object Itemmolecule = null;
		String moleculesinitem = null;
		
		if(MolecularApi.Blockmolecules.get(Itemname) != null){
			Itemmolecule = MolecularApi.Blockmolecules.get(Itemname);
			moleculesinitem = Itemmolecule.toString();
		}
		
		if(ExtendedPlayer.IsResearched(Itemname)){
			if(MolecularApi.Blockmolecules.get(Itemname) != null){
				par3List.add( "This Sample consists of: " + Itemmolecule );
				if(moleculesinitem.contains(",")){
					String[] splitmolecule = moleculesinitem.split(",");
					for( int i = 0; i <= splitmolecule.length - 1; i++){
						par3List.add(MolecularApi.Moleculesatoms.get(splitmolecule[i]));
					}
				}else{
					par3List.add(MolecularApi.Moleculesatoms.get(Itemmolecule));
				}
			}
		}else{
			par3List.add("You have not yet researched this sample");
		}
	}
}
