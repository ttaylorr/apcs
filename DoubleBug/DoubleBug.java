import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;

import java.util.List;
import java.util.Random;

public class DoubleBug extends Bug {

    private Random random;

    public DoubleBug() {
        super();
        this.random = new Random();
    }

    @Override
    public void move() {
        if (this.getGrid() != null) {
            List<Location> choices = this.getGrid().getEmptyAdjacentLocations(this.getLocation());
            Location to = choices.get(this.random.nextInt(choices.size()));
            int direction = this.getLocation().getDirectionToward(to);

            if (this.canMove()) {
                this.moveTo(to);

                if (this.random.nextDouble() < 0.5d && this.canMove()) {
                    Location to2 = to.getAdjacentLocation(direction);
                    this.moveTo(to2);
                }
            }
        }
    }
}
