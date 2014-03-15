package molecularscience.blocks;

import molecularscience.MolecularScience;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockSlag extends Block{
	public BlockSlag(Material material) {
		super(material);
		this.setCreativeTab(MolecularScience.MBlocks);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.2F, 1.0F);
	}
}
