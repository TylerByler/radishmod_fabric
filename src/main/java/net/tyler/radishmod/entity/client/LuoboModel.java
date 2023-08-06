package net.tyler.radishmod.entity.client;

import net.minecraft.util.Identifier;
import net.tyler.radishmod.RadishMod;
import net.tyler.radishmod.entity.custom.LuoboEntity;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;

public class LuoboModel extends GeoModel<LuoboEntity> {
    @Override
    public Identifier getModelResource(LuoboEntity animatable) {
        return new Identifier(RadishMod.MOD_ID, "geo/luobo.geo.json");
    }

    @Override
    public Identifier getTextureResource(LuoboEntity animatable) {
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
    public Identifier getAnimationResource(LuoboEntity animatable) {
        return new Identifier(RadishMod.MOD_ID, "animations/luobo.animation.json");
    }

    @Override
    public void setCustomAnimations(LuoboEntity animatable, long instanceId, AnimationState<LuoboEntity> animationState) {
        CoreGeoBone angryFace = getAnimationProcessor().getBone("AngryFace");

        if (angryFace != null && animatable.isAttacking()) {
            angryFace.setHidden(false);
        } else {
            angryFace.setHidden(true);
        }
    }
}
