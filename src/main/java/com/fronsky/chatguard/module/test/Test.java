package com.fronsky.chatguard.module.test;

import com.fronsky.chatguard.module.test.yml.Config;
import com.fronsky.chatguard.module.test.yml.Messages;

public class Test {
    public static boolean executeTests() {
        final boolean config = new Config().test();
        final boolean messages = new Messages().test();
        return config && messages;
    }
}
