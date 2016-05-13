package code.akselm.pathfinding;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by 18AxMoreen on 5/13/2016.
 */
public class PathfindingPlugin extends JavaPlugin{
    PPlayer p;

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        if (!(sender instanceof Player)) return false;
        Player player = (Player)sender;


        if (args.length == 0) return false;

        if (args[0].equalsIgnoreCase("spawn")){
            p = new PPlayer("AmazingBot", player.getLocation());
            player.sendMessage("k");
        }

        if (args[0].equalsIgnoreCase("here")){
            p.navigateTo(player.getLocation());
        }
        return true;
    }
}
