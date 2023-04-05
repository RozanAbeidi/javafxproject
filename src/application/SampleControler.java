package application;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * public class with fields for the textfield and labels
 * 
 * @param splittedLines
 * @return animalTypeToy
 */
public class SampleControler {

	private ObservableList<String> listResults = FXCollections.observableArrayList("foo", "bar");

	private DataBase database;

	@FXML
	private Button searchButton;

	@FXML
	private Button clearButton;

	@FXML
	private Button removeButton;

	@FXML
	private Button removeSearchButton;

	@FXML
	private Button saveButton;

	@FXML
	private TextField snTextField;

	@FXML
	private TextField nameTextField;

	@FXML
	private TextField typeTextField;

	@FXML
	private TextField brandTextField;

	@FXML
	private TextField priceTextField;

	@FXML
	private TextField acTextField;

	@FXML
	private TextField aaTextField;

	@FXML
	private TextField addNameTextField;

	@FXML
	private TextField addSNTextField;

	@FXML
	private TextField addtypeTextField;

	@FXML
	private Label snLabel;

	@FXML
	private Label nameLabel;

	@FXML
	private Label typeLabel;

	@FXML
	private Label brandLabel;

	@FXML
	private TextField materialTextField;

	@FXML
	private TextField sizeTextField;

	@FXML
	private TextField classificationTextField;

	@FXML
	private Label priceLabel;

	@FXML
	private Label addtypeLabel;

	@FXML
	private Label acLabel;

	@FXML
	private Label aaLabel;

	@FXML
	private Label addNameLabel;

	@FXML
	private Label addSNLabel;

	@FXML
	private Label categoryLabel;

	@FXML
	private Label TypeTextField;

	@FXML
	private TextField removeTextField;

	@FXML
	private TextField puzzleTextField;

	@FXML
	private TextField minplayersTextField;

	@FXML
	private TextField maxplayersTextField;

	@FXML
	private TextField designersTextField;

//	@FXML
//	private ListView<String> toyListView = new ListView<>(listResults);
//	
	@FXML
	private ListView<Toy> toyListView;

	@FXML
	private ListView<Toy> removeToyListView;

//	@FXML
//	private ChoiceBox categoryChoiceBox;

	@FXML
	private javafx.scene.control.RadioButton snRadioButton;

	@FXML
	private javafx.scene.control.RadioButton nameRadioButton;

	@FXML
	private javafx.scene.control.RadioButton typeRadioButton;

	private TextField searchBySerial;
	private ObservableList<Toy> toyList;

	private TextField searchByName;

	@FXML
	private ChoiceBox categoryChoiceBox = new ChoiceBox();

	private ArrayList<Toy> searchToy;

	/**
	 * method initializes the database
	 */
	public SampleControler() {
		database = new DataBase();
		database.loadData();
		toyListView = new ListView<>();
		toyList = FXCollections.observableArrayList();
		toyListView.setItems(toyList);

		// Add the search field and toy list view to the VBox

	}

	public void loadData() {
//		ListView listview = new ListView();
//
//		toyListView.add(sn);
//		toyListView.add(name);
//		toyListView.add(type);

//		String sn = snTextField.getText();
//		String name = nameTextField.getText();
//		String type = typeTextField.getText();

	}

	public void initialize() {
		categoryChoiceBox.getItems().addAll("Figure", "Animal", "Puzzle", "Board Game");
	}

	@FXML
	public void searchButtonListener(ActionEvent event) {

		if (snRadioButton.isSelected()) {
			String sn = snTextField.getText();
			ArrayList<Toy> foundItems = database.searchBySerial(sn);
			toyListView.getItems().clear();
			if (!foundItems.isEmpty()) {

				toyListView.getItems().add(foundItems.get(0));
			}
		} else if (nameRadioButton.isSelected()) {
			String name = nameTextField.getText();
			ArrayList<Toy> foundname = database.searchByName(name);
			toyListView.getItems().clear();
			if (!foundname.isEmpty()) {
				// toyListView.getItems().add(foundname.get(0));
				toyListView.getItems().addAll(foundname);

			}

			// do name search
		} else {
			String type = typeTextField.getText();
			ArrayList<Toy> foundtype = database.searchByCategory(type);
			toyListView.getItems().clear();
			if (!foundtype.isEmpty()) {
				// toyListView.getItems().add(foundtype.get(0));
				toyListView.getItems().addAll(foundtype);
//				
			}
			// do type search

		}
	}

	@FXML
	public void saveButtonListener(ActionEvent event) {
		String sn = addSNTextField.getText();
		String name = addNameTextField.getText();
		String brand = brandTextField.getText();
		Double price = Double.parseDouble(priceTextField.getText());
		int ac = Integer.parseInt(acTextField.getText()); // 4
		int aa = Integer.parseInt(aaTextField.getText()); // 5

		String tempValue = (String) categoryChoiceBox.getSelectionModel().getSelectedItem();

		database.makeToyObject(tempValue);

		if (tempValue.equals("Figure")) {

			String cat = classificationTextField.getText();

			// String[] makeFigToy = { sn, name, brand, price, ac, aa, cat };
			// database.makeFigureToy(makeFigToy);

			Toy figure = new Figure("Figure", sn, name, brand, price, ac, aa, cat);

			database.toys.add(figure);

		} else if (tempValue.equals("Animal")) {
			String mat = materialTextField.getText();
			String sz = sizeTextField.getText();

			Toy animal = new Animal("Animal", sn, name, brand, price, ac, aa, mat, sz);
			database.toys.add(animal);

		} else if (tempValue.equals("Puzzle")) {

			String pt = puzzleTextField.getText();

			Toy puzzle = new Puzzle("puzzle", sn, name, brand, price, ac, aa, pt);
			database.toys.add(puzzle);
		} else if (tempValue.equals("Board Game")) {

			String min = minplayersTextField.getText();
			String max = maxplayersTextField.getText();
			String design = designersTextField.getText();

			Toy BoardGame = new BoardGame("BoardGame", sn, name, brand, price, ac, aa, min, max, design);
			database.toys.add(BoardGame);
		}

	}

	@FXML
	public void removeButtonListener() {

	}

	@FXML
	public void removeSearchButtonListener() {

	}

	@FXML
	private void searchRemoveButtonListener(ActionEvent event) {
//		searchToy.clear();
//		String snRemove = removeTextField.getText();
//		validSerialNumber(snRemove);
//		searchBySerial(snRemove);
//		observableList<Toy> toy = FXCollection.observableArrayList(searchToy);
//		removeToyListView
	}

//		}
//		searchByName(nameTextField.getText());

//		ArrayList<Toy> searchToy =  searchToy.get()
//		boolean findtoy = searchToy.isEmpty();
//		TextField snTextField = null;
//		TextField snTextField = snTextField.equals(searchToy);
//		String sn = snTextField.getText();
//		String sn = snTextField.
//		String name = nameTextField.getText();
//		String type = typeTextField.getText();
//		ArrayList<Toy> foundToys = database.searchBySerial(sn);
//		database.searchByName(name);
//		database.searchByCategory(type);

//	public StringField snTextField(String searchBySerial) {
//		if (snTextField.getText() == searchBySerial) {
//			return toy;
//		}
//		else {
//			return null;
//		}
//		
//	}

	@FXML
	public void clearButtonListener(ActionEvent event) {
		snRadioButton.setSelected(false);
		nameRadioButton.setSelected(false);
		typeRadioButton.setSelected(false);
		snTextField.setVisible(true);
		snLabel.setVisible(true);
		nameTextField.setVisible(true);
		nameLabel.setVisible(true);
		typeTextField.setVisible(true);
		typeLabel.setVisible(true);
		nameTextField.setDisable(false);
		typeTextField.setDisable(false);
		snTextField.setDisable(false);

	}

	@FXML
	public void snRadioButtonListener(ActionEvent event) {
		nameTextField.setDisable(true);
		typeTextField.setDisable(true);
		snTextField.setDisable(false);
		snTextField.setVisible(true);
		nameRadioButton.setSelected(false);
		typeRadioButton.setSelected(false);
//		nameTextField.setVisible(false);
//		typeTextField.setVisible(false);
//		snLabel.setVisible(true);
//		nameLabel.setVisible(false);

	}

	@FXML
	public void nameRadioButtonListener(ActionEvent event) {
		snTextField.setDisable(true);
		typeTextField.setDisable(true);
		nameTextField.setDisable(false);
		nameTextField.setVisible(true);
		snRadioButton.setSelected(false);
		typeRadioButton.setSelected(false);
//		snLabel.setVisible(false);
//		typeLabel.setVisible(false);
//		nameLabel.setVisible(true);

	}

	@FXML
	public void typeRadioButtonListener(ActionEvent event) {
		snTextField.setDisable(true);
		nameTextField.setDisable(true);
		typeTextField.setDisable(false);
		typeTextField.setVisible(true);
		snRadioButton.setSelected(false);
		nameRadioButton.setSelected(false);
//		snLabel.setVisible(false);
//		nameLabel.setVisible(false);
//		typeLabel.setVisible(true);

	}

	@FXML
	public void categoryChoiceBox(ActionEvent event) {
		categoryChoiceBox.getItems().addAll("Figure", "Animal", "Puzzle", "Board Game");
		String selectedOption = (String) categoryChoiceBox.getSelectionModel().getSelectedItem();
		categoryChoiceBox.setOnAction(null);
		if (selectedOption.equals("")) {
//			addSNLabel.setVisible(true);
//			addNameLabel.setVisible(true);
//			brandTextField.setVisible(true);
//			priceLabel.setVisible(true);
//			acLabel.setVisible(true);
//			aaLabel.setVisible(true);
//			addSNTextField.setVisible(false);
//			addNameTextField.setVisible(false);
//			brandTextField.setVisible(false);
//			priceTextField.setVisible(false);
//			acTextField.setVisible(false);
//			aaTextField.setVisible(false);

		}
	}
}

