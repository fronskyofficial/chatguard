package com.fronsky.chatguard.module.test.yml;

import com.fronsky.chatguard.module.ChatGuardModule;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.Objects;

public class Config {
    private final FileConfiguration file;

    public Config() {
        this.file = ChatGuardModule.getData().getConfig().get();
    }

    public boolean test() {
        boolean result = this.file.contains("version");
        if (!Objects.equals(this.file.getString("version"), "1.1")) {
            result = false;
        }
        if (!this.file.contains("censor_instead_of_block")) {
            result = false;
        }
        if (!this.file.contains("enable_spam_warning_message")) {
            result = false;
        }
        if (!this.file.contains("banned_words")) {
            result = false;
        }
        return result;
    }
}
