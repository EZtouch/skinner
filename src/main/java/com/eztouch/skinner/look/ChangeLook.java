package com.eztouch.skinner.look;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.player.EnumPlayerModelParts;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.util.ArrayList;
import java.util.Collections;

public class ChangeLook
{
    private static ArrayList<EnumPlayerModelParts> partList;
    private static GameSettings settings;
    private static int counter;
    private static String mode;
    private static boolean layer = false;
    private static boolean changing = false;

    public ChangeLook(String mode)
    {
        partList = new ArrayList<EnumPlayerModelParts>();
        settings = Minecraft.getMinecraft().gameSettings;
        populatePartList();
        ChangeLook.mode = mode;
        handleSkinChanging();
    }

    public ChangeLook()
    {
        // NOOP
    }

    void populatePartList()
    {
        Collections.addAll(partList, EnumPlayerModelParts
                .values());
    }

    void handleSkinChanging()
    {
        if (mode.equals("change"))
        {
            for (EnumPlayerModelParts part : partList)
            {
                settings.setModelPartEnabled(part, layer);
            }
            layer = !layer;
        } else if (mode.equals("random"))
        {
            for (EnumPlayerModelParts part : partList)
            {
                int value = (Math.random() < 0.5) ? 0 : 1;
                if (value == 1)
                {
                    settings.switchModelPartEnabled(part);
                }
            }
        } else if (mode.equals("dynamic"))
        {
            changing = !changing;
        }
    }

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event)
    {
        if (changing)
        {
            if (++counter % 20 == 0)
            {
                counter = 0;
                for (EnumPlayerModelParts part : partList)
                {
                    settings.setModelPartEnabled(part, layer);
                }
                layer = !layer;
            }
        }
    }

}
