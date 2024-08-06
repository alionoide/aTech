package com.alionoide.atech.datagen;

import com.alionoide.atech.ATech;
import com.alionoide.atech.BlocksRegistry;
import com.alionoide.atech.ItemsRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.data.LanguageProvider;

import java.util.concurrent.CompletableFuture;

public class LanguageGenerator extends LanguageProvider {
    public LanguageGenerator(PackOutput output) {
        super(output, ATech.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        addItem(ItemsRegistry.ALIENIUM_INGOT, "Alienium Ingot");
        addItem(ItemsRegistry.RAW_ALIENIUM, "Raw Alienium");

        addBlock(BlocksRegistry.CRUSHER, "Crushulverator");
        addBlock(BlocksRegistry.ALIENIUM_BLOCK, "Alienium Block");
        addBlock(BlocksRegistry.RAW_ALIENIUM_BLOCK, "Raw Alienium Block");
        addBlock(BlocksRegistry.ALIENIUM_ORE, "Alienium Ore");

        add("itemGroup.atech_tab", "aTech");
    }
}

