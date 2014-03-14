package molecularscience.blocks;

import molecularscience.MolecularScience;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockOre extends Block{

	public BlockOre(Material material, int Harvestlevel) {
		super(material);
		this.setCreativeTab(MolecularScience.MBlocks);
		this.setHarvestLevel("pickaxe", Harvestlevel);
	}
}
