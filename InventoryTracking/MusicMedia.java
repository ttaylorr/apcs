
public class MusicMedia {

	private String title;
	private String artist;
	private String SKU;
	
	public MusicMedia(String title, String artist, String SKU) {
		this.title = title;
		this.artist = artist;
		this.SKU = SKU;
	}

	public String getTitle() {
		return title;
	}

	public String getArtist() {
		return artist;
	}

	public String getSKU() {
		return SKU;
	}
	
	public String getMediaType() {
		return "Unknown";
	}
	
	public String basicToString() {
		return this.title + " (" + this.artist + ")";
	}
	
	public String toString() {
		return this.title + " (" + this.artist + ")";
	}
}
