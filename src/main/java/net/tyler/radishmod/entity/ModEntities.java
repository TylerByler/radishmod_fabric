package net.tyler.radishmod.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.tyler.radishmod.RadishMod;
import net.tyler.radishmod.entity.custom.LuoboEntity;
import net.tyler.radishmod.entity.custom.RadscalEntity;

public class ModEntities {
    public static final EntityType<RadscalEntity> RADSCAL = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(RadishMod.MOD_ID, "radscal"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, RadscalEntity::new)
                    .dimensions(EntityDimensions.fixed(.6f, .8f)).build());

    public static final EntityType<LuoboEntity> LUOBO = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(RadishMod.MOD_ID, "luobo"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, LuoboEntity::new)
                    .dimensions(EntityDimensions.fixed(.6f, 2f)).build());
}
