package molecularscience.blocks;

import molecularscience.MolecularScience;
import molecularscience.RegisterBlocksItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class BlockGrinder extends Block{

	public BlockGrinder(Material material) {
		super(material);
		this.setCreativeTab(MolecularScience.MBlocks);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.99F, 1.0F);
	}
	
    public void onEntityCollidedWithBlock(World p_149670_1_, int p_149670_2_, int p_149670_3_, int p_149670_4_, Entity p_149670_5_)
    {
    	if(!p_149670_1_.isRemote){
    		String entity = p_149670_5_.toString();
    		p_149670_1_.removeEntity(p_149670_5_);;
    		if(entity.contains("item.tile.ChalcopyrietOre")){
    			Grind(p_149670_5_, p_149670_1_, p_149670_2_, p_149670_3_, p_149670_4_);
    		}
    	}
    }
    
    public void Grind(Entity entity, World world, int x, int y, int z){
    	Item drop = RegisterBlocksItems.Chalcopyrietdust;
    	 EntityItem entityItem = new EntityItem(world,
                 x, y, z,
                 new ItemStack(drop, 1));
    	 world.spawnEntityInWorld(entityItem);
    }
}