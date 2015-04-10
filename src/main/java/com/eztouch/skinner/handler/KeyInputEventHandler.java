package com.eztouch.skinner.handler;

import com.eztouch.skinner.client.settings.Keybindings;
import com.eztouch.skinner.look.ChangeLook;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;

public class KeyInputEventHandler
{

    private static void getPressedKeybinding()
    {
        ChangeLook newChange;
        if (Keybindings.change.isPressed())
        {
            newChange = new ChangeLook("change");
        } else if (Keybindings.random.isPressed())
        {
            newChange = new ChangeLook("random");
        } else if (Keybindings.dynamic.isPressed())
        {
            newChange = new ChangeLook("dynamic");
        } else if (Keybindings.morph.isPressed())
        {
            MorphingHandler.Morph("others");
        } else if (Keybindings.normal.isPressed())
        {
        	MorphingHandler.Morph("self");
        }
    }

    @SubscribeEvent
    public void handleKeyInputEvent(InputEvent.KeyInputEvent event)
    {
        getPressedKeybinding();
    }
}
