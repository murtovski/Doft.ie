package Project_package;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class authorized_user_store {
	 //Initialising the arraylist to store the user list
	static ArrayList <user> authUser = new ArrayList<user>();
	static File file = new File ("C:\\Users\\murta\\eclipse-workspace\\Semester2_Project_A00162736\\src\\Project_package\\user.txt");
	static ObjectOutputStream oos;
	static ObjectInputStream ois = null;
	
	public static void readUsers() throws Exception {
		File file2 = new File("C:\\Users\\murta\\eclipse-workspace\\Semester2_Project_A00162736\\src\\Project_package\\user.txt");
		
		if(file2.isFile()) {
			ois = new ObjectInputStream(new FileInputStream(file2));
			authUser = (ArrayList<user>)ois.readObject();
			ois.close();
			System.out.println(authUser);
		}
	}
	
	public static void writeUsers() throws IOException {
		oos = new ObjectOutputStream(new FileOutputStream(file));
		oos.writeObject(authUser);
		oos.close();
	}
	
	
	
	
	public void addUser(user e)
	{
		authUser.add(e);
	}
	
	public user getUser(int i)
	{
		return authUser.get(i);
	}
	
	public void removeUser(int i)
	{
		authUser.remove(i);
	}
	
	public int getUser_StoreSize()
	{
		return authUser.size();
	}
	
	public ArrayList<user> returnList(){
		return authUser;
	}

}
