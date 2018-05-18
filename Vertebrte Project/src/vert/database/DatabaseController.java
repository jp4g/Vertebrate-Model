package vert.database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import vert.Main;
import vert.backend.*;

public class DatabaseController {

	private Main main;

	private ObservableList<VNode> list = FXCollections.observableArrayList();

	@FXML
	private TableView<VNode> table;
	@FXML
	private TableColumn<VNode, String> id;
	@FXML
	private TableColumn<VNode, String> nature;
	@FXML
	private TableColumn<VNode, String> category;
	@FXML
	private TableColumn<VNode, String> commonName;
	@FXML
	private TableColumn<VNode, String> kingdom;
	@FXML
	private TableColumn<VNode, String> phylum;
	@FXML
	private TableColumn<VNode, String> subphylum;
	@FXML
	private TableColumn<VNode, String> theClass;
	@FXML
	private TableColumn<VNode, String> subclass;
	@FXML
	private TableColumn<VNode, String> order;
	@FXML
	private TableColumn<VNode, String> suborder;
	@FXML
	private TableColumn<VNode, String> family;
	@FXML
	private TableColumn<VNode, String> genus;
	@FXML
	private TableColumn<VNode, String> species;
	@FXML
	private TableColumn<VNode, String> geolPeriod;
	@FXML
	private TableColumn<VNode, String> geolEpoch;
	@FXML
	private TableColumn<VNode, String> ageRange;
	@FXML
	private TableColumn<VNode, String> sizeRange;
	@FXML
	private TableColumn<VNode, String> habitat;
	@FXML
	private TableColumn<VNode, String> diet;
	@FXML
	private TableColumn<VNode, String> egg;
	@FXML
	private TableColumn<VNode, String> citation;

	/**
	 * initializes the database controller
	 */
	@FXML
	private void initialize() {
		populateList();
		createTable();
	}

	/**
	 * adds all vnodes to the observable list
	 */
	private void populateList() {
		for (VNode v : main.getData()) {
			list.add(v);
		}
	}

	/**
	 * loads data into the table
	 */
	private void createTable() {
		id.setCellValueFactory(new PropertyValueFactory<VNode, String>("identifier"));
		nature.setCellValueFactory(new PropertyValueFactory<VNode, String>("nature"));
		category.setCellValueFactory(new PropertyValueFactory<VNode, String>("category"));
		commonName.setCellValueFactory(new PropertyValueFactory<VNode, String>("cName"));
		kingdom.setCellValueFactory(new PropertyValueFactory<VNode, String>("kingdom"));
		phylum.setCellValueFactory(new PropertyValueFactory<VNode, String>("phylum"));
		subphylum.setCellValueFactory(new PropertyValueFactory<VNode, String>("subphylum"));
		theClass.setCellValueFactory(new PropertyValueFactory<VNode, String>("vClass"));
		subclass.setCellValueFactory(new PropertyValueFactory<VNode, String>("subclass"));
		order.setCellValueFactory(new PropertyValueFactory<VNode, String>("order"));
		suborder.setCellValueFactory(new PropertyValueFactory<VNode, String>("suborder"));
		family.setCellValueFactory(new PropertyValueFactory<VNode, String>("family"));
		genus.setCellValueFactory(new PropertyValueFactory<VNode, String>("genus"));
		species.setCellValueFactory(new PropertyValueFactory<VNode, String>("species"));
		geolPeriod.setCellValueFactory(new PropertyValueFactory<VNode, String>("geolPeriod"));
		geolEpoch.setCellValueFactory(new PropertyValueFactory<VNode, String>("geolEpoch"));
		ageRange.setCellValueFactory(new PropertyValueFactory<VNode, String>("ageRange"));
		sizeRange.setCellValueFactory(new PropertyValueFactory<VNode, String>("sizeRange"));
		habitat.setCellValueFactory(new PropertyValueFactory<VNode, String>("habitatString"));
		diet.setCellValueFactory(new PropertyValueFactory<VNode, String>("diet"));
		egg.setCellValueFactory(new PropertyValueFactory<VNode, String>("egg"));
		citation.setCellValueFactory(new PropertyValueFactory<VNode, String>("citation"));
		table.setItems(list);
	}

}
