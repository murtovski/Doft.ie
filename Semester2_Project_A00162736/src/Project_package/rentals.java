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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class rentals extends JFrame implements ActionListener{
	
	private Container cp;
	private JFrame frame;
	private JButton next, prev, back;
	private JPanel info, outerBorderPanel, innerBorderPanel;
	private lettings_store store = new lettings_store();
	private ImageIcon icon0, icon1, icon2, icon3;
	private JTextField type, beds, price;
	private JTextArea location;
	private JPanel cardPanel, first, second, third, fourth;
	private CardLayout cards;
	private JLabel typeLabel, locationLabel, bedLabel, priceLabel, title, imageLabel;
	private int index = 0;
	private String path;
	
	
	
	public rentals () {
		
		setTitle("Registration Form");
		setBounds(300, 90, 900, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		cp = getContentPane();
		cp.setLayout(null);
		
		title = new JLabel("Available Rentals");
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
		type.setSize(150, 20);
		type.setLocation(200, 100);
		type.setText(store.getLetting(index).getType());
		cp.add(type);

		locationLabel = new JLabel("Location: ");
		locationLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		locationLabel.setSize(100, 20);
		locationLabel.setLocation(100, 160);
		cp.add(locationLabel);

		location = new JTextArea();
		location.setFont(new Font("Arial", Font.PLAIN, 15));
		location.setSize(150, 50);
		location.setLocation(200, 150);
		location.setText(store.getLetting(index).getLocation());
		location.setLineWrap(true);
		cp.add(location);

		bedLabel = new JLabel("Beds: ");
		bedLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		bedLabel.setSize(100, 20);
		bedLabel.setLocation(100, 230);
		cp.add(bedLabel);
		
		beds = new JTextField();
		beds.setFont(new Font("Arial", Font.PLAIN, 15));
		beds.setSize(150, 20);
		beds.setLocation(200, 230);
		beds.setText(store.getLetting(index).getRooms());
		cp.add(beds);
		
		priceLabel = new JLabel("Price: ");
		priceLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		priceLabel.setSize(100, 20);
		priceLabel.setLocation(100, 280);
		cp.add(priceLabel);
		
		price = new JTextField();
		price.setFont(new Font("Arial", Font.PLAIN, 15));
		price.setSize(150, 20);
		price.setLocation(200, 280);
		price.setText(store.getLetting(index).getPrice());
		cp.add(price);
		
		prev = new JButton("Previous");
		prev.setFont(new Font("Arial", Font.PLAIN, 15));
		prev.setSize(150, 40);
		prev.setLocation(100, 400);
		cp.add(prev);
		prev.addActionListener(this);
		
		back = new JButton("BACK");
		back.setFont(new Font("Arial", Font.PLAIN, 15));
		back.setSize(150, 40);
		back.setLocation(260, 400);
		cp.add(back);
		back.addActionListener(this);
		
		next = new JButton("NEXT");
		next.setFont(new Font("Arial", Font.PLAIN, 15));
		next.setSize(150, 40);
		next.setLocation(420, 400);
		cp.add(next);
		next.addActionListener(this);
		
		imageLabel = new JLabel("");
		imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		imageLabel.setBackground(Color.LIGHT_GRAY);
		imageLabel.setForeground(Color.GRAY);
		imageLabel.setBounds(423, 100, 250, 250);
		cp.add(imageLabel);
		path = store.getLetting(index).getImagePath();
		imageLabel.setIcon(ResizeImage(path));
		System.out.println(index);
		
		setVisible(true);
	}
	
	public ImageIcon ResizeImage(String ImagePath) {
		ImageIcon myImage = new ImageIcon(ImagePath);
		Image img = myImage.getImage();
		Image newImg = img.getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(newImg);
		return image;
	}
	
	public void refresh () {
		int max = store.getLetting_StoreSize() - 1;
		
//		System.out.println(store.getLetting(index).getImagePath());
		if (index == -1) {
			index = max;
		}
		if (index > max) {
			index = 0;
		}
		type.setText(store.getLetting(index).getType());
		location.setText(store.getLetting(index).getLocation());
		beds.setText(store.getLetting(index).getRooms());
		price.setText(store.getLetting(index).getPrice());
		path = store.getLetting(index).getImagePath();
		imageLabel.setIcon(ResizeImage(path));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == prev) {
			index --;
			refresh();
		}
		if(e.getSource() == next) {
			index ++;
			refresh();
		}
		if(e.getSource() == back) {
			this.dispose();
			home_page myhomepage = new home_page();
		}		
	}
}
