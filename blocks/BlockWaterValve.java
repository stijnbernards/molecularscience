package molecularscience.blocks;

import molecularscience.MolecularScience;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class BlockWaterValve extends Block
{

    public BlockWaterValve()
    {
        super(Material.iron);
        this.setCreativeTab(MolecularScience.MBlocks);
    }
}