public class Sale extends Transaction {

    private boolean isCash;
    protected final double DISCOUNT = 0.10d;

    public Sale(String description, int numItems, double cost, boolean isCash) {
        super(description, numItems, cost);
        this.isCash = isCash;
    }

    public boolean isCash() {
        return this.isCash;
    }

    public boolean isCredit() {
        return !this.isCash;
    }

    @Override
    public double getCost() {
        double a = super.getCost() - (super.getCost() / DISCOUNT);
        return a + (a * TAX_RATE);
    }

}
