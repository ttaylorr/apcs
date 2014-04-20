public class Timer {

    private long start;
    private long end;

    public long start() {
        return this.start = System.currentTimeMillis();
    }

    public long end() {
        return this.end = System.currentTimeMillis();
    }

    public long durration() {
        return this.end - this.start;
    }

    public String toString() {
        return this.durration() + " ms";
    }
}
