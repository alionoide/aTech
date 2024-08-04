package com.alionoide.atech;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class BlocksRegistry {
    // Create a Deferred Register to hold Blocks which will all be registered under the "atech" namespace
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(ATech.MODID);
    public static final DeferredRegister.Items BLOCK_ITEMS = DeferredRegister.createItems(ATech.MODID);

    public static final DeferredBlock<Block> ALIENIUM_ORE = BLOCKS.registerSimpleBlock("alienium_ore", BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_GREEN)
            .destroyTime(4.5f)
            .explosionResistance(12f)
            .sound(SoundType.STONE));
    public static final DeferredItem<BlockItem> ALIENIUM_ORE_ITEM = BLOCK_ITEMS.registerSimpleBlockItem("alienium_ore", BlocksRegistry.ALIENIUM_ORE);

    public static final DeferredBlock<Block> RAW_ALIENIUM_BLOCK = BLOCKS.registerSimpleBlock("raw_alienium_block", BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_GREEN)
            .destroyTime(4.5f)
            .explosionResistance(12f)
            .sound(SoundType.STONE));
    public static final DeferredItem<BlockItem> RAW_ALIENIUM_BLOCK_ITEM = BLOCK_ITEMS.registerSimpleBlockItem("raw_alienium_block", BlocksRegistry.RAW_ALIENIUM_BLOCK);

    public static final DeferredBlock<Block> ALIENIUM_BLOCK = BLOCKS.registerSimpleBlock("alienium_block", BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_GREEN)
            .destroyTime(7.5f)
            .explosionResistance(20f)
            .sound(SoundType.METAL));
    public static final DeferredItem<BlockItem> ALIENIUM_BLOCK_ITEM = BLOCK_ITEMS.registerSimpleBlockItem("alienium_block", BlocksRegistry.ALIENIUM_BLOCK);
}
