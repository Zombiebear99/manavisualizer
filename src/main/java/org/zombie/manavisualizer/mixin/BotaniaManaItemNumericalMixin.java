package org.zombie.manavisualizer.mixin;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.zombie.manavisualizer.ManaNumberFormatting;
import vazkii.botania.api.mana.ManaItem;
import vazkii.botania.client.integration.jei.JEIBotaniaPlugin;
import vazkii.botania.client.integration.jei.RunicAltarRecipeCategory;
import vazkii.botania.common.item.ManaTabletItem;
import vazkii.botania.common.item.equipment.bauble.BaubleItem;
import vazkii.botania.xplat.XplatAbstractions;

import java.util.List;

@Mixin({
		ManaTabletItem.class,
		BaubleItem.class,
})
public class BotaniaManaItemNumericalMixin extends Item
{
	public BotaniaManaItemNumericalMixin(Properties pProperties) {
		super(pProperties);
	}

	@Override
	public void appendHoverText(@NotNull ItemStack stack, @Nullable Level level, @NotNull List<Component> components, @NotNull TooltipFlag tooltipFlag) {
		final ManaItem manaItem = XplatAbstractions.INSTANCE.findManaItem(stack);
		if (manaItem != null && !ManaTabletItem.isStackCreative(stack)) {
			int currentMana = manaItem.getMana();
			int maxMana = manaItem.getMaxMana();
			components.add(ManaNumberFormatting.manaLevel(currentMana, maxMana).copy().withStyle(ChatFormatting.AQUA));
		}
		super.appendHoverText(stack, level, components, tooltipFlag);
	}
}
