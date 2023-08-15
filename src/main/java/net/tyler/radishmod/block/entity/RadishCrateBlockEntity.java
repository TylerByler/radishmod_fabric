package net.tyler.radishmod.block.entity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
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
import org.apache.logging.log4j.core.LogEventListener;
import org.jetbrains.annotations.Nullable;

import static net.tyler.radishmod.block.custom.RadishCrateBlock.LEVEL;

public class RadishCrateBlockEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> INVENTORY = DefaultedList.ofSize( 9, ItemStack.EMPTY);

    public RadishCrateBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.RADISH_CRATE, pos, state);
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable(getCachedState().getBlock().getTranslationKey());
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

    public static void updateInventoryCount(RadishCrateBlockEntity entity) {
        int count = 0;
        for(int i = 0; i < entity.getItems().size(); i++) {
            count = count + entity.getItems().get(i).getCount();
        }

    }

    public static void tick(World world, BlockPos blockPos, BlockState blockState, RadishCrateBlockEntity entity) {
        if (world.isClient) {
            return;
        }

        SimpleInventory inventory = new SimpleInventory(entity.size());
        for (int i = 0; i < entity.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        int count = 0;
        for (int i = 0; i < inventory.size(); i++) {
            count += inventory.getStack(i).getCount();
        }

        if(count >= 0) {
            if (count >= 32) {
                if (count >= 64) {
                    if (count >= 96) {
                        if (count >= 128) {
                            world.setBlockState(blockPos, blockState.with(LEVEL, 4));
                            markDirty(world, blockPos, blockState);
                            return;
                        }
                        world.setBlockState(blockPos, blockState.with(LEVEL, 3));
                        markDirty(world, blockPos, blockState);
                        return;
                    }
                    world.setBlockState(blockPos, blockState.with(LEVEL, 2));
                    markDirty(world, blockPos, blockState);
                    return;
                }
                world.setBlockState(blockPos, blockState.with(LEVEL, 1));
                markDirty(world, blockPos, blockState);
                return;
            }
            world.setBlockState(blockPos, blockState.with(LEVEL, 0));
            markDirty(world, blockPos, blockState);
        }
    }
}
