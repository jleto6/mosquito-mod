package net.jleto.mosquitos.entity.client.armor;

import net.jleto.mosquitos.Mosquitos;
import net.jleto.mosquitos.item.custom.ModArmorItem;
import net.jleto.mosquitos.item.custom.MosquitoArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.example.item.GeckoArmorItem;
import software.bernie.geckolib.model.GeoModel;

public class MosquitoArmorModel extends GeoModel<MosquitoArmorItem> {

    @Override
    public ResourceLocation getModelResource(MosquitoArmorItem MosquitoArmorItem) {
        return new ResourceLocation(Mosquitos.MODID, "geo/mosquito_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(MosquitoArmorItem MosquitoArmorItem) {
        return new ResourceLocation(Mosquitos.MODID, "textures/armor/mosquito_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(MosquitoArmorItem MosquitoArmorItem) {
        return new ResourceLocation(Mosquitos.MODID, "animations/mosquito_armor.animation.json");
    }
}