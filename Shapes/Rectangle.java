
public class Rectangle extends Shape {

	private double side1;
	private double side2;
	
	public Rectangle(String name) {
		super(name);
		
		this.side1 = 0;
		this.side2 = 0;
	}
	
	public Rectangle(String name, double side1, double side2) {
		super(name);
		
		this.side1 = side1;
		this.side2 = side2;
	}
	
	public double getSide1() {
		return side1;
	}

	public double getSide2() {
		return side2;
	}
	
	public double getArea() {
		return this.side1 * this.side2;
	}
	
	public double getPerimeter() {
		return 2 * (this.side1 + this.side2);
	}
	
}
