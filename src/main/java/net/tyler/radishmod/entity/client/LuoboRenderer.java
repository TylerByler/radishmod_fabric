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
        Identifier identifier;
        switch(animatable.getEyes()) {
            case BOTH -> identifier = new Identifier(RadishMod.MOD_ID, "textures/entity/luobo_both_eyes.png");
            case LEFT -> identifier = new Identifier(RadishMod.MOD_ID, "textures/entity/luobo_left_eye.png");
            case RIGHT -> identifier = new Identifier(RadishMod.MOD_ID, "textures/entity/luobo_right_eye.png");
            case NONE -> identifier = new Identifier(RadishMod.MOD_ID, "textures/entity/luobo_no_eyes.png");
            default -> identifier = new Identifier(RadishMod.MOD_ID, "textures/entity/luobo_left_eye.png");
        }

        return identifier;
    }

    @Override
    public float getMotionAnimThreshold(LuoboEntity animatable) {
        return 0.01f;
    }
}
