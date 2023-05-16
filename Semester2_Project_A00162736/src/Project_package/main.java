package Project_package;
import java.io.*;


public class main {
	
	public static void main(String[] args) throws Exception {
		
		authorized_user_store usrStore = new authorized_user_store();
		lettings_store letStore = new lettings_store();
		usrStore.readUsers();
		letStore.readLetting();
//		letStore.writeLetting();
		person_store store = new person_store();
		person person = new person();
		home_page home_page = new home_page();
	}
}
