package view;

import java.util.ArrayList;
import java.util.Scanner;

import exception.AgeMismatch;
import exception.NegativePrice;
import model.Toy;

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
		System.out.println("(1)   Search Inventory and Purchase Toy");
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
		System.out.print("Enter a toy type: \n");
		System.out.println("(1)   Figure");
		System.out.println("(2)   Animal");
		System.out.println("(3)   Puzzle");
		System.out.println("(4)   Board Game");
		String type = input.nextLine().trim();
		return type;
	}
	
	public void promptSerial() {
		System.out.print("\nEnter a serial number (must be a 10-digit number): ");
	}
	
	public void angrySerial() {
		System.out.println("Invalid serial entered! It must be a valid 10-digit number: ");
	}

	public void displaySerial(ArrayList<Toy> Inventory,int place) {
		System.out.println("This item found: \n");
		System.out.println(Inventory.get(place)+"\n");
		
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
	
	public void OutOfStock() {
		System.out.println("\nThis item is out of stock.\n");
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

	public String promptName() {
		System.out.print("\nEnter toy name: ");
		String type = input.nextLine().trim();
		while(type.length() < 1) {
			System.out.print("\nBlank string entered! Enter toy name: ");
			type = input.nextLine().trim();
		}
		return type;
	}
	
	public String promptBrand() {
		System.out.print("\nEnter toy brand: ");
		String type = input.nextLine().trim();
		while(type.length() < 1) {
			System.out.print("\nBlank string entered! Enter toy name: ");
			type = input.nextLine().trim();
		}
		return type;
	}
	
	public int promptAppropAge() {
		System.out.print("\nEnter Appropriate Age: ");
		
		String type = input.nextLine().trim();
		int age = 0;
		while(age <= 0) {
			try {	
				age = Integer.parseInt(type);
				if(age <=0) {
					System.out.print("Age must be positive! Try again:");
					type = input.nextLine().trim();
				}
			} catch (Exception e) {
				System.out.print("\nInvalid Value! Try again: ");
				type = input.nextLine().trim();
			}
		}
		return age;
	}
	
	
	public float promptPrice() {
		System.out.print("\nEnter price: ");
		String priceIO = input.nextLine().trim();
		float price = 0;
		while(price <= 0) {
			try {	
				price = Float.parseFloat(priceIO);
				if(price <= 0) {
					throw new NegativePrice(price);
				} else {
					break;
				}
			} catch (NegativePrice e) {
				System.out.print("\nPrice cannot be a negative number! Try again: ");
			}catch (Exception e2) {
				System.out.print("\nPrice must be a valid numerical value! Try again: ");
			}
			priceIO = input.nextLine().trim();
		}
		return price;
	}
	
	public String validateSerial() {
		Scanner input = new Scanner(System.in);
	    promptSerial();
	    String serial = input.nextLine();
	    Boolean validNumber = false;
	    Boolean validLength = false;
	    while (validNumber == false || validLength == false) {
	    	try {
	    		Long.parseLong(serial);
	    		validNumber = true;
	    		if(serial.length() == 10) {
	    			validLength = true;
	    		} else {
	    			angrySerial();
	    			serial = input.nextLine();
	    		}
	    	} catch(Exception e) {
	    		angrySerial();
	    		serial = input.nextLine();
	    	}
	    }
		return serial;
	}
	
	//Functions for the specialized type thingamabobs
	public int promptCount() {
		System.out.print("\nEnter Available Count: ");
		String CountIO = input.nextLine().trim();
		int Count = -1;
		while(Count <= 0) {
			try {	
				Count = Integer.parseInt(CountIO);
				if(Count <= 0) {
					throw new NegativePrice(Count);
				} else {
					break;
				}
			} catch (NegativePrice e) {
				System.out.print("\nCount cannot be a negative number! Try again: ");
			}catch (Exception e2) {
				System.out.print("\nCount must be a valid positive whole number! Try again: ");
			}
			CountIO = input.nextLine().trim();
		}
		return Count;
	}

	public String promptClassification() {
		System.out.print("\nEnter Figure Classification: ");
		char FigType = input.nextLine().trim().charAt(0);
		while(Character.toLowerCase(FigType) != 'a' && Character.toLowerCase(FigType) != 'd' && 
				Character.toLowerCase(FigType) != 'h') {
			System.out.print("\nIncorrect value entered! Must be A (Action), D (Doll), or H (Historic): ");
			FigType = input.nextLine().trim().charAt(0);
		}
		return FigType+"";
	}

	public String promptMaterial() {
		System.out.print("\nEnter Material: ");
		String Material = input.nextLine().trim();
		while(Material.length() <= 0) {
			System.out.print("\nERROR: Valid String must be given: ");
			Material = input.nextLine().trim();
		}
		return Material;
	}

	public String promptSize() {
		System.out.print("\nEnter Animal Size: ");
		char Size = input.nextLine().trim().charAt(0);
		while(Character.toLowerCase(Size) != 's' && Character.toLowerCase(Size) != 'm' && 
				Character.toLowerCase(Size) != 'l') {
			System.out.print("\nIncorrect value entered! Must be S (Small), M (Medium), or L (Large): ");
			Size = input.nextLine().trim().charAt(0);
			System.out.println(Size);
			System.out.println(Character.toLowerCase(Size));
		}
		return Size+"";
	}

	public String promptPlayerNum() {
		Boolean validated = false;
		int min = -1;
		int max = -1;
		String minString;
		String maxString;
		while(!validated) {
			try {
				System.out.print("\nEnter a minimum age: ");
				minString = input.nextLine().trim();
				while(min <= 0) {
					try {	
						min = Integer.parseInt(minString);
						if(min <= 0) {
							throw new NegativePrice(min);
						} else {
							break;
						}
					} catch (NegativePrice e) {
						System.out.print("\nMinimum Age cannot be a negative number! Try again: ");
					}catch (Exception e2) {
						System.out.print("\nMinimum Age must be a valid positive whole number! Try again: ");
					}
					minString = input.nextLine().trim();
				}
				
				System.out.print("\nEnter a maximum age: ");
				maxString = input.nextLine().trim();
				while(max <= 0) {
					try {	
						max = Integer.parseInt(maxString);
						if(max <= 0) {
							throw new NegativePrice(max);
						} else {
							break;
						}
					} catch (NegativePrice e) {
						System.out.print("\nMaximum Age cannot be a negative number! Try again: ");
					}catch (Exception e2) {
						System.out.print("\nMaximum Age must be a valid positive whole number! Try again: ");
					}
					maxString = input.nextLine().trim();
				}
				
				if(max < min) {
					throw new AgeMismatch(min,max);
				} else {
					validated = true;
				}
			} catch (AgeMismatch badage) {
				System.out.print("\nMaximum Age must be greater than or equal to Minimum age!\n");
				min = -1;
				max = -1;
			}
		}
		return (min+"-"+max);
	}

	
	//EEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE	
	
	
	public String promptDesigners() {
		System.out.print("\nEnter Designer Names (Use ',' to separate the names if there is more than"
				+ " one name): ");
		String Designers = input.nextLine().trim();
		while(Designers.length() <= 0) {
			System.out.print("\nERROR: Valid String must be given: ");
			Designers = input.nextLine().trim();
		}
		return Designers;
	}

	public void promptExistingSerial() {
		System.out.print("\nERROR: Serial Already Exists!");
	}

	public String promptPuzzleType() {
		System.out.print("\nEnter Puzzle type: ");
		char PuzType = input.nextLine().trim().charAt(0);
		while(Character.toLowerCase(PuzType) != 'm' && Character.toLowerCase(PuzType) != 'c' && 
				Character.toLowerCase(PuzType) != 'l' && Character.toLowerCase(PuzType) != 't' 
				&& Character.toLowerCase(PuzType) != 'r') {
			System.out.print("\nIncorrect value entered! Must be M (Mechanical), C (Cryptic), L (Logical), "
					+ "T (Trivia), or R (Riddle): ");
			PuzType = input.nextLine().trim().charAt(0);
			System.out.println(PuzType);
			System.out.println(Character.toLowerCase(PuzType));
		}
		return PuzType+"";
	}

	public void newToy() {
		System.out.print("\nNew Toy Added!\n");
		promptContinue();
	}
}