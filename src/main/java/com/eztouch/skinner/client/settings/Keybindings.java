package com.eztouch.skinner.client.settings;

import net.minecraft.client.settings.KeyBinding;

import org.lwjgl.input.Keyboard;

import com.eztouch.skinner.reference.Names;

public class Keybindings
{
	public static KeyBinding random = new KeyBinding(Names.Keys.RANDOM, Keyboard.KEY_C, Names.Keys.CATEGORY);
	public static KeyBinding change = new KeyBinding(Names.Keys.CHANGE, Keyboard.KEY_R, Names.Keys.CATEGORY);
	public static KeyBinding dynamic = new KeyBinding(Names.Keys.DYNAMIC, Keyboard.KEY_L, Names.Keys.CATEGORY);
}