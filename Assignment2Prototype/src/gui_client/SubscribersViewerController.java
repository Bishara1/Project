package gui_client;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import server.EchoServer;
import client.ChatClient;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import logic.Subscriber;

public class SubscribersViewerController {
	ChatClient client;
	PreparedStatement pst = null;
	Connection conn = null;
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
	private TextField txtFname;
	@FXML
	private TextField txtLname;
	@FXML
	private TextField txtID;
	@FXML
	private TextField txtPhone;
	@FXML
	private TextField txtEmail;
	@FXML
	private TextField txtVisa;
	@FXML
	private TextField txtSubNum;
	
	@FXML
	private Button btnclose=null;
	@FXML
	private Button btnUpdate=null;
		
	@FXML
	private TextField UserIdtxt;
	
	public void start(Stage primaryStage) throws Exception {
		String UserID = UserIdtxt.getText();  // 
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui_client/SubscribersViewer.fxml"));
		Parent root = loader.load();	
		Scene scene = new Scene(root);
		//scene.getStylesheets().add(getClass().getResource("/gui/ServerPort.css").toExternalForm());  //css
		primaryStage.setTitle("Client");
		primaryStage.setScene(scene);
		
		primaryStage.show();	
	}
	
	public void addSubscriber() {
		try 
	      {
	          conn = DriverManager.getConnection("jdbc:mysql://localhost/subscriber?serverTimezone=IST","root","Tali@110994");
	          System.out.println("SQL connection succeed");
	   	  } catch (SQLException ex)  { /* handle any errors*/
				System.out.println("SQLException: " + ex.getMessage());
				System.out.println("SQLState: " + ex.getSQLState());
				System.out.println("VendorError: " + ex.getErrorCode());
	   	  }
		String sql = "Insert into users";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1,txtFname.getText());
			pst.setString(2,txtLname.getText());
			pst.setString(3,txtID.getText());
			pst.setString(4,txtPhone.getText());
			pst.setString(5,txtEmail.getText());
			pst.setString(6,txtVisa.getText());
			pst.setString(7,txtSubNum.getText());
			pst.execute();
			
			System.out.println("User Added Succesffully");




		}
		catch(Exception e){
			System.out.println("Add User Error");
		}
	}
	
	public void UpdatBtn() {
		
	}
	
	public void ExitBtn() {
		System.out.println("exiting login screen");
		System.exit(0);	
	}
	
}
