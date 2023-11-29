package org.zombie.manavisualizer;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.zombie.manavisualizer.item.ModItems;

@Mod(Manavisualizer.MOD_ID)
public class Manavisualizer {

    public static final String MOD_ID = "manavisualizer";

    public static final CreativeModeTab TAB = new CreativeModeTab("manatab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.MANAREADER.get());
        }
    };

    public Manavisualizer() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.register(modEventBus);
    }
}
