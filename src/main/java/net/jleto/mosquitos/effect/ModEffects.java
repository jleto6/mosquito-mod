package net.jleto.mosquitos.effect;

import net.jleto.mosquitos.Mosquitos;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS
            = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, Mosquitos.MODID);

    public static final RegistryObject<MobEffect> BLEED = MOB_EFFECTS.register("bleed",
            () -> new BleedEffect(MobEffectCategory.HARMFUL, 0x430000));

    public static final RegistryObject<MobEffect> EBOLA = MOB_EFFECTS.register("ebola",
            () -> new EbolaEffect(MobEffectCategory.HARMFUL, 0x9fa115));

    public static final RegistryObject<MobEffect> REPELLENT = MOB_EFFECTS.register("repellent",
            () -> new RepellentEffect(MobEffectCategory.BENEFICIAL, 0x209300));

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}