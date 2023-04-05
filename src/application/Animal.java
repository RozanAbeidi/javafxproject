package application;

public class Animal extends Toy {
	String category = "Animal";
	String material;
	String size;

	/**
	 * @author rozan Due to some difficulties with github we manually imported
	 *         rozans code from LINE(3-47)
	 * 
	 */

	public Animal(String category, String serialNumber, String name, String brand, double price, int availableCount,
			int appAge, String material, String size) {

		super(serialNumber, name, brand, price, availableCount, appAge);
		this.material = material;
		this.size = size;
		this.category = category;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getMaterial() {
		return material;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getSize() {
		return size;
	}

	public String getCategory() {
		return category;
	}

	public String toString() {
		return "Category:" + category + " , " + super.toString() + " , " + "Material:" + material + " , " + "Size:"
				+ size;
	}

	public String format() {
		return super.format() + ";" + material + ";" + size;
	}
}
