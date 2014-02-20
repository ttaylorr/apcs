import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Name {

	public static void main(String[] args) {
		List<String> reverse = Arrays.asList("Sample Name".split(" "));
		Collections.reverse(reverse);
		String output = (Arrays.toString(reverse.toArray())).replace('[', ' ').replace(']', ' ').trim();
		System.out.println(output);
	}

}
