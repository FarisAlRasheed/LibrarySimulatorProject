
public class Member {
	//
	private int id;
	private String name;
	private int borrowedCount;
	private int numViewBorrowed;
	private int numBorrows;
	private int numReturns;
	private double sessionFees;
	//
	public static double totalRevenue;
	public static int totalViewBorrowed;
	public static int totalBorrows;
	public static int totalReturns;

	//
	public Member(int id, String name, int borrowedCount) {
		this.id = id;
		this.name = name;
		this.borrowedCount = borrowedCount;

	}
//

	public void displayStatistics() {
		System.out.println("\nSession Activity Summary");
		System.out.println("===\nBooks Borrowed: " + numBorrows);
		System.out.println("Books Returned: " + numReturns);
		System.out.println("Total Fees: " + sessionFees + "\n===");

	}

	private boolean canBorrow() {

		return borrowedCount < 5;
	}

	private boolean canReturn() {

		return borrowedCount > 0;

	}

	public boolean borrowOne() {

		if (canBorrow()) {
			borrowedCount++;
			totalBorrows++;
			numBorrows++;
			sessionFees += 0.5;
			totalRevenue += 0.5;
			return true;
		} else {
			System.err.println("\n ## You can't borrow more than 5 books at once! ## ");
		return false;
		}

	}

	public void reset() {
		numBorrows = 0;
		numReturns = 0;
		sessionFees = 0;
	}

	public boolean returnOne() {

		if (canReturn()) {
			numReturns++;
			totalReturns++;

			borrowedCount--;
return true;
		} else {
			System.err.println("\n## You don't have books to return! ##");
		return false;
		}

	}

	public String getName() {

		return name;
	}

	public int getId() {

		return id;
	}


	public int viewBorrowedCount() {

		numViewBorrowed++;
		return borrowedCount;
	}

	
}
