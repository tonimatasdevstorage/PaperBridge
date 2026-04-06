package net.ethenehosting.bridge;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PaperBridge implements ModInitializer {
	public static final String MOD_ID = "paper_bridge";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("PaperBridge has been initialized!");
	}
}