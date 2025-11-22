/*
	Team members:
	Name 							Uni ID
	1-Fahad Aldeghaither			446102355
	2-Faris Alrasheed  				446101056
	3-Abdulrahman Alwaalan			446107578


   GitHub repositery URL: https://github.com/FarisAlRasheed/LibrarySimulatorProject/tree/Member
 */

import java.util.Scanner;

public class LibrarySimulator {

	public static void main(String[] args) {
		//Scanner Object
		Scanner input = new Scanner(System.in);

		//Booleans used to manage menus state
		boolean programMenuON = true; // turn on program
		boolean userMenuOn = true; // turn on member menu
		boolean userLogin = true; // turn on member login menu
		boolean adminMenuOn = true; // turn on admin menu

		//first user instantiate
		Member m1 = new Member(1, "Faris", 0);

		//second user instantiate
		Member m2 = new Member(2, "Fahad", 0);

		//third user instantiate
		Member m3 = new Member(3, "Abdulrahman", 0);
		
		//selected member (each session)
		Member cM = null;

		//welcome message
		System.out.println("Welcome to the LibrarySimulator!");

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
				userLogin = true;
				do { //login 
					
					System.out.println("\n=========================================");
					System.out.println("Enter the member ID to log in, or 4 to exit:");
					System.out.println("(ID: 1) Faris");
					System.out.println("(ID: 2) Fahad");
					System.out.println("(ID: 3) Abdulrahman");
					System.out.println("4. Exit Program");
					System.out.print("\nChoose an option: ");
					String userId = input.next();

					switch (userId) // select which user
					{

					case "1": // choice Faris
						cM = m1;
						userLogin = false;
						break;
					case "2": // choice Fahad
						cM = m2;
						userLogin = false;
						break;
					case "3": // choice Abdulrahman
						cM = m3;
						userLogin = false;
						break;
					case "4":
						System.out.println("Exiting the program, Thank you!");
						return; // Exit the program

					default:
						System.err.println("Invalid member ID! Please try again.");
						continue;

					}
				} while (userLogin);
				
				userMenuOn = true;
				do { //user menu
					System.out.println("\nWelcome " + cM.getName() + "!"
					+"\n========================================="
					+"\nTotal Fees: " + cM.getSessionFees() + "\t\t" + "Borrowed Books: " + cM.getBorrowed() + "\\5"
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
						if(cM.borrowOne()) {
							System.out.println("\nBorrow Done!");
						}
						else {
							System.err.println("Borrow Failed!");
						}
						break;
						
					case "2":
						if(cM.returnOne()) {
							System.out.println("\nReturn Done!");
						}
						else {
							System.err.println("Return Failed!");
						}

						break;
					case "3":
						cM.displayStatistics();
						break;

					case "4": // Exit to main menu
						cM.reset(); //reset user stats
						cM = null;
						userMenuOn = false;
						break;

					case "5": // Exit Program
						System.out.println("Thank you for using the LibrarySimulator!");
						return;

					default://invalid option
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

					if (password.equals("admin")) { //hint: password = admin :)
						adminMenuOn = true;
						
						System.out.println("Welcome admin!");

						do {
							System.out.println("=========================================");
							System.out.println("admin Operations Menu:");
							System.out.println("1. View Total Revenue");
							System.out.println("2. Most Frequent Operations");	
							System.out.println("3. Exit to Main Menu");
							System.out.println("4. Exit Program");
							System.out.print("Choose an option: ");
							String choice = input.next();

							switch (choice) {

							case "1":
								System.out.printf("\nTotal Revenue Collected: %.2f credits\n", Member.totalRevenue);
								break;

							case "2":
								Member.frequentOperation();
								break;

							case "3": // Exit to main menu
								adminMenuOn = false;
								break;

							case "4": // Exit Program
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
