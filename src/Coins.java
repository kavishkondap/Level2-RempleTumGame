import java.awt.Color;
import java.awt.Graphics;

public class Coins extends GameObject {
	double speed = 5;
	Coins(int x, double y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}

	void update() {
		speed += 0.0001;
		y += speed;
		super.update();
	}

	void draw(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(x, (int) y, width, height);

	}

}
