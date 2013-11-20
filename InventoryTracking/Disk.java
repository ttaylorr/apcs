
public class Disk extends MusicMedia {

	public Disk(String title, String artist, String SKU) {
		super(title, artist, SKU);
	}

	public String getMediaType() {
		return "Disk";
	}
	
	public String toString() {
		return this.getMediaType() + " - " + super.basicToString();
	}
	
}
