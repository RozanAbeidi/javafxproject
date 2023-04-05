package application;

public class Figure extends Toy {
	String classification;
	String category;
	/**
	 * @author rozan
	 * Due to some difficulties with github we manually imported rozans code from
	 * LINE(10-15) 	
	 */
	public Figure(String category, String serialNumber, String name, String brand, double price, int availableCount, int appAge,
			String classification) {

		super(serialNumber, name, brand, price, availableCount, appAge);
		this.classification = classification;
		this.category = category;
	}
	
	public void setClassification(String classification) {
		this.classification = classification;
	}
	
	public String getClassification() {
		return classification;
	}
//	public String toString() {
//		return (serialNumber+"|" +name + "|" + brand + "|" + price + "|" + availableCount + "|" + appAge);
//	}

	public String getCategory() {
		// TODO Auto-generated method stub
		return category;
	}
	
	public String toString() {
		return "Category:" + category + " , " + super.toString() + " , " + "Classifiaction:" + classification; 
	}
	
	public String format() {
		return super.format() + ";"+ classification;
	}
}
