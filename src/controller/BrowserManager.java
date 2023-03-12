package controller;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import model.Toy;
import model.animal;
import model.boardgame;
import model.figure;
import model.puzzle;

public class BrowserManager {
	//This class will eventually be the controller part of our MVC architecture!
	ArrayList<Toy> Inventory = new ArrayList<Toy>();
	private final String FILE_PATH = "res/toys.txt";
	
	public BrowserManager() {
		System.out.println("bababooey");
		//Creates arraylist (loaded in other function)
		loadData();
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