package com.alionoide.atech;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ItemsRegistry {
    // Create a Deferred Register to hold Items which will all be registered under the "atech" namespace
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ATech.MODID);


    // Creates a new food item with the id "atech:example_id", nutrition 1 and saturation 2
    public static final DeferredItem<Item> RAW_ALIENIUM = ITEMS.registerSimpleItem("raw_alienium", new Item.Properties().stacksTo(65));
    public static final DeferredItem<Item> ALIENIUM_INGOT = ITEMS.registerSimpleItem("alienium_ingot", new Item.Properties().stacksTo(65));
}
