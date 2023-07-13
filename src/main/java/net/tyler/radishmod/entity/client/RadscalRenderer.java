package net.tyler.radishmod.entity.client;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.tyler.radishmod.RadishMod;
import net.tyler.radishmod.entity.custom.RadscalEntity;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class RadscalRenderer extends GeoEntityRenderer<RadscalEntity> {
    public RadscalRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new RadscalModel());
    }

    @Override
    public Identifier getTextureLocation(RadscalEntity animatable) {
        return new Identifier(RadishMod.MOD_ID, "textures/entity/radscal.png");
    }

    @Override
    public float getMotionAnimThreshold(RadscalEntity animatable) {
        return 0.01f;
    }
}
