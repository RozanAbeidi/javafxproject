package application;

public class Puzzle extends Toy{
	String puzzleType;
	String category = "puzzle";
	/**
	 * @author rozan
	 * Due to some difficulties with github we manually imported rozans code from
	 * LINE(11-17) 	
	 */

	public Puzzle(String category,String serialNumber, String name, String brand, double price, int availableCount, int appAge,
			String puzzleType) {

		super(serialNumber, name, brand, price, availableCount, appAge);
		this.puzzleType = puzzleType;
		this.category = category;

	}
	
	public void getPuzzleType(String puzzType) {
		this.puzzleType = puzzType;
	}
	
	public String setPuzzleType() {
		return puzzleType;
	}

	public String getCategory() {
		// TODO Auto-generated method stub
		return category;
	}
	
	public String toString() {
		return "Category:" + category + " , " + super.toString() + " , " + "Puzzle Type:" + puzzleType;
	}
	
	public String format() {
		return super.format() + ";"+ puzzleType;
	}
}
