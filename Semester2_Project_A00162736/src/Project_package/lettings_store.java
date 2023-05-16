package Project_package;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class lettings_store {
	private static ArrayList <lettings> Letting = new ArrayList<lettings>();
	static File file = new File ("C:\\Users\\murta\\eclipse-workspace\\Semester2_Project_A00162736\\src\\Project_package\\lettings.txt");
	static ObjectOutputStream oos = null;
	static ObjectInputStream ois = null;
	public lettings_store()
	{   
		
	}
	public static void readLetting() throws Exception {
		if(file.isFile()) {
			ois = new ObjectInputStream(new FileInputStream(file));
			Letting = (ArrayList<lettings>)ois.readObject();
			ois.close();
			System.out.println(Letting);
		}
	}
	public static void writeLetting() throws IOException {
		oos = new ObjectOutputStream(new FileOutputStream(file));
		oos.writeObject(Letting);
		oos.close();
	}
	public void addLetting(lettings e)
	{
		Letting.add(e);
	}
	public lettings getLetting(int i)
	{
		return Letting.get(i);
	}
	public void removeLetting(int i)
	{
		Letting.remove(i);
	}
	
	public int getLetting_StoreSize()
	{
	
		return Letting.size();
	}
	public ArrayList<lettings> returnList(){
		return Letting;
	}
}
