package vert.view;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import vert.Main;

public class SideBarController {

	private Main main;
	private BorderPane currentPane;
	
	@FXML
	private Button homeBtn;

	@FXML
	private Button searchBtn;
	
	@FXML
	private Button compareBtn;
	
	@FXML
	private Button databaseBtn;
	
	@FXML
	private Button helpBtn;
	
	@FXML
	private Button creditsBtn;
	
	@FXML
	private void loadHome() throws IOException {
		if(main.getLastVID() == null)
			main.showLandingPage();
		else 
			main.loadSingleHome(main.getLastVID());
		
	}
	
	@FXML
	private void loadSearch() throws IOException {
		main.loadSearch();
	}
	
	@FXML
	private void loadCompare() throws IOException {
		main.loadCompare();
	}
	
	@FXML
	private void loadDatabase() throws IOException {
		main.loadDatabase();
	}
	
	
	@FXML
	private void showHelp() throws IOException {
		main.showHelpStage();
	}

	@FXML
	private void showCredits() throws IOException {
		main.showCreditsStage();
	}
	
}
