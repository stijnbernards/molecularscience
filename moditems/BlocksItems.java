package molecularscience.moditems;

import molecularscience.MolecularScience;
import molecularscience.worldgen.WorldGen;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlocksItems {
	//items
	public static Item Emptyjar;
	public static Item Sample;
	public static Item Mineral;
	
	//blocks
	public static Block OrePlutonium;
	public static Block Evaporite;
	public static Block BlockHeatConductant;
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
        Evaporite = new BlockEvaporite(Material.rock).setHardness(3.0F).setBlockName("Evaporite");
        BlockHeatConductant = new BlockHeatConductant(Material.rock).setHardness(3.0F).setBlockName("BlockHeatConductant");
//        ResearchTableIdle = new ResearchTable(false).setBlockName("ResearchTableIdle").setCreativeTab(MolecularScience.Blocks);
//        ResearchTableActive = new ResearchTable(true).setBlockName("ResearchTableActive");
        
        GameRegistry.registerBlock(OrePlutonium, "Plutoniumore");
        GameRegistry.registerBlock(Evaporite, "Evaporite");
        GameRegistry.registerBlock(BlockHeatConductant, "BlockHeatConductant");
//        GameRegistry.registerBlock(ResearchTableIdle, "ResearchTableIdle");
//        GameRegistry.registerBlock(ResearchTableActive, "ResearchTableActive");
	}
}
