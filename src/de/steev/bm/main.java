package de.steev.bm;

import de.steev.bm.changes.interaction.Item_Recipy_Override;
import de.steev.bm.events.BedEvent;
import de.steev.bm.events.InteractEvent;
import de.steev.bm.events.KillEvent;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class main extends JavaPlugin implements Listener {

	// Global Variables that might come helpfull later
	public int playerInBed = 0;
	public World world;
	String version = "1.2";

	// Custom Playerdata File
	public File playerdata;
	public FileConfiguration playerDataConfig;
	public final String playerdatafilename = "playerdata.yml";

	// Handles initialisation
	public void onEnable() {
		// Messaging
		this.getLogger().info(ChatColor.AQUA + "Plugin Startet");

		// Registers Events
		this.getLogger().info(ChatColor.AQUA + "Lade Events");
		this.getServer().getPluginManager().registerEvents(new BedEvent(this), this);
		this.getServer().getPluginManager().registerEvents(new KillEvent(this), this);
		this.getServer().getPluginManager().registerEvents(new InteractEvent(this), this);
		this.getServer().getPluginManager().registerEvents(this, this);

		// PlayerData
		playerdata = new File(this.getDataFolder(), playerdatafilename);
		playerDataConfig = YamlConfiguration.loadConfiguration(playerdata);
		saveplayerdata();

		// More Messaging
		this.getLogger().info(ChatColor.AQUA + "Erstelle Rezepte");

		Item_Recipy_Override Saddle = new Item_Recipy_Override(this, "Saddle", Material.SADDLE, 1);
		char[] s_ing = { 'L', 'S', 'I' };
		String[] s_rec = { "LLL", "LSL", " I " };
		Material[] s_mat = { Material.LEATHER, Material.STRING, Material.IRON_NUGGET };
		Saddle.register_recipy(s_ing, s_mat, s_rec);

		Item_Recipy_Override Wool = new Item_Recipy_Override(this, "String", Material.STRING, 8);
		char[] w_ing = { 'W', 'F', };
		String[] w_rec = { " W ", "WFW", " W " };
		Material[] w_mat = { Material.WHITE_WOOL, Material.FLINT };
		Wool.register_recipy(w_ing, w_mat, w_rec);

		// More Messaging
		this.getLogger().info(ChatColor.AQUA + "Ich bin Fertig :D");
	}

	@EventHandler
	void onPlayerJoin(PlayerJoinEvent e) {
		Player p = (Player) e.getPlayer();
		UUID uuid = p.getUniqueId();
		// prevent this allways resetting the job count
		if (this.playerDataConfig.get(uuid + "." + version + ".read") == null) {
			p.sendMessage("================= Better Minecraft " + version + " =================");
			p.sendMessage("Command: /back eingefügt");
			p.sendMessage("=====================================================");

			this.playerDataConfig.set(uuid + ".name", p.getName());
			this.playerDataConfig.set(uuid + "." + version + ".read", "true");
			saveplayerdata();
		}
	}

	void saveplayerdata() {
		try {
			playerDataConfig.save(playerdata);
		} catch (IOException e) {
			this.getLogger().warning("Unable to save " + playerdatafilename); // shouldn't really happen, but save
			// throws the exception
		}
	}

	public void onDisable() {
		// Even more Messaging
		this.getLogger().info(ChatColor.AQUA + "Ich geh dann mal :c");
	}
}