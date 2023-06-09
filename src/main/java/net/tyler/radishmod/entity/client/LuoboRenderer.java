package net.tyler.radishmod.entity.client;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.tyler.radishmod.RadishMod;
import net.tyler.radishmod.entity.custom.LuoboEntity;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class LuoboRenderer extends GeoEntityRenderer<LuoboEntity> {
    public LuoboRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new LuoboModel());
    }

    @Override
    public Identifier getTextureLocation(LuoboEntity animatable) {
        return new Identifier(RadishMod.MOD_ID, "textures/entity/luobo.png");
    }
}
