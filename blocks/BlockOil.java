package molecularscience.blocks;

import java.util.Random;

import molecularscience.MolecularScience;
import molecularscience.tileentity.TileEntityOil;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockOil extends BlockContainer{

	public BlockOil(Material material) {
		super(material);
		this.setCreativeTab(MolecularScience.MBlocks);
	}
	
	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntityOil();
	}
	
    public void updateTick(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random rand){
		int rand1 = rand.nextInt(2);
		int rand2 = rand.nextInt(2);
		int rand3 = rand.nextInt(2);
		int rand4 = rand.nextInt(2);
		int rand5 = rand.nextInt(2);
		int rand6 = rand.nextInt(2);
		if(p_149674_1_.getBlock(p_149674_2_+rand1-rand6, p_149674_3_-rand5, p_149674_4_+rand3-rand4).getLocalizedName().contains("air") || p_149674_1_.getBlock(p_149674_2_+rand1-rand6, p_149674_3_+rand2-rand5, p_149674_4_+rand3-rand4).getLocalizedName().contains("water")){
			p_149674_1_.setBlockToAir(p_149674_2_, p_149674_3_, p_149674_4_);
			if(p_149674_1_.getBlock(p_149674_2_, p_149674_3_-1, p_149674_4_).getLocalizedName().contains("air")){
				p_149674_1_.setBlock(p_149674_2_, p_149674_3_-1, p_149674_4_, this);
			}else{
				p_149674_1_.setBlock(p_149674_2_+rand1-rand6, p_149674_3_-rand5, p_149674_4_+rand3-rand4, this);
			}
		}
    }
}
