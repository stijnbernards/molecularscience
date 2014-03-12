package molecularscience;

import molecularscience.electrolyzer.TileEntityElectrolyzer;
import molecularscience.electrolyzer.TileEntityElectrolyzerRenderer;
import cpw.mods.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy {

	@Override
    public void registerRenderers() {
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityElectrolyzer.class, new TileEntityElectrolyzerRenderer());
    }
	
}
