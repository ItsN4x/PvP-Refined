package net.itsn4x.pvprefined.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class PvPConfig {
    private static final Logger LOGGER = LoggerFactory.getLogger("PvP Refined Config");
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final Path CONFIG_DIR = FabricLoader.getInstance().getConfigDir().resolve("pvprefined");
    private static final Path CONFIG_FILE = CONFIG_DIR.resolve("pvprefined.json");

    // === MINING & DESYNC FIXES ===
    public static class MiningDesyncSettings {
        public boolean ghostBlockFix = true;
        public boolean containerDesyncFix = true;
    }

    // === COMBAT INPUT FIXES ===
    public static class CombatInputSettings {
        public boolean shieldVisualSync = true;
        public boolean fastSwitchBuffer = true;
        public boolean tridentDeadlockFix = true;
    }

    // === VISUAL QOL ===
    public static class VisualQoLSettings {
        public boolean lowFire = true;
        public float fireHeightMultiplier = 0.6f; // 0.0-1.0
        public boolean smallTotemPop = true;
        public float totemScaleMultiplier = 0.7f; // 0.0-1.0
        public boolean explosionFlashReduction = true;
        public float explosionFlashAlpha = 0.3f; // 0.0-1.0
        public boolean transparentChatBackground = true;
        public float chatBackgroundAlpha = 0.2f; // 0.0-1.0
    }

    public static class Settings {
        public boolean enabled = true;
        public MiningDesyncSettings miningDesync = new MiningDesyncSettings();
        public CombatInputSettings combatInput = new CombatInputSettings();
        public VisualQoLSettings visualQoL = new VisualQoLSettings();
    }

    private static Settings settings = new Settings();

    public static void load() {
        try {
            Files.createDirectories(CONFIG_DIR);
        } catch (IOException e) {
            LOGGER.error("Failed to create config directory", e);
        }

        if (CONFIG_FILE.toFile().exists()) {
            try (FileReader reader = new FileReader(CONFIG_FILE.toFile())) {
                settings = GSON.fromJson(reader, Settings.class);
                LOGGER.info("PvP Refined config loaded successfully");
            } catch (IOException e) {
                LOGGER.error("Failed to load config, using defaults", e);
                settings = new Settings();
                save();
            }
        } else {
            save();
            LOGGER.info("Created new PvP Refined config");
        }
    }

    public static void save() {
        try (FileWriter writer = new FileWriter(CONFIG_FILE.toFile())) {
            GSON.toJson(settings, writer);
            LOGGER.info("PvP Refined config saved");
        } catch (IOException e) {
            LOGGER.error("Failed to save config", e);
        }
    }

    public static Settings getSettings() {
        return settings;
    }

    // === GETTERS ===

    // Mining & Desync
    public static boolean isGhostBlockFixEnabled() {
        return settings.enabled && settings.miningDesync.ghostBlockFix;
    }

    public static boolean isContainerDesyncFixEnabled() {
        return settings.enabled && settings.miningDesync.containerDesyncFix;
    }

    // Combat Input
    public static boolean isShieldVisualSyncEnabled() {
        return settings.enabled && settings.combatInput.shieldVisualSync;
    }

    public static boolean isFastSwitchBufferEnabled() {
        return settings.enabled && settings.combatInput.fastSwitchBuffer;
    }

    public static boolean isTridentDeadlockFixEnabled() {
        return settings.enabled && settings.combatInput.tridentDeadlockFix;
    }

    // Visual QoL
    public static boolean isLowFireEnabled() {
        return settings.enabled && settings.visualQoL.lowFire;
    }

    public static float getFireHeightMultiplier() {
        return settings.visualQoL.fireHeightMultiplier;
    }

    public static boolean isSmallTotemPopEnabled() {
        return settings.enabled && settings.visualQoL.smallTotemPop;
    }

    public static float getTotemScaleMultiplier() {
        return settings.visualQoL.totemScaleMultiplier;
    }

    public static boolean isExplosionFlashReductionEnabled() {
        return settings.enabled && settings.visualQoL.explosionFlashReduction;
    }

    public static float getExplosionFlashAlpha() {
        return settings.visualQoL.explosionFlashAlpha;
    }

    public static boolean isTransparentChatBackgroundEnabled() {
        return settings.enabled && settings.visualQoL.transparentChatBackground;
    }

    public static float getChatBackgroundAlpha() {
        return settings.visualQoL.chatBackgroundAlpha;
    }
}
