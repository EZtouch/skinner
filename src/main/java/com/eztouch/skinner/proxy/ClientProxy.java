package com.eztouch.skinner.proxy;

import net.minecraftforge.fml.client.registry.ClientRegistry;

import com.eztouch.skinner.client.settings.Keybindings;

public class ClientProxy extends CommonProxy
{
	@Override
	public void registerKeyBindings()
	{
		ClientRegistry.registerKeyBinding(Keybindings.change);
		ClientRegistry.registerKeyBinding(Keybindings.dynamic);
		ClientRegistry.registerKeyBinding(Keybindings.random);
	}
}