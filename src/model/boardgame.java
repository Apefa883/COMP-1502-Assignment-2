package model;

public class boardgame extends Toy {
	int playerNum;
	String designers;
	
	
	
	public boardgame(int serial, String name, String brand, float price, int availableCount, 
			int ageRating, int playerNum, String designers) {
		super(serial, name, brand, price, availableCount, ageRating);
		this.playerNum = playerNum;
		this.designers = designers;
	}
	
	public int getPlayerNumber() {
		return playerNum;
	}
	
	public void setPlayerNumber(int playerNumber) {
		this.playerNum = playerNumber;
	}
}
