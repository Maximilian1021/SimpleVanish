package me.Maximilian1021.util;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Message
{
    public static void SendMessageToCommandSender(CommandSender sender, String rawMessage) { sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Static.MESSAGE_PREFIX + rawMessage)); }



    public static void SendMessageToPlayer(Player player, String rawMessage) { player.sendMessage(ChatColor.translateAlternateColorCodes('&', Static.MESSAGE_PREFIX + rawMessage)); }

    public static void SendMessageToPlayer(Player[] players, String rawMessage) {
        for (Player player : players)
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', Static.MESSAGE_PREFIX + rawMessage));
    }

    public static void SendMessageToAllPlayers(String rawMessage) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', Static.MESSAGE_PREFIX + rawMessage));
        }
    }


    public static void SendActionbarToPlayer(Player player, String rawMessage) { player.spigot().sendMessage(ChatMessageType.ACTION_BAR, (BaseComponent)new TextComponent(ChatColor.translateAlternateColorCodes('&', rawMessage))); }

    public static void SendActionbarToPlayer(Player[] players, String rawMessage) {
        for (Player player : players)
            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, (BaseComponent)new TextComponent(ChatColor.translateAlternateColorCodes('&', rawMessage)));
    }

    public static void SendActionbarToAllPlayers(String rawMessage) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, (BaseComponent)new TextComponent(ChatColor.translateAlternateColorCodes('&', rawMessage)));
        }
    }


    public static void SendTitleToPlayer(Player player, String title, String subtitle) { player.sendTitle(ChatColor.translateAlternateColorCodes('&', title), ChatColor.translateAlternateColorCodes('&', subtitle), 20, 80, 20); }

    public static void SendTitleToPlayer(Player[] players, String title, String subtitle) {
        for (Player player : players)
            player.sendTitle(ChatColor.translateAlternateColorCodes('&', title), ChatColor.translateAlternateColorCodes('&', subtitle), 80, 5, 20);
    }

    public static void SendTitleToAllPlayers(String title, String subtitle) {
        for (Player player : Bukkit.getOnlinePlayers())
            player.sendTitle(ChatColor.translateAlternateColorCodes('&', title), ChatColor.translateAlternateColorCodes('&', subtitle), 20, 80, 20);
    }
}
