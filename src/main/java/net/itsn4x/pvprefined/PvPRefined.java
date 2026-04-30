package net.itsn4x.pvprefined;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents;
import net.itsn4x.pvprefined.config.PvPConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PvPRefined implements ClientModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("PvP Refined");
	public static final String MOD_ID = "pvprefined";

	@Override
	public void onInitializeClient() {
		LOGGER.info("PvP Refined initializing for Minecraft 1.21.1");
		LOGGER.info("Client-side only mod - safe for strict anti-cheat servers");

		// Load configuration
		PvPConfig.load();

		// Register event listeners
		ClientLifecycleEvents.CLIENT_STARTED.register(client -> {
			LOGGER.info("PvP Refined loaded successfully");
		});

		LOGGER.info("PvP Refined initialization complete");
	}
}
