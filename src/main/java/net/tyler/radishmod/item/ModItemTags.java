package net.tyler.radishmod.item;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.tyler.radishmod.RadishMod;

public class ModItemTags {
    public static final TagKey<Item> RADISH_ITEMS = TagKey.of(RegistryKeys.ITEM, new Identifier(RadishMod.MOD_ID, "items/radish_items"));

}
