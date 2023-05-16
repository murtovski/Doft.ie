package Project_package;

import java.io.Serializable;

public class person implements Serializable{
	private String fName, lName, phone, address, dob;
	
	public person(String fName, String lName, String phone, String address, String dob) {
		this.fName = fName;
		this.lName = lName;
		this.phone = phone;
		this.address = address;
		this.dob = dob;
	}
	
	public person() {
		super();
	}
	@Override
	public String toString() {
		return "Name: " + this.fName + " " + this.lName + "\n" +
	           "Phone: " + this.phone + "\n" +
	           "Address: " + this.address + "\n" +
	           "DOB: " + this.dob;
	}
	
	public String getFName() {
		return fName;
	}
	public String getLName() {
		return lName;
	}
	public String getPhone() {
		return phone;
	}
	public String getAddress() {
		return address;
	}
	public String getDob() {
		return dob;
	}
	public String getFullName() {
		return fName + lName;
	}
	public void setFName(String FName) {
		this.fName = fName;
	}
	public void setLName(String LName) {
		this.lName = lName;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getUserName() {
		return fName.toLowerCase()+lName.substring(0, 1).toUpperCase();
	}
	
	public String printAll() {
		return "Full Name: " + getFullName() + "\nPhone Number: " + phone + "\nAddress: " + address + "\nDate Of Birth: " + dob;
	}
}
