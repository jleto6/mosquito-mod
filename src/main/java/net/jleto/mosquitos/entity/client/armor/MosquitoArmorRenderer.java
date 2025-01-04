package net.jleto.mosquitos.entity.client.armor;

import net.jleto.mosquitos.item.custom.MosquitoArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class MosquitoArmorRenderer extends GeoArmorRenderer<MosquitoArmorItem> {
    public MosquitoArmorRenderer() {
        super(new MosquitoArmorModel());

    }}