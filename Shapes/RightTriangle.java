public class RightTriangle extends Triangle {

	public RightTriangle(String name) {
		super(name, 0, 0, 0);
		// TODO Auto-generated constructor stub
	}

	public RightTriangle(String name, double a, double b, double c) {
		super(name, a, b, c);
	}

	public boolean isValidRightTriangle() {
		return Math.pow(super.getLeg1(), 2) + Math.pow(super.getLeg2(), 2) == Math.pow(super.getLeg3(), 2);
	}
	
	@Override
	public double getArea() {
		// Overriding the default implementation of Heron's formula for easier calculations
		return 0.5 * this.getLeg1() * this.getLeg2();
	}
}
