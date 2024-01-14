package org.zombie.manavisualizer;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.zombie.manavisualizer.item.ModItems;

public class ModCreativeModeTab {
    public static final CreativeModeTab MANAVISUALIZER_TAB = new CreativeModeTab("manatab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.MANAREADER.get());
        };
    };
}