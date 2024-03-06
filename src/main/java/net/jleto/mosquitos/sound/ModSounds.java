package net.jleto.mosquitos.sound;

import net.jleto.mosquitos.Mosquitos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Mosquitos.MODID);

    public static final RegistryObject<SoundEvent> CLASSIC_HURT = registerSoundEvents("classic_hurt");


    private static RegistryObject<SoundEvent> registerSoundEvents(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Mosquitos.MODID, name)));
    }


    public static void register(IEventBus eventBus) {
    SOUND_EVENTS.register(eventBus);
    }
}