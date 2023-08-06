package net.tyler.radishmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.tyler.radishmod.block.ModBlocks;
import net.tyler.radishmod.entity.ModEntities;
import net.tyler.radishmod.entity.client.LuoboRenderer;
import net.tyler.radishmod.entity.client.RadscalRenderer;
import net.tyler.radishmod.networking.ModMessages;
import net.tyler.radishmod.screen.ModScreenHandlers;
import net.tyler.radishmod.screen.RadishCrateScreen;

public class RadishModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RADISH_CROP, RenderLayer.getCutout());

        EntityRendererRegistry.register(ModEntities.RADSCAL, RadscalRenderer::new);
        EntityRendererRegistry.register(ModEntities.LUOBO, LuoboRenderer::new);

        HandledScreens.register(ModScreenHandlers.RADISH_CRATE_SCREEN_HANDLER, RadishCrateScreen::new);

        ModMessages.registerS2CPackets();
    }
}
