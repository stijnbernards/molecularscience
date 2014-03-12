package molecularscience.api;

import java.util.HashMap;
import java.util.List;

import scala.tools.nsc.doc.model.Constructor;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.ShapedRecipes;

public class MolecularCraftingHandler {
	
	public static void test(){
		CraftingManager.getInstance().getRecipeList().clear();
	}
}
