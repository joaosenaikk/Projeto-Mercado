package application;
	
import java.sql.Connection;

import connectionFactory.ConnectionDatabase;
import dao.ClienteDAO;
import javafx.application.Application;
import javafx.stage.Stage;
import model.Cliente;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Cliente cliente = new Cliente();
		ClienteDAO clienteDAO = new ClienteDAO();
		
		cliente.setNomeCliente("Pedro");
		cliente.setCpfCliente("1234567890");
		cliente.setDataNasc("1900-09-09");
		cliente.setEmail("Pedrodoscabal@gmail.com");
		cliente.setEndereco("rua do cachimba");
		cliente.setTelefone("12088887777");
		
		clienteDAO.create(cliente);

		
		
		launch(args);
	}

	private static void launch(String[] args) {
		// TODO Auto-generated method stub
		
	}
}
