package org.zombie.manavisualizer;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import org.zombie.manavisualizer.item.ModItems;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB,Manavisualizer.MOD_ID);

    public static final RegistryObject<CreativeModeTab> MOD_TAB = CREATIVE_MODE_TABS.register("manatab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.MANAREADER.get()))
                    .title(Component.translatable("creativetab.manatab"))
                    .displayItems(((itemDisplayParameters, output) ->{
                        output.accept(ModItems.MANAREADER.get());
                    }))

                    .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
