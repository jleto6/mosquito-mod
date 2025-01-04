package net.jleto.mosquitos.item;

import net.jleto.mosquitos.effect.ModEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.Foods;

public class ModFoods {


    public static final FoodProperties MOSQUITO = new FoodProperties.Builder().nutrition(2).fast()
            .nutrition(2).saturationMod(0.1F)

            .effect(() -> new MobEffectInstance(MobEffects.POISON, 600, 0), 0.8F).meat().build();

    public static final FoodProperties MOSQUITO_SPRAY = new FoodProperties.Builder().nutrition(0).fast()
            .nutrition(0).saturationMod(0F)
            .alwaysEat()
            .effect(() -> new MobEffectInstance(ModEffects.REPELLENT.get(), 120000, 0), 0.8F).meat()
            .build();

    public static final FoodProperties BLOOD_BUCKET = new FoodProperties.Builder().nutrition(0).fast()
            .nutrition(0).saturationMod(0F)
            .alwaysEat()
            .build();

}




