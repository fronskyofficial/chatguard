package com.fronsky.chatguard.module.data;

import com.fronsky.chatguard.formats.logging.BasicLogger;
import com.fronsky.chatguard.logic.file.IFile;
import com.fronsky.chatguard.logic.logging.ILogger;
import com.fronsky.chatguard.logic.utils.Language;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

public class Data {
    private final Plugin plugin;
    private final IFile<FileConfiguration> messages;
    private final IFile<FileConfiguration> config;
    private final Language language;
    private final ILogger logger;

    public Data(Plugin plugin, IFile<FileConfiguration> messages, IFile<FileConfiguration> config) {
        this.plugin = plugin;
        this.messages = messages;
        this.config = config;
        this.language = Language.DEFAULT;
        this.logger = new BasicLogger();
    }

    public Plugin getPlugin() {
        return plugin;
    }

    public IFile<FileConfiguration> getMessages() {
        return messages;
    }

    public IFile<FileConfiguration> getConfig() {
        return config;
    }

    public Language getLanguage() {
        return language;
    }

    public ILogger getLogger() {
        return logger;
    }
}
