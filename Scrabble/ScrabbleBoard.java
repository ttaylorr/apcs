import java.util.ArrayList;
import java.util.List;


public class ScrabbleBoard {

	private static BoardPiece[][] board;
	
	static {
		board = new BoardPiece[4][10];
		
		for(int i = 0; i < 4; i++) {
			for (int j = 0; j < 10; j++) {
				board[i][j] = new BoardPiece((10 * i) + j + 1, null);
			}
		}
		
		board[0][2].setType(BoardPiece.Type.DOUBLE_LETTER);
		board[0][8].setType(BoardPiece.Type.DOUBLE_LETTER);
		board[1][4].setType(BoardPiece.Type.DOUBLE_LETTER);
		board[2][0].setType(BoardPiece.Type.DOUBLE_LETTER);
		board[2][6].setType(BoardPiece.Type.DOUBLE_LETTER);
		board[3][2].setType(BoardPiece.Type.DOUBLE_LETTER);
		board[3][8].setType(BoardPiece.Type.DOUBLE_LETTER);

		board[0][4].setType(BoardPiece.Type.TRIPLE_LETTER);
		board[0][9].setType(BoardPiece.Type.TRIPLE_LETTER);
		board[1][9].setType(BoardPiece.Type.TRIPLE_LETTER);
		board[2][4].setType(BoardPiece.Type.TRIPLE_LETTER);
		board[2][9].setType(BoardPiece.Type.TRIPLE_LETTER);
		board[3][4].setType(BoardPiece.Type.TRIPLE_LETTER);
		board[3][9].setType(BoardPiece.Type.TRIPLE_LETTER);

		board[0][6].setType(BoardPiece.Type.DOUBLE_WORD);
		board[1][3].setType(BoardPiece.Type.DOUBLE_WORD);
		board[2][7].setType(BoardPiece.Type.DOUBLE_WORD);

		board[0][7].setType(BoardPiece.Type.TRIPLE_WORD);
		board[1][5].setType(BoardPiece.Type.TRIPLE_WORD);
		board[2][3].setType(BoardPiece.Type.TRIPLE_WORD);
		board[3][1].setType(BoardPiece.Type.TRIPLE_WORD);
	}
	
	public ArrayList<BoardPiece> getPiecesFor(int startingPos, char direction) {
		ArrayList<BoardPiece> pieces = new ArrayList<BoardPiece>();
	
		for (int i = 0; i < 4; i++) {
			if (direction == 'H') {
				pieces.add(getBoardPieceForPosition(startingPos + i));
			} else if (direction == 'V') {				
				pieces.add(getBoardPieceForPosition(startingPos + (i * 10)));
			}
		}
		
		return pieces;
	}
	
	public static BoardPiece getBoardPieceForPosition(int position) {
		List<BoardPiece> temp = new ArrayList<BoardPiece>();
		
		for(BoardPiece[] boardRow : board) {
			for(BoardPiece boardPiece : boardRow) {
				temp.add(boardPiece);
			}
		}
		
		return temp.get(position - 1);
	}
	
	public static int getCharValue(char c) {
		if (c == 'A' || c == 'E') return 1;
		if (c == 'D' || c == 'R') return 2;
		if (c == 'B' || c == 'M') return 3;
		if (c == 'V' || c == 'Y') return 4;
		if (c == 'J' || c == 'X') return 8;
		
		return -1;
	}	
}
