package net.itsn4x.pvprefined.config;

import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import me.shedaniel.clothconfig2.gui.entries.BooleanListEntry;
import me.shedaniel.clothconfig2.gui.entries.FloatListEntry;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class PvPConfigScreen {
    public static Screen create(Screen parent) {
        ConfigBuilder builder = ConfigBuilder.create()
                .setParentScreen(parent)
                .setTitle(Component.literal("PvP Refined Settings"))
                .setSavingRunnable(PvPConfig::save);

        ConfigCategory miningCategory = builder.getOrCreateCategory(Component.literal("Mining & Desync Fixes"));
        ConfigCategory combatCategory = builder.getOrCreateCategory(Component.literal("Combat Input Fixes"));
        ConfigCategory visualCategory = builder.getOrCreateCategory(Component.literal("Visual QoL"));

        ConfigEntryBuilder entryBuilder = builder.entryBuilder();
        PvPConfig.Settings settings = PvPConfig.getSettings();

        // === MINING & DESYNC ===
        miningCategory.addEntry(entryBuilder.startBooleanToggle(
                        Component.literal("Ghost Block Fix"),
                        settings.miningDesync.ghostBlockFix
                )
                .setDefaultValue(true)
                .setTooltip(Component.literal("Prevent walking through client-broken blocks before server confirmation"))
                .setSaveConsumer(val -> settings.miningDesync.ghostBlockFix = val)
                .build());

        miningCategory.addEntry(entryBuilder.startBooleanToggle(
                        Component.literal("Container Desync Fix"),
                        settings.miningDesync.containerDesyncFix
                )
                .setDefaultValue(true)
                .setTooltip(Component.literal("Prevent items from glitching back when quickly moving items"))
                .setSaveConsumer(val -> settings.miningDesync.containerDesyncFix = val)
                .build());

        // === COMBAT INPUT ===
        combatCategory.addEntry(entryBuilder.startBooleanToggle(
                        Component.literal("Shield Visual Sync"),
                        settings.combatInput.shieldVisualSync
                )
                .setDefaultValue(true)
                .setTooltip(Component.literal("Delay shield animation to match server-side block timing"))
                .setSaveConsumer(val -> settings.combatInput.shieldVisualSync = val)
                .build());

        combatCategory.addEntry(entryBuilder.startBooleanToggle(
                        Component.literal("Fast Switch Input Buffer"),
                        settings.combatInput.fastSwitchBuffer
                )
                .setDefaultValue(true)
                .setTooltip(Component.literal("Buffer right-click after switching to shield/trident"))
                .setSaveConsumer(val -> settings.combatInput.fastSwitchBuffer = val)
                .build());

        combatCategory.addEntry(entryBuilder.startBooleanToggle(
                        Component.literal("Trident Deadlock Fix"),
                        settings.combatInput.tridentDeadlockFix
                )
                .setDefaultValue(true)
                .setTooltip(Component.literal("Reset stuck charging animations"))
                .setSaveConsumer(val -> settings.combatInput.tridentDeadlockFix = val)
                .build());

        // === VISUAL QOL ===
        visualCategory.addEntry(entryBuilder.startBooleanToggle(
                        Component.literal("Low Fire"),
                        settings.visualQoL.lowFire
                )
                .setDefaultValue(true)
                .setTooltip(Component.literal("Reduce fire overlay height"))
                .setSaveConsumer(val -> settings.visualQoL.lowFire = val)
                .build());

        visualCategory.addEntry(entryBuilder.startFloatField(
                        Component.literal("Fire Height Multiplier"),
                        settings.visualQoL.fireHeightMultiplier
                )
                .setDefaultValue(0.6f)
                .setMin(0.0f)
                .setMax(1.0f)
                .setSaveConsumer(val -> settings.visualQoL.fireHeightMultiplier = val)
                .build());

        visualCategory.addEntry(entryBuilder.startBooleanToggle(
                        Component.literal("Small Totem Pop"),
                        settings.visualQoL.smallTotemPop
                )
                .setDefaultValue(true)
                .setTooltip(Component.literal("Scale down Totem of Undying animation"))
                .setSaveConsumer(val -> settings.visualQoL.smallTotemPop = val)
                .build());

        visualCategory.addEntry(entryBuilder.startFloatField(
                        Component.literal("Totem Scale Multiplier"),
                        settings.visualQoL.totemScaleMultiplier
                )
                .setDefaultValue(0.7f)
                .setMin(0.0f)
                .setMax(1.0f)
                .setSaveConsumer(val -> settings.visualQoL.totemScaleMultiplier = val)
                .build());

        visualCategory.addEntry(entryBuilder.startBooleanToggle(
                        Component.literal("Explosion Flash Reduction"),
                        settings.visualQoL.explosionFlashReduction
                )
                .setDefaultValue(true)
                .setTooltip(Component.literal("Reduce white flash from explosions"))
                .setSaveConsumer(val -> settings.visualQoL.explosionFlashReduction = val)
                .build());

        visualCategory.addEntry(entryBuilder.startFloatField(
                        Component.literal("Explosion Flash Alpha"),
                        settings.visualQoL.explosionFlashAlpha
                )
                .setDefaultValue(0.3f)
                .setMin(0.0f)
                .setMax(1.0f)
                .setSaveConsumer(val -> settings.visualQoL.explosionFlashAlpha = val)
                .build());

        visualCategory.addEntry(entryBuilder.startBooleanToggle(
                        Component.literal("Transparent Chat Background"),
                        settings.visualQoL.transparentChatBackground
                )
                .setDefaultValue(true)
                .setTooltip(Component.literal("Reduce chat background opacity"))
                .setSaveConsumer(val -> settings.visualQoL.transparentChatBackground = val)
                .build());

        visualCategory.addEntry(entryBuilder.startFloatField(
                        Component.literal("Chat Background Alpha"),
                        settings.visualQoL.chatBackgroundAlpha
                )
                .setDefaultValue(0.2f)
                .setMin(0.0f)
                .setMax(1.0f)
                .setSaveConsumer(val -> settings.visualQoL.chatBackgroundAlpha = val)
                .build());

        return builder.build();
    }
}
