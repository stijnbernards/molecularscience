package molecularscience.api;

import java.util.List;

import molecularscience.RegisterBlocksItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class MSEventHandler {

	@SubscribeEvent
	public void onEntityConstructing(EntityConstructing event)
	{
		if (event.entity instanceof EntityPlayer && ExtendedPlayer.get((EntityPlayer) event.entity) == null)
			ExtendedPlayer.register((EntityPlayer) event.entity);
		
		if (event.entity instanceof EntityPlayer && event.entity.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME) == null)
			event.entity.registerExtendedProperties(ExtendedPlayer.EXT_PROP_NAME, new ExtendedPlayer((EntityPlayer) event.entity));
	}
	
	@SubscribeEvent
	public void ontooltip(ItemTooltipEvent event){
		String Itemname = event.itemStack.getDisplayName();
		
		MolecularApi.itemAddInfo(event.toolTip, Itemname);
		
		if(event.itemStack.getItem() == RegisterBlocksItems.Mineral){
			switch(event.itemStack.getItemDamage()){
			case 0:
				MolecularApi.itemToolTip(event.toolTip, "Sylvite","item.Mineral.Sylvite");
				break;
			case 1:
				MolecularApi.itemToolTip(event.toolTip, "Halite","item.Mineral.Halite");
				break;
			case 2:
				MolecularApi.itemToolTip(event.toolTip, "Carnallite","item.Mineral.Carnallite");
				break;
			case 3:
				MolecularApi.itemToolTip(event.toolTip, "Langbeinite","item.Mineral.Langbeinite");
				break;
			case 4:
				MolecularApi.itemToolTip(event.toolTip, "PolyHalite","item.Mineral.PolyHalite");
				break;
			case 5:
				MolecularApi.itemToolTip(event.toolTip, "Kainite","item.Mineral.Kainite");
				break;
			case 6:
				MolecularApi.itemToolTip(event.toolTip, "Anhydrite","item.Mineral.Anhydrite");
				break;
			case 7:
				MolecularApi.itemToolTip(event.toolTip, "Gypsum","item.Mineral.Gypsum");
				break;
			case 8:
				MolecularApi.itemToolTip(event.toolTip, "Kieserite","item.Mineral.Kieserite");
				break;
			case 9:
				MolecularApi.itemToolTip(event.toolTip, "Dolomite","item.Mineral.Dolomite");
				break;
			case 10:
				MolecularApi.itemToolTip(event.toolTip, "Calcite","item.Mineral.Calcite");
				break;
			case 11:
				MolecularApi.itemToolTip(event.toolTip, "Magnesite","item.Mineral.Magnesite");
				break;
			}
		}
	}
}
