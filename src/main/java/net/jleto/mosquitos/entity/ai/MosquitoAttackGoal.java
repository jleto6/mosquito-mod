package net.jleto.mosquitos.entity.ai;

import net.jleto.mosquitos.entity.custom.MosquitoEntity;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.ZombieAttackGoal;
import net.minecraft.world.entity.monster.warden.WardenAi;
import net.minecraft.world.entity.player.Player;

public class MosquitoAttackGoal extends MeleeAttackGoal {
    private final MosquitoEntity entity;
    private int attackDelay = 4;
    private int ticksUntilNextAttack = 4;
    private boolean shouldCountTillNextAttack = false;

    public MosquitoAttackGoal(PathfinderMob pMob, double pSpeedModifier, boolean pFollowingTargetEvenIfNotSeen) {
        super(pMob, pSpeedModifier, pFollowingTargetEvenIfNotSeen);
        entity = ((MosquitoEntity) pMob);
    }



    @Override
    public void start() {
        super.start();
        attackDelay = 4;
        ticksUntilNextAttack = 4;
    }

    @Override
    protected void checkAndPerformAttack(LivingEntity pEnemy) {
        if (this.mob.isWithinMeleeAttackRange(pEnemy)) {
            shouldCountTillNextAttack = true;

            if(isTimeToStartAttackAnimation()) {
                entity.setAttacking(true);
            }

            if(isTimeToAttack()) {
                this.mob.getLookControl().setLookAt(pEnemy.getX(), pEnemy.getEyeY(), pEnemy.getZ());
                performAttack(pEnemy);
            }
        } else {
            resetAttackCooldown();
            shouldCountTillNextAttack = false;
            entity.setAttacking(false);
            entity.attackAnimationTimeout = 0;
        }
    }




    protected void resetAttackCooldown() {
        this.ticksUntilNextAttack = this.adjustedTickDelay(attackDelay * 1);
    }

    protected boolean isTimeToAttack() {
        return this.ticksUntilNextAttack <= 0;
    }

    protected boolean isTimeToStartAttackAnimation() {
        return this.ticksUntilNextAttack <= attackDelay;
    }

    protected int getTicksUntilNextAttack() {
        return this.ticksUntilNextAttack;
    }


    protected void performAttack(LivingEntity pEnemy) {
        this.resetAttackCooldown();
        this.mob.doHurtTarget(pEnemy);
    }

    @Override
    public void tick() {
        super.tick();
        if(shouldCountTillNextAttack) {
            this.ticksUntilNextAttack = Math.max(this.ticksUntilNextAttack - 1, 0);
        }
    }

    @Override
    public void stop() {
        entity.setAttacking(false);
        super.stop();
    }

    protected boolean canAttack(LivingEntity pTarget, boolean pIncludeInvincibles) {
        // Check if the target is a player and if the mosquito has the absorption effect
        if (pTarget instanceof Player && ((Player) pTarget).hasEffect(MobEffects.ABSORPTION)) {
            return false; // Don't attack if the player has absorption effect
        }
        return super.canPerformAttack(pTarget);
    }
}


