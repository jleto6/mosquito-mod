package net.jleto.mosquitos.item;

import net.jleto.mosquitos.Mosquitos;
//import net.jleto.mosquitos.entity.ModEntities;
import net.jleto.mosquitos.entity.ModEntities;
import net.jleto.mosquitos.fluid.ModFluids;
import net.jleto.mosquitos.item.custom.BloodBucket;
import net.jleto.mosquitos.item.custom.EbolaVaccine;
import net.jleto.mosquitos.item.custom.ModArmorItem;
import net.jleto.mosquitos.item.custom.MosquitoArmorItem;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Mosquitos.MODID);



   public static final RegistryObject<Item> MOSQUITO_SPAWN_EGG = ITEMS.register("mosquito_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.MOSQUITO, 0x4c4943, 0x510405,
                    new Item.Properties()));

    public static final RegistryObject<Item> MOSQUITO = ITEMS.register("mosquito",
            () -> new Item(new Item.Properties().food(ModFoods.MOSQUITO)));

    public static final RegistryObject<Item> COOKED_MOSQUITO = ITEMS.register("cooked_mosquito",
            () -> new Item(new Item.Properties().food(Foods.BEEF)));

    public static final RegistryObject<Item> MOSQUITO_LEATHER = ITEMS.register("mosquito_leather",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RUBBER = ITEMS.register("rubber",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> BLOOD_BUCKET = ITEMS.register("blood_bucket",
            () ->   new BloodBucket(ModFluids.SOURCE_BLOOD_WATER,
                        new Item.Properties().stacksTo(1)
                                .food(ModFoods.BLOOD_BUCKET)));


                    //new BloodDrop(new Item.Properties().food(ModFoods.BLOOD_DROP)));

    public static final RegistryObject<Item> MOSQUITO_LEATHER_BOOTS = ITEMS.register("mosquito_leather_boots",
            () -> new MosquitoArmorItem(ModArmorMaterials.MOSQUITO_LEATHER, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> MOSQUITO_SPRAY = ITEMS.register("mosquito_spray",
            () -> new Item(new Item.Properties().food(ModFoods.MOSQUITO_SPRAY)));

    public static final RegistryObject<Item> EBOLA_VACCINE = ITEMS.register("ebola_vaccine",
            () -> new EbolaVaccine(new Item.Properties().food(ModFoods.BLOOD_BUCKET)));


    public static final RegistryObject<Item> HAZMAT_BOOTS = ITEMS.register("hazmat_boots",
            () -> new ModArmorItem(ModArmorMaterials.HAZMAT, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> HAZMAT_PANTS = ITEMS.register("hazmat_pants",
            () -> new ArmorItem(ModArmorMaterials.HAZMAT, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> HAZMAT_VEST = ITEMS.register("hazmat_vest",
            () -> new ArmorItem(ModArmorMaterials.HAZMAT, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> HAZMAT_HELMET = ITEMS.register("hazmat_helmet",
            () -> new ArmorItem(ModArmorMaterials.HAZMAT, ArmorItem.Type.HELMET, new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
