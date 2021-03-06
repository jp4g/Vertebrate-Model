package vert.compare;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import vert.Main;
import vert.backend.VNode;
import vert.backend.VSearch;

public class CompareSearchController {

	private Main main;
	VSearch v = new VSearch(main.getData());

	ObservableList<String> categoryList = FXCollections.observableArrayList("Identifier", "Nature", "Category",
			"Common Name", "Kingdom", "Phylum", "Subphylum", "Class", "Subclass", "Order", "Suborder", "Family",
			"Genus", "Species", "GeolPeriod", "GeolEpoch", "Habitat", "Diet", "Egg Type");

	@FXML
	private ComboBox sortBox;

	@FXML
	private ComboBox queryBox;

	@FXML
	private ComboBox resultBox;

	@FXML
	private Button searchBtn;

	@FXML
	private Button confirmBtn;

	@FXML
	private void initialize() {
		sortBox.setItems(categoryList);
	}

	/**
	 * sets query options based on the value chosen for "sort by"
	 */
	@FXML
	private void handleQueryOptions() {
		queryBox.setItems(populateList(v.getPossible((String) sortBox.getValue())));
	}

	@FXML
	private void getResults() throws IOException {
		if (sortBox.getValue() == null || queryBox.getValue() == null) {
			main.showSearchWarning();
		} else
			resultBox.setItems(populateNameList(v.query((String) sortBox.getValue(), (String) queryBox.getValue())));
	}

	/**
	 * adds strings from an array to an observable list
	 */
	@FXML
	private ObservableList<String> populateList(String[] arr) {
		ObservableList<String> temp = FXCollections.observableArrayList();
		for (String s : arr)
			temp.add(s);
		return temp;
	}

	/**
	 * adds names in string form to an observable list from an array of VNodes
	 */
	@FXML
	private ObservableList<String> populateNameList(VNode[] arr) {
		ObservableList<String> temp = FXCollections.observableArrayList();
		for (VNode s : arr)
			temp.add(s.getName());
		return temp;
	}

	/**
	 * determines the VNode used
	 * 
	 * @param key the name being searched for
	 */
	@FXML
	private VNode getCurrent(String key) {
		for (int i = 0; i < Main.getData().length; i++) {
			if (Main.getData()[i].getName().toLowerCase().equals(key.toLowerCase()))
				return Main.getData()[i];
		}
		return null;
	}

	/**
	 * handles the confirmation button
	 */
	@FXML
	private void handleConfirm() {
		if (resultBox.getValue() != null) {
			main.passVNode(getCurrent((String) resultBox.getValue()));
			closeWindow();
		}
	}

	/**
	 * closes the help window when the "Confirm" button is clicked
	 */
	@FXML
	private void closeWindow() {
		Stage stage = (Stage) resultBox.getScene().getWindow();
		stage.close();
	}

}
