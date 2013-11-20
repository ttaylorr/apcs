
public class DigitalVideoDisk extends Disk {
	
	public DigitalVideoDisk(String title, String artist, String SKU) {
		super(title, artist, SKU);
	}

	public String getMediaType() {
		return "DVD";
	}
	
	public String toString() {
		return this.getMediaType() + " - " + super.basicToString();
	}
	
}
