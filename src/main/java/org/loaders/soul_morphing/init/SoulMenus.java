package org.loaders.soul_morphing.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.loaders.soul_morphing.hud.VoidFurnaceGuiMenu;

import static org.loaders.soul_morphing.Soul_morphing.MODID;

public class SoulMenus {
    public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, MODID);
    public static final DeferredHolder<MenuType<?>, MenuType<VoidFurnaceGuiMenu>> VOID_FURNACE_GUI = REGISTRY.register("void_furnace_gui", () -> IMenuTypeExtension.create(VoidFurnaceGuiMenu::new));
}

