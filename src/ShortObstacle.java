import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class ShortObstacle extends GameObject{
	double speed = 5;
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	ShortObstacle(int x, double y, int width, int height) {
		super(x, y, width, height);
		if (needImage) {
		    loadImage ("log.png");
		}
		// TODO Auto-generated constructor stub
	}
	
	void update () {
		//speed+=0.05;
		//if (GamePanel.score)
		y+=speedForObstacles;
		super.update();
	}
	void draw(Graphics g) {
//		g.setColor(Color.YELLOW);
//		g.fillRect((int) x, (int) y, width, height);
		if (gotImage) {
			g.drawImage(image, (int) x, (int) y, width, height, null);
			g.setColor(new Color(145, 116, 33));
			//g.drawRect((int) x,(int)  y, width, height);
		} else {
			g.setColor(Color.YELLOW);
			g.fillRect((int)x, (int)y, width, height);
		}
		
	}
	void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage = true;
	        } catch (Exception e) {
	            
	        }
	        needImage = false;
	    }
	}
}
