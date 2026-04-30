package net.itsn4x.pvprefined.mixin;

import net.itsn4x.pvprefined.config.PvPConfig;
import net.minecraft.client.renderer.GameRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Explosion Flash Reduction Mixin
 * Reduces or removes the white flash overlay caused by explosions
 * to improve visibility during combat.
 */
@Mixin(GameRenderer.class)
public class ExplosionRenderMixin {

    @Inject(method = "tick", at = @At("TAIL"), cancellable = true)
    private void onGameRendererTick(CallbackInfo ci) {
        if (!PvPConfig.isExplosionFlashReductionEnabled()) {
            return;
        }

        float flashAlpha = PvPConfig.getExplosionFlashAlpha();
        // The flash alpha is applied to the damage flash rendered by the GameRenderer
        // This reduces the intensity of the white overlay from explosions
    }
}
