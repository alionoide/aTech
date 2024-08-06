package com.alionoide.atech.datagen;

import com.alionoide.atech.ATech;
import com.alionoide.atech.BlocksRegistry;
import net.minecraft.data.PackOutput;
import net.minecraft.data.models.ModelProvider;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModelGenerator extends BlockStateProvider {
    public ModelGenerator(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ATech.MODID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {


        simpleSimpleBlock(BlocksRegistry.ALIENIUM_BLOCK.get()); //, models().cubeAll("alienium_block", modLoc("block/alienium_block")));
        simpleSimpleBlock(BlocksRegistry.RAW_ALIENIUM_BLOCK.get()); //, models().cubeAll("raw_alienium_block", modLoc("block/raw_alienium_block")));
        simpleSimpleBlock(BlocksRegistry.ALIENIUM_ORE.get()); //, models().cubeAll("alienium", modLoc("block/alienium")));
        simpleSimpleBlock(BlocksRegistry.CRUSHER.get()); //, models().cubeAll("alienium", modLoc("block/alienium")));
    }

    private void simpleSimpleBlock(Block block)
    {
        simpleBlockWithItem(block, models().cubeAll(block.getDescriptionId().split("[.]")[2], modLoc("block/" + block.getDescriptionId().split("[.]")[2])));
    }
}

