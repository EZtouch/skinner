package com.eztouch.skinner.look;

import java.util.ArrayList;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.player.EnumPlayerModelParts;

import com.eztouch.skinner.utility.LogHelper;

public class ChangeLook
{
	private static ArrayList<EnumPlayerModelParts> partList;
	private static GameSettings settings;
	private int value;
	private static int counter;
	private static String mode;
	private static boolean layer = false;
	private static boolean changing = false;

	public ChangeLook(String mode)
	{
		partList = new ArrayList<EnumPlayerModelParts>();
		settings = Minecraft.getMinecraft().gameSettings;
		for (EnumPlayerModelParts part : net.minecraft.entity.player.EnumPlayerModelParts
				.values())
		{
			partList.add(part);
		}
		setMode(mode);
		something();
	}

	public void something()
	{
		if (mode.equalsIgnoreCase("static"))
		{
			for (EnumPlayerModelParts part : partList)
			{
				settings.setModelPartEnabled(part, layer);
				LogHelper.info(part + " has been switched");
			}
			layer = !layer;
		} else if (mode.equalsIgnoreCase("random"))
		{
			LogHelper.info("random skin chnage detected");
			for (EnumPlayerModelParts part : partList)
			{
				value = (Math.random() < 0.5) ? 0 : 1;
				if (value == 1)
				{
					settings.switchModelPartEnabled(part);
				}
			}
		} else if (mode.equalsIgnoreCase("dynamic"))
		{
			changing = !changing;
		}
	}

	public void setMode(String mode)
	{
		this.mode = mode;
	}

	public static String getMode()
	{
		return mode;
	}

	public static boolean isChanging()
	{
		return changing;
	}

	public static ArrayList<EnumPlayerModelParts> getPartList()
	{
		return partList;
	}

	public void setPartList(ArrayList<EnumPlayerModelParts> partList)
	{
		this.partList = partList;
	}

	public static GameSettings getSettings()
	{
		return settings;
	}

	public void setSettings(GameSettings settings)
	{
		this.settings = settings;
	}

	public int getValue()
	{
		return value;
	}

	public void setValue(int value)
	{
		this.value = value;
	}

	public static int getCounter()
	{
		return counter;
	}

	public static void setCounter(int newCounter)
	{
		counter = newCounter;
	}

	public static boolean isLayer()
	{
		return layer;
	}

	public static void setLayer(boolean layer)
	{
		ChangeLook.layer = layer;
	}

	public static void setChanging(boolean changing)
	{
		ChangeLook.changing = changing;
	}

}
