package net.jleto.mosquitos.fluid;

import net.jleto.mosquitos.Mosquitos;
import net.jleto.mosquitos.Mosquitos;
import net.jleto.mosquitos.block.ModBlocks;
import net.jleto.mosquitos.item.ModItems;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFluids {
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(ForgeRegistries.FLUIDS, Mosquitos.MODID);

    public static final RegistryObject<FlowingFluid> SOURCE_BLOOD_WATER = FLUIDS.register("blood_water_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.BLOOD_WATER_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_BLOOD_WATER = FLUIDS.register("flowing_blood_water",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.BLOOD_WATER_FLUID_PROPERTIES));


    public static final ForgeFlowingFluid.Properties BLOOD_WATER_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.BLOOD_WATER_FLUID_TYPE, SOURCE_BLOOD_WATER, FLOWING_BLOOD_WATER)
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(ModBlocks.BLOOD_WATER_BLOCK)
            .bucket(ModItems.BLOOD_BUCKET);


    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}