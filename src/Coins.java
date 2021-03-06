import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;

public class Coins extends GameObject {
	double speed = 5;
	public static BufferedImage redImage;
	public static BufferedImage blueImage;
	public static BufferedImage yellowImage;
	public BufferedImage currentImage;
	public static boolean needImage = true;
	public static boolean gotImage = false;
	static Random rand = new Random();
	static int random;
	public byte pointValue;
	Coins(int x, double y, int width, int height) {
		super(x, y, width, height);
		if (needImage) {
			loadImages();
//			
		}
		if (random == 0) {
			currentImage = redImage;
			//System.out.println("RED");
			pointValue = 2;
			random = rand.nextInt(3);
		} else if (random == 1) {
			currentImage = blueImage;
			//System.out.println("BLUE");
			pointValue = 3;
			random = rand.nextInt(3);
		} else if (random == 2) {
			currentImage = yellowImage;
			//System.out.println("YELLOW");
			pointValue = 1;
			random = rand.nextInt(3);
		} else {
			System.out.println("EROOROROROROROr");
		}
		
		// TODO Auto-generated constructor stub
	}

	void update() {
		// speed += 0.05;
//		if (GamePanel.score % 5 == 0 && GamePanel.score != 0) {
//			speedForObstacles++;
//		}
		y += speedForObstacles;
		super.update();
	}

	void draw(Graphics g) {
//		g.setColor(Color.GREEN);
//		g.fillRect((int) x, (int) y, width, height);
		if (gotImage) {
			g.drawImage(currentImage, (int) x, (int) y, width, height, null);
			g.setColor(Color.BLUE);
			// g.drawRect((int) x,(int) y, width, height);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect((int) x, (int) y, width, height);
		}
	}

	static void setRandomColor() {
		random++;
		random = random % 3;
	}

	void loadImages() {
		if (needImage) {
			try {
				redImage = ImageIO.read(this.getClass().getResourceAsStream("red.png"));
				blueImage = ImageIO.read(this.getClass().getResourceAsStream("blue.png"));
				yellowImage = ImageIO.read(this.getClass().getResourceAsStream("yCoin.png"));
				gotImage = true;
			} catch (Exception e) {

			}
			needImage = false;
		}
	}

}
