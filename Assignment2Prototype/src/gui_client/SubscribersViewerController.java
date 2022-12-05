package gui_client;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.naming.spi.InitialContextFactory;

import server.EchoServer;
import client.ChatClient;
import client.ClientUI;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import logic.Subscriber;

public class SubscribersViewerController implements Initializable{
	ChatClient client;
	private ObservableList<Subscriber> obs;

	@FXML
	private TableView<Subscriber> tableSub;
	@FXML
	private TableColumn<Subscriber,String> fnamecol;
	@FXML
	private TableColumn<Subscriber,String> lnamecol;
	@FXML
	private TableColumn<Subscriber,String> idcol;
	@FXML
	private TableColumn<Subscriber,String> phonecol;
	@FXML
	private TableColumn<Subscriber,String> emailcol;
	@FXML
	private TableColumn<Subscriber,String> visacol;
	@FXML
	private TableColumn<Subscriber,String> subnumcol;
	
	@FXML
	private TextField SubscriberIDtxt;

	@FXML
	private Button btnclose=null;
	@FXML
	private Button btnUpdate=null;
		
	@FXML
	private TextField UserIdtxt;
	
	public void start(Stage primaryStage) throws Exception { 
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui_client/SubscribersViewer.fxml"));
		Parent root = loader.load();	
		Scene scene = new Scene(root);
		//scene.getStylesheets().add(getClass().getResource("/gui/ServerPort.css").toExternalForm());  //css
		primaryStage.setTitle("Client");
		primaryStage.setScene(scene);
//		ImportDataBtn();
		
		primaryStage.show();	
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ClientUI.chat.accept("Read");
		obs = FXCollections.observableArrayList(ChatClient.subscribers);
		LoadTable();
		tableSub.setItems(obs);
	}
	
	public void UpdatBtn() {
		
	}
	
//	public void ImportDataBtn() {
//		ClientUI.chat.accept("Read");
//		obs = FXCollections.observableArrayList(ChatClient.subscribers);
//		
//	}
	
	public void ExitBtn() {
		System.out.println("exiting login screen");
		System.exit(0);	
	}
	
	public void LoadTable() {
		fnamecol.setCellValueFactory(new PropertyValueFactory<>("Fname"));
		lnamecol.setCellValueFactory(new PropertyValueFactory<>("Lname"));
		idcol.setCellValueFactory(new PropertyValueFactory<>("Id"));
		phonecol.setCellValueFactory(new PropertyValueFactory<>("PhoneNum"));
		emailcol.setCellValueFactory(new PropertyValueFactory<>("Email"));
		visacol.setCellValueFactory(new PropertyValueFactory<>("Visa"));
		subnumcol.setCellValueFactory(new PropertyValueFactory<>("SubNum"));
	}
}
