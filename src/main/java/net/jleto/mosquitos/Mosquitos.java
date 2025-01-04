package net.jleto.mosquitos;

import com.mojang.logging.LogUtils;

import net.jleto.mosquitos.block.ModBlocks;
import net.jleto.mosquitos.client.BloodHudOverlay;
import net.jleto.mosquitos.effect.ModEffects;
import net.jleto.mosquitos.entity.ModEntities;
import net.jleto.mosquitos.entity.client.MosquitoRenderer;
import net.jleto.mosquitos.fluid.ModFluidTypes;
import net.jleto.mosquitos.fluid.ModFluids;
import net.jleto.mosquitos.item.ModItems;
import net.jleto.mosquitos.item.custom.MosquitoArmorItem;
import net.jleto.mosquitos.sound.ModSounds;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Mosquitos.MODID)
public class Mosquitos
{
    public static final String MODID = "mosquitos";
    private static final Logger LOGGER = LogUtils.getLogger();

    public Mosquitos()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        net.jleto.mosquitos.item.CreativeModeTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModEffects.register(modEventBus);
        ModEntities.register(modEventBus);
        ModBlocks.register(modEventBus);
        modEventBus.addListener(this::commonSetup);


        ModFluids.register(modEventBus);
        ModFluidTypes.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);


    }
    private void commonSetup(final FMLCommonSetupEvent event) {

       // ItemBlockRenderTypes.setRenderLayer(ModBlocks.CYAN_FLOWER.get(), RenderType.cutout());
       // ItemBlockRenderTypes.setRenderLayer(ModBlocks.POTTED_CYAN_FLOWER.get(), RenderType.cutout());
      //  ItemBlockRenderTypes.setRenderLayer(ModBlocks.COG.get(), RenderType.cutout());
      //  ItemBlockRenderTypes.setRenderLayer(ModBlocks.COG_ANIMATED.get(), RenderType.cutout());


        event.enqueueWork(() -> {
          //  ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.CYAN_FLOWER.getId(), ModBlocks.POTTED_CYAN_FLOWER);
        });

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
          //  event.accept(ModItems);
        }

    }



    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents{
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

           EntityRenderers.register(ModEntities.MOSQUITO.get(), MosquitoRenderer::new);
        }
    }
}
