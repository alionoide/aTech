package com.alionoide.atech.datagen;

import com.alionoide.atech.ATech;
import com.alionoide.atech.BlocksRegistry;
import com.alionoide.atech.ItemsRegistry;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import java.util.concurrent.CompletableFuture;

public class RecipeGenerator extends RecipeProvider {
    public RecipeGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider);
    }

    @Override
    protected void buildRecipes(RecipeOutput output) {
        // Alienium block from ingots
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlocksRegistry.ALIENIUM_BLOCK_ITEM)
                .pattern("XXX")
                .pattern("XXX")
                .pattern("XXX")
                .define('X', ItemsRegistry.ALIENIUM_INGOT)
                .unlockedBy("has_alienium_ingot", has(ItemsRegistry.ALIENIUM_INGOT))
                .save(output);

        // Alienium ingots from block
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemsRegistry.ALIENIUM_INGOT, 9)
                .requires(BlocksRegistry.ALIENIUM_BLOCK_ITEM)
                .unlockedBy("has_alienium_block", has(BlocksRegistry.ALIENIUM_BLOCK_ITEM))
                .save(output, ResourceLocation.fromNamespaceAndPath(ATech.MODID, "alienium_ingot_from_block_crafting"));

        // Raw alienium block from ore
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlocksRegistry.RAW_ALIENIUM_BLOCK_ITEM)
                .pattern("XXX")
                .pattern("XXX")
                .pattern("XXX")
                .define('X', ItemsRegistry.RAW_ALIENIUM)
                .unlockedBy("has_raw_alienium", has(ItemsRegistry.RAW_ALIENIUM))
                .save(output);

        // Raw alienium from block
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemsRegistry.RAW_ALIENIUM, 9)
                .requires(BlocksRegistry.RAW_ALIENIUM_BLOCK_ITEM)
                .unlockedBy("has_raw_alienium_block", has(BlocksRegistry.RAW_ALIENIUM_BLOCK_ITEM))
                .save(output);

        // Smelting alienium ore (item/block)
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ItemsRegistry.RAW_ALIENIUM), RecipeCategory.MISC, ItemsRegistry.ALIENIUM_INGOT, 2f, 200)
                .unlockedBy("has_raw_alienium", has(ItemsRegistry.RAW_ALIENIUM))
                .save(output, ResourceLocation.fromNamespaceAndPath(ATech.MODID, "alienium_ingot_from_raw_smelting"));
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(ItemsRegistry.RAW_ALIENIUM), RecipeCategory.MISC, ItemsRegistry.ALIENIUM_INGOT, 2f, 200)
                .unlockedBy("has_raw_alienium", has(ItemsRegistry.RAW_ALIENIUM))
                .save(output, ResourceLocation.fromNamespaceAndPath(ATech.MODID, "alienium_ingot_from_raw_blasting"));

        // TODO: - This one isnt working?
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(BlocksRegistry.ALIENIUM_ORE_ITEM), RecipeCategory.MISC, ItemsRegistry.ALIENIUM_INGOT, 2f, 200)
                .unlockedBy("has_alienium_ore", has(BlocksRegistry.ALIENIUM_ORE_ITEM))
                .save(output, ResourceLocation.fromNamespaceAndPath(ATech.MODID, "alienium_ingot_from_ore_smelting"));
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(BlocksRegistry.ALIENIUM_ORE_ITEM), RecipeCategory.MISC, ItemsRegistry.ALIENIUM_INGOT, 2f, 200)
                .unlockedBy("has_alienium_ore", has(BlocksRegistry.ALIENIUM_ORE_ITEM))
                .save(output, ResourceLocation.fromNamespaceAndPath(ATech.MODID, "alienium_ingot_from_ore_blasting"));
    }
}

