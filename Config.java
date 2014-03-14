package molecularscience;

import molecularscience.api.MolecularApi;
import molecularscience.electrolyzer.TileEntityElectrolyzer;
import molecularscience.moditems.TileEntityHeatConductant;
import molecularscience.moditems.TileEntityOil;
import molecularscience.moditems.TileEntitySteam;
import cpw.mods.fml.common.registry.GameRegistry;

public class Config {
	
	public static void registerSamples(){
		MolecularApi.addBlockMolecule("dirt", "Silicon Oxide");
		MolecularApi.addBlockMolecule("sand", "Silicon Oxide");
		MolecularApi.addBlockMolecule("Wood", "Cellulose");
		MolecularApi.addBlockMolecule("Coal Ore", "Carbon");
		MolecularApi.addBlockMolecule("Air", "Oxygen,Water,CarbonDiOxide,Nitrogen");
		MolecularApi.addBlockMolecule("Sylvite", "PotassiumChloride");
		MolecularApi.addBlockMolecule("Halite", "NatriumChloride");
		MolecularApi.addBlockMolecule("Carnallite", "PotassiumChloride,MagnesiumChloride,Water");
		MolecularApi.addBlockMolecule("Langbeinite", "Potassium,Magnesium,Sulfate");
		MolecularApi.addBlockMolecule("Polyhalite", "Potassium,Calcium,MagnesiumSulfate,Water");
		MolecularApi.addBlockMolecule("Kainite", "Potassium,MagnesiumSulfate,Chlorine,Water");
		MolecularApi.addBlockMolecule("Anhydrite", "Calcium,Sulfate");
		MolecularApi.addBlockMolecule("Gypsum", "Calcium,Sulfate,Water");
		MolecularApi.addBlockMolecule("Kieserite", "MagnesiumSulfate,Water");
		MolecularApi.addBlockMolecule("Dolomite", "Calcium,Magnesium,CarbonTriOxide");
		MolecularApi.addBlockMolecule("Calcite", "Calcium Carbonate");
		MolecularApi.addBlockMolecule("Magnesite", "Magnesium Carbonate");
	}
	
	public static void registerMolecules(){
		MolecularApi.addMolecules("Water", "H2O");
		MolecularApi.addMolecules("Oxygen", "O2");
		MolecularApi.addMolecules("Silicon Oxide", "SiO2");
		MolecularApi.addMolecules("Cellulose", "C6H10O5");
		MolecularApi.addMolecules("Carbon", "C");
		MolecularApi.addMolecules("Oxygen", "O2");
		MolecularApi.addMolecules("CarbonDiOxide", "CO2");
		MolecularApi.addMolecules("Nitrogen", "N2");
		MolecularApi.addMolecules("PotassiumChloride", "KCl");
		MolecularApi.addMolecules("NatriumChloride", "NaCl");
		MolecularApi.addMolecules("MagnesiumChloride", "MgCl2");
		MolecularApi.addMolecules("Potassium", "K2");
		MolecularApi.addMolecules("Magnesium", "Mg2");
		MolecularApi.addMolecules("Sulfate", "(SO4)²¯");
		MolecularApi.addMolecules("Calcium", "Ca2");
		MolecularApi.addMolecules("MagnesiumSulfate", "MgSO4");
		MolecularApi.addMolecules("Chlorine", "Cl");
		MolecularApi.addMolecules("CarbonTriOxide", "CO3");
		MolecularApi.addMolecules("Calcium Carbonate", "CaCO3");
		MolecularApi.addMolecules("Magnesium Carbonate", "MgCO3");
	}
	
	public static void registerAtoms(){
		MolecularApi.addAtoms("Hydrogen", "H");
		MolecularApi.addAtoms("Oxygen", "O");
		MolecularApi.addAtoms("Silicon", "Si");
		MolecularApi.addAtoms("Carbon", "C");
		MolecularApi.addAtoms("Nitrogen", "N");
	}
	
	public static void registerMineralProps(){
		MolecularApi.addMineralProperties("item.Mineral.Sylvite", "Light Colored", "Uneven", "Brittle to ductile", "Vitreous", "White", "Sylvite");
		MolecularApi.addMineralProperties("item.Mineral.Halite", "Colorless", "Conchoidal", "Brittle", "Vitreous", "White", "Halite");
		MolecularApi.addMineralProperties("item.Mineral.Carnallite", "Yellow/White", "Conchoidal", "-", "Greasy", "White", "Carnallite");
		MolecularApi.addMineralProperties("item.Mineral.Langbeinite", "White with pale tints of yellow to green", "Conchoidal", "Brittle", "Vitreous", "White", "Langbeinite");
		MolecularApi.addMineralProperties("item.Mineral.PolyHalite", "White/Gray", "Conchoidal", "Brittle", "Vitreous to Resinous", "White", "Polyhalite");
		MolecularApi.addMineralProperties("item.Mineral.Kainite", "Brownish", "Splintery", "-", "Vitreous", "White", "Kainite");
		MolecularApi.addMineralProperties("item.Mineral.Anhydrite", "Colorless to pale blue in pure form", "Conchoidal", "Brittle", "Vitreous to Greasy", "White", "Anhydrite");
		MolecularApi.addMineralProperties("item.Mineral.Gypsum", "Colorless to white in pure form", "Conchoidal", "Flexible, Inelestic", "Vitreous to Silky", "White", "Gypsum");
		MolecularApi.addMineralProperties("item.Mineral.Kieserite", "Colorless Grayish-white or Yellowish", "Uneven", "Fragile", "Vitreous to Dull", "White", "Kieserite");
		MolecularApi.addMineralProperties("item.Mineral.Dolomite", "White  Gray to Pink", "Conchoidal", "Brittle", "Vitreous to Pearly", "White", "Dolomite");
		MolecularApi.addMineralProperties("item.Mineral.Calcite", "Colorless", "Conchoidal", "Brittle", "Vitreous to Pearly", "White", "Calcite");
		MolecularApi.addMineralProperties("item.Mineral.Magnesite", "Pale Yellow", "Conchoidal", "Brittle", "Vitreous", "White", "Magnesite");
	}
	
	public static void InitRecipes(){

	}
	
	public static void registerTileEntity(){
		GameRegistry.registerTileEntity(TileEntityHeatConductant.class, "molecularscience.heatconductant");
		GameRegistry.registerTileEntity(TileEntitySteam.class, "molecularscience.steam");
		GameRegistry.registerTileEntity(TileEntityElectrolyzer.class, "molecularscience.electrolyzer");
		GameRegistry.registerTileEntity(TileEntityOil.class, "molecularscience.oil");
	}
}
