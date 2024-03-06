package net.jleto.mosquitos.item;


import net.jleto.mosquitos.Mosquitos;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class CreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Mosquitos.MODID);



    public static final RegistryObject<CreativeModeTab> Mosquitos_Tab = CREATIVE_MODE_TABS.register("mosquitos",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.MOSQUITO.get()))
                    .title(Component.translatable("creativetab.mosquitos"))
                    .displayItems((itemDisplayParameters, output) -> {

                    output.accept(ModItems.MOSQUITO.get());
                    output.accept(ModItems.COOKED_MOSQUITO.get());
                    output.accept(ModItems.MOSQUITO_SPAWN_EGG.get());
                    output.accept(ModItems.MOSQUITO_LEATHER.get());
                    output.accept(ModItems.MOSQUITO_LEATHER_BOOTS.get());
                    output.accept(ModItems.MOSQUITO_SPRAY.get());
                    output.accept(ModItems.BLOOD_BUCKET.get());
                    output.accept(ModItems.EBOLA_VACCINE.get());
                    output.accept(ModItems.RUBBER.get());
                    output.accept(ModItems.HAZMAT_HELMET.get());
                    output.accept(ModItems.HAZMAT_VEST.get());
                    output.accept(ModItems.HAZMAT_PANTS.get());
                    output.accept(ModItems.HAZMAT_BOOTS.get());








                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
