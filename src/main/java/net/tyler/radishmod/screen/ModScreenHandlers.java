package net.tyler.radishmod.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.tyler.radishmod.RadishMod;

public class ModScreenHandlers {
    public static ScreenHandlerType<RadishCrateScreenHandler> RADISH_CRATE_SCREEN_HANDLER;

    public static void registerAllScreenHandlers() {
        RADISH_CRATE_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier(RadishMod.MOD_ID, "radish_crate"), RadishCrateScreenHandler::new);
    }
}
