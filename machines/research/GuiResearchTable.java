package molecularscience.machines.research;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

public class GuiResearchTable extends GuiContainer {

	private static final ResourceLocation Guitexture = new ResourceLocation("molecularscience","textures/gui/container/guielectrolyzer.png");
	
    public GuiResearchTable (InventoryPlayer inventoryPlayer,
                    TileEntityResearchTable tileEntity) {
            super(new ContainerResearchTable(inventoryPlayer, tileEntity));
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int param1, int param2) {

    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float par1, int par2,
                    int par3) {
    		this.mc.getTextureManager().bindTexture(Guitexture);
            int x = (width - xSize) / 2;
            int y = (height - (ySize+27)) / 2;
            this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize+27);
    }

}