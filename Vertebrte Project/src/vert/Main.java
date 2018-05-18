package vert;

import java.io.IOException;

import vert.Main;
import vert.backend.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application {
	
	private static Stage primaryStage;
	private static BorderPane mainLayout;
	private static VNode[] data;
	
	
	
	
	private static VNode lastVNode;
	private static VNode vHolder;
	private static final String newEmail = "paleozoo1995@gmail.com";

	@Override
	public void start(Stage primaryStage) throws IOException {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Vertebrate Visualizer");
		showMainView();
		showLandingPage();
	}

	/**
	 * loads and displays the MainView fxml file
	 * 
	 * @throws IOException
	 */
	private void showMainView() throws IOException {
		FXMLLoader l = new FXMLLoader();
		l.setLocation(Main.class.getResource("view/MainView.fxml"));
		mainLayout = l.load();
		Scene scene = new Scene(mainLayout, 800, 600);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	/**
	 * Loads the side bar
	 */
	public static void showSideBar() throws IOException {
		FXMLLoader l = new FXMLLoader();
		l.setLocation(Main.class.getResource("view/SideBar.fxml"));
		BorderPane sideBar = l.load();
		mainLayout.getChildren().add(sideBar);
	}

	/**
	 * shows a new stage warning about a search error
	 */
	public static void showSearchWarning() throws IOException {
		FXMLLoader l = new FXMLLoader();
		l.setLocation(Main.class.getResource("search/Warning.fxml"));
		BorderPane warning = l.load();
		// Create a new stage //
		Stage addDialogueStage = new Stage();
		addDialogueStage.setTitle("Warning!");
		addDialogueStage.initModality(Modality.WINDOW_MODAL);
		addDialogueStage.initOwner(primaryStage);
		Scene scene = new Scene(warning);
		addDialogueStage.setScene(scene);
		addDialogueStage.showAndWait();
	}
	
	/**
	 * Loads the initial landing page pane
	 */
	public static void showLandingPage() throws IOException {
		FXMLLoader l = new FXMLLoader();
		l.setLocation(Main.class.getResource("view/LandingPage.fxml"));
		BorderPane landingPage = l.load();
		mainLayout.setCenter(landingPage);
		showSideBar();
	}

	/**
	 * loads the database into mainview
	 */
	public static void loadDatabase() throws IOException {
		FXMLLoader l = new FXMLLoader();
		l.setLocation(Main.class.getResource("database/Database.fxml"));
		BorderPane database = l.load();
		mainLayout.setCenter(database);
		showSideBar();
	}

	/**
	 * loads the search page into mainview
	 */
	public static void loadSearch() throws IOException {
		FXMLLoader l = new FXMLLoader();
		l.setLocation(Main.class.getResource("search/Search.fxml"));
		BorderPane search = l.load();
		mainLayout.setCenter(search);
		showSideBar();
	}

	/**
	 * loads the search page into mainview
	 */
	public static void loadSingleHome(VNode topic) throws IOException {
		passVNode(topic);
		FXMLLoader l = new FXMLLoader();
		l.setLocation(Main.class.getResource("home/SingleHome.fxml"));
		BorderPane singleHome = l.load();
		mainLayout.setCenter(singleHome);
		showSideBar();
	}
	
	/**
	 * loads the compare page into mainview
	 */
	public static void loadCompare() throws IOException {
		FXMLLoader l = new FXMLLoader();
		l.setLocation(Main.class.getResource("compare/Compare.fxml"));
		BorderPane compare = l.load();
		mainLayout.setCenter(compare);
		showSideBar();
	}
	
	/**
	 * Loads the compare search pane
	 */
	public static VNode showCompareSearch() throws IOException {
		FXMLLoader l = new FXMLLoader();
		l.setLocation(Main.class.getResource("compare/CompareSearch.fxml"));
		BorderPane compareSearch = l.load();
		// Create a new stage //
		Stage addDialogueStage = new Stage();
		addDialogueStage.setTitle("Search");
		addDialogueStage.initModality(Modality.WINDOW_MODAL);
		addDialogueStage.initOwner(primaryStage);
		Scene scene = new Scene(compareSearch);
		addDialogueStage.setScene(scene);
		addDialogueStage.showAndWait();
		VNode x = vHolder;
		vHolder = null;
		return x; 
	}
	
	/**
	 * shows a new stage for help/ instructions
	 */
	public static void showHelpStage() throws IOException {
		FXMLLoader l = new FXMLLoader();
		l.setLocation(Main.class.getResource("help/Help.fxml"));
		BorderPane help = l.load();
		// Create a new stage //
		Stage addDialogueStage = new Stage();
		addDialogueStage.setTitle("Help");
		addDialogueStage.initModality(Modality.WINDOW_MODAL);
		addDialogueStage.initOwner(primaryStage);
		Scene scene = new Scene(help);
		addDialogueStage.setScene(scene);
		addDialogueStage.showAndWait();
	}

	/**
	 * shows a new stage for credits
	 */
	public static void showCreditsStage() throws IOException {
		FXMLLoader l = new FXMLLoader();
		l.setLocation(Main.class.getResource("credits/Credits.fxml"));
		BorderPane credits = l.load();
		// Create a new stage //
		Stage addDialogueStage = new Stage();
		addDialogueStage.setTitle("Credits");
		addDialogueStage.initModality(Modality.WINDOW_MODAL);
		addDialogueStage.initOwner(primaryStage);
		Scene scene = new Scene(credits);
		addDialogueStage.setScene(scene);
		addDialogueStage.showAndWait();
	}

	/**
	 * returns the array of VNodes
	 */
	public static VNode[] getData() {
		return data;
	}

	/**
	 * sets lastVNode (last shown vertebrate)
	 */
	public static void setLastVID(VNode last) {
		lastVNode = last;
	}
	
	/**
	 * returns lastVNode (last shown vertebrate)
	 * @return 
	 */
	public static VNode getLastVID() {
		return lastVNode;
	}
	
	public static VNode vHolderWipe() {
		VNode temp = vHolder;
		vHolder = null;
		return temp;
	}
	
	/**
	 * passes a VNode into the main class
	 */
	public static void passVNode(VNode v) {
		vHolder = v;
	}
	
	public static void main(String[] args) {
		VDriver v = new VDriver();
		data = v.getData();
		launch(args);
	}

}
