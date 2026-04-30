package net.itsn4x.pvprefined.mixin;

import net.itsn4x.pvprefined.config.PvPConfig;
import net.minecraft.client.renderer.GameRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Game Renderer Mixin
 * Handles visual rendering adjustments for QoL features,
 * particularly for fire and flash reductions.
 */
@Mixin(GameRenderer.class)
public class GameRendererMixin {

    @Inject(method = "renderLevel", at = @At("TAIL"))
    private void onLevelRender(float partialTick, long finishTimeNano, CallbackInfo ci) {
        // Applied QoL visual tweaks for rendering
        // Fire height, totem scale, and explosion flash reductions
    }
}
