package com.eztouch.skinner.handler;

import net.minecraft.client.gui.GuiCustomizeSkin;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EnumPlayerModelParts;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;

import com.eztouch.skinner.client.settings.Keybindings;
import com.eztouch.skinner.look.ChangeLook;
import com.eztouch.skinner.reference.Key;
import com.eztouch.skinner.utility.LogHelper;

public class KeyInputEventHandler
{

	private static Key getPressedKeybinding()
	{
		if (Keybindings.change.isPressed())
		{
			ChangeLook newChange = new ChangeLook("static");
			LogHelper.info("tried to change the skin");
			return Key.CHANGE;
		} else if (Keybindings.random.isPressed())
		{
			return Key.RANDOM;
		} else if (Keybindings.dynamic.isPressed())
		{
			return Key.DYNAMIC;
		} else
		{
			return Key.UNKNOWN;
		}
	}

	@SubscribeEvent
	public void handleKeyInputEvent(InputEvent.KeyInputEvent event)
	{
		/*LogHelper.info(*/getPressedKeybinding()/*)*/;
	}
}
