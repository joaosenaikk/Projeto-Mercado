package application;
	
import java.io.IOException;
import java.util.ArrayList;

import dao.ClienteDAO;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import model.Cliente;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	private static Stage stage;
	private static Scene main;
	
	public void start(Stage primaryStage) {
		try {
			
			stage = primaryStage;
			
			Parent fxmlLogin = FXMLLoader.load(getClass().getResource("/view/viewLogin.fxml"));
			main = new Scene(fxmlLogin);
			
			primaryStage.setScene(main);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void TelaHome() throws IOException {
		FXMLLoader fxmlHome = new FXMLLoader();
		fxmlHome.setLocation(Main.class.getResource("/view/menuPrincipal.fxml"));
		Parent TelaHome = fxmlHome.load();
		main = new Scene(TelaHome);
		stage.setTitle("Mercadinho - Menu Principal");
		stage.setScene(main);
		stage.setResizable(false);
		stage.centerOnScreen();
		stage.show();
	}
	
	
	public static void TelaLogin() throws IOException {
		FXMLLoader fxmlLogin = new FXMLLoader();
		fxmlLogin.setLocation(Main.class.getResource("/view/viewLogin.fxml"));
		Parent TelaLogin = fxmlLogin.load();
		main = new Scene(TelaLogin);
		stage.setTitle("Mercadinho - Login");
		stage.setScene(main);
		stage.setResizable(false);
		stage.centerOnScreen();
		stage.show();
	}
	public static void main(String[] args) {

		
		
		
		
		launch(args);
	}


		
	}

