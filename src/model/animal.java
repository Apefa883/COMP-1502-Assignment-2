package model;

public class animal extends Toy {
	String material;
	char size;
	
	
	public animal(long serial, String name, String brand, float price, int availableCount, int ageRating, String material, char size) {
		super(serial, name, brand, price, availableCount, ageRating);
		this.material = material;
		this.size = size;
	}
	
	public String getMaterial() {
		return material;
	}
	
	public void setMaterial(String material) {
		this.material = material;
	}
	
	public char getSize() {
		return size;
	}
	
	public void setSize(char size) {
		this.size = size;
	}

}

