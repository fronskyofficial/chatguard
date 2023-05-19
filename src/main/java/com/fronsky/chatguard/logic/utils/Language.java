package com.fronsky.chatguard.logic.utils;

import com.fronsky.chatguard.module.ChatGuardModule;

public enum Language {
    DEFAULT("Please choose a language message. The current message is a default message."), // id = 0
    NO_PERMISSION("&cYou do not have permissions to perform this action. Please contact your system administrator for assistance."), // id = 1
    RELOAD("&cYou do not have permissions to perform this action. Please contact your system administrator for assistance."), // id = 2
    WORD_WARNING("&cYou do not have permissions to perform this action. Please contact your system administrator for assistance."); // id = 3

    private final String message;

    Language(String message) {
        this.message = message;
    }

    public int getId() {
        return ordinal();
    }

    public String getMessage() {
        String _message = ChatGuardModule.getData().getMessages().get().getString(name().toLowerCase());
        if (_message == null) {
            _message = message;
        }
        return _message;
    }

    public String getMessageWithColor() {
        return ColorUtils.colorize(getMessage());
    }

    public Language getLanguage(String name) {
        Language language = null;
        for (Language obj : Language.values()) {
            if (name.equalsIgnoreCase(obj.name())) {
                language = obj;
                break;
            }
        }
        return language;
    }
}
