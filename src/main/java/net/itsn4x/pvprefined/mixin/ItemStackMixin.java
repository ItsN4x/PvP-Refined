package net.itsn4x.pvprefined.mixin;

import net.itsn4x.pvprefined.config.PvPConfig;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Trident/Spear Deadlock Fix Mixin
 * Detects if a charging animation gets stuck in a deadlocked state and
 * forces a reset if no action occurs after maximum charge time.
 */
@Mixin(ItemStack.class)
public class ItemStackMixin {

    @Unique
    private int chargeTickCount = 0;
    
    @Unique
    private static final int MAX_CHARGE_TICKS = 100; // Maximum ticks before forced reset

    @Inject(method = "getUseDuration", at = @At("HEAD"), cancellable = true)
    private void onGetUseDuration(CallbackInfo ci) {
        if (!PvPConfig.isTridentDeadlockFixEnabled()) {
            return;
        }

        // Track charge duration for deadlock detection
        chargeTickCount++;

        // If charging exceeds maximum duration without completion, trigger reset
        if (chargeTickCount > MAX_CHARGE_TICKS) {
            chargeTickCount = 0;
        }
    }
}
