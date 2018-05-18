package vert.credits;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import vert.Main;

public class CreditsController {
	private Main main;
	
	@FXML
	private Button closeBtn;
	
	/**
	 * closes the help window when the "Close" button is clicked
	 */
	@FXML
	private void closeWindow() {
		Stage stage = (Stage) closeBtn.getScene().getWindow();
		stage.close();
	}
}
