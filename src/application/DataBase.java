package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class DataBase {
	Scanner keyboard = new Scanner(System.in);
	ArrayList<Toy> toys = new ArrayList<>();
	String[] splittedLines;
	private final String FILE_PATH = "res//toys.txt";
	File db = new File(FILE_PATH);
	ArrayList<Toy> searchToy = new ArrayList<>();

	/*
	 * This method is responsible for loading the data and also checking the file
	 * exists or not. from the the file it splits it and we take the serial number
	 * to use that as a parameter for our toytype method and makeToyObeject method.
	 */
	public void loadData() {
		String lines;
		String serialNumber;
		String toyType;
		Toy toy;
		try (Scanner fileReader = new Scanner(db)) {
			while (fileReader.hasNextLine()) {
				lines = fileReader.nextLine();
				splittedLines = lines.split(";");
				serialNumber = splittedLines[0];
				toyType = toyType(serialNumber);
				toy = makeToyObject(toyType);
				toys.add(toy);
//				System.out.println(toy.getAppAge());
//				System.out.println(serialNumber+"|" +name + "|" + brand + "|" + price + "|" + availableCount + "|" + appAge);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}

	}

	/*
	 * it takes the serial number and returns string toytype checking the first
	 * index of the serial number
	 */

	public String toyType(String serialNumber) {
		char firstDigit = serialNumber.charAt(0);
		String toyType = "";
		if (firstDigit == '0' || firstDigit == '1') {
			toyType = "Figure";
		} else if (firstDigit == '2' || firstDigit == '3') {
			toyType = "Animal";
		} else if (firstDigit == '4' || firstDigit == '5' || firstDigit == '6') {
			toyType = "Puzzle";
		} else if (firstDigit == '7' || firstDigit == '8' || firstDigit == '9') {
			toyType = "BoardGame";
		}
		return toyType;
	}

	/*
	 * @param Stirng toyType taking the toy type and calling the method for their
	 * each respective toy object maker mathod.
	 */

	public Toy makeToyObject(String toyType) {
		Toy toyClass = null;
		if (toyType.equals("Figure")) {
			toyClass = makeFigureToy(splittedLines);
		} else if (toyType.equals("Animal")) {
			toyClass = makeAnimalToy(splittedLines);
		}
		if (toyType.equals("Puzzle")) {
			toyClass = makePuzzleToy(splittedLines);
		} else if (toyType.equals("BoardGame")) {
			toyClass = makeBoardToy(splittedLines);
		}
		return toyClass;
	}

	/**
	 * taking splitted line and constracting the toy according to its toytype
	 * 
	 * @param splittedLines
	 * @return figure type toy
	 */

	public Toy makeFigureToy(String[] splittedLines) {
		String serialNumber = splittedLines[0];
		String name = splittedLines[1];
		String brand = splittedLines[2];
		double price = Double.parseDouble(splittedLines[3]);
		int availableCount = Integer.parseInt(splittedLines[4]);
		int appAge = Integer.parseInt(splittedLines[5]);
		String classification = splittedLines[6];
		return new Figure("Figure", serialNumber, name, brand, price, availableCount, appAge, classification);
	}

	/**
	 * taking splitted line and constracting the toy according to its toytype
	 * 
	 * @param splittedLines
	 * @return animalTypeToy
	 */

	public Toy makeAnimalToy(String[] splittedLines) {
		String serialNumber = splittedLines[0];
		String name = splittedLines[1];
		String brand = splittedLines[2];
		double price = Double.parseDouble(splittedLines[3]);
		int availableCount = Integer.parseInt(splittedLines[4]);
		int appAge = Integer.parseInt(splittedLines[5]);
		String material = splittedLines[6];
		String size = splittedLines[7];
		return new Animal("Animal", serialNumber, name, brand, price, availableCount, appAge, material, size);
	}

	/**
	 * taking splitted line and constracting the toy according to its toytype
	 * 
	 * @param splittedLines
	 * @return puzzle type toy
	 */

	public Toy makePuzzleToy(String[] splittedLines) {
		String serialNumber = splittedLines[0];
		String name = splittedLines[1];
		String brand = splittedLines[2];
		double price = Double.parseDouble(splittedLines[3]);
		int availableCount = Integer.parseInt(splittedLines[4]);
		int appAge = Integer.parseInt(splittedLines[5]);
		String puzzleType = splittedLines[6];
		return new Puzzle("puzzle", serialNumber, name, brand, price, availableCount, appAge, puzzleType);
	}

	/**
	 * taking splitted line and constracting the toy according to its toytype
	 * 
	 * @param splittedLines
	 * @return boardgame type toy.
	 */

	public Toy makeBoardToy(String[] splittedLines) {
		String serialNumber = splittedLines[0];
		String name = splittedLines[1];
		String brand = splittedLines[2];
		double price = Double.parseDouble(splittedLines[3]);
		int availableCount = Integer.parseInt(splittedLines[4]);
		int appAge = Integer.parseInt(splittedLines[5]);
		String[] splittedPlayerInfo = splittedLines[6].split("-");
		String minPlayers = splittedPlayerInfo[0];
		String maxPlayers = splittedPlayerInfo[1];
		String designers = splittedLines[7];
//		TODO
		return new BoardGame("boardGame", serialNumber, name, brand, price, availableCount, appAge, minPlayers,
				maxPlayers, designers);

	}

	/**
	 * launches the search menu and work according to it its just calling the other
	 * search method inside of a while loop and a swtich case.
	 */

	/*
	 * takes the user provided serial number and runs a for loop to see that matches
	 * to that serial number or not if it matches it adds the item to the temporary
	 * arraylist called searched toys list
	 * 
	 */

	public ArrayList<Toy> searchBySerial(String serialNumber) {
		ArrayList<Toy> searchToy = new ArrayList<>();
		for (Toy item : toys) {
			if (item.getSerialNumber().equals(serialNumber)) {
				searchToy.add(item);
				return searchToy;
//				for (Toy items: searchToy) {
//					System.out.println(items.toString());
//				System.out.println(item.getName());
			}

		}
		return searchToy;
	}

	/*
	 * takes the user provided category and runs a for loop to see that matches to
	 * that category or not if it matches it adds the item to the temporary
	 * arraylist called searched toys list
	 */

	public void searchByCategory(String category) {
		for (Toy item : toys) {
			if (item.getCategory().toLowerCase().contains(category.toLowerCase())) {
				searchToy.add(item);
//				for (Toy items: searchToy) {
//					System.out.println(items.toString());
//				}
			}
		}

	}

	/*
	 * takes the user provided name and runs a for loop to see that matches to that
	 * name or the portion of it or not if it matches it adds the item to the
	 * temporary arraylist called searched toys list
	 */

	public void searchByName(String name) {
		for (Toy item : toys) {
			if (item.getName().toLowerCase().contains(name.toLowerCase())) {
				searchToy.add(item);
//				for (Toy items: searchToy) {
//					System.out.println(items.toString());
//				}
			}
		}

	}

	/**
	 * sharing the temporay arrayList for printing
	 * 
	 * @return
	 */
	public ArrayList<Toy> getSeachToy() {
		return searchToy;
	}

	/**
	 * it checks for the seral number that is already added or not if its not added
	 * then it allows the user to add them.
	 * 
	 * @author rozan
	 * @param serialNumber
	 * @return
	 */

	public boolean serialNumberExist(String serialNumber) {
		for (Toy toy : toys) {
			if (toy.getSerialNumber().equals(serialNumber)) {
				return true;
			}
		}
		return false;

	}

	/*
	 * this method is responsible for checking the serial number is valid or not
	 * first it checks for the digit is actually 10 or not and if its convertable to
	 * long it proves that the serial number is valid cause it has all digits in it.
	 */

	public String validSerialNumber() {
		boolean flag = true;
		String serialNumber = "";
		while (flag) {
			System.out.println("Enter Your Serial Number: ");
			serialNumber = keyboard.nextLine();
			if (serialNumber.length() == 10) {
				try {
					long number = Long.parseLong(serialNumber);
					flag = false;
				} catch (NumberFormatException e) {
					e.getMessage();
				}
			} else {
				System.out.println("The Number Should be 10 digits long and must a valid integer");
			}
		}
		return serialNumber;
	}
	/*
	 * if the serial number passed but the validation test then the user will
	 * provide all the necessary inputs for making that toy and by using the serial
	 * number we can call the exact toy constructor for the specific type toy we
	 * need to make and it gets add to our toys arrayList.
	 */

	public void makeAddedToy() {
		String serialNumber = validSerialNumber();
		System.out.print("Enter Toy Name: ");
		String name = keyboard.nextLine();
		System.out.print("Enter Toy Brand: ");
		String brand = keyboard.nextLine();
		System.out.print("Enter Toy Price: ");
		String priceAsText = keyboard.nextLine();
		double price = Double.parseDouble(priceAsText);
		System.out.print("Enter Available Counts: ");
		String availableCountAsText = keyboard.nextLine();
		int availableCount = Integer.parseInt(availableCountAsText);
		System.out.print("Enter Appropriate Age: ");
		String appAgeAsText = keyboard.nextLine();
		int appAge = Integer.parseInt(appAgeAsText);

		if (toyType(serialNumber).equals("Figure")) {
			System.out.println("Enter Classification: ");
			String classification = keyboard.nextLine();
			Toy figure = new Figure("Figure", serialNumber, name, brand, price, availableCount, appAge, classification);
			toys.add(figure);
		} else if (toyType(serialNumber).equals("Animal")) {
			System.out.println("Enter the matiral of the Toy Please: ");
			String material = keyboard.nextLine();
			System.out.println("Enter the size of the toy Please: ");
			String size = keyboard.nextLine();
			Toy animal = new Animal("Animal", serialNumber, name, brand, price, availableCount, appAge, material, size);
			toys.add(animal);
		}

		else if (toyType(serialNumber).equals("BoardGame")) {
			System.out.println("Enter Designer Names Use (',') to seprate if there is more than one designers");
			String designers = keyboard.nextLine();
			System.out.println("Number of min players: ");
			String minP = keyboard.nextLine();
			System.out.println("Number of max Players: ");
			String maxP = keyboard.nextLine();
			Toy BoardGame = new BoardGame("BoardGame", serialNumber, name, brand, price, availableCount, appAge, minP,
					maxP, designers);
			toys.add(BoardGame);
		}

		else if (toyType(serialNumber).equals("Puzzle")) {
			System.out.println("Enter Puzzle Type Please: ");
			String puzzType = keyboard.nextLine();
			Toy puzzle = new Puzzle("puzzle", serialNumber, name, brand, price, availableCount, appAge, puzzType);
			toys.add(puzzle);
		}
		System.out.println("New Toy Added");
	}

	/*
	 * for removing the toy we just take the serial number and check the serial
	 * number valid or not if its valid we search the toy and remove the toy at the
	 * end of this method.
	 */
	public void removeToy() {
//		System.out.println("Enter Serial Number");
		String serialNumber = validSerialNumber();
		int index = 0;
		boolean flag = true;
		for (Toy items : toys) {
			if (items.getSerialNumber().equals(serialNumber)) {
				System.out.println(items.toString());
				index = toys.indexOf(items);
			}
		}
		System.out.println("Do You want to remove this item(Y/N)");
		char option = keyboard.nextLine().charAt(0);
		while (flag) {
			if (option == 'Y' || option == 'y') {
				toys.remove(index);
				System.out.println("Item Removed Succesfully");
				flag = false;
				break;
			}

			else if (option == 'n' || option == 'N') {
				flag = false;
				break;
			}

			else if (option != 'n' || option != 'N' || option != 'y' || option != 'Y') {
				System.out.println("In valid input! Plase try again");
				flag = false;
			}
		}
	}

	/*
	 * uses printwriter to write on the file using the format method for each type
	 * of toy each own type of format method is called.
	 */

	public void saveAndExit() {
		// TODO Auto-generated method stub
		try {
			PrintWriter pw = new PrintWriter(db);
			for (Toy items : toys) {
				pw.println(items.format());
//				System.out.println(items.format());
				pw.flush();
			}
			pw.close();
			System.out.println("Done Saving! Visit us again. Thank You!!!");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
	}
}
