package com.fronsky.chatguard.module.test.yml;

import com.fronsky.chatguard.module.ChatGuardModule;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.Objects;

public class Messages {
    private final FileConfiguration file;

    public Messages() {
        this.file = ChatGuardModule.getData().getMessages().get();
    }

    public boolean test() {
        boolean result = this.file.contains("version");
        if (!Objects.equals(this.file.getString("version"), "1.1")) {
            result = false;
        }
        if (!this.file.contains("reload")) {
            result = false;
        }
        if (!this.file.contains("word_warning")) {
            result = false;
        }
        return result;
    }
}
