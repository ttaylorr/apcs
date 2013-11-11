
public class Square extends Rectangle {
	
	public Square() {
		super("Square", 0, 0);
	}
	
	public Square(double side) {
		super("Square", side, side);
	}

	@Override
	public double getArea() {
		return Math.pow(super.getSide1(), 2);
	}

	@Override
	public double getPerimeter() {
		return super.getSide1() * 4;
	}
	
	
	
}
