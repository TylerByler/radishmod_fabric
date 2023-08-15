package net.tyler.radishmod.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.tyler.radishmod.RadishMod;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

public class RadscalEntity extends AnimalEntity implements GeoEntity {
    private AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    public static final RawAnimation WALK = RawAnimation.begin().thenLoop("animation.radscal.walk");
    public static final RawAnimation IDLE = RawAnimation.begin().thenLoop("animation.radscal.idle");
    public static final RawAnimation RUN = RawAnimation.begin().thenLoop("animation.radscal.run");
    public static final RawAnimation ATTACK = RawAnimation.begin().thenPlay("animation.radscal.attackbasic)");

    public RadscalEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder setAttributes() {
        return AnimalEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 8D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2.0f)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 1.5f)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.15f);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(2, new MeleeAttackGoal(this, 2.0D, false));
        this.goalSelector.add(7, new WanderAroundFarGoal(this, 1.0D));

        this.goalSelector.add(8, new LookAtEntityGoal(this, PlayerEntity.class, 8.0f));
        this.goalSelector.add(8, new LookAroundGoal(this));

        this.goalSelector.add(1, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
    }

    @Override
    protected Identifier getLootTableId() {
        return new Identifier(RadishMod.MOD_ID, "entities/radscal");
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "Walk/Idle", 0, (state) -> {
            if (state.isMoving() && this.isAttacking()) {
                state.setAndContinue(RUN);
            } else if (state.isMoving()) {
                state.setAndContinue(WALK);
            } else state.setAndContinue(IDLE);
            return null;
        }));

        /*controllerRegistrar.add(new AnimationController<>(this, "Attack", 0, (state) -> {
            if (this.handSwinging) {
                state.resetCurrentAnimation();
                state.setAndContinue(ATTACK);
                this.handSwinging = false;
            }
            return null;
        }));*/
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}
