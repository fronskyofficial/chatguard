package com.fronsky.chatguard.formats.logging;

import com.fronsky.chatguard.logic.logging.ILogger;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.util.logging.Level;

public class BasicLogger implements ILogger {
    @Override
    public void info(String message) {
        Bukkit.getServer().getLogger().log(Level.INFO, message);
    }

    @Override
    public void warning(String message) {
        Bukkit.getServer().getLogger().log(Level.WARNING, message);
    }

    @Override
    public void severe(String message) {
        Bukkit.getServer().getLogger().log(Level.SEVERE, message);
    }

    @Override
    public void debug(String message) {
        Bukkit.getServer().getLogger().log(Level.OFF, ChatColor.BOLD + "[DEBUG] " + ChatColor.RESET + message);
    }
}
