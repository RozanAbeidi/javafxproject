package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class SampleControler {

	private ObservableList<String> listResults = FXCollections.observableArrayList("foo", "bar");

	private DataBase database;

	@FXML
	private Button searchButton;

	@FXML
	private Button clearButton;

	@FXML
	private TextField snTextField;

	@FXML
	private TextField nameTextField;

	@FXML
	private TextField typeTextField;

	@FXML
	private Label snLabel;

	@FXML
	private Label nameLabel;

	@FXML
	private Label typeLabel;

//	@FXML
//	private ListView<String> toyListView = new ListView<>(listResults);
//	
	@FXML
	private ListView<Toy> toyListView;

//	@FXML
//	private ChoiceBox categoryChoiceBox;

	@FXML
	private javafx.scene.control.RadioButton snRadioButton;

	@FXML
	private javafx.scene.control.RadioButton nameRadioButton;

	@FXML
	private javafx.scene.control.RadioButton typeRadioButton;

	private TextField searchBySerial;

	public SampleControler() {
		database = new DataBase();
		database.loadData();
		toyListView = new ListView<>();

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

	}

	@FXML
	public void searchButtonListener(ActionEvent event) {
//		ArrayList<Toy> searchToy =  searchToy.get
//		boolean findtoy = searchToy.isEmpty();
//		TextField snTextField = null;
//		TextField snTextField = snTextField.equals(searchToy);
//		String sn = snTextField.getText();
//		String sn = snTextField.
//		String name = nameTextField.getText();
//		String type = typeTextField.getText();
//		ArrayList<Toy> foundToys = database.searchBySerial(sn);
////		database.searchByName(name);
////		database.searchByCategory(type);

	}

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
//		

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

}
