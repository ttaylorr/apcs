public class RegularHexagon extends Shape {

	private double sideLength;
	private double radius;

	public RegularHexagon(String name) {
		super(name);
	}

	public RegularHexagon(String name, double sideLength, double radius) {
		super(name);

		this.sideLength = sideLength;
		this.radius = radius;
	}

	@Override
	public double getArea() {
		return 6 * (new IsoscelesTriangle("temp", sideLength, radius))
				.getArea();
	}

	@Override
	public double getPerimeter() {
		return this.sideLength * 6;
	}

}
