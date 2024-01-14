package org.zombie.manavisualizer;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.zombie.manavisualizer.item.ModItems;

@Mod(Manavisualizer.MOD_ID)
public class Manavisualizer {

    public static final String MOD_ID = "manavisualizer";

    public Manavisualizer() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModCreativeTab.register(modEventBus);
        ModItems.register(modEventBus);
    }
}
