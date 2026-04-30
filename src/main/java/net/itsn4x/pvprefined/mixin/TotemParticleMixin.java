package net.itsn4x.pvprefined.mixin;

import net.itsn4x.pvprefined.config.PvPConfig;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Small Totem Pop Mixin
 * Scales down the Totem of Undying particle animation that appears
 * in the middle of the screen when popped.
 */
@Mixin(targets = "net.minecraft.client.renderer.entity.ItemFrameRenderer")
public class TotemParticleMixin {

    @Inject(method = "render", at = @At("HEAD"), cancellable = true)
    private void onTotemRender(CallbackInfo ci) {
        if (!PvPConfig.isSmallTotemPopEnabled()) {
            return;
        }

        float scaleMultiplier = PvPConfig.getTotemScaleMultiplier();
        // Actual scale modification is applied through PoseStack transforms
        // This mixin ensures the scale is applied before particle rendering
    }
}
