import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

import java.awt.*;
import java.util.*;

public class HortaBugOver extends Critter {

    private final Deque<Map.Entry<Location, Color>> deque;

    public HortaBugOver() {
        super();
        this.setColor(Color.GREEN);
        this.deque = new ArrayDeque<Map.Entry<Location, Color>>();
    }

    @Override
    public void act() {
        Location to = this.selectMoveLocation(getMoveLocations());

        Actor potential = this.getGrid().get(to);
        if (potential != null && potential instanceof Rock) {
            Rock rock = (Rock) potential;
            // We can't actually give it the rock because after
            // the .removeSelfFromGrid is called, the reference is null
            // Instead we offer it the locatiom, and put a new rock
            // in its place instead.
            deque.offer(new AbstractMap.SimpleEntry<Location, Color>(to, potential.getColor()));

            this.getGrid().remove(to);
        }

        this.moveTo(to);

        if (!this.deque.isEmpty()) {
            // Make a copy of the array, to avoid CMEs
            for (Map.Entry<Location, Color> entry : new ArrayDeque<Map.Entry<Location, Color>>(this.deque)) {
                if (this.getGrid().get(entry.getKey()) == null) {
                    this.getGrid().put(entry.getKey(), new Rock(entry.getValue()));
                    // Remove the location if it actually exists
                    this.deque.remove(entry.getKey());
                }
            }
        }
    }

    // Override this function to provide the Horta with rocks that it can move into
    @Override
    public ArrayList<Location> getMoveLocations() {
        ArrayList<Location> locs = new ArrayList<Location>();
        locs.addAll(this.getGrid().getEmptyAdjacentLocations(this.getLocation()));
        locs.addAll(this.getGrid().getOccupiedAdjacentLocations(this.getLocation()));
        return locs;
    }
}
