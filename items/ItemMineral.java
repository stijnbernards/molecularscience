package molecularscience.items;

import java.util.List;

import molecularscience.MolecularScience;
import molecularscience.api.ExtendedPlayer;
import molecularscience.api.MolecularApi;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemMineral extends Item{
	
    public ItemMineral()
    {
        super();
        this.setHasSubtypes(true);
        this.setCreativeTab(MolecularScience.MItems);
    }
 
    @SideOnly(Side.CLIENT)
    private IIcon[] icons;
 
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister par1IconRegister)
    {
        icons = new IIcon[12];
 
        for (int i = 0; i < icons.length; i++)
        {
           icons[i] = par1IconRegister.registerIcon("molecularscience:" + (this.getUnlocalizedName().substring(5)) + i);
        }
    }
    
    public static final String[] names = new String[] { "Sylvite", "Halite", "Carnallite", "Langbeinite", "PolyHalite", "Kainite", "Anhydrite", "Gypsum", "Kieserite", "Dolomite", "Calcite", "Magnesite" };
 
    @Override
    public String getUnlocalizedName(ItemStack par1ItemStack)
    {
        int i = MathHelper.clamp_int(par1ItemStack.getItemDamage(), 0, 15);
        return super.getUnlocalizedName() + "." + names[i];
    }
 
    @Override
    public IIcon getIconFromDamage(int par1)
    {
        return icons[par1];
    }
 
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        for (int x = 0; x < 12; x++)
        {
            par3List.add(new ItemStack(this, 1, x));
        }
    }
    
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		
		String Itemname = par1ItemStack.getDisplayName();
		
		Object Itemmolecule = null;
		String moleculesinitem = null;
		
		if(MolecularApi.Blockmolecules.get(Itemname) != null){
			Itemmolecule = MolecularApi.Blockmolecules.get(Itemname);
			moleculesinitem = Itemmolecule.toString();
		}
		
		String name = par1ItemStack.getUnlocalizedName();
		Object properties = MolecularApi.MineralProperties.get(name);
		String propertiess = properties.toString();
		String[] props = propertiess.split(",");
		
		switch(ExtendedPlayer.getmineralresearchphase(name)){
		case 1:
			par3List.add("Color: "+props[0]+".");
			break;
		case 2:
			par3List.add("Color: "+props[0]+".");
			par3List.add("Fracture: "+props[1]+".");
			break;
		case 3:
			par3List.add("Color: "+props[0]+".");
			par3List.add("Fracture: "+props[1]+".");
			par3List.add("Tentacity: "+props[2]+".");
			break;
		case 4:
			par3List.add("Color: "+props[0]+".");
			par3List.add("Fracture: "+props[1]+".");
			par3List.add("Tentacity: "+props[2]+".");
			par3List.add("Luster: "+props[3]+".");
			break;
		case 5:
			par3List.add("Color: "+props[0]+".");
			par3List.add("Fracture: "+props[1]+".");
			par3List.add("Tentacity: "+props[2]+".");
			par3List.add("Luster: "+props[3]+".");
			par3List.add("Streak: "+props[4]+".");
			break;
		}
		
		if(ExtendedPlayer.IsResearched(Itemname)){
			if(MolecularApi.Blockmolecules.get(Itemname) != null){
				par3List.add( "This Sample consists of: " + Itemmolecule );
				if(moleculesinitem.contains(",")){
					String[] splitmolecule = moleculesinitem.split(",");
					for( int i = 0; i <= splitmolecule.length - 1; i++){
						par3List.add(MolecularApi.Moleculesatoms.get(splitmolecule[i]));
					}
				}else{
					par3List.add(MolecularApi.Moleculesatoms.get(Itemmolecule));
				}
			}
		}else{
			par3List.add("You have not yet researched this mineral");
		}
	}
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
		String Itemname = par1ItemStack.getUnlocalizedName();
		ExtendedPlayer.mineralResearch(Itemname);
		return false;
    }
}
