import java.awt.Rectangle;

public class GameObject {
	double x;
	double y;
	int width;
	int height;
	double speed;
	static double speedForObstacles = 5;
	boolean isActive;
	Rectangle collisionBox;
	GameObject(double x2, double y, int width, int height) {
		this.x = x2;
		this.y = y;
		this.width = width;
		this.height = height;
		this.speed = 0.2;
		this.isActive = true;
		collisionBox = new Rectangle ((int) this.x, (int) this.y, this.width, this.height);
	
	}

	void update() {
		collisionBox.setBounds((int) x, (int) y, width, height);
		speedForObstacles+=0.00025;
	}
}
