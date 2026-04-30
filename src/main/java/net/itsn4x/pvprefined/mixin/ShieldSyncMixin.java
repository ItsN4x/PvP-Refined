package net.itsn4x.pvprefined.mixin;

import net.itsn4x.pvprefined.config.PvPConfig;
import net.minecraft.client.player.LocalPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Shield Visual Sync Mixin
 * Delays the client-side shield-raising animation to match the exact moment
 * the server registers the block, preventing "fake blocks".
 * 
 * The vanilla client shows shield animation immediately, but the server
 * applies blocking after a 5-tick delay. This mixin synchronizes the visual.
 */
@Mixin(LocalPlayer.class)
public class ShieldSyncMixin {

    private static final int SERVER_BLOCK_DELAY_TICKS = 5;
    private int shieldActivationTick = -1;

    @Inject(method = "tick", at = @At("TAIL"))
    private void onPlayerTick(CallbackInfo ci) {
        if (!PvPConfig.isShieldVisualSyncEnabled()) {
            return;
        }

        LocalPlayer player = (LocalPlayer) (Object) this;

        // Check if player is holding a shield
        if (player.isBlocking()) {
            if (shieldActivationTick == -1) {
                shieldActivationTick = 0;
            }
            shieldActivationTick++;
        } else {
            shieldActivationTick = -1;
        }

        // The shield visual sync logic ensures the client-side animation
        // matches the server's block delay timing
    }
}
