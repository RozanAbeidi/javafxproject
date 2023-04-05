package application;

public class BoardGame extends Toy{
	String numPlayers;
	String designers;
	String minPlayers;
	String maxPlayers;
	String category = "Board Game";
	/**
	 * @author rozan
	 * Due to some difficulties with github we manually imported rozans code from
	 * LINE(13-20) 	
	 */	
	public BoardGame(String category, String serialNumber, String name, String brand, double price, int availableCount, int appAge,
			String minPlayers, String maxPlayers, String designers) {

		super(serialNumber, name, brand, price, availableCount, appAge);
		this.designers = designers;
		this.category = category;
		this.minPlayers = minPlayers;
		this.maxPlayers = maxPlayers;

	}
	
	public void setNumPlayers(String numOfPlayers) {
		this.numPlayers = numOfPlayers;
	}
	
	public String getNumPlayers() {
		return numPlayers;
	}
	
	public void setDesigners(String designers){
		this.designers = designers;
	}
	
	public String getDesigners() {
		return designers;
	}


	public String getCategory() {
		// TODO Auto-generated method stub
		return category;
	}
	
	public void setMinPlayers(String minPlayer) {
		this.minPlayers = minPlayer;
	}
	
	public String getMinPLayers() {
		return minPlayers;
	}
	
	public void setMaxPlayers(String maxplayer) {
		this.maxPlayers = maxplayer;
	}
	
	public String getMaxPlayer() {
		return maxPlayers;
	}
	
	public String toString() {
		return "Category:" + category + " , " + super.toString() + " , " + "Number of players: " + minPlayers + "-" + maxPlayers +" , " + "Designer:" + designers;
	}
	
	public String format() {
		return super.format() + ";" + minPlayers + "-" + maxPlayers + ";" + designers; 
	}
}
