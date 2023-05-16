package Project_package;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JPanel;
import javax.swing.JComboBox;


public class admin extends JFrame implements ActionListener{
	
	private DefaultTableModel users;
	private JTable myTable;
	private JButton myAddDataButton, myRemoveDataButton, backBtn, addLetBtn;
	private JTextField nameInput, passInput;
	private JFrame frame;
	private JComboBox showHide;
	private authorized_user_store store;
	private JButton remLetBtn;
	
	public admin() {
		
		store = new authorized_user_store();
		frame = new JFrame();
		frame.setTitle("Administration");
		frame.setBounds(300, 90, 750, 700);
		Container cp = frame.getContentPane();
		cp.setLayout(null);
		frame.setResizable(false);
		users = new DefaultTableModel(); 
		myTable = new JTable(users);
		myTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		
		
		//------------ Heading -------------

		JLabel title = new JLabel("Administration Page");
		title.setFont(new Font("Arial", Font.PLAIN, 30));
		title.setSize(273, 35);
		title.setLocation(200, 30);
		cp.add(title);
		
		
		
		JScrollPane scroll = new JScrollPane(myTable);
		users.addColumn("Name"); 
		users.addColumn("Password");
		passToTable();
		scroll.setSize(600, 250);
		scroll.setLocation(70, 100);
		cp.add(scroll);

		//----------------Adding the input text fields--------------
		JLabel name = new JLabel("Full Name: ");
		name.setSize(70, 20);
		name.setLocation(105, 400);
		nameInput = new JTextField();
		nameInput.setSize(100, 20);
		nameInput.setLocation(175, 400);
		cp.add(name);
		cp.add(nameInput);
		
		JLabel pass = new JLabel("Password: ");
		pass.setSize(70, 20);
		pass.setLocation(410, 400);
		passInput = new JTextField();
		passInput.setSize(100, 20);
		passInput.setLocation(475, 400);
		cp.add(pass);
		cp.add(passInput);
		
		
		
		//----------------Adding the function buttons---------------
		myAddDataButton = new JButton("Add User");
		myAddDataButton.setFont(new Font("Arial", Font.PLAIN, 15));
		myAddDataButton.setSize(125, 50);
		myAddDataButton.setLocation(302, 500);
		myAddDataButton.addActionListener(this);
		cp.add(myAddDataButton);

		myRemoveDataButton = new JButton("Remove User");
		myRemoveDataButton.setFont(new Font("Arial", Font.PLAIN, 15));
		myRemoveDataButton.setSize(125, 50);
		myRemoveDataButton.setLocation(450, 500);
		myRemoveDataButton.addActionListener(this);
		cp.add(myRemoveDataButton);
		
		
		
		cp.add(myAddDataButton);
		cp.add(myRemoveDataButton);
		
		showHide = new JComboBox();
		showHide.setBounds(302, 400, 81, 21);
		frame.getContentPane().add(showHide);
		showHide.addItem("Show");
		showHide.addItem("Hide");
		showHide.addActionListener(this);
		showHide.setSelectedItem("Show");
		
		backBtn = new JButton("Back");
		backBtn.setFont(new Font("Arial", Font.PLAIN, 15));
		backBtn.setBounds(150, 500, 125, 50);
		frame.getContentPane().add(backBtn);
		
		addLetBtn = new JButton("Add Letting");
		addLetBtn.setFont(new Font("Arial", Font.PLAIN, 15));
		addLetBtn.setBounds(302, 561, 125, 50);
		cp.add(addLetBtn);
		
		remLetBtn = new JButton("Remove Let");
		remLetBtn.setFont(new Font("Arial", Font.PLAIN, 15));
		remLetBtn.setBounds(450, 561, 125, 50);
		frame.getContentPane().add(remLetBtn);
		
		remLetBtn.addActionListener(this);
		addLetBtn.addActionListener(this);
		backBtn.addActionListener(this);
	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public int getRowCount() {
		int count = users.getRowCount();
		return count;
	}
	public String tokenizerReturn(String fullName) {
		StringTokenizer token = new StringTokenizer(fullName, " ");
		String firstName = token.nextToken();
		String lastName = token.nextToken();
		return firstName.toLowerCase() + lastName.substring(0, 1).toUpperCase();
	}
	
	
	public void passToTable()
	{
		users.setRowCount(0);
		for (int i = 0; i < store.getUser_StoreSize(); i++) {
			String userName = store.getUser(i).getUserName();
			String pass = store.getUser(i).getPassword();
			users.addRow(new Object[]{userName, pass});
		}
	}
	
	public void disposeAdmin() {
		frame.dispose();	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == myAddDataButton) {
			String finalUserName = tokenizerReturn(nameInput.getText());
			String finalPassword = passInput.getText();
			boolean check = true;
			//do the loop
			for (int i = 0; i < store.getUser_StoreSize(); i++) {
				if (store.getUser(i).getUserName().equals(finalUserName)) 
				{
					JOptionPane.showMessageDialog(null, "This username already exists!!", "Warning",JOptionPane.WARNING_MESSAGE);
					check = false;
				}
				if (finalPassword.toCharArray().length<6) 
				{
					JOptionPane.showMessageDialog(null, "Password must contain at least 6 characters!!", "Warning",JOptionPane.WARNING_MESSAGE);
					check = false;
				}
			}
			if(check == true) {
				user u1 = new user(finalUserName, finalPassword);
				store.addUser(u1);
				passToTable();
				try {
					store.writeUsers();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}	
		}
		
		if(e.getSource() == myRemoveDataButton) 
		{
			if (myTable.getSelectedRow() != 0) {
				int col = 0;
				int row = myTable.getSelectedRow();
				String name = myTable.getModel().getValueAt(row, col).toString();
				for (int i = 0; i < store.getUser_StoreSize(); i++) {
					if (name.equals(store.getUser(i).getUserName())) {
						store.removeUser(i);
						passToTable();
						try {
							store.writeUsers();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				}
			}
			else JOptionPane.showMessageDialog(null, "We need at least one admin!", "Warning",JOptionPane.WARNING_MESSAGE);
		}
		if (e.getSource() == remLetBtn)
		{
			delete_address delAdd = new delete_address();
			frame.dispose();
		}
		
		
		if (e.getSource() == backBtn) 
		{
			home_page home = new home_page();
			frame.dispose();
		}
		if(e.getSource() == showHide) {
			if(showHide.getSelectedItem().equals("Show")) {
				myTable.setVisible(true);
			}
			if(showHide.getSelectedItem().equals("Hide")) {
				myTable.setVisible(false);
			}
		}
		if(e.getSource() == addLetBtn) 
		{
			add_let addLet = new add_let();
			frame.dispose();
		}
		
	}
}


