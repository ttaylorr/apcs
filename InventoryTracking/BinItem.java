
public class BinItem {

	private String SKU;
	private int quantity;
	
	public BinItem(String SKU, int quantity) {
		this.SKU = SKU;
		this.quantity = quantity;
	}

	public String getSKU() {
		return SKU;
	}

	public int getQuantity() {
		return quantity;
	}
	
	public String toString() {
		return "SKU " + this.getSKU() + ": " + this.quantity;
	}
	
}
