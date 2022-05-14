package src;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;

public class LaborView extends View{
	
	private int vertices;
	
	private Image img;
	
	public LaborView(int vert) {
		vertices = vert;
		switch(vertices) {
		
		case 3:
			img = new ImageIcon(this.getClass().getResource("Lab_3.png")).getImage();
			break;
			
		case 4:
			img = new ImageIcon(this.getClass().getResource("Lab_4.png")).getImage();
			break;
			
		case 5:
			img = new ImageIcon(this.getClass().getResource("Lab_5.png")).getImage();
			break;
			
		case 6:
			img = new ImageIcon(this.getClass().getResource("Lab_6.png")).getImage();
			break;
			
		case 7:
			img = new ImageIcon(this.getClass().getResource("Lab_7.png")).getImage();
			break;
			
		case 8:
			img = new ImageIcon(this.getClass().getResource("Lab_8.png")).getImage();;
			break;
			
		default:
			break;
		}
	}

	public void Draw(Graphics g, Point p) {
		g.drawImage(img, p.x, p.y, null);
		
	}

}
