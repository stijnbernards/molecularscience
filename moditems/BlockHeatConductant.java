package molecularscience.moditems;

import java.util.List;
import java.util.Random;

import molecularscience.MolecularScience;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockHeatConductant extends BlockContainer{
	
	int conductiveness = 0;
	
	public BlockHeatConductant(Material material, int conduct) {
		super(material);
		this.setCreativeTab(MolecularScience.MBlocks);
		this.setBlockTextureName("molecularscience:BlockHeatConductant");
		this.conductiveness = conduct;
	}
    
	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntityHeatConductant(this, conductiveness);
	}
	
    public void updateTick(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_){}
    
    @Override
    public void onEntityCollidedWithBlock(World p_149670_1_, int p_149670_2_, int p_149670_3_, int p_149670_4_, Entity p_149670_5_)
    {
        p_149670_5_.attackEntityFrom(DamageSource.fallingBlock, 2);
    }
	
    @SideOnly(Side.CLIENT)
    public int colorMultiplier(IBlockAccess p_149720_1_, int p_149720_2_, int p_149720_3_, int p_149720_4_)
    {
    	int temp = 0;
    	TileEntityHeatConductant tile = (TileEntityHeatConductant) p_149720_1_.getTileEntity(p_149720_2_, p_149720_3_, p_149720_4_);
    	if (tile != null)
    	{
    		temp = tile.color;
    	}
   		return temp;
    }
    
    public boolean isOpaqueCube(){
    	return false;
    }
    
    public boolean renderAsNormalBlock(){
    	return false;
    }
}
