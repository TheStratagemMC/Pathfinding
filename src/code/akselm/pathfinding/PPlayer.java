package code.akselm.pathfinding;

import net.minecraft.server.v1_9_R2.*;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_9_R2.CraftServer;

/**
 * Created by 18AxMoreen on 5/13/2016.
 */
public class PPlayer {
    private EntityPlayer player;
    private Navigation navigation;

    public PPlayer(String name, Location location){
        this.player = new PlayerBuilder(name).create();
        this.player.teleportTo(location, false);
        navigation = new Navigation(new EntityZombie(player.world), player.world);
    }

    public void join(){
        NetworkManager nm = new NetworkManager(EnumProtocolDirection.SERVERBOUND);
        ((CraftServer)Bukkit.getServer()).getHandle().a(nm, player);
    }

    public void navigateTo(Location location){
        PathEntity entity = navigation.a(location.getX(), location.getY(), location.getZ());
        for (int i= 0; i < entity.d(); i++){
            PathPoint point = entity.a(i);
            player.move(point.a, point.b, point.c);
            Bukkit.broadcastMessage("moved to " + point.a + ", "+point.b+ ", "+point.c);
        }
    }
}
