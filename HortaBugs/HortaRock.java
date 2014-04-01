import info.gridworld.actor.Critter;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

import java.awt.*;
import java.util.AbstractMap;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class HortaRock extends Rock {

    // Because this wasn't public in the actual Rock class ;/
    public static final Color DEFAULT_COLOR = Color.BLACK;

    // Map: Location of Horta (cloned) -> Cycle when it happened
    private final Deque<Map.Entry<Location, Long>> deque;
    private long cycle;

    public HortaRock() {
        this(HortaRock.DEFAULT_COLOR);
    }

    public HortaRock(Color color) {
        super(color);
        this.deque = new ArrayDeque<Map.Entry<Location, Long>>();
        this.cycle = 1;
    }

    @Override
    public void act() {
        if (this.deque != null) {
            // Clone to avoid CMEs
            for(Map.Entry<Location, Long> entry : new ArrayDeque<Map.Entry<Location, Long>>(this.deque)) {
                if (entry.getValue() < this.cycle) {
                    HortaRunner.world.getGrid().put(entry.getKey(), new HortaUnder());
                    this.deque.remove(entry);
                }
            }
        }
        this.cycle++;
    }

    /**
     * Method to tell the rock that there is a Horta about to go under it.
     * Must be called before the call to Critter.makeMove().
     */
    public final boolean goUnder(HortaUnder horta) {
        if (this.deque != null) {
            Location clone = new Location(horta.getLocation().getRow(), horta.getLocation().getCol());
            System.out.println("cloned location: " + clone);
            horta.removeSelfFromGrid();
            return this.deque.offerLast(new AbstractMap.SimpleEntry<Location, Long>(clone, this.cycle));
        } else {
            return false;
        }
    }
}
