package com.eztouch.skinner.proxy;

import com.eztouch.skinner.client.settings.Keybindings;
import net.minecraftforge.fml.client.registry.ClientRegistry;

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