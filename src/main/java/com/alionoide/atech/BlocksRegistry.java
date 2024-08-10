package com.alionoide.atech;

import com.alionoide.atech.blocks.CrusherBlockEntity;
import com.alionoide.atech.blocks.CrusherBlock;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class BlocksRegistry {
    // Create a Deferred Register to hold Blocks which will all be registered under the "atech" namespace
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(ATech.MODID);
    public static final DeferredRegister.Items BLOCK_ITEMS = DeferredRegister.createItems(ATech.MODID);
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, ATech.MODID);

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


    public static final DeferredBlock<CrusherBlock> CRUSHER = BLOCKS.registerBlock("crusher", CrusherBlock::new, BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_GRAY)
            .destroyTime(10f)
            .explosionResistance(30f)
            .sound(SoundType.METAL));
    public static final DeferredItem<BlockItem> CRUSHER_ITEM = BLOCK_ITEMS.registerSimpleBlockItem("crusher", BlocksRegistry.CRUSHER);
    public static final Supplier<BlockEntityType<CrusherBlockEntity>> CRUSHER_BE = BLOCK_ENTITIES.register("crusher_be", () -> BlockEntityType.Builder.of(CrusherBlockEntity::new, CRUSHER.get()).build(null));
}
