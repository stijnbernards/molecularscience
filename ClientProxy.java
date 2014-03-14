package molecularscience;

import molecularscience.machines.electrolyzer.TileEntityElectrolyzer;
import molecularscience.machines.electrolyzer.TileEntityElectrolyzerRenderer;
import molecularscience.machines.research.TileEntityResearchTable;
import molecularscience.machines.research.TileEntityResearchTableRenderer;
import cpw.mods.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy {

	@Override
    public void registerRenderers() {
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityElectrolyzer.class, new TileEntityElectrolyzerRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityResearchTable.class, new TileEntityResearchTableRenderer());
    }
	
}
