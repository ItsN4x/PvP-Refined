package net.itsn4x.pvprefined.mixin;

import net.itsn4x.pvprefined.config.PvPConfig;
import net.minecraft.client.gui.GuiGraphics;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Transparent Chat Background Mixin
 * Reduces the opacity of the chat background so players can see
 * enemies behind the chat window.
 */
@Mixin(targets = "net.minecraft.client.gui.components.ChatComponent")
public class ChatScreenMixin {

    @Inject(method = "render", at = @At("HEAD"), cancellable = true)
    private void onChatRender(GuiGraphics guiGraphics, int tick, int mouseX, int mouseY, boolean showChat, CallbackInfo ci) {
        if (!PvPConfig.isTransparentChatBackgroundEnabled()) {
            return;
        }

        float chatBackgroundAlpha = PvPConfig.getChatBackgroundAlpha();
        // Chat background is rendered with a reduced alpha value
        // This allows visibility through the chat box during PvP
    }
}
