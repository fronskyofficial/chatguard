package com.fronsky.chatguard;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onLoad() {
        System.out.println("Plugin loading...");
    }

    @Override
    public void onEnable() {
        System.out.println("Plugin enabling...");
    }

    @Override
    public void onDisable() {
        System.out.println("Plugin disabling...");
    }
}
