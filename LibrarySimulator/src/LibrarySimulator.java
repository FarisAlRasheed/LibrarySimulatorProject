/*
Team members:
Name 							Uni ID
1-Fahad Aldeghaither			446102355
2-Faris Alrasheed  				446101056
3-Abdulrahman Alwalan
 */

import java.util.Scanner;

public class LibrarySimulator {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		//Booleans used to manage menus state
		boolean programMenuON = true; // turn on program
		boolean userMenuOn = true; // turn on member menu
		boolean userLogin = true; // turn on member login menu
		boolean adminMenuOn = true; // turn on admin menu

		//first user vars
		String userName_1 = "Faris";
		int userId_1 = 1;
		int userBorrowed_1 = 0;
		int userReturned_1 = 0;

		//second user vars
		String userName_2 = "Fahad";
		int userId_2 = 2;
		int userBorrowed_2 = 0;
		int userReturned_2 = 0;

		//third user vars
		String userName_3 = "Abdulrahman";
		int userId_3 = 3;
		int userBorrowed_3 = 0;
		int userReturned_3 = 0;

		//shared vars for users each session
		String userName = "";
		int userID = 0;
		int Borrowed = 0;
		int returned = 0;
		double Balance = 0;

		//vars for admin stats
		int totBorrow = 0;
		int totReturn = 0;
		double totBalance = 0;

		//welcome message
		System.out.println("\nWelcome to the LibrarySimulator!");

		//main program menu
		do {
			System.out.println("=========================================");
			System.out.println("Main Menu:");
			System.out.println("1. Login as Member");
			System.out.println("2. Login as Administrator");
			System.out.println("3. Exit Program");
			System.out.print("\nChoose an option: ");
			String Choice = input.next();

			switch (Choice) {
			case "1": // Member Login
				userLogin =true;
				do { //login 
					
					System.out.println("\n=========================================\nEnter the member ID to log in, or 4 to exit: ");
					System.out.println("(ID: 1) Faris");
					System.out.println("(ID: 2) Fahad");
					System.out.println("(ID: 3) Abdulrahman");
					System.out.println("4. Exit Program");
					System.out.print("\nChoose an option: ");

					String userId = input.next();

					switch (userId) // select which user
					{

					case "1": // choice Faris
						userName = userName_1;
						Borrowed = userBorrowed_1;
						returned = userReturned_1;
						userID = userId_1;
						userLogin = false;
						break;
					case "2": // choice Fahad
						userName = userName_2;
						Borrowed = userBorrowed_2;
						returned = userReturned_2;
						userID = userId_2;
						userLogin = false;
						break;
					case "3": // choice Abdulrahman
						userName = userName_3;
						Borrowed = userBorrowed_3;
						returned = userReturned_3;
						userID = userId_3;
						userLogin = false;
						break;
					case "4":
						System.out.println("Exiting the program, Thank you ");
						return; // Exit the program

					default:
						System.err.println("Invalid member ID. Please try again.");
						continue;

					}
				} while (userLogin);
				userMenuOn=true;
				do { //user menu
					System.out.println("\nWelcome " + userName + "!"
					+"\n========================================="
					+"\nTotal Fees: " + Balance + "\t\t" + "Borrowed Books: " + Borrowed + "\\5"
					+"\n=========================================");	
					System.out.println("Member Operations Menu:"
					+"\n1. Borrow a Book"
					+"\n2. Return a Book"
					+"\n3. Session Activity Summary"
					+"\n4. Exit to Main Menu"
					+"\n5. Exit Program");
					System.out.print("\nChoose an option: ");
					String choice = input.next();

					switch (choice) {

					case "1":
						if(Borrowed < 5){
							Borrowed++;
							totBorrow++;
							Balance -= 0.5;
							totBalance += 0.5;
						}
						else{
							System.err.println("\n ## You can't borrow more than 5 books at once! ## ");
						}
						break;
						
					case "2":
						if(Borrowed <= 5 && Borrowed != 0){
							//for user stats and vars
							Borrowed--;
							returned++;

							//for admin stats
							totBorrow--;
							totReturn++;
						}
						else{
							System.out.println("\n## You don't have books to return! ##");
						}
						break;
					case "3":
						System.out.println("\nSession Activity Summary");
						System.out.println("===\nBooks Borrowed: " + Borrowed);
						System.out.println("Books Returned: " + returned);
						System.out.println("Total Fees: " + Balance +"\n===");

						break;

					case "4": // Exit to main menu
						//to save users data
						if(userID == 1){
							userBorrowed_1 = Borrowed;
						}
						else if(userID == 2){
							userBorrowed_2 = Borrowed;
						}
						else if(userID == 3){
							userBorrowed_3 = Borrowed;
						}
						Balance =0;
						returned = 0;

						// to exit
						userMenuOn = false;
						break;

					case "5": // Exit Program
						System.out.println("Thank you for using the LibrarySimulator!");
						return;

					default:
						System.err.println("Invalid option, Please try again.");
						break;

					}
				} while (userMenuOn); // end do for member menu

				break; // end case 1 for member menu

			case "2": // Admin login
				do {

					System.out.println("*****************************************"
							+ "\nEnter admin password to login, or 0 to exit to Main Menu");
					String password = input.next();

					if (password.equals("admin")) {
							
						System.out.println("Welcome admin!");

						do {
							System.out.println("=========================================");

							System.out.println("admin Operations Menu:");
							System.out.println("1. .........");
							System.out.println("2. .........");
							System.out.println("3. ..............");
							System.out.println("4. Exit to Main Menu");
							System.out.println("5. Exit Program");
							System.out.print("Choose an option: ");
							String choice = input.next();

							switch (choice) {

							case "1":

							case "2":

							case "3":

							case "4": // Exit to main menu

								adminMenuOn = false;
								break;

							case "5": // Exit Program
								System.out.println("Thank you for using the LibrarySimulator!");
								return;

							default:
								System.err.println("Invalid option, Please try again.");
								break;

							}

						} while (adminMenuOn);
					}

					else if (password.equals("0")) {
						adminMenuOn = false;
					}

					else {

						System.err.println("Invalid password, Please try again");

					}

				} while (adminMenuOn);

				break;

			case "3":// Exit to program

				programMenuON = false;
				System.out.println("Thank you for using the LibrarySimulator!");

				break;

			default: //invalid option
				System.err.println("Invalid option, Please try again.");
				break;

			} // end switch for main menu

		} while (programMenuON); // end do for whole program

	}

}
