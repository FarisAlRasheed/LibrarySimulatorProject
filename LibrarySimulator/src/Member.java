/*
	Team members:
	Name 							Uni ID
	1-Fahad Aldeghaither			446102355
	2-Faris Alrasheed  				446101056
	3-Abdulrahman Alwaalan			446107578


   GitHub repositery URL: https://github.com/FarisAlRasheed/LibrarySimulatorProject/tree/Member
 */
public class Member {
	//instances attributes
	private int id;
	private String name;
	private int borrowedCount;//currently borrowed books for each user
	private int numViewBorrowed;
	private int numBorrows;
	private int numReturns;
	private double sessionFees;
	//static vars across all instances
	public static double totalRevenue;
	public static int totalViewBorrowed;
	public static int totalBorrows;
	public static int totalReturns;
	
	//main constructor
	public Member(int id,String name, int borrowedCount) {
		this.id=id;
		this.name=name;
		this.borrowedCount=borrowedCount;
	}
	//default constructor
	public Member() {
		id=0;
		name="";
		borrowedCount=0;
	}

	//if can borrow condition
	private boolean canBorrow() {
		
		return borrowedCount<5;
	}
	
	//if can return condition
	private boolean canReturn() {
		
			return borrowedCount>0;		
		
	}
	
	public boolean borrowOne() {
		if (canBorrow()) {
			borrowedCount++;
			numBorrows++;
			totalBorrows++;
			sessionFees += 0.5;
			totalRevenue += 0.5;
			return true;
		}
		else {
			System.err.println("\nERROR: You can't borrow more than 5 books at once!");
			return false;
		}
		
	}
	public boolean returnOne() {
		if(canReturn()) {
			borrowedCount--;
			numReturns++;
			totalReturns++;
			return true;
		}
		else{
			System.err.println("\nERROR: You don't have books to return!");
			return false;
		}
	}
	

	public void displayStatistics() {
		System.out.println("\nSession Activity Summary");
		System.out.println("===\nBooks Borrowed: " + numBorrows);
		System.out.println("Books Returned: " + numReturns);
		System.out.printf("Total Fees: %.2f\n===\n", sessionFees);
	}
	
	public void reset() {
		sessionFees=0;
		numReturns=0;
		numBorrows=0;
	}
	
	public String getName() {
		return name;
	}
	
	public double getSessionFees() {
		return sessionFees;
	}
	public int getBorrowed() {
		return borrowedCount;
	}
	public static void frequentOperation() {
		System.out.println("\nMost Frequent Operations");
		System.out.println("===");
		if(totalBorrows == totalReturns){
			System.out.println("borrow and return opperations are the same");
		}
		else if(totalBorrows > totalReturns){
			System.out.println("borrow opperations are more frequent");
		}
		else{
			System.out.println("return opperations are more frequent");
		}
		System.out.println("===");
		
	}
	
	public void viewBorrowedCount() {
		System.out.println("Borrowed Count = " + borrowedCount);
		numViewBorrowed++;
	}
	
}
