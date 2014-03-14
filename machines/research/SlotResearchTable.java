package molecularscience.machines.research;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotResearchTable extends Slot {

	private TileEntityResearchTable teResearch;
	
	public SlotResearchTable(IInventory inventory, int id, int x, int y) {
		super(inventory, id, x, y);
		this.teResearch = (TileEntityResearchTable) inventory;
	}
	
	@Override
	public boolean isItemValid(ItemStack itemstack) {
		return teResearch.isItemValidForSlot(slotNumber, itemstack);
	}
}
