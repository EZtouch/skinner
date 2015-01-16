package com.eztouch.skinner.handler;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import com.eztouch.skinner.reference.Reference;

public class ConfigurationHandler
{
	public static Configuration configuration;
	public static boolean testValue = false;

	public static void init(File configFile)
	{
		// create the configuration object from the given configuration file
		if (configuration == null)
		{
			configuration = new Configuration(configFile);
			loadConfiguration();
		}
	}

	@SubscribeEvent
	public void onConfigurationChangedEvent(
			ConfigChangedEvent.OnConfigChangedEvent event)
	{
		if (event.modID.equalsIgnoreCase(Reference.MOD_ID))
		{
			loadConfiguration();
		}
	}

	private static void loadConfiguration()
	{
		testValue = configuration.getBoolean("configValue",
				configuration.CATEGORY_GENERAL, false,
				"This is an example configuration value");

		if (configuration.hasChanged())
		{
			configuration.save();
		}
	}
}
