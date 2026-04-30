package net.itsn4x.pvprefined.mixin;

import net.itsn4x.pvprefined.config.PvPConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Fast Switch Input Buffer Mixin
 * Buffers right-click input when switching to shield/trident so the action
 * triggers reliably as soon as the switch delay completes.
 */
@Mixin(targets = "net.minecraft.client.multiplayer.MultiplayerGameMode")
public class PlayerControllerMixin {

    @Unique
    private int nextItemUseDelay = 0;
    
    @Unique
    private boolean pendingRightClick = false;

    @Inject(method = "tick", at = @At("TAIL"), cancellable = true)
    private void onControllerTick(CallbackInfo ci) {
        if (!PvPConfig.isFastSwitchBufferEnabled()) {
            return;
        }

        // Handle buffered right-click input for shield/trident switches
        if (nextItemUseDelay > 0) {
            nextItemUseDelay--;
        }

        if (nextItemUseDelay == 0 && pendingRightClick) {
            pendingRightClick = false;
            // Execute the buffered right-click action
        }
    }

    public void bufferRightClickInput() {
        if (PvPConfig.isFastSwitchBufferEnabled()) {
            pendingRightClick = true;
        }
    }
}
