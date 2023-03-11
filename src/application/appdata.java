package application;

import java.util.ArrayList;

import model.Animals;
import model.Figures;
import model.Puzzles;
import model.Toy;
import model.boardGames;

public class appdata {
	
	public static void main(String[] args) {
		
		ArrayList<Toy> toys = new ArrayList<>();
		
		Toy figure = new Figures("figure");
		toys.add(figure);
		
		Toy animal = new Animals("animal");
		toys.add(animal);
		
		Toy puzzle = new Puzzles("puzzle");
		toys.add(puzzle);
		
		Toy bg = new boardGames("board game");
		toys.add(bg);
		
		
		
	}
}
