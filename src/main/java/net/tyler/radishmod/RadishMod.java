package net.tyler.radishmod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.tyler.radishmod.block.ModBlocks;
import net.tyler.radishmod.entity.ModEntities;
import net.tyler.radishmod.entity.custom.LuoboEntity;
import net.tyler.radishmod.entity.custom.RadscalEntity;
import net.tyler.radishmod.item.ModCreativeModeTabs;
import net.tyler.radishmod.item.ModItems;
import net.tyler.radishmod.networking.ModMessages;
import net.tyler.radishmod.world.gen.ModEntityGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RadishMod implements ModInitializer {
	public static final String MOD_ID = "radishmod";
    public static final Logger LOGGER = LoggerFactory.getLogger("radishmod");

	@Override
	public void onInitialize() {
		ModCreativeModeTabs.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		FabricDefaultAttributeRegistry.register(ModEntities.RADSCAL, RadscalEntity.setAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.LUOBO, LuoboEntity.setAttributes());

		ModEntityGeneration.addSpawns();

		ModMessages.registerC2SPackets();
	}
}