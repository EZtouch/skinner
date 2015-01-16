package com.eztouch.skinner.look;

import java.util.ArrayList;

import scala.collection.immutable.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.GuiCustomizeSkin;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.player.EnumPlayerModelParts;

public class ChangeLook extends GameSettings
{
	private ArrayList<EnumPlayerModelParts> theList;
	private GameSettings settings = Minecraft.getMinecraft().gameSettings;
	private EntityPlayerSP player = Minecraft.getMinecraft().thePlayer;
	private int value;

	public ChangeLook(String mode)
	{
		theList = new ArrayList<EnumPlayerModelParts>();
		theList.add(net.minecraft.entity.player.EnumPlayerModelParts.HAT);
		theList.add(net.minecraft.entity.player.EnumPlayerModelParts.CAPE);
		theList.add(net.minecraft.entity.player.EnumPlayerModelParts.JACKET);
		theList.add(net.minecraft.entity.player.EnumPlayerModelParts.LEFT_SLEEVE);
		theList.add(net.minecraft.entity.player.EnumPlayerModelParts.RIGHT_SLEEVE);
		theList.add(net.minecraft.entity.player.EnumPlayerModelParts.LEFT_PANTS_LEG);
		theList.add(net.minecraft.entity.player.EnumPlayerModelParts.RIGHT_PANTS_LEG);
		if (mode.equalsIgnoreCase("static"))
		{
			for (EnumPlayerModelParts part : theList)
			{
				settings.switchModelPartEnabled(part);
			}
		} else if (mode.equalsIgnoreCase("random"))
		{
			for (EnumPlayerModelParts part : theList)
			{
				value = (Math.random() < 0.5) ? 0 : 1;
				if (value == 1)
				{
					settings.switchModelPartEnabled(part);
				}
			}
		}
	}
}
