import java.awt.Color;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import java.util.ArrayList;

public class EbolaCritter extends Critter {
	private static final int SICKTIME = 10;
	private static final double CHANCEOFDEATH = 0.05;
	// debug
	// private static final double CHANCEOFDEATH = 0;
	private int timeSick;
	private boolean isImmune;
	private boolean isSick;

	public EbolaCritter() {
		timeSick = 0;
		isImmune = false;
		isSick = false;
	}

	public EbolaCritter(boolean sick) {
		if (sick)
			infect();
		else {
			timeSick = 0;
			isImmune = false;
			isSick = false;
		}
	}

	@SuppressWarnings("unchecked")
	public void processActors(ArrayList<Actor> actors) {
		int n = actors.size();
		if (n == 0)
			return;
		ArrayList<EbolaCritter> neighbours = new ArrayList();
		for (Actor a : actors) {
			if (a instanceof EbolaCritter)
				neighbours.add((EbolaCritter) a);
		}

		// setColor(other.getColor());
		for (EbolaCritter o : neighbours)
			if (o.isSick() && !isImmune)
				infect();
	}

	public void makeMove(Location loc) {
		if (isSick) {
			if (timeSick > 0) {
				timeSick--;
				if (Math.random() < CHANCEOFDEATH)
					removeSelfFromGrid();
				else
					super.makeMove(loc);
			} else {
				isImmune = true;
				isSick = false;
				setColor(Color.GREEN);
				super.makeMove(loc);
			}
		} else
			super.makeMove(loc);
	}

	public void infect() {
		timeSick = SICKTIME;
		isImmune = false;
		isSick = true;
		setColor(Color.RED);
	}

	public boolean isSick() {
		return isSick;
	}

	public boolean isImmune() {
		return isImmune;
	}
}
