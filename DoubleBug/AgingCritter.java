import info.gridworld.actor.Critter;

import java.util.Random;

public class AgingCritter extends Critter {

    private int cycles = 0;

    @Override
    public void act() {
        this.cycles++;
        if (this.cycles == 10) {
            this.removeSelfFromGrid();
        } else if (this.canMoveWithAge()) {
            super.act();
        }
    }

    public boolean canMoveWithAge() {
        Random r = new Random();
        double d = (10 - this.cycles) / (double) 10;

        return r.nextDouble() < d;
    }
}
