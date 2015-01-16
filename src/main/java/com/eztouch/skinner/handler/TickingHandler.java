package com.eztouch.skinner.handler;

import com.eztouch.skinner.utility.LogHelper;
import com.eztouch.skinner.look.ChangeLook;

import net.minecraft.entity.player.EnumPlayerModelParts;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class TickingHandler
{
	@SubscribeEvent
	public void onWorldTick(TickEvent.WorldTickEvent event)
	{
		if (ChangeLook.isChanging() == true)
		{
			ChangeLook.setCounter(ChangeLook.getCounter() + 1);
			if (ChangeLook.getCounter() % 20 == 0)
			{
				ChangeLook.setCounter(0);
				for (EnumPlayerModelParts part : ChangeLook.getPartList())
				{
					ChangeLook.getSettings().switchModelPartEnabled(part);
				}
			}
		}
	}
}
