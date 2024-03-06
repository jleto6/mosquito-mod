package net.jleto.mosquitos.entity.custom;

import net.jleto.mosquitos.effect.ModEffects;
import net.jleto.mosquitos.entity.ModEntities;
import net.jleto.mosquitos.entity.ai.MosquitoAttackGoal;
import net.jleto.mosquitos.item.ModItems;
import net.jleto.mosquitos.sound.ModSounds;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.FlyingAnimal;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.nio.file.Path;

public class MosquitoEntity extends Animal implements FlyingAnimal {

    private static final EntityDataAccessor<Boolean> ATTACKING =
            SynchedEntityData.defineId(MosquitoEntity.class, EntityDataSerializers.BOOLEAN);

    public MosquitoEntity(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.moveControl = new FlyingMoveControl(this, 20, true);


    }

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public final AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;

    @Override
    public void tick() {
        super.tick();

        if(this.level().isClientSide()) {
            setupAnimationStates();
        }
    }

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.tickCount);
        } else {
            --this.idleAnimationTimeout;
        }

       if (this.isAttacking() && attackAnimationTimeout <= 0) {
           attackAnimationTimeout = 9; //length in ticks of animation
           attackAnimationState.start(this.tickCount);

       } else {
           --this.attackAnimationTimeout;
       }

        if(!this.isAttacking()) {
            attackAnimationState.stop();
        }


    }

    @Override
    protected void updateWalkAnimation(float pPartialTick) {
        float f;
        if (this.getPose() == Pose.STANDING) {
            f = Math.min(pPartialTick * 6F, 1f);
        } else {
            f = 0f;
        }

        this.walkAnimation.update(f, 0.2f);
    }

    @Override
    protected PathNavigation createNavigation(Level pLevel) {
        FlyingPathNavigation flyingpathnavigation = new FlyingPathNavigation(this, pLevel);
        flyingpathnavigation.setCanOpenDoors(false);
        flyingpathnavigation.setCanFloat(true);
        flyingpathnavigation.setCanPassDoors(true);
        return flyingpathnavigation;
    }

    public void setAttacking(boolean attacking) {
        this.entityData.set(ATTACKING, attacking);
    }

    public boolean isAttacking() {
        return this.entityData.get(ATTACKING);
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        return null;
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ATTACKING, false);
    }

    @Override
    protected void registerGoals() {


        this.goalSelector.addGoal(0, new FloatGoal(this));

        this.goalSelector.addGoal(1, new MosquitoAttackGoal(this, 1.0D, true));

        this.goalSelector.addGoal(3, new FollowParentGoal(this, 1.1D));
        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.1D));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 3f));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));

        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));


    }

    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 3.0)
                .add(Attributes.FLYING_SPEED, 0.6)
                .add(Attributes.MOVEMENT_SPEED, 0.5)
                .add(Attributes.FOLLOW_RANGE,48)
                .add(Attributes.ATTACK_DAMAGE, 1f);


    }




    @Override
    public boolean causeFallDamage(float pFallDistance, float pMultiplier, DamageSource pSource) {
        return false;
    }

    @Override
    protected boolean shouldDespawnInPeaceful() {
        {
            return false;
        }
    }




    public boolean doHurtTarget(Entity pEntity) {


        // Check if the target is a living entity and has the repellent effect active
        if (pEntity instanceof LivingEntity) {
            LivingEntity livingTarget = (LivingEntity) pEntity;
            if (livingTarget.hasEffect(ModEffects.REPELLENT.get())) {
                return false; // Don't attack if the player has the repellent effect
            }
        }

        boolean flag = pEntity.hurt(this.damageSources().mobAttack(this), (float)((int)this.getAttributeValue(Attributes.ATTACK_DAMAGE)));
        if (flag) {

            // Apply WITHER effect to the target entity
            if (pEntity instanceof LivingEntity) {
                LivingEntity livingTarget = (LivingEntity) pEntity;
                MobEffectInstance bleedEffect = new MobEffectInstance(ModEffects.BLEED.get(), 200); // Duration of 10 seconds (20 ticks per second)
                livingTarget.addEffect(bleedEffect);

                if (random.nextDouble() < 0.1) {
                    // Apply the Ebola effect to the target entity
                    livingTarget.addEffect(new MobEffectInstance(ModEffects.EBOLA.get(), 600)); // Adjust duration as needed
                }
            }

            this.doEnchantDamageEffects(this, pEntity);
        }

        return flag;
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return SoundEvents.BEE_HURT;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
                 return SoundEvents.BEE_HURT;

    }

    @Override
    public boolean isFlying() {
        return !this.onGround();
    }


    protected boolean canAttack(LivingEntity pTarget, boolean pIncludeInvincibles) {
        // Check if the target is a player and if the mosquito has the absorption effect
        if (pTarget instanceof Player && ((Player) pTarget).hasEffect(MobEffects.ABSORPTION)) {
            return false; // Don't attack if the player has absorption effect
        }
        return super.canAttack(pTarget);
    }
}





