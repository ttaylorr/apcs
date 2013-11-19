import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MyFileReader {

	// Author: Taylor and Miranda and StackOverflow

	public static void main(String[] args) {
		BufferedReader in;

		int sentences = 0;
		int words = 0;

		String all = "";

		try {
			in = new BufferedReader(new FileReader(
					"C:\\Users\\TBLAU16\\workspace\\FileReader\\test.txt"));

			while (true) {
				if (in.ready()) {
					all += in.readLine();

					// Process file
				} else {
					// done.
					System.out.println(all);
					
					all.replace((CharSequence)".  ", (CharSequence)". ");
					all.replace((CharSequence)"!  ", (CharSequence)"! ");
					all.replace((CharSequence)"?  ", (CharSequence)"? ");
					all.trim();
					
					sentences = all.split("(\\S.+?[.!?])(?=\\s+|$)").length;
				
					words += all.split("\\ ").length;
					words -= sentences;
					words += 1;
					
					System.out.println("Words: " + words);
					System.out.println("Sentences: " + sentences);
					
					break;

				}
			}

			in.close();
		} catch (IOException e) {
			System.err.println("wat");
			e.printStackTrace();
		}
	}

}
