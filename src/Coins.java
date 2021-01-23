import java.awt.Color;
import java.awt.Graphics;

public class Coins extends GameObject {
	double speed = 5;

	Coins(int x, double y, int width, int height) {
		super(x, y, width, height);
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
		g.setColor(Color.GREEN);
		g.fillRect((int) x, (int) y, width, height);

	}

}
