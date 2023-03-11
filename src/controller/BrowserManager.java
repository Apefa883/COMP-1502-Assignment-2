package controller;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import model.Toy;

public class BrowserManager {
	//This class will eventually be the controller part of our MVC architecture!
	ArrayList<Toy> Inventory = new ArrayList<Toy>();
	private final String FILE_PATH = "res/toys.txt";
	
	public BrowserManager() {
		System.out.println("bababooey");
		//Creates arraylist (loaded in other function)
		loadData();
	}



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
						System.out.println("Figure");
					} else if(Character.getNumericValue(currentLine.charAt(0)) < 4) {
						System.out.println("Animal");
					} else if(Character.getNumericValue(currentLine.charAt(0)) < 7) {
						System.out.println("Puzzle");
					} else {
						System.out.println("Board Game");
					}
				}
					//parsedLine = currentLine.split(";");
					//Toy newToy = new Toy(Integer.parseInt(parsedLine[0]), 
					//Integer.parseInt(parsedLine[1]), Integer.parseInt(parsedLine[2]));
					//Inventory.add(newToy);
				
			} catch(FileNotFoundException e) {
				System.out.println("ERROR: ARCHIVE FILE NOT FOUND!");
			}
		}
	}
			
}