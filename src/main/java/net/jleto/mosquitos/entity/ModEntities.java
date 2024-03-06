package net.jleto.mosquitos.entity;

import net.jleto.mosquitos.Mosquitos;
import net.jleto.mosquitos.entity.custom.MosquitoEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Mosquitos.MODID);


    public static final RegistryObject<EntityType<MosquitoEntity>> MOSQUITO =
            ENTITY_TYPES.register("mosquito", () -> EntityType.Builder.of(MosquitoEntity::new, MobCategory.CREATURE)
                    .sized(1f, 1f).build("mosquito"));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
