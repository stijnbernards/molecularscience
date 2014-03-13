package molecularscience.moditems;

import molecularscience.MolecularScience;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockInsulator extends Block{

	public BlockInsulator(Material material) {
		super(material);
		this.setCreativeTab(MolecularScience.MBlocks);
	}
}