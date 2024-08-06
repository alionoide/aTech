package com.alionoide.atech.blocks;

import com.alionoide.atech.BlocksRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class CrusherBlockEntity extends BlockEntity {
    public CrusherBlockEntity(BlockPos pos, BlockState state) {
        super(BlocksRegistry.CRUSHER_BE.get(), pos, state);
    }



}
