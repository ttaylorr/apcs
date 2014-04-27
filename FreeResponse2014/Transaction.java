public class Transaction {

    private String description;
    private int numItems;
    private double cost;
    protected static final double TAX_RATE = 0.07d;

    public Transaction(String description, int numItems, double cost) {
        this.description = description;
        this.numItems = numItems;
        this.cost = cost;
    }

    public String getDescription() {
        return this.description;
    }

    public int getNumItems() {
        return this.numItems;
    }

    public double getCost() {
        return this.cost;
    }

    public double getTotal() {
        return this.cost + (this.cost * TAX_RATE);
    }
}
