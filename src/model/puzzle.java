package model;

public class puzzle extends Toy{
	char puzzleType;
	
	
	
	public puzzle(long serial, String name, String brand, float price, int availableCount, 
			int ageRating, char puzzleType) {
		super(serial, name, brand, price, availableCount, ageRating);
		this.puzzleType = puzzleType;
	}
	
	public char getPuzzleType() {
		return puzzleType;
	}
	
	public void setClassification(char puzzleType) {
		this.puzzleType = puzzleType;
	}


}