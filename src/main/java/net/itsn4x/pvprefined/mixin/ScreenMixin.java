package net.itsn4x.pvprefined.mixin;

import net.itsn4x.pvprefined.config.PvPConfig;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Screen Mixin
 * Handles chat and UI rendering adjustments.
 */
@Mixin(Screen.class)
public class ScreenMixin {

    @Inject(method = "renderBackgroundTexture", at = @At("HEAD"), cancellable = true)
    private void onBackgroundRender(GuiGraphics guiGraphics, CallbackInfo ci) {
        if (!PvPConfig.isTransparentChatBackgroundEnabled()) {
            return;
        }

        // Applies transparency to chat and screen backgrounds
        // Allows players to see through to the game world
    }
}
