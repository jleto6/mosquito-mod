package net.jleto.mosquitos.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class EbolaEffect extends MobEffect {
    public EbolaEffect(MobEffectCategory category, int duration) {
        super(category, duration);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        super.applyEffectTick(entity, amplifier);
        if (entity.getHealth() > 1.0F) {
            entity.hurt(entity.damageSources().magic(), 1.0F);
        }
        entity.hurt(entity.damageSources().wither(), 1.0F);
        if (entity instanceof Player) {
            ((Player) entity).causeFoodExhaustion(0.005F * (amplifier + 1));
        }
        // Apply confusion effect if Ebola effect is active
        if (entity.hasEffect(this)) {
            entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 100, amplifier));
            entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, amplifier));
            entity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 100, amplifier));
            entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 100, amplifier));
        }
    }


    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        int ticksMagic = 25 >> amplifier;
        int ticksWither = 40 >> amplifier;
        return ticksMagic > 0 ? duration % ticksMagic == 0 : true;
    }
}

