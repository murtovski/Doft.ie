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
import javax.swing.SwingConstants;


public class delete_address extends JFrame implements ActionListener{
	
	private DefaultTableModel lets;
	private JTable myTable;
	private JButton myRemoveDataButton, backBtn;
	private JFrame frame;
	private lettings_store store;
	
	public delete_address() {
		
		store = new lettings_store();
		frame = new JFrame();
		frame.setTitle("Remove Lettings");
		frame.setBounds(300, 90, 750, 700);
		Container cp = frame.getContentPane();
		cp.setLayout(null);
		frame.setResizable(false);
		lets = new DefaultTableModel(); 
		myTable = new JTable(lets);
		myTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		
		//------------ Heading -------------
		JLabel title = new JLabel("Delete Letting");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Arial", Font.PLAIN, 30));
		title.setSize(273, 35);
		title.setLocation(217, 11);
		cp.add(title);
		
		JScrollPane scroll = new JScrollPane(myTable);
		lets.addColumn("Type"); 
		lets.addColumn("Location");
		lets.addColumn("Beds");
		lets.addColumn("Price");
		passToTable();
		scroll.setSize(600, 250);
		scroll.setLocation(70, 100);
		cp.add(scroll);

		myRemoveDataButton = new JButton("Remove Let");
		myRemoveDataButton.setFont(new Font("Arial", Font.PLAIN, 15));
		myRemoveDataButton.setSize(125, 50);
		myRemoveDataButton.setLocation(450, 400);
		myRemoveDataButton.addActionListener(this);
		cp.add(myRemoveDataButton);
		cp.add(myRemoveDataButton);
		
		backBtn = new JButton("Back");
		backBtn.setFont(new Font("Arial", Font.PLAIN, 15));
		backBtn.setBounds(150, 400, 125, 50);
		frame.getContentPane().add(backBtn);
		backBtn.addActionListener(this);
	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public int getRowCount() {
		int count = lets.getRowCount();
		return count;
	}
	
	
	public void passToTable()
	{
		lets.setRowCount(0);
		for (int i = 0; i < store.getLetting_StoreSize(); i++) {
			String typeName = store.getLetting(i).getType();
			String loc = store.getLetting(i).getLocation();
			String beds = store.getLetting(i).getRooms();
			String price = store.getLetting(i).getPrice();
			lets.addRow(new Object[]{typeName, loc, beds, price});
		}
	}
	
	public void disposeAdmin() {
		frame.dispose();	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == myRemoveDataButton) {
			if (myTable.getSelectedRow() != 0) {
				int nameCol = 0, locCol = 1, bedCol = 2, priceCol = 3;
				int row = myTable.getSelectedRow();
				String name = myTable.getModel().getValueAt(row, nameCol).toString();
				String location = myTable.getModel().getValueAt(row, locCol).toString();
				String rooms = myTable.getModel().getValueAt(row, bedCol).toString();
				String price = myTable.getModel().getValueAt(row, priceCol).toString();
				for (int i = 0; i < store.getLetting_StoreSize(); i++) {
					if (name.equals(store.getLetting(i).getType()) && location.equals(store.getLetting(i).getLocation()) && price.equals(store.getLetting(i).getPrice())) {
						store.removeLetting(i);;
						passToTable();
						try {
							store.writeLetting();;
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				}
			}
			else JOptionPane.showMessageDialog(null, "We need at least one admin!", "Warning",JOptionPane.WARNING_MESSAGE);
		}
		
		if (e.getSource() == backBtn) {
			admin admin = new admin();
			frame.dispose();
		}
		
	}
}


