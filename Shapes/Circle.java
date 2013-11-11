
public class Circle extends Shape {

	private double radius;
	
	public Circle() {
		super("Circle");
	}
	
	public Circle(double radius) {
		super("Circle");
		this.radius = radius;
	}
	
	public double getRadius() {
		return this.radius;
	}

	@Override
	public double getArea() {
		return Math.pow(this.radius, 2) * Math.PI;	
	}

	@Override
	public double getPerimeter() {
		return 2 * Math.PI * this.radius;
	}
	
}
