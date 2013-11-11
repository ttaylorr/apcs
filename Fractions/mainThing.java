import java.util.Scanner;

public class mainThing {

	public mainThing() {
		boolean isCloseRequested = false;
		int choice = -1;

		Scanner scan = new Scanner(System.in);

		Fraction f1 = new Fraction();

		while (!isCloseRequested) {
			System.out.println("Please enter your choice....");
			System.out
					.println("0 - modify, 1 - add, 2 - subtract, 3 - divide, 4 - multiply, 5 - test equality, 6 - quit");

			choice = scan.nextInt();

			if (choice == 6) {
				isCloseRequested = true;
				System.out.println("Game over, thank you for playing!");
			}

			else if (choice == 0) {
				System.out.println("Please enter a numerator...");
				int n = scan.nextInt();
				System.out.println("Please enter a denomenator...");
				int d = scan.nextInt();

				f1.setNumerator(n);
				f1.setDenominator(d);
			}

			else if (choice == 1) {
				System.out.println("Please enter a numerator...");
				int n = scan.nextInt();
				System.out.println("Please enter a denomenator...");
				int d = scan.nextInt();

				Fraction f2 = new Fraction(n, d);

				System.out.print(f1 + " + " + f2 + " = ");
				f1.add(f2);
				System.out.println(f1);
			}

			else if (choice == 2) {
				System.out.println("Please enter a numerator...");
				int n = scan.nextInt();
				System.out.println("Please enter a denomenator...");
				int d = scan.nextInt();

				Fraction f2 = new Fraction(n, d);

				System.out.print(f1 + " - " + f2 + " = ");
				f1.subtract(f2);
				System.out.println(f1);
			}

			else if (choice == 3) {
				System.out.println("Please enter a numerator...");
				int n = scan.nextInt();
				System.out.println("Please enter a denomenator...");
				int d = scan.nextInt();

				Fraction f2 = new Fraction(n, d);

				System.out.print(f1 + " / " + f2 + " = ");
				f1.divide(f2);
				System.out.println(f1);
			}

			else if (choice == 4) {
				System.out.println("Please enter a numerator...");
				int n = scan.nextInt();
				System.out.println("Please enter a denomenator...");
				int d = scan.nextInt();

				Fraction f2 = new Fraction(n, d);

				System.out.print(f1 + " - " + f2 + " = ");
				f1.subtract(f2);
				System.out.println(f1);
			}

			else if (choice == 5) {
				System.out.println("Please enter a numerator...");
				int n = scan.nextInt();
				System.out.println("Please enter a denomenator...");
				int d = scan.nextInt();

				Fraction f2 = new Fraction(n, d);

				System.out.println(f1 + " ?= " + f2 + " = " + (f1.equals(f2)));

			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		new mainThing();
	}

}