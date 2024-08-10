package com.alionoide.atech.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class CrusherBlock extends Block implements EntityBlock {
    public CrusherBlock(Properties properties) {
        super(properties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new CrusherBlockEntity(pPos, pState);
    }

    @Override
    public InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult result) {
        if (!level.isClientSide()) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity instanceof CrusherBlockEntity) {
                NetworkHooks.openScreen((ServerPlayer) player, (CrusherBlockEntity) blockEntity, pos);
            } else {
                throw new IllegalStateException("Our Container provider is missing!");
            }
        }
        return InteractionResult.SUCCESS;
    }
}