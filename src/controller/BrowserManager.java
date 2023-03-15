package controller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import exception.NegativePrice;
import model.Toy;
import model.animal;
import model.boardgame;
import model.figure;
import model.puzzle;
import view.AppMenu;

public class BrowserManager {
	//This class is the controller part of our MVC architecture!
	ArrayList<Toy> Inventory = new ArrayList<Toy>();
	AppMenu AppMen;
	private final String FILE_PATH = "res/toys.txt";
	public boolean flag;
	
	public BrowserManager() {
		//Creates arraylist (loaded in other function)
		AppMen = new AppMenu();
		loadData();
		lunchApplication();
	}

	/**
	 * Takes information from AppMenu and calls methods according to the given information.
	 * @return Doesn't return anything.
	 */
	private void lunchApplication() {
		
		flag = true;
		char option;
		
		while (flag) {
			option = AppMen.showMainMenu();
			
			switch (option) {
			case '1':
				Search();
				flag = false;
				break;
			case '2':
				AddToy();
				break;
			case '3':
				RemoveToy();
				break;
			case '4':
				Save();
				flag = false;
			}
		}
	}

	private void Save() {
		try {
			File db = new File(FILE_PATH);
			PrintWriter pw = new PrintWriter(db);
			
			AppMen.promptSaving();
			
			for (Toy t: Inventory) {
				pw.println(t.format());
			}
			
			pw.close();
			AppMen.promptSaved();
		} catch(IOException g) {
			AppMen.promptSaveFailure();
		}
	}

	/**
	 * Removes an existing toy
	 */
	private void RemoveToy() {
		int place = -1;
		while(place == -1) {
			place = searchBySerial();
			if(place == -1) {
				AppMen.OutOfStock();
				AppMen.promptContinue();
			} else {
				break;
			}
		}
		AppMen.displaySerial(Inventory,place);
		Boolean kill = AppMen.promptRemove();
		if(kill) {
			Inventory.remove(place);
			AppMen.promptKilled();
		} else {
			AppMen.promptCoward();
		}
	}

	/**
	 * Loads all the toy elements into an array of strings, then creates a new object with all 
	 * array elements as parameters. Neat tech, isn't it?
	 */
	private void AddToy() {
		Scanner input = new Scanner(System.in);
		
		String[] parameters = new String[8];
		parameters[0] = newSerial();
		
		parameters[1] = AppMen.promptName();
		
		parameters[2] = AppMen.promptBrand();
		
		parameters[3] = ""+AppMen.promptPrice();
		
		parameters[4] = ""+AppMen.promptCount();
		
		parameters[5] = ""+AppMen.promptAppropAge();
		
		if(Character.getNumericValue(parameters[0].charAt(0)) < 2) {
			//Parameters for Figures
			parameters[6] = AppMen.promptClassification();
			Toy newToy = new figure(parameters[0],parameters[1],parameters[2],Float.parseFloat(parameters[3]),
					Integer.parseInt(parameters[4]),Integer.parseInt(parameters[5]),parameters[6].charAt(0));
			Inventory.add(newToy);
			
		} else if(Character.getNumericValue(parameters[0].charAt(0)) < 4) {
			//Parameters for Animals
			parameters[6] = AppMen.promptMaterial();
			parameters[7] = AppMen.promptSize();
			
			Toy newToy = new animal(parameters[0],parameters[1],parameters[2],Float.parseFloat(parameters[3]),
					Integer.parseInt(parameters[4]),Integer.parseInt(parameters[5]),parameters[6],
					parameters[7].charAt(0));
			Inventory.add(newToy);
			
		} else if(Character.getNumericValue(parameters[0].charAt(0)) < 7) {
			//Parameters for Puzzles
			parameters[6] = AppMen.promptPuzzleType();
			
			Toy newToy = new puzzle(parameters[0],parameters[1],parameters[2],Float.parseFloat(parameters[3]),
					Integer.parseInt(parameters[4]),Integer.parseInt(parameters[5]),parameters[6].charAt(0));
			Inventory.add(newToy);
			
		} else {
			parameters[6] = AppMen.promptPlayerNum();
			parameters[7] = AppMen.promptDesigners();
			//Parameters for Board Games
			
			Toy newToy = new boardgame(parameters[0],parameters[1],parameters[2],Float.parseFloat(parameters[3]),
					Integer.parseInt(parameters[4]),Integer.parseInt(parameters[5]),parameters[6],parameters[7]);
			Inventory.add(newToy);
		}
		
		AppMen.newToy();
	}

	/**
	 * Submenu for toy searches
	 */
	private void Search() {
		char option = 0;
		Boolean flag = true;
		while(flag == true) {
			option = AppMen.showSubMenu();
			switch (option) {
			case '1':
				int place = searchBySerial();
				if(place > -1) {
					AppMen.displaySerial(Inventory,place);
					AppMen.promptContinue();
				} else {
					AppMen.OutOfStock();
					AppMen.promptContinue();
				}
				break;
			case '2':
				searchByName();
				break;
			case '3':
				searchByType();
				break;
				
			case '4':
				flag = false;
				lunchApplication();
				break;
				
			default:
				break;
			}
		}
		
	}

	private void searchByType() {
		
		Scanner input = new Scanner(System.in);
	    AppMen.promptType();
	    String type = input.nextLine().toLowerCase();

	    ArrayList<Toy> matches = new ArrayList<>();

	    for (Toy toy : Inventory) {
	        if (toy.getClass().getSimpleName().equalsIgnoreCase(type)) {
	            matches.add(toy);
	        }
	    }
		
	    if (matches.isEmpty()) {
	    	AppMen.promptNotFound();
	    } else {
	        for (Toy toy : matches) {
	            AppMen.showToy();
	        }

	        String selection = AppMen.promptSelectType();

	        if (selection.equalsIgnoreCase("cancel")) {
	            return;
	        }
	        
	        Toy selectedToy = null;
	        
	        for (Toy toy : matches) {
	            if (toy.getSerial() == selection) {
	                selectedToy = toy;
	                break;
	            }
	        }

	        if (selectedToy == null) {
	            AppMen.promptInvalid();
	        } else {
	            int count = selectedToy.getCount();
	            if (count == 0) {
	                AppMen.promptOutOfStock();
	            } else {
	                selectedToy.setCount(count - 1);
	                AppMen.promptPurchased();
	                
	                AppMen.promptContinue();
	            }
	        }
	    }
	}

	
	private String newSerial() {
		String serial = AppMen.validateSerial();
		Boolean existing = CheckExistingSerial(serial);
		while(existing) {
			AppMen.promptExistingSerial();
			serial = AppMen.validateSerial();
			existing = CheckExistingSerial(serial);
		}
		return serial;
	}
	

	private void searchByName() {
		Scanner input = new Scanner(System.in);
	    AppMen.promptName();
	    String name = input.nextLine().toLowerCase();

	    ArrayList<Toy> matches = new ArrayList<>();

        for (Toy toy : Inventory) {
            if (toy.getName().toLowerCase().contains(name.toLowerCase())) {
                matches.add(toy);
            }
        }

	}

	private int searchBySerial() {
		int place = -1;
		String serial = AppMen.validateSerial();
	    //Basic idea - iterates through list to find the given toy. Gonna be simpler than the name one.
	    for(int i = 0; i<Inventory.size(); i++ ) {
	    	if(Long.parseLong(serial) == Long.parseLong(Inventory.get(i).getSerial())) {
	    		place = i;
	    		break;
	    	}
	    }
	    return place;
	    
	}
	
	private Boolean CheckExistingSerial(String serial) {
		Boolean exists = false;
		for(int i = 0; i<Inventory.size(); i++ ) {
	    	if(Long.parseLong(serial) == Long.parseLong(Inventory.get(i).getSerial())) {
	    		exists = true;
	    		break;
	    	}
	    }
		return exists;
	}

	
	/**
	 * Loads all data contained the toys.txt file.
	 */
	private void loadData() {
		File warehouse = new File(FILE_PATH);
		String currentLine;
		String[] parsedLine;
		
		if (warehouse.exists()) {
			try {
				Scanner fileReader = new Scanner(warehouse);
				while (fileReader.hasNextLine()) {
					currentLine = fileReader.nextLine();
					if (Character.getNumericValue(currentLine.charAt(0)) < 2) {
						parsedLine = currentLine.split(";");
						figure newToy = new figure(parsedLine[0],parsedLine[1],parsedLine[2],
								Float.parseFloat(parsedLine[3]),Integer.parseInt(parsedLine[4]),
								Integer.parseInt(parsedLine[5]),parsedLine[6].charAt(0));
						Inventory.add(newToy);
						
					} else if(Character.getNumericValue(currentLine.charAt(0)) < 4) {
						
						parsedLine = currentLine.split(";");
						animal newToy = new animal(parsedLine[0],parsedLine[1],parsedLine[2],
								Float.parseFloat(parsedLine[3]),Integer.parseInt(parsedLine[4]),
								Integer.parseInt(parsedLine[5]),parsedLine[6],parsedLine[7].charAt(0));
						Inventory.add(newToy);
						
					} else if(Character.getNumericValue(currentLine.charAt(0)) < 7) {
						parsedLine = currentLine.split(";");
						puzzle newToy = new puzzle(parsedLine[0],parsedLine[1],parsedLine[2],
								Float.parseFloat(parsedLine[3]),Integer.parseInt(parsedLine[4]),
								Integer.parseInt(parsedLine[5]),parsedLine[6].charAt(0));
						Inventory.add(newToy);
						
					} else {
						parsedLine = currentLine.split(";");
						boardgame newToy = new boardgame(parsedLine[0],parsedLine[1],parsedLine[2],
								Float.parseFloat(parsedLine[3]),Integer.parseInt(parsedLine[4]),
								Integer.parseInt(parsedLine[5]),parsedLine[6],parsedLine[7]);
						Inventory.add(newToy);
					}
				}
				fileReader.close();
			} catch(FileNotFoundException e) {
				System.out.println("ERROR: ARCHIVE FILE NOT FOUND!");
			}
		}
	}
}