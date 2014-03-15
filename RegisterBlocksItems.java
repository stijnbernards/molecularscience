package molecularscience;

import molecularscience.blocks.BlockEvaporite;
import molecularscience.blocks.BlockGrinder;
import molecularscience.blocks.BlockHeatConductant;
import molecularscience.blocks.BlockInsulator;
import molecularscience.blocks.BlockOil;
import molecularscience.blocks.BlockOre;
import molecularscience.blocks.BlockSlag;
import molecularscience.blocks.BlockSteam;
import molecularscience.blocks.BlockWaterValve;
import molecularscience.items.ItemEmptyjar;
import molecularscience.items.ItemMineral;
import molecularscience.items.ItemSample;
import molecularscience.machines.research.BlockResearchTable;
import molecularscience.worldgen.WorldGen;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;

public class RegisterBlocksItems {
	//items
	public static Item Emptyjar;
	public static Item Sample;
	public static Item Mineral;
	public static Item Chalcopyrietdust;
	public static Item Copperdust;
	
	//blocks
	public static Block OrePlutonium;
	public static Block Evaporite;
	public static Block BlockSlowHeatConductant;
	public static Block BlockMediumHeatConductant;
	public static Block BlockFastHeatConductant;
	public static Block ChalcopyrietOre;
	public static Block Insulator;
	public static Block PineSteam;
	public static Block PineOil;
	public static Block WaterValve;
	public static Block ResearchTable;
	public static Block Grinder;
	public static Block BlockSlag;
	
	public static void WorldGen(){
		GameRegistry.registerWorldGenerator(new WorldGen(), 1);
		
	}
	
	public static void InitItems(){
		Emptyjar = new ItemEmptyjar().setUnlocalizedName("Emptyjar").setCreativeTab(MolecularScience.MItems);
		Copperdust = new Item().setUnlocalizedName("Copperdust").setCreativeTab(MolecularScience.MItems);
		Chalcopyrietdust = new Item().setUnlocalizedName("Chalcopyrietdust").setCreativeTab(MolecularScience.MItems);
        Sample = new ItemSample().setUnlocalizedName("sample");
        Mineral = new ItemMineral().setUnlocalizedName("Mineral");
        
        GameRegistry.registerItem(Copperdust,"Copperdust");
        GameRegistry.registerItem(Chalcopyrietdust,"Chalcopyrietdust");
        GameRegistry.registerItem(Emptyjar,"Emptyjar");
        GameRegistry.registerItem(Sample,"Sample");
        GameRegistry.registerItem(Mineral,"Mineral");
	}
	
	public static void InitBlocks(){
        OrePlutonium = new BlockOre(Material.rock, 2).setHardness(3.0F).setBlockName("Plutoniumore");
        BlockSlag = new BlockSlag(Material.rock).setHardness(3.0F).setBlockName("BlockSlag");
        Grinder = new BlockGrinder(Material.rock).setHardness(3.0F).setBlockName("Grinder");
        WaterValve = new BlockWaterValve().setHardness(3.0F).setBlockName("WaterValve");
        PineSteam = new BlockSteam(Material.rock).setHardness(3.0F).setBlockName("PineSteam");
        PineOil = new BlockOil(Material.rock).setHardness(3.0F).setBlockName("PineOil");
        Insulator = new BlockInsulator(Material.rock).setHardness(3.0F).setBlockName("Insulator");
        Evaporite = new BlockEvaporite(Material.rock).setHardness(3.0F).setBlockName("Evaporite");
        ChalcopyrietOre = new BlockOre(Material.rock,2).setHardness(3.0F).setBlockName("ChalcopyrietOre");
        BlockSlowHeatConductant = new BlockHeatConductant(Material.rock, 50).setHardness(3.0F).setBlockName("BlockSlowHeatConductant");
        BlockMediumHeatConductant = new BlockHeatConductant(Material.rock, 25).setHardness(3.0F).setBlockName("BlockMediumHeatConductant");
        BlockFastHeatConductant = new BlockHeatConductant(Material.rock, 5).setHardness(3.0F).setBlockName("BlockFastHeatConductant");
        ResearchTable = new BlockResearchTable().setBlockName("ResearchTable").setCreativeTab(MolecularScience.MBlocks);
        
        GameRegistry.registerBlock(BlockSlag, "BlockSlag");
        GameRegistry.registerBlock(WaterValve, "WaterValve");
        GameRegistry.registerBlock(Grinder, "Grinder");
        GameRegistry.registerBlock(OrePlutonium, "Plutoniumore");
        GameRegistry.registerBlock(PineOil, "PineOil");
        GameRegistry.registerBlock(PineSteam, "PineSteam");
        GameRegistry.registerBlock(Insulator, "Insulator");
        GameRegistry.registerBlock(Evaporite, "Evaporite");
        GameRegistry.registerBlock(BlockFastHeatConductant, "BlockFastHeatConductant");
        GameRegistry.registerBlock(ChalcopyrietOre, "ChalcopyrietOre");
        GameRegistry.registerBlock(BlockSlowHeatConductant, "BlockSlowHeatConductant");
        GameRegistry.registerBlock(BlockMediumHeatConductant, "BlockMediumHeatConductant");
        GameRegistry.registerBlock(ResearchTable, "ResearchTable");
	}
}
