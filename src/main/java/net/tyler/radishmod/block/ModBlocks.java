package net.tyler.radishmod.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.tyler.radishmod.RadishMod;
import net.tyler.radishmod.block.custom.RadishCropBlock;
import net.tyler.radishmod.item.ModCreativeModeTabs;

public class ModBlocks {

    // *** Define and register new Blocks *** //
    public static final Block RADISH_CROP = registerBlockWithoutItem("radish_crop",
            new RadishCropBlock(FabricBlockSettings.copy(Blocks.WHEAT)));
    public static final Block COMPACT_RADISHES = registerBlock("compact_radishes",
            new Block(FabricBlockSettings.copyOf(Blocks.PUMPKIN)), ItemGroups.NATURAL);
    public static final Block RADISH_BRICKS = registerBlock("radish_bricks",
            new Block(FabricBlockSettings.copyOf(Blocks.BRICKS)), ItemGroups.NATURAL);
    public static final Block DECORATED_RADISH_BRICKS = registerBlock("decorated_radish_bricks",
            new Block(FabricBlockSettings.copyOf(Blocks.BRICKS)), ItemGroups.NATURAL);


    // *** Helper Methods *** //

    //Adds a Block to the Block Registry
    private static Block registerBlock(String name, Block block, RegistryKey<ItemGroup> tab) {
        Item newItem = registerBlockItem(name, block);
        addToItemGroup(tab, newItem);
        return Registry.register(Registries.BLOCK, new Identifier(RadishMod.MOD_ID, name), block);
    }

    //Adds a Block to the Block Registry without adding a counterpart Item
    private static Block registerBlockWithoutItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(RadishMod.MOD_ID, name), block);
    }

    //Adds an Item counterpart for a block to the Item Registry
    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(RadishMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    //Adds Item counterpart to an ItemGroup
    private static void addToItemGroup(RegistryKey<ItemGroup> group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
        ItemGroupEvents.modifyEntriesEvent(ModCreativeModeTabs.RADISH_MOD_GROUP).register(entries -> entries.add(item));
    }

    public static void registerModBlocks() {
        RadishMod.LOGGER.info("Registering Mod Blocks for " + RadishMod.MOD_ID);
    }

}
