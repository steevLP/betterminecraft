package de.steev.bm.events;

import de.steev.bm.main;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class InteractEvent implements Listener {

    private main plugin;

    public InteractEvent(main plugin){
        this.plugin = plugin;
    }

    /**
     * Carrot: Carrot 3
     * Potato: potato 2
     * Wheat: 2 Wheat, 2 Wheat Seeds
     * Beetroots: 1 Beetroot, 3 Beetroot seeds
     */
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event){
        if(event.getAction().equals(Action.RIGHT_CLICK_BLOCK)){

            /** the clicked block */
            Block target = event.getClickedBlock();
            /** the location of the clicked block */
            Location loc = target.getLocation().clone().add(0.5, 0.5, 0.5);

            // Detects which type to replant
            // TODO: do the replant implementation
            switch(target.getType().toString()){
                case "CARROT":
                    break;
                case "POTATO":
                    break;
                case "WHEAT":
                    break;
                case "BEETROOT":
                    break;
            }
        }
    }
}
