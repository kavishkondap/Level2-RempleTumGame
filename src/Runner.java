import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Runner extends GameObject{
int velocity;
int acceleration;
boolean right;
boolean left;
public static final int MAX = 16;
long last_time = System.nanoTime();
long time = System.nanoTime();
double delta_time = (int) ((time - last_time) / 1000000);
public static BufferedImage image;
public static boolean needImage = true;
public static boolean gotImage = false;	
	Runner(double x, double y, int width, int height) {
		super(x, y, width, height);
		this.velocity = -MAX;
		this.acceleration = -1;
		if (needImage) {
		    loadImage ("temple_run_dude_no_back.png");
		}
		// TODO Auto-generated constructor stub
	}
	void update () {
		super.update();
	
		
		if (inAir()) {
			y-=velocity;
			velocity += acceleration;
			
		}
		if (!inAir()) {
			y = 850;
		}
		time = System.nanoTime();
		delta_time = (int) (time-last_time)/1000000;
		last_time = time;
	move();
	}
	public boolean inAir () {
		return velocity != -MAX;
	}
	void draw (Graphics g) {
//		g.setColor(Color.BLUE);
//		g.fillRect((int) x, (int) y, width, height);
		if (gotImage) {
			g.drawImage(image, (int) x, (int) y, width, height, null);
			g.setColor(Color.BLUE);
			//g.drawRect((int) x,(int) y, width, height);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect((int)x, (int)y, width, height);
		}
	}
//	void right () {
//		x+=speed;
//	}
//	void left () {
//		x-=speed;
//	}
	void move () {
		
		if (left) {
			x-=speed*delta_time;
		}
		if (right) {
			x+=speed*delta_time;
		}
		if (x<0) {
			x = TempleRun.WIDTH - width;
		}
		if (x+width>TempleRun.WIDTH) {
			x = 0;
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

	

//	void up () {
//		y-=speed;
//	}
//	void down () {
//		y+=speed;
//	}
}
