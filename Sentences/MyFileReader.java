import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Author(name = "Taylor Blau")
@Author(name = "Miranda Weismantel")
@Author(name = "Jack Townsend")

public class MyFileReader {

	public static void main(String[] args) {
		BufferedReader in;

		int sentences = 0;
		int words = 0;

		String all = "";

		try {
			in = new BufferedReader(new FileReader(
					"./myfile.txt"));

			while (true) {
				if (in.ready()) {
					all += in.readLine();

					// Process file
				} else {
					// done.
					System.out.println(all);
					
					all.replace(".  ", ". ");
					all.replace("!  ", "! ");
					all.replace("?  ", "? ");
					all.replace("-", "");
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
			e.printStackTrace();
		}
	}

}
