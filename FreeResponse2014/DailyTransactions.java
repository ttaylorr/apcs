public class DailyTransactions {

    private Transaction[] transactions;

    public DailyTransactions(Transaction... transactions) {
        this.transactions = transactions;
    }

    public double getTransactionAverage() {
        double d = 0;
        for (Transaction t : this.transactions) {
            d += t.getTotal();
        }

        return this.transactions.length == 0 ? 0.0d : d / this.transactions.length;
    }
}
