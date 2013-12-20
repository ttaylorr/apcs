import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Scrabble {

	private static final boolean DEBUG = false;
	
	public static void main(String[] args) throws IOException {

		File file;
		BufferedReader reader = null;

		ScrabbleBoard board = new ScrabbleBoard();
		String word = null;
		ArrayList<ArrayList<String>> instructions = new ArrayList<ArrayList<String>>();
		
		try {
			file = new File("./ACSL.dat");
			reader = new BufferedReader(new FileReader(file));
		} catch (IOException e) {
			System.err.println("Unable to read from file, aborting!");
			System.exit(-1);
		}

		int lineNum = 0;

		while (true) {
			if (!reader.ready())
				break;

			if (lineNum == 0) {
				word = reader.readLine().replaceAll(",", "");
			} else {
				String line = reader.readLine();

				String[] data = line.split(",");
				
				ArrayList<String> inst = new ArrayList<String>();
				for(int i = 0; i < 6; i += 2) {
					inst.add(data[i] + "," + data[i + 1]);
				}

				instructions.add(new ArrayList<String>());
				instructions.set(lineNum - 1, inst);
			}
			
			lineNum++;
		}
		
		for(ArrayList<String> instruction : instructions) {
			HashMap<ArrayList<BoardPiece>, Integer> piecesInRange = new HashMap<ArrayList<BoardPiece>, Integer>();
			
			for(String s : instruction) {
				int pos = Integer.parseInt(s.split(",")[0]);
				char dir = s.split(",")[1].charAt(0);

				int score = 0;
				int mult = 1;
				
				ArrayList<BoardPiece> pieces = board.getPiecesFor(pos, dir);
				
				for(int i = 0; i < pieces.size(); i++) {
					BoardPiece piece = pieces.get(i);
					
					if (DEBUG) System.out.println(piece.toString());
					
					if(piece.isDoubleWord()) mult *= 2;
					if(piece.isTripleWord()) mult *= 3;
					
					if(piece.isDoubleLetter()) score += (ScrabbleBoard.getCharValue(word.charAt(i)) * 2);
					else if(piece.isTrippleLetter()) score += (ScrabbleBoard.getCharValue(word.charAt(i)) * 3);
					else score += (ScrabbleBoard.getCharValue(word.charAt(i)) * 1);
				}
				
				score *= mult;
				
				if (DEBUG) System.out.println("Score: " + score + " mult: " + mult + "\n");
				
				piecesInRange.put(pieces, score);
			}
			
			int largest = Collections.max(piecesInRange.values());
			if (DEBUG) System.out.println((piecesInRange.values()));

			System.out.println(largest);
		}
	}

}
