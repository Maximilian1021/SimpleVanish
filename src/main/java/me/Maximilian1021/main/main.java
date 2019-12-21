package me.Maximilian1021.main;

import me.Maximilian1021.commands.cmdVanish;
import me.Maximilian1021.events.eventVanish;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin implements Listener {

    PluginDescriptionFile pdf = this.getDescription(); //Gets plugin.yml


    @Override
    public void onEnable() {
        super.onEnable();

        Bukkit.getConsoleSender().sendMessage("-------------");
        Bukkit.getConsoleSender().sendMessage("Plugin-Name: " + pdf.getName());
        Bukkit.getConsoleSender().sendMessage("Version: " + pdf.getVersion());
        Bukkit.getConsoleSender().sendMessage("Author " + pdf.getAuthors());
        Bukkit.getConsoleSender().sendMessage("Author " + pdf.getWebsite());

        registerCommands();
        registerEvents();

        Bukkit.getConsoleSender().sendMessage("-------------");

    }

    @Override
    public void onDisable() {
        super.onDisable();
    }


    public void registerEvents() {

        PluginManager pm = Bukkit.getPluginManager();

        //pm.registerEvents(new eventVanish(), this);
        pm.registerEvents(new cmdVanish(), this);

    }

    public void registerCommands() {

        getCommand("vanish").setExecutor(new cmdVanish());
        getCommand("v").setExecutor(new cmdVanish());


    }

}
