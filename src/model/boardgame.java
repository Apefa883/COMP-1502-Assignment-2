package model;

public class boardgame extends Toy {
	int minPlayers;
	int maxPlayers;
	String designers;
	
	
	
	public boardgame(long serial, String name, String brand, float price, int availableCount, 
			int ageRating, String playerNum, String designers) {
		super(serial, name, brand, price, availableCount, ageRating);
		String playerNumArray[] = playerNum.split("-");
		minPlayers = Integer.parseInt(playerNumArray[0]);
		minPlayers = Integer.parseInt(playerNumArray[1]);
		this.designers = designers;
	}
	
	public int getMinPlayers() {
		return minPlayers;
	}
	
	public int getMaxPlayers() {
		return maxPlayers;
	}
	
	public void setMinPlayers(int playerNumber) {
		this.minPlayers = playerNumber;
	}
	
	public void setMaxPlayers(int playerNumber) {
		this.maxPlayers = playerNumber;
	}
	
	public String getDesigners() {
		return designers;
	}
	
	public void setDesigners(String designers) {
		this.designers = designers;
	}
}
