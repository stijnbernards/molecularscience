package molecularscience.electrolyzer;

import java.util.HashMap;
import java.util.Map;

import molecularscience.moditems.BlocksItems;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ElectrolyzerResults {

	private static Map<Integer, Object[]> results = new HashMap<Integer, Object[]>();
	
	public static void initResult(){
		addResult(0, 0, BlocksItems.Emptyjar, 1, BlocksItems.Sample, 1);
	}
	public static ItemStack getResult(int slot, Item type){
		for(int i = 0; i < results.size(); i++){
			if((int)results.get(i)[0] == slot){
				if(results.get(i)[1] == type){
					return new ItemStack((Item) results.get(i)[4], 1);
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
				if(results.get(i)[1] == type){
					return (int)results.get(i)[2];
				}
			}
		}
		return 1;
	}

	private static void addResult(int id, int slot, Item type, int ammount, Item result, int size){
		results.put(id, new Object[]{slot, type, ammount, result, size});
	}
}
