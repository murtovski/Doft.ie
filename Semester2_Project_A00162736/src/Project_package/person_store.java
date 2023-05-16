package Project_package;

import java.util.ArrayList;


public class person_store 
		{
		private ArrayList <person> Person;
		public person_store()
		{
			Person = new ArrayList<person>();    
		}

		public void addEmployee(person person)
		{
			Person.add(person);
		}
		
		public person getEmployee(int i)
		{
			return Person.get(i);
		}
		
		public void removeEmployee(int i)
		{
			Person.remove(i);
		}
		
		public int getEmployee_StoreSize()
		{
			return Person.size();
		}

}
