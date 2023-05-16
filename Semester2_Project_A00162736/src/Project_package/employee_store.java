package Project_package;

import java.util.ArrayList;


public class employee_store 
		{
		private ArrayList <user> User;
		public employee_store()
		{
			User = new ArrayList<user>();    
		}

		public void addEmployee(user person)
		{
			User.add(person);
		}
		
		public user getEmployee(int i)
		{
			return User.get(i);
		}
		
		public void removeEmployee(int i)
		{
			User.remove(i);
		}
		
		public int getEmployee_StoreSize()
		{
			return User.size();
		}

}
