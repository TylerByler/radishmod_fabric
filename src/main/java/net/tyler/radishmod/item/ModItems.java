package net.tyler.radishmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.tyler.radishmod.RadishMod;
import net.tyler.radishmod.block.ModBlocks;
import net.tyler.radishmod.entity.ModEntities;

public class ModItems {

    // *** Define and register new items *** //
    public static final Item RADISH = registerItem("radish",
            new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(4).saturationModifier(4).build())));
    public static final Item ROASTED_RADISH = registerItem("roasted_radish",
            new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(6).saturationModifier(6).build())));
    public static final Item HEARTYRADISH = registerItem("hearty_radish",
            new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(8).saturationModifier(8).build())));
    public static final Item VEGETABLE_SOUP = registerItem("vegetable_soup",
            new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(8).saturationModifier(8).build()).maxCount(1)));

    public static final Item RADISH_BUNDLE = registerItem("radish_bundle",
            new Item(new FabricItemSettings()));

    public static final Item RADISH_SEEDS = registerItem("radish_seeds",
            new AliasedBlockItem(ModBlocks.RADISH_CROP, new FabricItemSettings()));

    public static final Item RADSCAL_SPAWN_EGG = registerItem("radscal_spawn_egg",
            new SpawnEggItem(ModEntities.RADSCAL, 0xAB3636, 0x269B41,
                    new FabricItemSettings()));
    public static final Item LUOBO_SPAWN_EGG = registerItem("luobo_spawn_egg",
            new SpawnEggItem(ModEntities.LUOBO, 0x5c7b0f, 0xd1c5b3,
                    new FabricItemSettings()));

    // Add items to their groups
    public static void addItemsToItemGroup() {
        addToItemGroup(ItemGroups.FOOD_AND_DRINK, RADISH);
        addToItemGroup(ItemGroups.FOOD_AND_DRINK, ROASTED_RADISH);
        addToItemGroup(ItemGroups.FOOD_AND_DRINK, HEARTYRADISH);
        addToItemGroup(ItemGroups.FOOD_AND_DRINK, VEGETABLE_SOUP);
        addToItemGroup(ItemGroups.NATURAL, RADISH_SEEDS);
        addToItemGroup(ItemGroups.NATURAL, RADISH_BUNDLE);
        addToItemGroup(ItemGroups.SPAWN_EGGS, RADSCAL_SPAWN_EGG);
        addToItemGroup(ItemGroups.SPAWN_EGGS, LUOBO_SPAWN_EGG);

        addToItemGroup(ModCreativeModeTabs.RADISH_MOD_GROUP, RADISH);
        addToItemGroup(ModCreativeModeTabs.RADISH_MOD_GROUP, ROASTED_RADISH);
        addToItemGroup(ModCreativeModeTabs.RADISH_MOD_GROUP, RADISH_BUNDLE);
        addToItemGroup(ModCreativeModeTabs.RADISH_MOD_GROUP, HEARTYRADISH);
        addToItemGroup(ModCreativeModeTabs.RADISH_MOD_GROUP, VEGETABLE_SOUP);
        addToItemGroup(ModCreativeModeTabs.RADISH_MOD_GROUP, RADISH_SEEDS);
        addToItemGroup(ModCreativeModeTabs.RADISH_MOD_GROUP, RADSCAL_SPAWN_EGG);
        addToItemGroup(ModCreativeModeTabs.RADISH_MOD_GROUP, LUOBO_SPAWN_EGG);
    }

    // *** Helper Methods *** //

    //Adds an item to the item registry
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(RadishMod.MOD_ID, name), item);
    }

    //Adds Item to specific group
    private static void addToItemGroup(RegistryKey<ItemGroup> group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }

    // Called in RadishMod to initialize registry of items
    public static void registerModItems() {
        RadishMod.LOGGER.info("Registering Mod Items for " + RadishMod.MOD_ID);

        addItemsToItemGroup();
    }
}
