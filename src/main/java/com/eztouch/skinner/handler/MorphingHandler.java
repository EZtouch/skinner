package com.eztouch.skinner.handler;

import java.awt.Desktop;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;

import com.eztouch.skinner.utility.LogHelper;

public class MorphingHandler
{
	public static void Morph(String type)
	{
		Entity pointedEntity = ((Entity) Minecraft.getMinecraft().pointedEntity);
		if (pointedEntity != null && ((String) pointedEntity.toString().substring(0, 19)) .equals("EntityOtherPlayerMP"))
		{
			String playerName = (String) ((String) pointedEntity.toString() .substring(21, ((String) pointedEntity.toString()).indexOf("'/")));
			LogHelper.info(playerName);
			String url = "http://www.minecraft.net/profile/skin/remote?url=http://skins.minecraft.net/MinecraftSkins/"+playerName+".png ";
			launchBrowser(url);
		    //Minecraft.getMinecraft().username
			//
		}else if (type.equalsIgnoreCase("self"))
		{
			String url ="https://minecraft.net/profile/skin/remote?url=https://lh3.googleusercontent.com/ss8A0ZJdQe_Nd-XkxwCS-UDn7mR4Q6mRslnfQ0GimITPVZiXPi7zrd8GiqgmHGu-W5blMeU2l17sv6s=w1896-h791";
			launchBrowser(url);
		}
	}
	
	public static void launchBrowser(String url)
	{
		URL urlLink = null;
		try
		{
			urlLink = new URL(url);
		} catch (MalformedURLException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
    if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
        try {
            desktop.browse(urlLink.toURI());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
	
}
