package vert.compare;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import vert.Main;

public class CompareWarningCurrentController {
	private Main main;
	
	@FXML
	private Button closeBtn;
	
	/**
	 * closes the help window when the "OK" button is clicked
	 */
	@FXML
	private void closeWindow() {
		Stage stage = (Stage) closeBtn.getScene().getWindow();
		stage.close();
	}
}
