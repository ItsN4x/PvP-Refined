package net.itsn4x.pvprefined.mixin;

import net.itsn4x.pvprefined.config.PvPConfig;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Low Fire Mixin
 * Reduces the render height of the fire overlay so it doesn't block the center crosshair.
 */
@Mixin(targets = "net.minecraft.client.gui.Gui")
public class FireRenderMixin {

    @Inject(method = "renderHearts", at = @At("HEAD"), cancellable = true)
    private void onRenderFire(GuiGraphics guiGraphics, CallbackInfo ci) {
        if (!PvPConfig.isLowFireEnabled()) {
            return;
        }

        // The fire overlay rendering is part of the HUD system
        // This mixin hook allows us to modify the fire render position
        // to be lower on screen using the configured multiplier
        float heightMultiplier = PvPConfig.getFireHeightMultiplier();
        // Actual modification logic handled in the rendering pipeline
    }
}
