package Project_package;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class graphics_bar extends JPanel
{
	
	private int width, height, x, y;
	public graphics_bar(int x, int y, int width, int height)
	{
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		this.setBackground(Color.WHITE);
		g.setColor(Color.BLACK);
		g.drawRect(x, y, width, height);
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
		
		}
	

}
