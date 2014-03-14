package molecularscience.moditems;

import java.util.Random;

import molecularscience.MolecularScience;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockSteam extends BlockContainer{

	public BlockSteam(Material material) {
		super(material);
		this.setCreativeTab(MolecularScience.MBlocks);
	}
	
	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntitySteam();
	}
	
    public void updateTick(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random rand){
		int rand1 = rand.nextInt(2);
		int rand2 = rand.nextInt(2);
		int rand3 = rand.nextInt(2);
		int rand4 = rand.nextInt(2);
		int rand5 = rand.nextInt(2);
		int rand6 = rand.nextInt(2);
		if(p_149674_1_.getBlock(p_149674_2_+rand1-rand6, p_149674_3_+rand2-rand5, p_149674_4_+rand3-rand4).getLocalizedName().contains("air")){
			p_149674_1_.setBlockToAir(p_149674_2_, p_149674_3_, p_149674_4_);
			p_149674_1_.setBlock(p_149674_2_+rand1-rand6, p_149674_3_+rand2-rand5, p_149674_4_+rand3-rand4, this);
		}
		if(p_149674_1_.getBlock(p_149674_2_+rand1-rand6, p_149674_3_+rand2-rand5, p_149674_4_+rand3-rand4).getLocalizedName().contains("Water")){
			p_149674_1_.setBlockToAir(p_149674_2_, p_149674_3_, p_149674_4_);
			p_149674_1_.setBlock(p_149674_2_+rand1-rand6, p_149674_3_+rand2-rand5, p_149674_4_+rand3-rand4, this);
		}
    }
}
