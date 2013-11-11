
public class Triangle extends Shape {

	private double leg1, leg2, leg3;
	
	public Triangle(String name) {
		super(name);
	}
	
	public Triangle(String name, double leg1, double leg2, double leg3) {
		super(name);
		
		this.leg1 = leg1;
		this.leg2 = leg2;
		this.leg3 = leg3;
	}

	public double getLeg1() {
		return leg1;
	}

	public void setLeg1(double leg1) {
		this.leg1 = leg1;
	}

	public double getLeg2() {
		return leg2;
	}

	public void setLeg2(double leg2) {
		this.leg2 = leg2;
	}

	public double getLeg3() {
		return leg3;
	}

	public void setLeg3(double leg3) {
		this.leg3 = leg3;
	}
	
	public double getPerimeter() {
		return this.leg1 + this.leg2 + this.leg3;
	}
	
	public double getArea() {
		double s = this.getSemiperimeter();
		double a = Math.sqrt(s * (s-this.leg1) * (s-this.leg2) * (s-this.leg3));
		return a;
	}
}