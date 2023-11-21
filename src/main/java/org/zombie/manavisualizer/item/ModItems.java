package org.zombie.manavisualizer.item;

import net.minecraft.ChatFormatting;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.zombie.manavisualizer.Manavisualizer;
import org.zombie.manavisualizer.item.custom.ManaReaderWandItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Manavisualizer.MOD_ID);

    public static final RegistryObject<Item> MANAREADER = ITEMS.register("manareader",
            () -> new ManaReaderWandItem(ChatFormatting.AQUA, new Item.Properties().stacksTo(1).tab(ModCreativeModeTab.MANAVISUALIZER_TAB)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
