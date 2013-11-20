import java.util.ArrayList;

public class Bin {

	private String name;
	private ArrayList<BinItem> contents;

	public Bin(String name) {
		this.name = name;
		contents = new ArrayList<BinItem>();
	}

	public String getName() {
		return this.name;
	}

	public ArrayList<BinItem> getContents() {
		return this.contents;
	}

	public void add(BinItem b) {
		this.contents.add(b);
	}

	public String toString() {
		String s = "Bin " + this.getName() + ":\n";

		for (BinItem b : this.contents) {
			s += b + "\n";
		}

		return s;
	}

}
