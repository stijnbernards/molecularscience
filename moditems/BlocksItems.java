package molecularscience.moditems;

import molecularscience.MolecularScience;
import molecularscience.worldgen.WorldGen;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.Potion;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlocksItems {
	//items
	public static Item Emptyjar;
	public static Item Sample;
	public static Item Mineral;
	
	//blocks
	public static Block OrePlutonium;
	public static Block Evaporite;
	public static Block BlockSlowHeatConductant;
	public static Block BlockMediumHeatConductant;
	public static Block BlockFastHeatConductant;
	public static Block ChalcopyrietOre;
	public static Block Insulator;
//	public static Block ResearchTableIdle;
//	public static Block ResearchTableActive;
	
	public static void WorldGen(){
		GameRegistry.registerWorldGenerator(new WorldGen(), 1);
		
	}
	
	public static void InitItems(){
		Emptyjar = new ItemEmptyjar().setUnlocalizedName("Emptyjar").setCreativeTab(MolecularScience.MItems);
        Sample = new ItemSample().setUnlocalizedName("sample");
        Mineral = new ItemMineral().setUnlocalizedName("Mineral");
        
        GameRegistry.registerItem(Emptyjar,"Emptyjar");
        GameRegistry.registerItem(Sample,"Sample");
        GameRegistry.registerItem(Mineral,"Mineral");
	}
	
	public static void InitBlocks(){
        OrePlutonium = new BlockOre(Material.rock, 2).setHardness(3.0F).setBlockName("Plutoniumore");
        Insulator = new BlockInsulator(Material.rock).setHardness(3.0F).setBlockName("Insulator");
        Evaporite = new BlockEvaporite(Material.rock).setHardness(3.0F).setBlockName("Evaporite");
        ChalcopyrietOre = new BlockOre(Material.rock,2).setHardness(3.0F).setBlockName("ChalcopyrietOre");
        BlockSlowHeatConductant = new BlockHeatConductant(Material.rock, 50).setHardness(3.0F).setBlockName("BlockSlowHeatConductant");
        BlockMediumHeatConductant = new BlockHeatConductant(Material.rock, 25).setHardness(3.0F).setBlockName("BlockMediumHeatConductant");
        BlockFastHeatConductant = new BlockHeatConductant(Material.rock, 5).setHardness(3.0F).setBlockName("BlockFastHeatConductant");
//        ResearchTableIdle = new ResearchTable(false).setBlockName("ResearchTableIdle").setCreativeTab(MolecularScience.Blocks);
//        ResearchTableActive = new ResearchTable(true).setBlockName("ResearchTableActive");
        
        GameRegistry.registerBlock(OrePlutonium, "Plutoniumore");
        GameRegistry.registerBlock(Insulator, "Insulator");
        GameRegistry.registerBlock(Evaporite, "Evaporite");
        GameRegistry.registerBlock(ChalcopyrietOre, "ChalcopyrietOre");
        GameRegistry.registerBlock(BlockSlowHeatConductant, "BlockSlowHeatConductant");
        GameRegistry.registerBlock(BlockMediumHeatConductant, "BlockMediumHeatConductant");
        GameRegistry.registerBlock(BlockFastHeatConductant, "BlockFastHeatConductant");
//        GameRegistry.registerBlock(ResearchTableIdle, "ResearchTableIdle");
//        GameRegistry.registerBlock(ResearchTableActive, "ResearchTableActive");
	}
}
