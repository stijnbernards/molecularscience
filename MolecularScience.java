package molecularscience;

import molecularscience.api.GuiHandler;
import molecularscience.api.MSEventHandler;
import molecularscience.electrolyzer.BlockElectrolyzer;
import molecularscience.electrolyzer.ElectrolyzerResults;
import molecularscience.electrolyzer.TileEntityElectrolyzer;
import molecularscience.moditems.BlocksItems;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = MolecularScience.MODID, version = MolecularScience.VERSION)
public class MolecularScience {
	
	//versie en id
    public static final String MODID = "MolecularScience";
    public static final String VERSION = "1.0.0";
    
    public static Block blockTiny;
    
	@Instance(value = "MolecularScience")
	public static MolecularScience instance;
	
	@SidedProxy(clientSide="molecularscience.ClientProxy", serverSide="molecularscience.CommonProxy")
	public static CommonProxy proxy;
	
	//creative tab
	public static CreativeTabs Molecules = new CreativeTabs("Molecules"){
		public Item getTabIconItem(){
			return Items.arrow;
		}
	};
	public static CreativeTabs MBlocks = new CreativeTabs("MBlocks"){
		public Item getTabIconItem(){
			return Items.apple;
		}
	};
	public static CreativeTabs MItems = new CreativeTabs("MItems"){
		public Item getTabIconItem(){
			return Items.apple;
		}
	};
	
    public static DamageSource HeatConductant = new DamageSource("HeatConductant");
	
	@EventHandler
	public void load(FMLInitializationEvent event){
		MinecraftForge.EVENT_BUS.register(new MSEventHandler());
	}
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
        blockTiny = new BlockElectrolyzer();
        GameRegistry.registerBlock(blockTiny, "blockTiny");
		BlocksItems.InitItems();
		BlocksItems.InitBlocks();
		BlocksItems.WorldGen();
		Config.InitRecipes();
		Config.registerMolecules();
		Config.registerSamples();
		Config.registerMineralProps();
		Config.registerTileEntity();
        proxy.registerRenderers();
        NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
        ElectrolyzerResults.initResult();
	}
	
	@EventHandler
	public void init(FMLPostInitializationEvent event) {}
}
