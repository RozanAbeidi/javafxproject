package application;

public abstract class Toy {
	private String serialNumber;
	private String name;
	private String brand;
	private double price;
	private int availableCount;
	private int appAge;//Appropriate age.
	
	public Toy(String serialNumber, String name, String brand, double price, int availableCount, int appAge) {

		this.serialNumber = serialNumber;
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.availableCount = availableCount;
		this.appAge = appAge;

	}
	
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	
	public String getSerialNumber() {
		return serialNumber;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public void setPrice(int price) {
		this.price= price;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setAvailableCount(int count) {
		this.availableCount = count-1;
	}
	
	public int getAvaiableCount() {
		return availableCount;
	}
	
	public void setAppAge(int age) {
		this.appAge = age;
	}
	
	public int getAppAge() {
		return appAge;
	}
	
	public void setPurchaseCount() {
		availableCount = getAvaiableCount()-1;
	}
	
	
	public abstract String getCategory();
	
	public String toString() {
		return "Serial Number:" + serialNumber + " , " +  "Name:" + name + " , " + "Brand:" + brand + " , " +  "Price:" + price + " , " +  "Avaiable Quantity:" + availableCount + " , " + "Appropiate Age:" + appAge; 
	}
	
	public String format() {
		return serialNumber + ";" + name + ";" + brand + ";" + price + ";"+ availableCount + ";"+ appAge;
	}
	
}
