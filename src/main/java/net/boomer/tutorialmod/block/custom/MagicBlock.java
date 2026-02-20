package net.boomer.tutorialmod.block.custom;

import net.boomer.tutorialmod.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class MagicBlock extends Block {
    public MagicBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player,
                                 BlockHitResult hit) {
        world.playSound(player, pos, SoundEvents.BLOCK_BEACON_AMBIENT, SoundCategory.BLOCKS, 3f, 1f);
        return ActionResult.SUCCESS;
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (entity instanceof ItemEntity itemEntity) {
            if (itemEntity.getStack().getItem() == ModItems.JAIL_BIRD) {
                itemEntity.setStack(new ItemStack(Items.DIAMOND, itemEntity.getStack().getCount()));
            }
        }

        super.onSteppedOn(world, pos, state, entity);
    }

    @Override //do append public void to get this
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {
        tooltip.add(Text.translatable("tooltip.tutorial-mod.magic_block.tooltip"));
        tooltip.add(Text.translatable("tooltip.tutorial-mod.magic_block.tooltip.1"));
        super.appendTooltip(stack, context, tooltip, options);
    }
}
