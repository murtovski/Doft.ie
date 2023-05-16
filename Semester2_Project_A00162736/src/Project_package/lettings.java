package Project_package;

import java.io.Serializable;

import javax.swing.ImageIcon;

public class lettings implements Serializable{
	private String type, location, rooms, price, imagePath;

	
	public lettings(String type, String location, String rooms, String price, String imagePath) {
		this.type = type;
		this.location = location;
		this.rooms = rooms;
		this.price = price;
		this.imagePath = imagePath;
	}
	
	public lettings() {
		super();
	}
	
	@Override
	public String toString() {
		return type+ "," + location + "," + rooms + "," + price + "," + imagePath;
	}
	
	public String getType() {
		return type;
	}
	public String getLocation() {
			return location;
	}
	public String getRooms() {
		return rooms;
	}
	public String getPrice() {
		return price;
	}
	public String getImagePath() {
		return imagePath;
	}
	
	public void setType(String type) {
		this.type = type;
		
	}
	public void setLocation(String location) {
		this.location = location;
		
	}
	public void setrooms(String rooms) {
		this.rooms = rooms;
		
	}
	public void setprice(String price) {
		this.price = price;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

}
