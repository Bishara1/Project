package logic;

import java.io.Serializable;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Subscriber implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ObservableList<String> obs = FXCollections.observableArrayList();


	public Subscriber(String fname, String lName, String id, String phoneNum, String email, String visa,
			String subNUm) {
		super();
		Fname = fname;
		LName = lName;
		this.id = id;
		PhoneNum = phoneNum;
		Email = email;
		Visa = visa;
		SubNUm = subNUm;
	}
	private String Fname;
	private String LName;
	private String id;
	private String PhoneNum;
	private String Email;
	private String Visa;
	private String SubNUm;




	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFname() {
		return Fname;
	}
	public void setFname(String fname) {
		Fname = fname;
	}
	public String getLName() {
		return LName;
	}
	public void setLName(String lName) {
		LName = lName;
	}
	public String getPhoneNum() {
		return PhoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		PhoneNum = phoneNum;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getVisa() {
		return Visa;
	}
	public void setVisa(String visa) {
		Visa = visa;
	}
	public String getSubNUm() {
		return SubNUm;
	}
	public void setSubNUm(String subNUm) {
		SubNUm = subNUm;
	}
	
   

	
}
