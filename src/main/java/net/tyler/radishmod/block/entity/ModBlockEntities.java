package net.tyler.radishmod.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.tyler.radishmod.RadishMod;
import net.tyler.radishmod.block.ModBlocks;
import net.tyler.radishmod.block.custom.RadishCrateBlock;

public class ModBlockEntities {
    public static BlockEntityType<RadishCrateBlockEntity> RADISH_CRATE;

    public static void registerBlockEntities() {
        RADISH_CRATE = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(RadishMod.MOD_ID, "radish_crate"),
                FabricBlockEntityTypeBuilder.create(RadishCrateBlockEntity::new,
                        ModBlocks.RADISH_CRATE).build(null));
    }
}
