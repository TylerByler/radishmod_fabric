package net.tyler.radishmod.screen;

import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.screen.ScreenHandlerType;

public class ModScreenHandlers {
    public static ScreenHandlerType<RadishCrateScreenHandler> RADISH_CRATE_SCREEN_HANDLER;

    public static void registerAllScreenHandlers() {
        RADISH_CRATE_SCREEN_HANDLER = new ScreenHandlerType<>(RadishCrateScreenHandler::new, FeatureSet.empty());
    }
}
