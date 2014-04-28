import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Location;

import java.util.Random;

public class JiveBug extends Bug {

    private double prob;
    private int[] myTurns = {
        Location.RIGHT, Location.HALF_LEFT,
        Location.HALF_RIGHT, Location.FULL_CIRCLE,
        Location.HALF_CIRCLE
    };

    public JiveBug(double prob) {
        this.prob = prob;
    }

    public int getDanceTurn() {
        return this.myTurns[new Random().nextInt(this.myTurns.length)];
    }

    @Override
    public void turn() {
        super.setDirection(this.getDanceTurn());
    }

    @Override
    public void move() {
        if (this.getGrid() == null) {
            return;
        } else {
            Location next = this.getLocation().getAdjacentLocation(this.getDirection());
            if (this.getGrid().isValid(next)) {
                this.moveTo(next);
            } else {
                this.removeSelfFromGrid();
            }
            this.tossFlower();
        }
    }

    public void tossFlower() {
        Location b = this.getLocation().getAdjacentLocation(Location.AHEAD).getAdjacentLocation(Location.RIGHT);

        if (this.getGrid().isValid(b)) {
            if (new Random().nextDouble() < this.prob) {
                this.getGrid().put(b, new Flower(this.getColor()));
            }
        }
    }

    @Override
    public void act() {
        if (this.getGrid() != null) {
            this.turn();
            if (Math.random() < 0.5d) {
                this.move();
            }
        }
    }
}
