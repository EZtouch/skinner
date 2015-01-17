package com.eztouch.skinner.client.gui;

import com.eztouch.skinner.handler.ConfigurationHandler;
import com.eztouch.skinner.reference.Reference;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.config.GuiConfig;

class ModGuiConfig extends GuiConfig
{
    public ModGuiConfig(GuiScreen guiScreen)
    {
        super(guiScreen, new ConfigElement(
                ConfigurationHandler.configuration
                        .getCategory(Configuration.CATEGORY_GENERAL))
                .getChildElements(), Reference.MOD_ID, false, false, GuiConfig
                .getAbridgedConfigPath(ConfigurationHandler.configuration
                        .toString()));
    }
}
