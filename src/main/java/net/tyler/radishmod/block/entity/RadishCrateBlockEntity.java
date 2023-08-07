package net.tyler.radishmod.block.entity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.state.property.IntProperty;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.tyler.radishmod.block.custom.RadishCrateBlock;
import net.tyler.radishmod.screen.RadishCrateScreenHandler;
import org.jetbrains.annotations.Nullable;

public class RadishCrateBlockEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> INVENTORY = DefaultedList.ofSize(3, ItemStack.EMPTY);

    public RadishCrateBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.RADISH_CRATE, pos, state);
    }

    @Override
    public Text getDisplayName() {
        return Text.literal("Radish Crate");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new RadishCrateScreenHandler(syncId, playerInventory, this);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, INVENTORY);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt, INVENTORY);
        super.readNbt(nbt);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return this.INVENTORY;
    }

    public static void tick(World world, BlockPos blockPos, BlockState blockState, RadishCrateBlockEntity entity) {
        if(world.isClient()) {
            return;
        }

        Block block = world.getBlockState(blockPos).getBlock();
        if (block.getClass().equals(RadishCrateBlock.class)) {
            int count = entity.INVENTORY.get(1).getCount() + entity.INVENTORY.get(2).getCount();
            if(count > 0) {
                if(count > 32) {
                    if(count > 64) {
                        if(count > 96) {
                            if (count > 128) {

                            }
                        }
                    }
                }
            }
            ((RadishCrateBlock) block).LEVEL
        }
    }
}
