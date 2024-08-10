package com.alionoide.atech;

import com.alionoide.atech.menus.CrusherMenu;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class MenuRegistry {

    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(BuiltInRegistries.MENU, ATech.MODID);

    public static final Supplier<MenuType<CrusherMenu>> CRUSHER_MENU = MENUS.register("crusher_menu", () -> new MenuType(CrusherMenu::new, FeatureFlags.DEFAULT_FLAGS));
}
