package investmentAdviserV2;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class program {
	
	public static void main(String[] args)
	{
		mainMenu();		
	}
	
	public static void mainMenu() 
	{
		int selectionOption;
		Scanner input = new Scanner(System.in);
		
		
		while(true) {
			System.out.println( "Real Estate Investment Adviser \n" +
					  "-----------------------------\n" +
					  "[1] - Calculate cashflow\n" +
		              "[2] - Exit\n" +
		              "What would you like to do? "
		            );
			selectionOption = input.nextInt();
			if(selectionOption == 1) {
				cashflow();
				input.close();
				break;
			}else if (selectionOption == 2) {
				exit();
				input.close();
				break;
			}else {
				System.out.println("RESPONSE: Choose one of the options! \n");
				continue;
			}
		}
		input.close();
	}
	
	public static void cashflow() 
	{
		/*
		USER INPUT
		•	Actual purchase price 
		•	Monthly rent income 
		•	Monthly expenses 
		•	Total Loan amount
		•	Down payment 
		•	Total interest rate 
		•	Length of mortgage 
		*/
		
		int userInput;
		Scanner input = new Scanner(System.in);
		
		// main list
		List<LinkedHashMap<String,String>> list = new ArrayList<LinkedHashMap<String, String>>();
	    LinkedHashMap<String, String> userEntry = new LinkedHashMap<String, String>();
	    
	    // user input list
	    List<LinkedHashMap<String,Integer>> listASK = new ArrayList<LinkedHashMap<String, Integer>>();
	    LinkedHashMap<String, Integer> userEntryASK = new LinkedHashMap<String, Integer>();
	    List<Integer> prices = new ArrayList<Integer>();
	    
	    // set value and key for main list
	    userEntry.put("Aparment Puchase Price","0");
	    userEntry.put("Rent Income per month","0");
	    userEntry.put("Rent Expenses per month","0");
	    userEntry.put("Total LoanAmount","0");
	    userEntry.put("Down Payment","0");
	    userEntry.put("Total Interest Rate","0");
	    userEntry.put("Mortgage Length","0");
	    
	    // add value and key to the main list
	    list.add(userEntry);
	    
	    // Loop main key list and ask user for input
	    for(Map<String, String> map : list){
	        for(String key : map.keySet()){
	        	System.out.println("Please enter value of " + key);
	        	userInput = input.nextInt();
	        	userEntryASK.put(key,userInput);
	        }
	        listASK.add(userEntryASK);
	    }
	    
	    // print after user entries 
	    for(Map<String, Integer> map : listASK){
	    	System.out.println("You entered following values. Please review your entries.\n");
	        for(String key : map.keySet()){
	        	int value = map.get(key);
	        	prices.add(value);
	            System.out.println(key + ": price " + value );
	        }
	    }
	    
	    // user decide to show the result or exit
	    System.out.println( "\n Last step \n" +
				  "-----------------------------\n" +
				  "[1] - Calculate cashflow based on these values\n" +
	              "[2] - Exit\n" +
	              "What would you like to do? --"
	            );
		userInput = input.nextInt();
		
		if(userInput == 1) {
			// set type
			int purchasePrice, rentIncome, rentExpenses,
			totalLoanAmount, downPayment, totalInterestRate, mortgageLength;
			
			// user inputs
		    purchasePrice = prices.get(0);
		    rentIncome =prices.get(1);
		    rentExpenses =prices.get(2); 
		    totalLoanAmount = prices.get(3);
		    downPayment = prices.get(4);
		    totalInterestRate = prices.get(5);
		    mortgageLength = prices.get(6);
		    
			/*
			Program calculations 
			•	VAT 30%
			•	Monthly Mortgage payment
			•	Actual interest 
			•	Total annual debt 
			•	Total monthly cash flow before tax
			•	Total annual cash flow before tax 
			•	Cash on cash return
			*/
		    
			/* calculations_ program output */
		    
		  
			
			// monthly mortgage payment
	      	double rate =( 2.250/100)/12; 
	      	int time = mortgageLength * 12; 
	      	double mortgagePayment = (totalLoanAmount * rate) / (1 - Math.pow(1 + rate, -time));
	      
	        // rent - expenses - interestRate * 12 
			double vat = rentIncome - rentExpenses - mortgagePayment;
			
			// Actual Capitalization Rate 
	    	int calc1 = rentIncome - rentExpenses;
			double actualInterest = calc1 * 100 / purchasePrice;
	
			
			// Total Annual Debt 
			double annualDebt = mortgagePayment * 12; 
			
			// Monthly CashFlow 
			double monthlyCashFlow = rentIncome - rentExpenses - mortgagePayment; 
			
			// Annual CashFlo2 
			int incomePerYear = rentIncome * 12;
			int expensesPerYear = rentExpenses * 12;
			int calc = incomePerYear - expensesPerYear;
			double annualCashFlow  = calc - annualDebt; 
			
			// Cash on Cash Return ROI 
			double cashOnCashReturn = annualCashFlow * 100 /downPayment; 
			
		
			
			System.out.println("Vat 30%: " + vat +  " /year \n" +
							 	"Monthly Morgage Payment: " + mortgagePayment + " /monthly \n" +
							 	"Actual interest: " + actualInterest + " %\n" +
							 	"Total annual debt: " + annualDebt + "\n" +
							 	"Total monthly cash flow before tax: " + monthlyCashFlow + "\n" +
							 	"Total annual cash flow before tax: " + annualCashFlow + "\n" +
							 	"Cash on cash return: " + cashOnCashReturn + " %\n" 
								); 
			input.close();
		}else if (userInput == 2) {
			exit();
			input.close();
			
		}else {
			System.out.println("RESPONSE: Choose one of the options! \n");
		}
		
	    input.close();
	}
	
	
	public static void exit() 
	{
		System.out.print("Exit the program\n");
	}
}
