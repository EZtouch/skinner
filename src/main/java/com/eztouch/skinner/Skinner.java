package com.eztouch.skinner;

import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import com.eztouch.skinner.handler.ConfigurationHandler;
import com.eztouch.skinner.handler.KeyInputEventHandler;
import com.eztouch.skinner.proxy.ClientProxy;
import com.eztouch.skinner.proxy.IProxy;
import com.eztouch.skinner.reference.Reference;
import com.eztouch.skinner.utility.LogHelper;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class Skinner
{
	@Mod.Instance(Reference.MOD_ID)
	public static Skinner instance;

	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static IProxy proxy;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		ConfigurationHandler.init(event.getSuggestedConfigurationFile());
		FMLCommonHandler.instance().bus().register(new ConfigurationHandler());

		proxy.registerKeyBindings();

		ClientProxy clientP = new ClientProxy();
		clientP.registerKeyBindings();

		LogHelper.info("Pre Initialization Complete");
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event)
	{
		FMLCommonHandler.instance().bus().register(new KeyInputEventHandler());
		LogHelper.info("Initialization Complete");
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		LogHelper.info("Post Initialization Complete");
	}

}
