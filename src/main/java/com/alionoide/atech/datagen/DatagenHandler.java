package com.alionoide.atech.datagen;

import com.alionoide.atech.ATech;
import com.mojang.logging.LogUtils;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import org.slf4j.Logger;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, modid = ATech.MODID)
public class DatagenHandler {

    private static final Logger LOGGER = LogUtils.getLogger();

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        // Data generators may require some of these as constructor parameters.
        // See below for more details on each of these.
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        // Recipes
        generator.addProvider(
                event.includeServer(),
                new RecipeGenerator(output, lookupProvider)
        );
        // Language
        generator.addProvider(
                event.includeClient(),
                new LanguageGenerator(output)
        );
        // Models
        generator.addProvider(
                event.includeClient(),
                new ModelGenerator(output, existingFileHelper)
        );

        LOGGER.info("aTech: Datagen finished!");
    }
}
