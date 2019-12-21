package me.Maximilian1021.commands;


import java.util.ArrayList;

import me.Maximilian1021.util.Message;
import me.Maximilian1021.util.Static;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class cmdVanish implements CommandExecutor, Listener {
    Player executor;
    public static ArrayList<Player> vanished = new ArrayList<Player>();

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            Message.SendMessageToCommandSender(sender, Static.RAWMESSAGE_NOTASCONSOLE);
            return true;
        }

        this.executor = (Player) sender;

        if (this.executor.hasPermission(Static.PERMISSION_VANISH)) {
            if (vanished.contains(this.executor)) {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    player.showPlayer(Bukkit.getPluginManager().getPlugin("SimpleVanish"), this.executor);
                    vanished.remove(this.executor);
                }
                Message.SendMessageToPlayer(this.executor, "&5Vanish&d has been &cdeactivated&d.");
            } else {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    player.hidePlayer(Bukkit.getPluginManager().getPlugin("SimpleVanish"), this.executor);
                    vanished.add(this.executor);
                }
                Message.SendMessageToPlayer(this.executor, "&5Vanish&d has been &aactivated&d.");
            }
        } else {
            Message.SendMessageToCommandSender(sender, Static.RAWMESSAGE_NOPERMISSIONS);
        }
        return true;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        for (Player player : vanished) {
            event.getPlayer().hidePlayer(Bukkit.getPluginManager().getPlugin("SimpleVanish"), player);
        }
    }


    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event) {
        vanished.remove(event.getPlayer());
    }


    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        if (vanished.contains(event.getPlayer()))
            Message.SendActionbarToPlayer(event.getPlayer(), "&5&lVanish is enabled!");
    }
}
