package com.eztouch.skinner.proxy;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.item.Item;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;

import com.eztouch.skinner.client.settings.Keybindings;
import com.eztouch.skinner.handler.TickingHandler;
import com.eztouch.skinner.look.ChangeLook;

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