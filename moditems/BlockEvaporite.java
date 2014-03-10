package molecularscience.moditems;

import java.util.ArrayList;
import java.util.Random;

import molecularscience.MolecularScience;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockEvaporite extends Block{
	
	public BlockEvaporite(Material material) {
		super(material);
		this.setCreativeTab(MolecularScience.MBlocks);
		this.setHarvestLevel("pickaxe", 1);
	}
	
	@Override
	public int quantityDropped(Random par1Random){
		Random rand = new Random();
		return rand.nextInt(3);
	}
	
    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return BlocksItems.Mineral;
    }
	
    public int damageDropped(int p_149692_1_){
		Random rand = new Random();
		return rand.nextInt(11);
	}
}
