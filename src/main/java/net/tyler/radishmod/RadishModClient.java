package net.tyler.radishmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.tyler.radishmod.block.ModBlocks;
import net.tyler.radishmod.entity.ModEntities;
import net.tyler.radishmod.entity.client.LuoboRenderer;
import net.tyler.radishmod.entity.client.RadscalRenderer;
import net.tyler.radishmod.networking.ModMessages;

public class RadishModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RADISH_CROP, RenderLayer.getCutout());

        EntityRendererRegistry.register(ModEntities.RADSCAL, RadscalRenderer::new);
        EntityRendererRegistry.register(ModEntities.LUOBO, LuoboRenderer::new);

        ModMessages.registerS2CPackets();
    }
}
