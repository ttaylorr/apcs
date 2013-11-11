
public class Fraction {

	private int numerator;
	private int denominator;

	public Fraction() {
		this.numerator = 0;
		this.denominator = 0;
	}
	
	public Fraction(int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}

	public int getNumerator() {
		return numerator;
	}

	public void setNumerator(int numerator) {
		this.numerator = numerator;
	}

	public int getDenominator() {
		return denominator;
	}

	public void setDenominator(int denominator) {
		this.denominator = denominator;
	}

	public boolean equals(Fraction f1) {
		return this.toDouble() == f1.toDouble();
	}
	
	public boolean lessThan(Fraction f1) {
		return this.toDouble() < f1.toDouble();
	}
	
	public double toDouble() {
		return (double) this.getNumerator() / this.getDenominator();
	}
	
	@Override
	public String toString() {
		return this.getNumerator() + "/" + this.getDenominator();
	}
	
	public void add(Fraction f1) {
		int d1 = f1.getDenominator();
		
		f1.numerator *= this.getDenominator();
		f1.denominator *= this.getDenominator();
		
		this.numerator *= d1;
		this.denominator *= d1;
		
		this.numerator += f1.getNumerator();
		
		this.reduce();
	}

	public void subtract(Fraction f1) {
		this.add(new Fraction(f1.getNumerator() * -1, f1.getDenominator()));
	}
	
	public void multiply(Fraction f1) {
		this.numerator *= f1.getNumerator();
		this.denominator *= f1.getDenominator();
		
		this.reduce();
	}
	
	public void divide(Fraction f1) {
		this.multiply(new Fraction(f1.getDenominator(),f1.getNumerator()));
	}
	
	protected int gcm(int a, int b) {
		return b == 0 ? a : gcm(b, a % b);
	}
	
	protected void reduce() {
		int gcm = gcm(this.getNumerator(), this.getDenominator());
		
		this.numerator /= gcm;
		this.denominator /= gcm;
	}
	
}