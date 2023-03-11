package model;

public class figure extends Toy{
	char classification;
	
	
	
	public figure(int serial, String name, String brand, float price, int availableCount, 
			int ageRating, char classification) {
		super(serial, name, brand, price, availableCount, ageRating);
		this.classification = classification;
	}
	
	public char getClassification() {
		return classification;
	}
	
	public void setClassification(char classification) {
		this.classification = classification;
	}

}
