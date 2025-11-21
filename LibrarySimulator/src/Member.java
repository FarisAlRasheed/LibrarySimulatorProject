
public class Member {
	//
	private int id;
	private String name;
	private int borrowedCount;
	private int numViewBorrowed;
	private int numBorrows;
	private int numReturns;
	private double sessionFees;

	//admin
	public static double totalRevenue;
	public static int totalViewBorrowed;
	public static int totalBorrows;
	public static int totalReturns;
	
	//
	public Member(int id,String name, int borrowedCount) {
		this.id=id;
		this.name=name;
		this.borrowedCount=borrowedCount;

	}
//
	public Member() {
	id=0;
	name="";
	borrowedCount=0;
		
	}

	private boolean canBorrow() {
		System.out.println("\n ## You can't borrow more than 5 books at once! ## ");
		return borrowedCount<5;
	}
		
	private boolean canReturn() {
		System.out.println("\n## You don't have books to return! ##");
		return borrowedCount>0;		
	}

	private  void viewBorrowedCount() {
		System.out.println("===\nBooks Borrowed: " + numBorrows);
	}
	
	private void borrowOne() {
		if (canBorrow() == false) {
			return;
		}
		else {
			numBorrows++;
			totalBorrows++;
			sessionFees += 0.5;
			totalRevenue += 0.5;
		}
		
	}
	private void returnOne() {
		if(canReturn() == false) {
			return;
		}
		else{
			numBorrows--;
			numReturns++;
			totalBorrows--;
			totalReturns++;
		}
	}
	
	
	
	
}
