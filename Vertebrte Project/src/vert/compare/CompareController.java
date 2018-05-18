package vert.compare;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import vert.Main;
import vert.backend.VNode;

public class CompareController {
	private Main main;
	private VNode v1;
	private VNode v2;

	@FXML
	private Button searchBtn1;

	@FXML
	private Button searchBtn2;

	@FXML
	private Button confirmBtn;

	@FXML
	private Button prevVert;

	@FXML
	private TextField field1;

	@FXML
	private TextField field2;

	/**
	 * search for a vertebrate
	 */
	@FXML
	private VNode search() throws IOException {
		return main.showCompareSearch();
	}

	@FXML
	private void setField1(String text) {
		field1.setText(text);
	}

	@FXML
	private void setField2(String text) {
		field2.setText(text);
	}

	@FXML
	private void handleSearch1() throws IOException {
		v1 = search();
		if (v1 != null)
			setField1(v1.getName());
	}

	@FXML
	private void handleSearch2() throws IOException {
		v2 = search();
		if (v2 != null)
			setField2(v2.getName());
	}

}
