package molecularscience.machines.electrolyzer;

import java.util.HashMap;
import java.util.Map;

import scala.annotation.meta.field;
import molecularscience.RegisterBlocksItems;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ElectrolyzerResults {

	private static Map<Integer, Object[]> results = new HashMap<Integer, Object[]>();
	
	public static void initResult(){
		addResult(0, 0, RegisterBlocksItems.Emptyjar.getUnlocalizedName(), 1, RegisterBlocksItems.Sample, 1);
	}
	public static ItemStack getResult(int slot, Item type){
		for(int i = 0; i < results.size(); i++){
			if((int)results.get(i)[0] == slot){
				if(results.get(i)[1].equals(type.getUnlocalizedName())){
					return new ItemStack((Item) results.get(i)[3], 1);
				}
			}
		}
		return null;
	}
	
	public static int getMaxTime(int slot, Item type){
		return 50;
	}
	
	public static int getReduceItem(int slot, Item type){
		for(int i = 0; i < results.size(); i++){
			if((int)results.get(i)[0] == slot){
				if(results.get(i)[1].equals(type.getUnlocalizedName())){
					return (int)results.get(i)[2];
				}
			}
		}
		return 1;
	}

	private static void addResult(int id, int slot, String string, int ammount, Item sample, int size){
		results.put(id, new Object[]{slot, string, ammount, sample, size});
	}
}
