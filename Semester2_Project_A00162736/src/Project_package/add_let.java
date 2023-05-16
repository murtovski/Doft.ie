package Project_package;


import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.SwingConstants;

public class add_let extends JFrame implements ActionListener{
	
	private Container cp;
	private JFrame frame;
	private JButton addBtn, back, imageBtn;
	private lettings_store store = new lettings_store();
	private JTextField type, beds, price;
	private JTextField location;
	private JPanel cardPanel, first, second, third, fourth;
	private CardLayout cards;
	private JLabel typeLabel, locationLabel, bedLabel, priceLabel, title;
	private JLabel imageLabel;
	private int index = 0;
	private File selectedFile = null;
	private JLabel warningLabel;
	
	
	
	public add_let () {
		
		setTitle("Add Letting");
		setBounds(300, 90, 900, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		cp = getContentPane();
		cp.setLayout(null);
		
		title = new JLabel("Add Letting");
		title.setFont(new Font("Arial", Font.PLAIN, 30));
		title.setSize(300, 30);
		title.setLocation(300, 30);
		cp.add(title);
		
		typeLabel = new JLabel("Type: ");
		typeLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		typeLabel.setSize(100, 20);
		typeLabel.setLocation(100, 100);
		cp.add(typeLabel);

		type = new JTextField();
		type.setFont(new Font("Arial", Font.PLAIN, 15));
		type.setSize(180, 20);
		type.setLocation(200, 100);
		cp.add(type);

		locationLabel = new JLabel("Location: ");
		locationLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		locationLabel.setSize(100, 20);
		locationLabel.setLocation(100, 160);
		cp.add(locationLabel);

		location = new JTextField();
		location.setFont(new Font("Arial", Font.PLAIN, 15));
		location.setSize(180, 20);
		location.setLocation(200, 160);
		cp.add(location);

		bedLabel = new JLabel("Beds: ");
		bedLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		bedLabel.setSize(100, 20);
		bedLabel.setLocation(100, 220);
		cp.add(bedLabel);
		
		beds = new JTextField();
		beds.setFont(new Font("Arial", Font.PLAIN, 15));
		beds.setSize(180, 20);
		beds.setLocation(200, 220);
		cp.add(beds);
		
		priceLabel = new JLabel("Price: ");
		priceLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		priceLabel.setSize(100, 20);
		priceLabel.setLocation(100, 280);
		cp.add(priceLabel);
		
		price = new JTextField();
		price.setFont(new Font("Arial", Font.PLAIN, 15));
		price.setSize(180, 20);
		price.setLocation(200, 280);
		cp.add(price);
		
		back = new JButton("BACK");
		back.setFont(new Font("Arial", Font.PLAIN, 15));
		back.setSize(150, 40);
		back.setLocation(100, 400);
		cp.add(back);
		back.addActionListener(this);
		
		addBtn = new JButton("ADD");
		addBtn.setFont(new Font("Arial", Font.PLAIN, 15));
		addBtn.setSize(150, 40);
		addBtn.setLocation(260, 400);
		cp.add(addBtn);
		addBtn.addActionListener(this);
		
		imageBtn = new JButton("ADD IMAGE");
		imageBtn.setFont(new Font("Arial", Font.PLAIN, 15));
		imageBtn.setBounds(420, 400, 150, 40);
		cp.add(imageBtn);
		imageBtn.addActionListener(this);
		
		imageLabel = new JLabel("");
		imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		imageLabel.setBackground(Color.LIGHT_GRAY);
		imageLabel.setForeground(Color.GRAY);
		imageLabel.setBounds(423, 100, 250, 250);
		getContentPane().add(imageLabel);
		cp.add(imageLabel);
		
		warningLabel = new JLabel("Please Fill all Fields");
		warningLabel.setForeground(Color.RED);
		warningLabel.setHorizontalAlignment(SwingConstants.CENTER);
		warningLabel.setFont(new Font("Arial", Font.BOLD, 11));
		warningLabel.setBounds(260, 350, 150, 20);
		warningLabel.setVisible(false);
		cp.add(warningLabel);
		
		setVisible(true);
	}
	
	public ImageIcon ResizeImage(String ImagePath) {
		ImageIcon myImage = new ImageIcon(ImagePath);
		Image img = myImage.getImage();
		Image newImg = img.getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(newImg);
		return image;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == imageBtn) {
			JFileChooser file = new JFileChooser();
			file.setCurrentDirectory(new File("C:\\Users\\murta\\eclipse-workspace\\Semester2_Project_A00162736\\images"));
			FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg", "jpeg", "png", "gif");
			file.addChoosableFileFilter(filter);
			int result = file.showSaveDialog(null);
			if(result == JFileChooser.APPROVE_OPTION) {
				selectedFile = file.getSelectedFile();
				String path = selectedFile.getAbsolutePath();
				imageLabel.setIcon(ResizeImage(path));
				System.out.println(selectedFile.getAbsolutePath());
			}
			else if (result == JFileChooser.CANCEL_OPTION) {
				System.out.println("No file Selected");
			}
		}
		if (e.getSource() == addBtn) {
			//check all fields are occupied
			if (type.getText().equals(null)|| location.getText().equals(null) || beds.getText().equals(null) || price.getText().equals(null)) {
				warningLabel.setText("Please Fill all Fields");
				warningLabel.setVisible(true);
			}
			else if (selectedFile == null){
				warningLabel.setText("Please select an image");
				warningLabel.setVisible(true);
			}
			else
			{
				lettings let = new lettings(type.getText(), location.getText(), beds.getText(), price.getText(), selectedFile.getAbsolutePath());
				store.addLetting(let);
				try {
					store.writeLetting();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				warningLabel.setText("New Letting added!");
				warningLabel.setVisible(true);
			}
		}
		
		if(e.getSource() == back) {
			this.dispose();
			admin admin = new admin();
		}		
	}
}
