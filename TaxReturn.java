
import java.util.Scanner;

public class TaxReturn { 
	
	/** Constructs a TaxReturn object for a given 
	 * income and marital status, and computes the tax. 
	 * @param anIncome the taxpayer income 
	 * @param aStatus either SINGLE or MARRIED 
	 **/
	public TaxReturn(double anIncome, int aStatus) {
        income = anIncome;
        status = aStatus;
    }
	
	//determines which tax bracket you fall into and calculates
    public double getTax() {
        double tax = 0;
        //single brackets
        if (status == SINGLE) {
            if (income <= SINGLE_BRACKET1) {
            	tax = RATE1 * income;
            }else if (income <= SINGLE_BRACKET2) {
            	tax = RATE2 * income;
            }else {
            	tax = RATE3 * income;
            }
        //married brackets
        } else {
            if (income <= MARRIED_BRACKET1) {
            	tax = RATE1 * income;
            }else if (income <= MARRIED_BRACKET2) {
            	tax = RATE2 * income;
            }else {
            	tax = RATE3 * income;
            }
        }
        return tax;
    }
    
    
    
    //variable declarations and initializers
    public static final int SINGLE = 1;
    public static final int MARRIED = 2;
    private static final double RATE1 = 0.15;
    private static final double RATE2 = 0.28;
    private static final double RATE3 = 0.31;
    private static final double SINGLE_BRACKET1 = 21450;
    private static final double SINGLE_BRACKET2 = 51900;
    private static final double MARRIED_BRACKET1 = 35800;
    private static final double MARRIED_BRACKET2 = 86500;
    private double income;
    private int status;
    
    //main method
    public static void main(String[] args) {

    	//scanner object to get inputs
    	Scanner in = new Scanner(System.in);
    	
        System.out.print("Please enter your income: ");
        double income = in.nextDouble();
        
        System.out.print("Enter S (single) or M (married): ");
        String input = in.next();
        
        int status = 0;
        
        if (input.equalsIgnoreCase("S")) {
        	status = TaxReturn.SINGLE;
        }else if (input.equalsIgnoreCase("M")) {
        	status = TaxReturn.MARRIED;
        }else {
            System.out.println("Bad input.");
            return;
        }

        TaxReturn aTaxReturn = new TaxReturn(income, status);
        System.out.println("The tax is " + aTaxReturn.getTax());
    }
}