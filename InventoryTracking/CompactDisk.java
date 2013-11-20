
public class CompactDisk extends Disk {
	
	public CompactDisk(String title, String artist, String SKU) {
		super(title, artist, SKU);
	}

	public String getMediaType() {
		return "CD";
	}
	
	public String toString() {
		return this.getMediaType() + " - " + super.basicToString();
	}
}
