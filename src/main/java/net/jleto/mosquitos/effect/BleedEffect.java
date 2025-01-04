package net.jleto.mosquitos.effect;

import net.jleto.mosquitos.block.ModBlocks;
import net.jleto.mosquitos.fluid.ModFluids;
import net.minecraft.client.resources.model.Material;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class BleedEffect extends MobEffect {
    public BleedEffect(MobEffectCategory category, int duration) {
        super(category, duration);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        super.applyEffectTick(entity, amplifier);

        if (entity.getHealth() > 1.0F) {
            entity.hurt(entity.damageSources().magic(), 1.0F);
        }

        Level level = entity.getCommandSenderWorld();

        if (level instanceof ServerLevel) {
            ServerLevel serverWorld = (ServerLevel) level;
            BlockPos pos = entity.blockPosition();
            if (serverWorld.isEmptyBlock(pos)) {
                serverWorld.setBlockAndUpdate(pos, ModBlocks.BLOOD_WATER_BLOCK.get().defaultBlockState());
            }
        }
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return duration % 1 == 0; // Apply every second (20 ticks)
    }
}

