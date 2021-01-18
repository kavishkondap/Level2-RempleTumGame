import java.awt.Color;
import java.awt.Graphics;

public class Runner extends GameObject{
int velocity;
int acceleration;
public static final int MAX = 13;
	Runner(int x, double y, int width, int height) {
		super(x, y, width, height);
		this.velocity = -MAX;
		this.acceleration = -1;
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
	}
	public boolean inAir () {
		return velocity != -MAX;
	}
	void draw (Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, (int) y, width, height);
	}
	void right () {
		x+=speed;
	}
	void left () {
		x-=speed;
	}
	void up () {
		y-=speed;
	}
	void down () {
		y+=speed;
	}
}
