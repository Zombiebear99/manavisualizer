package org.zombie.manavisualizer.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vazkii.botania.api.block_entity.GeneratingFlowerBlockEntity;
import vazkii.botania.api.mana.ManaPool;

import java.util.List;

public class ManaReaderItem extends Item {
    public ManaReaderItem(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable Level level, @NotNull List<Component> components, @NotNull TooltipFlag flag) {
        if (!Screen.hasShiftDown()){
            components.add(Component.literal("right click on mana pool or mana generating flower to see how much it is full in numbers").withStyle(ChatFormatting.AQUA));
        }
        super.appendHoverText(stack, level, components, flag);
    }
    public InteractionResult onItemUseFirst(ItemStack stack, UseOnContext context) {
        Level world = context.getLevel();
        BlockPos pos = context.getClickedPos();
        BlockState state = world.getBlockState(pos);
        BlockEntity tile = world.getBlockEntity(pos);

        InteractionResult result = InteractionResult.PASS;

        if (context.getPlayer() instanceof ServerPlayer player) {
            if (tile instanceof ManaPool) {
                StringBuilder msg = new StringBuilder();
                msg.append("mana in pool");
                int cur = ((ManaPool) tile).getCurrentMana();
                msg.append(" : ").append(cur);
                int max = 0;
                max = ((ManaPool) tile).getMaxMana(); // Replace with your actual max mana value
                if (max > 0) {
                    msg.append(" / ").append(max);
                }
                msg.append(" [mana]");

                player.sendSystemMessage(Component.literal(msg.toString()));
                result = InteractionResult.SUCCESS;
            }
            if (tile instanceof GeneratingFlowerBlockEntity) {
                StringBuilder msg1 = new StringBuilder();
                msg1.append("mana in flower");
                int cur = ((GeneratingFlowerBlockEntity) tile).getMana();
                msg1.append(" : ").append(cur);
                int max = 0;
                max = ((GeneratingFlowerBlockEntity) tile).getMaxMana(); // Replace with your actual max mana value
                if (max > 0) {
                    msg1.append(" / ").append(max);
                }
                msg1.append(" [mana]");

                player.sendSystemMessage(Component.literal(msg1.toString()));
                result = InteractionResult.SUCCESS;
            }
        }

        return super.onItemUseFirst(stack, context);
    }
}
