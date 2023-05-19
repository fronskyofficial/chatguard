package com.fronsky.chatguard.module.objects;

import org.bukkit.entity.Player;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class SpamChecker {
    private static final Map<Player, Deque<String>> messages = new HashMap<>();

    public static boolean isSpamming(Player player, String message) {
        if (player.hasPermission("chatguard.bypass")) {
            return false;
        }

        Deque<String> recentMessages = messages.getOrDefault(player, new LinkedList<>());
        recentMessages.addFirst(message);

        if (recentMessages.size() > 10) {
            recentMessages.removeLast();
        }

        messages.put(player, recentMessages);

        return recentMessages.stream().filter(m -> m.equalsIgnoreCase(message)).count() > 1;
    }
}
