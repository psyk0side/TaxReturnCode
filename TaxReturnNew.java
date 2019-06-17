package taxReturn;

import java.util.Scanner;

public class TaxReturnOld {
	/**
	 * Constructs a TaxReturn object for a given income and marital status, and
	 * computes the tax.
	 * 
	 * @param anIncome the taxpayer income
	 * @param aStatus  either SINGLE or MARRIED
	 **/
	public TaxReturnOld(double anIncome, int aStatus) {
		income = anIncome;
		status = aStatus;
	}

	// determines which tax bracket you fall into and calculates
	public double getTax() {
		double tax = 0;
		// single brackets
		if (status == SINGLE) {
			if (income <= SINGLE_BRACKET1) {
				tax = RATE1 * income;
			} else if (income <= SINGLE_BRACKET2) {
				tax = RATE2 * income;
			} else {
				tax = RATE3 * income;
			}
			// married brackets
		} else if (status == MARRIED) {
			if (income <= MARRIED_BRACKET1) {
				tax = RATE1 * income;
			} else if (income <= MARRIED_BRACKET2) {
				tax = RATE2 * income;
			} else {
				tax = RATE3 * income;
			}
		} else if (status == SINGLE_PARENT) {
			if (income <= SINGLEP_BRACKET1) {
				tax = RATE1 * income - (chIld * 5000);
			} else if (income <= SINGLEP_BRACKET2) {
				tax = RATE2 * income - (chIld * 5000);
			} else {
				tax = RATE3 * income - (chIld * 5000);
			}
		} else {
			tax = RATE4 * income;
		}
		return tax;
	}

	// variable declarations and initializers
	public static final int SINGLE = 1;
	public static final int MARRIED = 2;
	public static final int SINGLE_PARENT = 3;
	public static final int UNKNOWN = 4;
	private static final double RATE1 = 0.15;
	private static final double RATE2 = 0.28;
	private static final double RATE3 = 0.31;
	private static final double RATE4 = 0.33;
	private static final double SINGLE_BRACKET1 = 22450;
	private static final double SINGLE_BRACKET2 = 52900;
	private static final double MARRIED_BRACKET1 = 35800;
	private static final double MARRIED_BRACKET2 = 86500;
	private static final double SINGLEP_BRACKET1 = 22450;
	private static final double SINGLEP_BRACKET2 = 52900;
	private double income;
	private int status;
	public int chIld;

	// main method
	public static void main(String[] args) {

		// scanner object to get inputs
		Scanner in = new Scanner(System.in);

		System.out.print("Please enter your income: ");
		double income = in.nextDouble();

		System.out.print("Enter S (single), M (married), SP (single parent), or U (other): ");
		String input = in.next();

		int status = 0;

		if (input.equalsIgnoreCase("S")) {
			status = TaxReturnOld.SINGLE;
		} else if (input.equalsIgnoreCase("M")) {
			status = TaxReturnOld.MARRIED;
		} else if (input.equalsIgnoreCase("SP")) {
			status = TaxReturnOld.SINGLE_PARENT;
		} else if (input.equalsIgnoreCase("U")) {
			status = TaxReturnOld.UNKNOWN;
		} else {
			System.out.println("Bad input.");
			return;
		}
		
		if (input.equalsIgnoreCase("SP")) {
			System.out.println("How many children do you have?");
			int chIld = in.nextInt();
		} else {
			
		}

		TaxReturnOld aTaxReturn = new TaxReturnOld(income, status);
		System.out.println("The tax is " + aTaxReturn.getTax());
	}
}
