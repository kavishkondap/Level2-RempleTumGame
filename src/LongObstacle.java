import java.awt.Color;
import java.awt.Graphics;

public class LongObstacle extends GameObject{
	double speed = 5;
	LongObstacle(int x, double y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	void update () {
		speed+=0.0001;
		y+=speed;
		super.update();
	}
	void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect(x, (int) y, width, height);
	}

}
