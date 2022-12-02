package gui_client;

import java.net.URL;
import java.util.ResourceBundle;

import client.ChatClient;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class LoginController {
	ChatClient client;
	
	//save changes by tali
	//taaliiiii
	
	public void start(Stage primaryStage) throws Exception {	
		Parent root = FXMLLoader.load(getClass().getResource("/gui_client/Login.fxml"));
				
		Scene scene = new Scene(root);
		//scene.getStylesheets().add(getClass().getResource("/gui/ServerPort.css").toExternalForm());  css
		primaryStage.setTitle("Client");
		primaryStage.setScene(scene);
		
		primaryStage.show();		
	}
	
	public void ExitBtn() {
		System.out.println("exiting login screen");
		System.exit(0);	
	}
	
	public void LoginBtn(ActionEvent event) throws Exception {
		((Node)event.getSource()).getScene().getWindow().hide(); //hiding primary window
		Stage primaryStage = new Stage();
		
		Parent root = FXMLLoader.load(getClass().getResource("/gui_client/SubscribersViewer.fxml"));
		Scene scene = new Scene(root);
		
		//scene.getStylesheets().add(getClass().getResource("/gui/.css").toExternalForm());
		primaryStage.setTitle("Subscribers Viewer");
		primaryStage.setScene(scene);
		
		primaryStage.show();	
	}
}
