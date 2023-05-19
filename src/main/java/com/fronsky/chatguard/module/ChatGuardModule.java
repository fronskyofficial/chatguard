package com.fronsky.chatguard.module;

import com.fronsky.chatguard.Main;
import com.fronsky.chatguard.formats.file.YmlFile;
import com.fronsky.chatguard.logic.file.IFile;
import com.fronsky.chatguard.logic.module.Module;
import com.fronsky.chatguard.module.commands.ChatGuard;
import com.fronsky.chatguard.module.data.Data;
import com.fronsky.chatguard.module.events.Chat;
import com.fronsky.chatguard.module.test.Test;
import org.bukkit.configuration.file.FileConfiguration;

public class ChatGuardModule extends Module<Main> {
    private static Data data;
    private final boolean testResult;

    public ChatGuardModule(Main mainClass) {
        super(mainClass);
        final IFile<FileConfiguration> messages = new YmlFile("messages", mainClass);
        final IFile<FileConfiguration> config = new YmlFile("config", mainClass);
        setData(new Data(mainClass, messages, config));
        if (!(this.testResult = Test.executeTests())) {
            data.getLogger().severe("An error has occurred in a file. To resolve the issue, please delete all files and restart or reload the server.");
        }
    }

    public static Data getData() {
        return ChatGuardModule.data;
    }

    public static void setData(final Data data) {
        ChatGuardModule.data = data;
    }


    @Override
    public void onLoad() {

    }

    @Override
    public void onEnable() {
        if (!testResult) {
            return;
        }

        command(ChatGuard::new);
        event(Chat::new);
    }

    @Override
    public void onDisable() {
        if (!testResult) {
            return;
        }
    }
}
