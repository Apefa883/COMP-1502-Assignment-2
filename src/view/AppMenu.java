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
	

}
