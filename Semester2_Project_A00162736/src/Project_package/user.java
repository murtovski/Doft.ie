package Project_package;
import java.awt.Dimension;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class user extends person implements Serializable{
	
	private String userName;
	private String password;
	
	public user (String userName, String password) {
		this.password = password;
		this.userName = userName;
	}
	
	public user() {
		super();
	}
	
	/**
	 * This is the function that takes the information from the text file
	 * 
	 * 
	 */
	@Override
	public String toString() {
		return userName+","+password;
	}
	
	//Getters
	public String getPassword() {
		return password;
	}
	public String getUserName() {
		return userName;
	}
	//Setters
	public void setPassword(String password) {
		this.password = password;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
