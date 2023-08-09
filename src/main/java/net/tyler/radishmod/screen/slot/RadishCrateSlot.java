package net.tyler.radishmod.screen.slot;

import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;
import net.tyler.radishmod.item.ModItemTags;
import net.tyler.radishmod.item.ModItems;

public class RadishCrateSlot extends Slot {
    public RadishCrateSlot(Inventory inventory, int index, int x, int y) {
        super(inventory, index, x, y);
    }

    @Override
    public boolean canInsert(ItemStack stack) {
        if(stack.getItem() == ModItems.RADISH) {
            return true;
        }

        return false;
    }
}
