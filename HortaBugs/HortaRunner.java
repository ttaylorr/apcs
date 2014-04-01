import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

import java.awt.Color;

public class HortaRunner {
    public static ActorWorld world;

    public static void main(String[] args) {
        HortaRunner.world = new ActorWorld();
        world.add(new Location(7, 8), new HortaRock());
        world.add(new Location(3, 3), new HortaRock());
        world.add(new Location(2, 8), new HortaRock(Color.BLUE));
        world.add(new Location(5, 5), new HortaRock(Color.PINK));
        world.add(new Location(1, 5), new HortaRock(Color.RED));
        world.add(new Location(7, 2), new HortaRock(Color.YELLOW));
//        world.add(new Location(4, 4), new HortaUnder());
        world.add(new Location(5, 8), new HortaUnder());
        world.show();
    }
}
