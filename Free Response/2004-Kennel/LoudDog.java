
public class LoudDog extends Dog {

	public LoudDog(String name) {
		super(name);
	}
	
	public String speak() {
		StringBuffer toReturn = new StringBuffer();
		
		for(int i = 0; i < 2; i++) {
			toReturn.append(super.speak() + " ");
		}
		
		return toReturn.toString();
	}
	
}
