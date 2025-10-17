import java.util.Scanner;

public class LibrarySimulator {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		boolean programMenuON = true; // turn on program
		boolean userMenuOn = true; // turn on member menu
		boolean userLogin = true;
		boolean adminMenuOn = true; // turn on admin menu

		String userName_1 = "Faris";
		int userId_1 = 1;
		int userCheckedOut_1 = 0;
		int userReturned_1 = 0;

		String userName_2 = "Fahad";
		int userId_2 = 2;
		int userCheckedOut_2 = 0;
		int userReturned_2 = 0;

		String userName_3 = "Abdulrahman";
		int userId_3 = 3;
		int userCheckedOut_3 = 0;
		int userReturned_3 = 0;

		String userName = "";
		int checkedOut = 0;
		int returned = 0;

		System.out.println("Welcome to the LibrarySimulator!");

		do {
			System.out.println("=========================================");
			System.out.println("Main Menu:");
			System.out.println("1. Login as Member");
			System.out.println("2. Login as Administrator");
			System.out.println("3. Exit Program");
			System.out.print("Choose an option: ");
			String Choice = input.next();

			switch (Choice) {
			case "1": // Member Login

				do {

					System.out.println(
							"=========================================\nEnter Id member to log in, or 4 to exit: ");
					System.out.println("1. Faris");
					System.out.println("2. Fahad");
					System.out.println("3. Abdulrahman");
					System.out.println("4. Exit Program");
					System.out.print("Choose an option: ");

					String userId = input.next();

					switch (userId) // select which user
					{

					case "1": // choice Faris
						userName = userName_1;
						checkedOut = userCheckedOut_1;
						returned = userReturned_1;
						userLogin = false;
						break;
					case "2": // choice Fahad
						userName = userName_2;
						checkedOut = userCheckedOut_2;
						returned = userReturned_2;
						userLogin = false;
						break;
					case "3": // choice Abdulrahman
						userName = userName_3;
						checkedOut = userCheckedOut_3;
						returned = userReturned_3;
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

				do {
					System.out.println("\nWelcome " + userName + "!");
					System.out.println("=========================================");

					System.out.println("Member Operations Menu:");
					System.out.println("1. Check Out a Book");
					System.out.println("2. Return a Book");
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

			case "2":
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
				break;

			default:
				System.err.println("Invalid option, Please try again.");
				break;

			} // end switch for main menu

		} while (programMenuON); // end do for hole program

	}

}
