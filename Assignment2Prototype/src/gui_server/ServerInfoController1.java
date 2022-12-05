package gui_server;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import logic.Connected;
import logic.Subscriber;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import server.EchoServer;


public class ServerInfoController1 implements Initializable {
	
	@FXML
	private Button btnRefresh;
	@FXML
	private TextField serverIptxt;
	@FXML
	private TableView<Connected> table;
	
	 @FXML
	 public TableColumn<Connected, String> colIp;

	 @FXML
	 public TableColumn<Connected, String> colHost;

	 @FXML
	 public TableColumn<Connected, String> colStatus;
	
	private ObservableList<Connected> data;
	
	
	

	
	 
	public void start(Stage primaryStage) throws Exception {
		// get port and initialize port text field
		String port = Integer.toString(EchoServer.DEFAULT_PORT);
		
		//FXMLLoader loader = new FXMLLoader();
		Parent root = FXMLLoader.load(getClass().getResource("/gui_server/ServerInfo.fxml"));
		Scene scene = new Scene(root);
		//scene.getStylesheets().add(getClass().getResource("/gui/ServerPort.css").toExternalForm());  css
		primaryStage.setTitle("Server Info");
		primaryStage.setScene(scene);
		//this.serverIptxt.setText("");
		//primaryStage.initStyle(StageStyle.UNDECORATED);
		primaryStage.show();
		
	}
	
	public void RunServer() {
		String[] args = {"5555"};
		EchoServer.runServer(args);
	}

	public void RefreshList()
	{
		data = FXCollections.observableArrayList(EchoServer.users);
		table.setItems(data);
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		colIp.setCellValueFactory(new PropertyValueFactory<>("Ip"));
		colHost.setCellValueFactory(new PropertyValueFactory<>("Host"));
		colStatus.setCellValueFactory(new PropertyValueFactory<>("Status"));
	}

}
