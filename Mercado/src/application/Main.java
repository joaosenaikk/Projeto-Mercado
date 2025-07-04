package application;
	
import java.util.ArrayList;

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
		ArrayList<Cliente> clientes = new ArrayList<>();
		
		clientes = clienteDAO.read();
		
		for(int i = 0; i < clientes.size(); i++) {
			cliente = clientes.get(i);
			System.out.println("---");
			System.out.println(cliente.getIdCliente());
			System.out.println(" | ");
			System.out.println(cliente.getCpfCliente());
			System.out.println(" | ");
			System.out.println(cliente.getDataNasc());
			System.out.println(" | ");
			System.out.println(cliente.getNomeCliente());
			System.out.println(" | ");
			System.out.println(cliente.getEndereco());
			System.out.println(" | ");
			System.out.println(cliente.getEmail());
			System.out.println(" | ");
			System.out.println(cliente.getTelefone());
			
			
			
		}
		

		
		
		launch(args);
	}


		
	}

