package net.jleto.mosquitos.event;

import net.jleto.mosquitos.Mosquitos;
import net.jleto.mosquitos.blood.PlayerBlood;
import net.jleto.mosquitos.blood.PlayerBloodProvider;
import net.jleto.mosquitos.client.BloodHudOverlay;
import net.jleto.mosquitos.entity.ModEntities;
import net.jleto.mosquitos.entity.custom.MosquitoEntity;
import net.jleto.mosquitos.Mosquitos;
import net.jleto.mosquitos.entity.ModEntities;
import net.jleto.mosquitos.entity.custom.MosquitoEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Mosquitos.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)

public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.MOSQUITO.get(), MosquitoEntity.createAttributes().build());

    }


}




