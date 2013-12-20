
public class BoardPiece {

	private int position;
	private Type type;
	
	public BoardPiece(int position, Type type) {
		if (position < 1 || position > 40)
			throw new IllegalArgumentException();
	
		this.position = position;
		this.type = (type == null ? Type.NONE : type);
	}
	
	public Type getType() {
		return this.type;
	}
	
	public int getPosition() {
		return this.position;
	}
	
	public void setType(Type type) {
		this.type = type;
	}
	
	public boolean isDoubleWord() { return this.type == Type.DOUBLE_WORD; }
	public boolean isDoubleLetter() { return this.type == Type.DOUBLE_LETTER; }
	public boolean isTripleWord() { return this.type == Type.TRIPLE_WORD; }
	public boolean isTrippleLetter() { return this.type == Type.TRIPLE_LETTER; }
	
	@Override
	public String toString() {
		return this.getPosition() + " - " + this.getType();
	}
	
	public static enum Type {
		DOUBLE_WORD, DOUBLE_LETTER, TRIPLE_WORD, TRIPLE_LETTER, NONE;
	}
	
}
