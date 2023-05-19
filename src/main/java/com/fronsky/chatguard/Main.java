package com.fronsky.chatguard;

import com.fronsky.chatguard.logic.module.ModuleManager;
import com.fronsky.chatguard.module.ChatGuardModule;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    private final ModuleManager<Main> moduleManager = new ModuleManager<>();

    @Override
    public void onLoad() {
        moduleManager.prepare(new ChatGuardModule(this));
        try {
            moduleManager.load();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void onEnable() {
        try {
            moduleManager.enable();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void onDisable() {
        try {
            moduleManager.disable();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
