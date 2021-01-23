import java.awt.Color;
import java.awt.Graphics;

public class LongObstacle extends GameObject{
	double speed = 5;
	LongObstacle(int x, double y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	void update () {
		//speed+=0.05;
		y+=speedForObstacles;
		super.update();
	}
	void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect((int) x, (int) y, width, height);
	}

}
