package com.eztouch.skinner.handler;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;

import com.eztouch.skinner.client.settings.Keybindings;
import com.eztouch.skinner.look.ChangeLook;
import com.eztouch.skinner.reference.Key;

public class KeyInputEventHandler
{

	private static Key getPressedKeybinding()
	{
		ChangeLook newChange;
		if (Keybindings.change.isPressed())
		{
			newChange = new ChangeLook("static");
			return Key.CHANGE;
		} else if (Keybindings.random.isPressed())
		{
			newChange = new ChangeLook("random");
			return Key.RANDOM;
		} else if (Keybindings.dynamic.isPressed())
		{
			newChange = new ChangeLook("dynamic");
			return Key.DYNAMIC;
		} else
		{
			return Key.UNKNOWN;
		}
	}

	@SubscribeEvent
	public void handleKeyInputEvent(InputEvent.KeyInputEvent event)
	{
		getPressedKeybinding();
	}
}
