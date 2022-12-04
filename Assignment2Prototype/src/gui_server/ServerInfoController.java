package gui_server;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import server.EchoServer;

public class ServerInfoController {
	
	@FXML
	private TextField serverIptxt;
	@FXML
	private TextField porttxt;
	
	public void start(Stage primaryStage) throws Exception {
		// get port and initialize port text field
		String port = Integer.toString(EchoServer.DEFAULT_PORT);
		
		//FXMLLoader loader = new FXMLLoader();
		Parent root = FXMLLoader.load(getClass().getResource("/gui_server/ServerInfo.fxml"));
		
		Scene scene = new Scene(root);
		//scene.getStylesheets().add(getClass().getResource("/gui/ServerPort.css").toExternalForm());  css
		primaryStage.setTitle("Server Info");
		primaryStage.setScene(scene);
		
		//primaryStage.initStyle(StageStyle.UNDECORATED);
		primaryStage.show();
		porttxt.setText(port);
	}
	
	public void ExitBtn() {
		System.out.println("Exiting server info");
		System.exit(0);	
	}
}
