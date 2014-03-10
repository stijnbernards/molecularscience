package molecularscience.moditems;

import molecularscience.MolecularScience;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockHeatConductant extends Block{

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
    public TileEntity createTileEntity(World world, int metadata)
    {
    	System.out.println("update");
    	return new TileEntityHeatConductant();
    }
}
