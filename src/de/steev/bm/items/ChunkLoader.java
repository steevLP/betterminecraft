package de.steev.bm.items;

import de.steev.bm.main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * Not implemented do not use do not think of this
 */
public class ChunkLoader implements Listener {
    main plugin;

    public ChunkLoader(main plugin){
        this.plugin = plugin;
        // NamespaceKeys
        NamespacedKey chunkLoader = new NamespacedKey(plugin, "ChunkLoader");

        ItemStack ChunkLoaderStack = new ItemStack(Material.BEACON);
        ChunkLoaderStack.setAmount(1);

        ItemMeta meta = ChunkLoaderStack.getItemMeta();

        // Shape Keys
        ShapedRecipe rec_saddle = new ShapedRecipe(chunkLoader, ChunkLoaderStack);
        //Recipe shapes
        rec_saddle.shape("III","IEI","OOO");

        // Material Definitions
        rec_saddle.setIngredient('I', Material.IRON_INGOT);
        rec_saddle.setIngredient('E', Material.ENDER_PEARL);
        rec_saddle.setIngredient('O', Material.OBSIDIAN);

        // More Messaging
        plugin.getLogger().info(ChatColor.AQUA + "Registriere Chunkloader");

        // Add recipes to Server
        Bukkit.addRecipe(rec_saddle);
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event){
        //event.setCancelled(true);
        Block target = event.getClickedBlock();
        System.out.println(target);
    }

    @EventHandler
    private void onBlockPlace(BlockPlaceEvent event){
        // TODO: Add a Chunkticket
        // TODO: get chunk that will be loaded
        // TODO: Create loading routine
        // TODO: Detect how many chunkloaders the player placed
        // TODO: stop placeevent when limit is exceeded
    }

    @EventHandler
    private void onBlockBreak(BlockBreakEvent event){
        // TODO: remove the ChunkTicket
        // TODO: make chunkloading stop
        // TODO: remove all handling properties
    }
}
