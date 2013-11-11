
public class IsoscelesTriangle extends Triangle {

	public IsoscelesTriangle(String name, double base, double leg) {
		super(name);

		super.setLeg1(base);
		super.setLeg2(leg);
		super.setLeg3(leg);
	}

}
