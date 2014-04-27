public class Return extends Transaction {

    public Return(String description, int numItems, double cost) {
        // Cost made negative since it's a return
        super(description, numItems, -cost);
    }
}
