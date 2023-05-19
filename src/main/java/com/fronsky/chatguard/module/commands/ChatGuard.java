package com.fronsky.chatguard.module.commands;

import com.fronsky.chatguard.logic.command.CommandHandler;
import com.fronsky.chatguard.logic.utils.Language;
import com.fronsky.chatguard.module.ChatGuardModule;
import com.fronsky.chatguard.module.commands.help.HelpMessage;
import com.fronsky.chatguard.module.data.Data;
import lombok.NonNull;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;

public class ChatGuard extends CommandHandler {
    private final Data data;

    public ChatGuard() {
        super("chatguard", "chatguard.cmd.chatguard");
        setSubcommands(Arrays.asList("help", "reload", "info"));
        this.data = ChatGuardModule.getData();
    }

    @Override
    public boolean onCommand(@NonNull CommandSender sender, @NonNull String label, @NonNull String[] args) {
        sender.sendMessage(ChatColor.WHITE + "<---------------" + ChatColor.DARK_RED + "ChatGuard Info" + ChatColor.WHITE + "--------------->");
        sender.sendMessage(ChatColor.YELLOW + "Name: " + ChatColor.WHITE + "ChatGuard");
        sender.sendMessage(ChatColor.YELLOW + "Author: " + ChatColor.GRAY + "Fronsky Inc");

        if (sender instanceof Player) {
            Player player = (Player) sender;

            TextComponent plugin = new TextComponent(ChatColor.YELLOW + "Plugin: " + ChatColor.GRAY + "www.fronsky.com/resources/chatguard");
            plugin.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://www.fronsky.com/resources/chatguard"));

            TextComponent website = new TextComponent(ChatColor.YELLOW + "Website: " + ChatColor.GRAY + "www.fronsky.com");
            website.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://www.fronsky.com"));

            player.spigot().sendMessage(plugin);
            player.spigot().sendMessage(website);
        } else {
            sender.sendMessage(ChatColor.YELLOW + "Plugin: " + ChatColor.GRAY + "www.fronsky.com/resources/chatguard");
            sender.sendMessage(ChatColor.YELLOW + "Website: " + ChatColor.GRAY + "www.fronsky.com");
        }
        sender.sendMessage(ChatColor.YELLOW + "Version: " + ChatColor.RED + data.getPlugin().getDescription().getVersion());
        sender.sendMessage(ChatColor.WHITE + "<---------------------------------------->");
        return true;
    }

    public void help(@NonNull CommandSender sender, @NonNull String label, @NonNull String[] args) {
        sender.sendMessage(ChatColor.WHITE + "<---------------" + ChatColor.DARK_RED + "ChatGuard Help" + ChatColor.WHITE + "--------------->");
        sender.sendMessage(ChatColor.YELLOW + "Aliases:" + ChatColor.GRAY + "/chat " + ChatColor.WHITE + ", " + ChatColor.GRAY + "/guard");
        sender.sendMessage(ChatColor.YELLOW + "Commands: ");
        if (sender instanceof Player) {
            Player player = (Player) sender;
            HelpMessage.helpCommand(player);
            HelpMessage.chatguardCommand(player);
            HelpMessage.reloadCommand(player);
        } else {
            sender.sendMessage(ChatColor.GRAY + "- /chatguard help");
            sender.sendMessage(ChatColor.GRAY + "- /chatguard or /chatguard info");
            sender.sendMessage(ChatColor.GRAY + "- /chatguard reload");
        }
        sender.sendMessage(ChatColor.WHITE + "<---------------------------------------->");
    }

    public void reload(@NonNull CommandSender sender, @NonNull String label, @NonNull String[] args) {
        data.getConfig().reload();
        data.getMessages().reload();
        sender.sendMessage(Language.RELOAD.getMessageWithColor());
    }

    public void info(@NonNull CommandSender sender, @NonNull String label, @NonNull String[] args) {
        sender.sendMessage(ChatColor.WHITE + "<---------------" + ChatColor.DARK_RED + "ChatGuard Info" + ChatColor.WHITE + "--------------->");
        sender.sendMessage(ChatColor.YELLOW + "Name: " + ChatColor.WHITE + "ChatGuard");
        sender.sendMessage(ChatColor.YELLOW + "Author: " + ChatColor.GRAY + "Fronsky Inc");

        if (sender instanceof Player) {
            Player player = (Player) sender;

            TextComponent plugin = new TextComponent(ChatColor.YELLOW + "Plugin: " + ChatColor.GRAY + "www.fronsky.com/resources/chatguard");
            plugin.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://www.fronsky.com/resources/chatguard"));

            TextComponent website = new TextComponent(ChatColor.YELLOW + "Website: " + ChatColor.GRAY + "www.fronsky.com");
            website.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://www.fronsky.com"));

            player.spigot().sendMessage(plugin);
            player.spigot().sendMessage(website);
        } else {
            sender.sendMessage(ChatColor.YELLOW + "Plugin: " + ChatColor.GRAY + "www.fronsky.com/resources/chatguard");
            sender.sendMessage(ChatColor.YELLOW + "Website: " + ChatColor.GRAY + "www.fronsky.com");
        }
        sender.sendMessage(ChatColor.YELLOW + "Version: " + ChatColor.RED + data.getPlugin().getDescription().getVersion());
        sender.sendMessage(ChatColor.WHITE + "<---------------------------------------->");
    }
}
