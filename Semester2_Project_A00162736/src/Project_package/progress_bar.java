package Project_package;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class progress_bar extends JPanel
{
	private int progress, width;
	
	
	public progress_bar()
	{
		//set preferred size of the bar
		setPreferredSize(new Dimension(300, 20));
		progress = 0;
	}
	public void setProgress(int progress) {
        // Set the new progress value and repaint the panel.
        this.progress = progress;
//        System.out.println(progress);
        width = (int) (progress * getWidth() / 100.0);
        repaint();
    }
	
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		 g.setColor(Color.GREEN);
		// Draw the progress bar as a filled rectangle.
//        System.out.println(width);
        g.fillRect(0, 0, width, getHeight());
		}
	

}
