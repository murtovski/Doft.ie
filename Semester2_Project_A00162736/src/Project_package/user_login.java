package Project_package;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;

public class user_login extends JFrame implements ActionListener {
	
	private Container cp;
	private JButton backBtn, loginBtn;
	private JTextField passwordField;
	private JTextField usernameField;
	private employee_store myStore;
	authorized_user_store store = new authorized_user_store();
	
	
	public user_login() {
		
		setTitle("Please Login to contiunue");
		setBounds(900, 90, 600, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		cp = getContentPane();
		cp.setLayout(null);
		
		
		//Adding the buttons
		loginBtn = new JButton("Login");
		loginBtn.setBounds(346, 262, 142, 44);
		getContentPane().add(loginBtn);
		loginBtn.addActionListener(this);
		
		backBtn = new JButton("Back");
		backBtn.setBounds(108, 262, 145, 44);
		getContentPane().add(backBtn);
		
		usernameField = new JTextField();
		usernameField.setBounds(167, 94, 104, 20);
		getContentPane().add(usernameField);
		usernameField.setColumns(10);
		
		passwordField = new JTextField();
		passwordField.setBounds(402, 94, 104, 20);
		getContentPane().add(passwordField);
		passwordField.setColumns(10);
		
		JLabel nameLabel = new JLabel("Username: ");
		nameLabel.setBounds(94, 97, 63, 14);
		getContentPane().add(nameLabel);
		
		JLabel pwordLabel = new JLabel("Password: ");
		pwordLabel.setBounds(329, 97, 63, 14);
		getContentPane().add(pwordLabel);
		
		JLabel lblNewLabel = new JLabel("Enter details to login");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(192, 11, 200, 44);
		getContentPane().add(lblNewLabel);
		backBtn.addActionListener(this);
		
		setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == loginBtn) {
			String uName = usernameField.getText();
			String pWord = passwordField.getText();
			boolean check = true;
			for (int i = 0; i < store.getUser_StoreSize(); i++) {
				String name = store.getUser(i).getUserName();
				String pass = store.getUser(i).getPassword();
				if(uName.equals(name)&&pWord.equals(pass)) {
					admin myAdmin = new admin();
					this.dispose();
					check = true;
					break;
				}else check = false;
			}
			if (check == false) {
				JOptionPane.showMessageDialog(null, "Login details are incorrect", "Warning",JOptionPane.WARNING_MESSAGE);
			}
		}
		
		if (e.getSource() == backBtn) {
			setVisible(false);
			home_page hp = new home_page();
		}
		}
}
