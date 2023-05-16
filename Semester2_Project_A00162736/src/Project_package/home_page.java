package Project_package;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JLayeredPane;
import javax.swing.border.BevelBorder;

public class home_page extends JFrame implements ActionListener{
	
	private JMenu menuBar;
	private JButton b0, b1, b2, b3;
	private ImageIcon icon, icon2, icon3, icon4, icon5, icon6, icon7;
	private CardLayout cards;
	private JPanel cardPanel, first, second, third, fourth, barPanel, fifth;
	private JFrame frame;
	progress_bar bar;
	private int index = 0;
	private int x = 150, y = 10, width = 424, height = 30;
	private int start = 0;
	private int increment = width / 4;
	
	public home_page() {
		//Container declaration
		frame = new JFrame();
		frame.setTitle("Welcome to Doft!");
		frame.setBounds(300, 90, 750, 700);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		Container cp = frame.getContentPane();
		cp.setLayout(new BorderLayout(10, 10));
		cp.setBackground(Color.BLACK);
		Font f=new Font("TimesRoman", Font.BOLD,25);
		
		
		JPanel panel1 = new JPanel();
		panel1.setPreferredSize(new Dimension(100, 100));
		panel1.setLayout(new BorderLayout(10, 10));
		
		
		//--------------Sub Panel----------------------
		JPanel sPanel0 = new JPanel();
		sPanel0.setBackground(Color.CYAN);
		sPanel0.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
		JLabel heading = new JLabel("Welcome to Doft");
		heading.setFont(f);
		sPanel0.add(heading);
		JPanel sPanel1 = new JPanel();
		sPanel1.setBackground(Color.lightGray);
		sPanel1.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel sHeading = new JLabel("We can find your home");
		sPanel1.add(sHeading);
		
		
		//--------------Sub Panel----------------------
		panel1.add(sPanel0, BorderLayout.NORTH);
		panel1.add(sPanel1, BorderLayout.SOUTH);
		
		
		
		//--------------South Panel----------------------
		JPanel panel2 = new JPanel();
		barPanel = new JPanel();
		panel2.setPreferredSize(new Dimension(50, 50));
		panel2.setBackground(Color.lightGray);
		panel2.setLayout(null);
		panel2.add(barPanel);
		barPanel.setBounds(x, y, width, height);
		barPanel.setBackground(Color.LIGHT_GRAY);
		barPanel.setLayout(new BorderLayout());
		bar = new progress_bar();
		barPanel.add(bar, BorderLayout.SOUTH);
		moveProgressBar();
		
		//--------------East Panel----------------------
		icon = new ImageIcon("images\\house1.jpg");
		JPanel panel3 = new JPanel();
		panel3.setPreferredSize(new Dimension(150, 150));
		panel3.setLayout(new FlowLayout());
		//panel3.setBackground(Color.RED);
		JLabel pic = new JLabel();
		pic.setIcon(icon);
		panel3.add(pic);
		
		//--------------West Panel----------------------
		icon2 = new ImageIcon("images\\house2.jpg");
		JPanel panel4 = new JPanel();
		panel4.setPreferredSize(new Dimension(150, 150));
		panel4.setLayout(new FlowLayout());
		//panel4.setBackground(Color.RED);
		JLabel pic1 = new JLabel();
		pic1.setIcon(icon2);
		panel4.add(pic1);
		
		//--------------Center Panel----------------------
		JPanel panel5 = new JPanel();
		panel5.setPreferredSize(new Dimension(50, 50));
		panel5.setLayout(new BorderLayout(10, 10));
		panel5.setBackground(Color.BLACK);
		
		JPanel navBar = new JPanel();
		navBar.setPreferredSize(new Dimension(50, 50));
		navBar.setLayout(new GridLayout(1, 0));
		b0 = new JButton("Landlord Login");
		b0.setBackground(Color.lightGray);
		b0.setForeground(Color.DARK_GRAY);
		b1 = new JButton("Guest Search");
		b1.setBackground(Color.lightGray);
		b1.setForeground(Color.DARK_GRAY);
		navBar.add(b0); navBar.add(b1);
		panel5.add(navBar, BorderLayout.NORTH);
		
		//-----------Creating Card Panel-------------------
		cards = new CardLayout();
		cardPanel = new JPanel();
		cardPanel.setLayout(cards);
		first = new JPanel(); second = new JPanel();
		third = new JPanel(); fourth = new JPanel();
		fifth = new JPanel();
		icon3 = new ImageIcon("images\\house3.jpg"); icon4 = new ImageIcon("images\\house4.jpg");
		icon5 = new ImageIcon("images\\house5.jpg"); icon6 = new ImageIcon("images\\house6.jpg");
		icon7 = new ImageIcon("images\\small_house2.jpg");
		JLabel pic2 = new JLabel(); JLabel pic3 = new JLabel();
		JLabel pic4 = new JLabel(); JLabel pic5 = new JLabel();
		JLabel pic6 = new JLabel();
		pic2.setIcon(icon3); pic3.setIcon(icon4);
		pic4.setIcon(icon5); pic5.setIcon(icon6);
		pic6.setIcon(icon7);
		first.add(pic2); second.add(pic3);
		third.add(pic4); fourth.add(pic5);
		fifth.add(pic6);
		cardPanel.add(first); cardPanel.add(second);
		cardPanel.add(third); cardPanel.add(fourth);
		panel5.add(cardPanel, BorderLayout.CENTER);
		b3 = new JButton("NEXT");
		b3.setBackground(Color.lightGray);
		b3.setForeground(Color.DARK_GRAY);
		panel5.add(b3, BorderLayout.SOUTH);
		
		
		//--------------Adding Panels----------------------
		cp.add(panel1, BorderLayout.NORTH);
		cp.add(panel2, BorderLayout.SOUTH);
		cp.add(panel3, BorderLayout.EAST);
		cp.add(panel4, BorderLayout.WEST);
		cp.add(panel5, BorderLayout.CENTER);
		
		
		
//		frame.setSize(750, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		
		b0.addActionListener(this);
		b1.addActionListener(this);
		b3.addActionListener(this);
	}
	
	public void moveProgressBar() {
		if (index > 3) {
			index = 0;
		}
		if (index == 0) 
		{
			start = 0;
		}
			start = index * 25;
			bar.setProgress(start);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==b3) {
			index++;
			cards.next(cardPanel);
			moveProgressBar();
		}
		if (e.getSource() == b0) {
			frame.dispose();
//			admin myAdmin = new admin();
			user_login myUserTable = new user_login();
		}
		if (e.getSource() == b1) {
			frame.dispose();
			rentals myRentals = new rentals();
		}
		
	}


}
