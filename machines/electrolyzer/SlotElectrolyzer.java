package molecularscience.machines.electrolyzer;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotElectrolyzer extends Slot {

	private TileEntityElectrolyzer teSmithingAnvil;
	
	public SlotElectrolyzer(IInventory inventory, int id, int x, int y) {
		super(inventory, id, x, y);
		this.teSmithingAnvil = (TileEntityElectrolyzer) inventory;
	}
	
	@Override
	public boolean isItemValid(ItemStack itemstack) {
		return teSmithingAnvil.isItemValidForSlot(slotNumber, itemstack);
	}
}
