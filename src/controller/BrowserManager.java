package controller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import model.Toy;
import model.animal;
import model.boardgame;
import model.figure;
import model.puzzle;
import mru.game.model.Player;
import view.AppMenu;

public class BrowserManager {
	//This class will eventually be the controller part of our MVC architecture!
	ArrayList<Toy> Inventory = new ArrayList<Toy>();
	AppMenu AppMen;
	private final String FILE_PATH = "res/toys.txt";
	public boolean flag;
	
	public BrowserManager() throws Exception {
		System.out.println("bababooey");
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
				flag = false;
			case '4':
				try {
					Save();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				flag = false;
			}
		}
	}

	private void Save() throws IOException {
		File db = new File(FILE_PATH);
		PrintWriter pw = new PrintWriter(db);
		
		AppMen.promptSaving();
		
		for (Toy t: Inventory) {
			pw.println(t.format()); // need to fix format method
		}
		
		pw.close();
		AppMen.promptSaved();
	}

	private void RemoveToy() {
		
		
	}

	private void AddToy() {
		// TODO Auto-generated method stub
		
	}

	private void Search() {
			
			char option = AppMen.showSubMenu();
			
			switch (option) {
			case '1':
				searchBySerial();
				break;
			case '2':
				searchByName();
				break;
			case '3':
				searchByType();
				break;
				
			case '4':
				break;
				
			default:
				break;
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
	            if (toy.getSerial().equals(selection)) { // need to fix
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


	private void searchByName() {
		// TODO Auto-generated method stub
		
	}

	private void searchBySerial() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Loads all data contained the toys.txt file.
	 */
	private void loadData() {
		System.out.println("Farting now...");
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
						figure newToy = new figure(Long.parseLong(parsedLine[0]),parsedLine[1],parsedLine[2],
								Float.parseFloat(parsedLine[3]),Integer.parseInt(parsedLine[4]),
								Integer.parseInt(parsedLine[5]),parsedLine[6].charAt(0));
						Inventory.add(newToy);
						
					} else if(Character.getNumericValue(currentLine.charAt(0)) < 4) {
						
						parsedLine = currentLine.split(";");
						animal newToy = new animal(Long.parseLong(parsedLine[0]),parsedLine[1],parsedLine[2],
								Float.parseFloat(parsedLine[3]),Integer.parseInt(parsedLine[4]),
								Integer.parseInt(parsedLine[5]),parsedLine[6],parsedLine[7].charAt(0));
						Inventory.add(newToy);
						
					} else if(Character.getNumericValue(currentLine.charAt(0)) < 7) {
						parsedLine = currentLine.split(";");
						puzzle newToy = new puzzle(Long.parseLong(parsedLine[0]),parsedLine[1],parsedLine[2],
								Float.parseFloat(parsedLine[3]),Integer.parseInt(parsedLine[4]),
								Integer.parseInt(parsedLine[5]),parsedLine[6].charAt(0));
						Inventory.add(newToy);
						
					} else {
						parsedLine = currentLine.split(";");
						boardgame newToy = new boardgame(Long.parseLong(parsedLine[0]),parsedLine[1],parsedLine[2],
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