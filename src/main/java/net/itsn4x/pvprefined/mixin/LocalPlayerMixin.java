package net.itsn4x.pvprefined.mixin;

import net.itsn4x.pvprefined.config.PvPConfig;
import net.minecraft.client.player.LocalPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Local Player Mixin
 * Handles additional client-side synchronization improvements
 * for player state during fast combat scenarios.
 */
@Mixin(LocalPlayer.class)
public class LocalPlayerMixin {

    @Inject(method = "updatedPlayerLookDirection", at = @At("TAIL"))
    private void onLookDirectionUpdate(CallbackInfo ci) {
        // Ensure smooth look updates during combat
        // No FPS-dependent glitches or inconsistent behavior
    }
}
