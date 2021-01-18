import java.awt.Rectangle;

public class GameObject {
	int x;
	double y;
	int width;
	int height;
	int speed;
	boolean isActive;
	Rectangle collisionBox;
	GameObject(int x, double y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.speed = 50;
		this.isActive = true;
		collisionBox = new Rectangle (this.x, (int) this.y, this.width, this.height);
	}

	void update() {
		collisionBox.setBounds(x, (int) y, width, height);
	}
}
