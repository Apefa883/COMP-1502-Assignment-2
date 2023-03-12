package view;

import java.util.Scanner;

public class AppMenu {
	//This class will display things to the user
	//All of the info its menus glean will go back to BrowserManager.
	
	Scanner input;
	
	/**
	 * Constructor class.
	 * Creates Scanner for user input.
	 * @return Doesn't return anything.
	 */
	public AppMenu() {
		input = new Scanner(System.in);
	}
	
	/**
	 * Prints out main menu.
	 * Takes and stores user input first character into variable "option".
	 * @param char  Takes user first character input.
	 * @return returns user input's first character.
	 */
	public char showMainMenu() {
		
		System.out.println("**************************************************");
		System.out.println("*          WELCOME TO TOY STORE COMPANY!         *");
		System.out.println("**************************************************");
		System.out.println("");
		System.out.println("How We May Help You?");
		System.out.println("");
		System.out.println("(1)	  Search Inventory and Purchase Toy");
		System.out.println("(2)   Add New Toy");
		System.out.println("(3)   Remove Toy");
		System.out.println("(4)   Save & Exit");
		System.out.println("");
		System.out.print("Enter Option: ");
		
		char option = input.nextLine().toLowerCase().charAt(0);
		return option;
	}
	
	/**
	 * Prints out Sub Menu.
	 * Takes and stores user input first character into variable "option".
	 * @param char  Takes user first character input.
	 * @return returns user input's first character.
	 */
	public char showSubMenu() {
		
		System.out.println("Find Toys With:");
		System.out.println("");
		System.out.println("(1)   Serial Number (SN)");
		System.out.println("(2)   Toy Name");
		System.out.println("(3)   Type");
		System.out.println("(4)   Back to Main Menu");
		System.out.println("");
		System.out.print("Enter Option: ");
		
		char option = input.nextLine().toLowerCase().charAt(0);
		return option;
	}
	
	public String promptType() {
		System.out.print("Enter a toy type: ");
		System.out.println("(1)   Figure");
		System.out.println("(2)   Animal");
		System.out.println("(3)   Puzzle");
		System.out.println("(4)   Board Game");
		String type = input.nextLine().trim();
		return type;
	}

	public void promptContinue() {
		System.out.println("Press \"Enter\" to continue...");
		input.nextLine();
	}

	public void promptInvalid() {
		System.out.println("Invalid selection...");
		System.out.println("Please Try Again: ");
		input.nextLine();
	}

	public String promptSelectType() {
		System.out.print("Select a toy to purchase (enter SN) or type 'cancel': ");
		String selection = input.nextLine();
		return selection;
	}

	public void promptNotFound() {
		System.out.println("No matches found.");
	}

	public void showToy() {
		// TODO Auto-generated method stub
		
	}

	public void promptOutOfStock() {
		System.out.println("Sorry, this toy is out of stock!");
	}

	public void promptPurchased() {
		System.out.println("Purchase Successful!");
		
	}

	public void promptSaving() {
		System.out.println("");
		System.out.println("Saving Data Into Database...");
	}

	public void promptSaved() {
		System.out.println("");
		System.out.println("*********** THANKS FOR VISITING US! ***********");
	}

}
