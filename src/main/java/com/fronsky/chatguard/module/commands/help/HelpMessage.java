package com.fronsky.chatguard.module.commands.help;

import net.md_5.bungee.api.chat.*;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class HelpMessage {
    public static void helpCommand(Player player) {
        String command = "/chatguard help";
        BaseComponent[] hoverText = new ComponentBuilder(ChatColor.WHITE + command + "\n")
                .append("\n")
                .append(ChatColor.GRAY + "Displays chatguard command help message\n")
                .append(ChatColor.RED + "chatguard.cmd.chatguard.help")
                .create();
        TextComponent message = new TextComponent(ChatColor.GRAY + "- " + command);
        message.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, hoverText));
        message.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, command));
        player.spigot().sendMessage(message);
    }

    public static void chatguardCommand(Player player) {
        String command = "/chatguard or /chatguard info";
        BaseComponent[] hoverText = new ComponentBuilder(ChatColor.WHITE + command + "\n")
                .append("\n")
                .append(ChatColor.GRAY + "Displays information about this chat command\n")
                .append(ChatColor.RED + "chatguard.cmd.chatguard")
                .create();
        TextComponent message = new TextComponent(ChatColor.GRAY + "- " + command);
        message.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, hoverText));
        message.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, command));
        player.spigot().sendMessage(message);
    }

    public static void reloadCommand(Player player) {
        String command = "/chatguard reload";
        BaseComponent[] hoverText = new ComponentBuilder(ChatColor.WHITE + command + "\n")
                .append("\n")
                .append(ChatColor.GRAY + "Reloads all ChatGuard plugin files\n")
                .append(ChatColor.RED + "chatguard.cmd.chatguard.reload")
                .create();
        TextComponent message = new TextComponent(ChatColor.GRAY + "- " + command);
        message.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, hoverText));
        message.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, command));
        player.spigot().sendMessage(message);
    }
}
