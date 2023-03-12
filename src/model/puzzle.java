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
	
	public String toString() {
		String title = (brand+" "+name);
		switch(puzzleType) {
			case 'M':
				title+=(" Mechanical Puzzle ");
				break;
			case 'C':
				title+=(" Cryptic Puzzle ");
				break;
			case 'L':
				title+=(" Logic Puzzle ");
				break;
			case 'T':
				title+=(" Trivia Puzzle ");
				break;
			case 'R':
				title+=(" Riddle Puzzle ");
				break;
			default:
				title += (" Puzzle ");
				break;
		}
		title += (" $"+price+"\n"+"For ages "+ageRating+" and up. "+availableCount+" in stock."
				+" Serial #"+serial);
		return title;
	}

}