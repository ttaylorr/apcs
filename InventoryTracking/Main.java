import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
	}
	
	public static String lookupMedia(ArrayList<MusicMedia> catalog, String sku) {
		for(MusicMedia m : catalog) {
			if(m.getSKU().equalsIgnoreCase(sku)) {
				return m.toString();
			}
		}
		
		return "SKU not found...";
	}
	
}
