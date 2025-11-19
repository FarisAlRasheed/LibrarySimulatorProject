
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
		
		return borrowedCount<5;
	}
		
	private boolean canReturn() {
		
			return borrowedCount>0;		
		
	}
	
	
	
	
	
}
