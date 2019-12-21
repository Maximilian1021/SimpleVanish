package me.Maximilian1021.events;

import me.Maximilian1021.commands.cmdVanish;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class eventVanish implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        for (Player p : cmdVanish.vanished) {
            e.getPlayer().hidePlayer(p);
        }
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e) {
        cmdVanish.vanished.remove(e.getPlayer());
    }
}
