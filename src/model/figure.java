package model;

public class figure extends Toy{
	char classification;
	
	
	
	public figure(long serial, String name, String brand, float price, int availableCount, 
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

	public String toString() {
		String title = (brand+" "+name);
		switch(classification) {
		case 'A':
			title+=(" action figure ");
			break;
		case 'D':
			title+=(" doll ");
			break;
		case 'H':
			title+=(" historical figure ");
			break;
		default:
			title += (" figure ");
			break;
	}
		title += ("$"+price+"\n"+"For ages "+ageRating+" and up. "+availableCount+" in stock."+" Serial #"+serial);
		return title;
	}
}
