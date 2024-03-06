package net.jleto.mosquitos.event;

import net.jleto.mosquitos.Mosquitos;
import net.jleto.mosquitos.client.BloodHudOverlay;
import net.jleto.mosquitos.entity.client.MosquitoModel;
import net.jleto.mosquitos.entity.client.ModModelLayers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Mosquitos.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.MOSQUITO_LAYER, MosquitoModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerGuiOverlays(RegisterGuiOverlaysEvent event) {
        //event.registerAboveAll("thirst", BloodHudOverlay.HUD_BLOOD);
}}
