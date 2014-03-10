package molecularscience.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import net.minecraft.item.ItemStack;

public class MolecularApi {
	
	public static Map MineralProperties = new HashMap();
	public static Map<String, String> Blockmolecules = new TreeMap<String, String>(String.CASE_INSENSITIVE_ORDER);
	public static Map Moleculesatoms = new HashMap();
	public static Map atoms = new HashMap();
	
	public static void addBlockMolecule(String sample, String molecule){
		Blockmolecules.put(sample, molecule);
	}
	
	public static void addMolecules( String molecule, String atoms){
		Moleculesatoms.put(molecule, atoms);
	}
	
	public static void addAtoms( String atomname, String atom){
		atoms.put(atomname, atom);
	}
	public static void addMineralProperties( String Mineral, String Color, String Fracture, String Tentacity , String Luster, String Streak, String name){
		MineralProperties.put(Mineral, Color+","+Fracture+","+Tentacity+","+Luster+","+Streak+","+name);
	}
	
	public static void itemToolTip(List<String> tooltip, String name, String unloc){
		if(ExtendedPlayer.getmineralresearchphase(unloc) == 6)
			tooltip.set(0, name);
	}
	
	public static void itemAddInfo(List<String> tooltip, String name){
		if(ExtendedPlayer.IsResearched(name)){
			String info = "This block consists of: " + Blockmolecules.get(name);
			tooltip.add(1, info);
		}
	}
}
