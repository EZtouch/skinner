package com.eztouch.skinner.client.settings;

import com.eztouch.skinner.reference.Names;
import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Keyboard;

public class Keybindings
{
    public static final KeyBinding random = new KeyBinding(Names.Keys.RANDOM,
            Keyboard.KEY_R, Names.Keys.CATEGORY);
    public static final KeyBinding change = new KeyBinding(Names.Keys.CHANGE,
            Keyboard.KEY_C, Names.Keys.CATEGORY);
    public static final KeyBinding dynamic = new KeyBinding(Names.Keys.DYNAMIC,
            Keyboard.KEY_O, Names.Keys.CATEGORY);
}