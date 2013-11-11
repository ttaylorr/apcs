public class Time {

	private int hrs;
	private int mins;
	private int secs;

	// Default time constructor, sets all values to 0.
	public Time() {
		this.hrs = 0;
		this.mins = 0;
		this.secs = 0;
	}

	// Accepted Time constructor, sets values to input, then updates.
	public Time(int hrs, int mins, int secs) {
		this.hrs = hrs;
		this.mins = mins;
		this.secs = secs;
		update();
	}

	// Resets all time values to 0.
	public void resetTime() {
		this.hrs = 0;
		this.mins = 0;
		this.secs = 0;
	}

	// Tests equality for this Time object and another Time object, t.
	public boolean equals(Time t) {
		return this.hrs == t.hrs && this.mins == t.mins && this.secs == t.secs;
	}

	// Returns the String equivelant of this Time object.
	public String toString() {
		return this.hrs + ":" + (this.mins >= 10 ? this.mins : "0" + this.mins)
				+ ":" + (this.secs >= 10 ? this.secs : "0" + this.secs);
	}

	// Increments the time forward by one second.
	public void increment() {
		this.secs++;
		update();
	}

	// Decrements the time backward by one second.
	public void decrement() {
		this.secs--;
		update();
	}

	// Setter methods
	public void setHour(int hrs) {
		this.hrs = hrs;
	}

	public void setMinute(int mins) {
		this.mins = mins;
	}

	public void setSecond(int secs) {
		this.secs = secs;
	}

	// Helper method for the helper method :(
	public void reduce() {
		update();
	}

	// Helper method to update the time and fix broken times.  (Only right two times a day).
	protected void update() {
		if (secs >= 60) { 
			this.mins += secs % 60 == 0 ? this.secs / 60 : this.secs % 60;
			this.secs = 0;
			update();
		} else if (secs < 0) {
			this.mins -= -(this.secs / 60) + 1;
			this.secs = 59;
			update();
		}

		if (mins >= 60) {
			this.hrs += mins % 60 == 0 ? this.mins / 60 : this.mins % 60;
			this.mins = 0;
		} else if (mins < 0) {
			this.hrs -= -(this.mins / 60) + 1;
			this.mins = 59;
		}
	}

}