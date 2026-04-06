package dev.tonimatas;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Ethylene implements ModInitializer {
	public static final String MOD_ID = "ethylene";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Ethylene has been initialized!");
	}
}