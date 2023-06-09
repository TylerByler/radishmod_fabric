package net.tyler.radishmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.tyler.radishmod.RadishMod;

public class ModCreativeModeTabs {
    public static final RegistryKey<ItemGroup> RADISH_MOD_GROUP = RegistryKey.of(RegistryKeys.ITEM_GROUP,
            new Identifier(RadishMod.MOD_ID, "test_group"));

    public static void registerItemGroups() {
        Registry.register(Registries.ITEM_GROUP, RADISH_MOD_GROUP, FabricItemGroup.builder()
                .displayName(Text.translatable("radishmod.test_group"))
                .icon(() -> new ItemStack(ModItems.RADISH))
                .build());
    }
}
