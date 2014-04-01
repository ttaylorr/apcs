import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;

import java.awt.*;
import java.util.ArrayList;

public class HortaUnder extends Critter {

    public HortaUnder() {
        this.setColor(Color.GREEN);
    }

    @Override
    public void act() {
        // For some reason a call to Grid.put doesn't end up calling act()
        // I'm thinking that this is a bug...
        ArrayList<Location> locations = this.getMoveLocations();
        Location to = this.selectMoveLocation(locations);

        Actor potential = this.getGrid().get(to);
        if (potential != null && potential instanceof HortaRock) {
            HortaRock rock = (HortaRock) potential;
            rock.goUnder(this);
        } else {
            this.moveTo(to);
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
