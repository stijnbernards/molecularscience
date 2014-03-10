package molecularscience.moditems;

import java.util.Random;

import molecularscience.MolecularScience;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockHeatConductant extends BlockContainer{
	
	int color = 0x000000;
	
	public BlockHeatConductant(Material material) {
		super(material);
		this.setCreativeTab(MolecularScience.MBlocks);
		this.setBlockTextureName("molecularscience:BlockHeatConductant");
	}
	
    @SideOnly(Side.CLIENT)
    public int getBlockColor()
    {
        return 0x000000;
    }

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntityHeatConductant(this);
	}
	
    public void updateTick(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_)
    {
    	TileEntityHeatConductant tile = (TileEntityHeatConductant) p_149674_1_.getTileEntity(p_149674_2_, p_149674_3_, p_149674_4_);
    	if (tile != null)
    	{
    		color = (int) tile.Temperature;
    	}
    }
	
    @SideOnly(Side.CLIENT)
    public int colorMultiplier(IBlockAccess p_149720_1_, int p_149720_2_, int p_149720_3_, int p_149720_4_)
    {
        return color;
    }
}
