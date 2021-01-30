import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;

public class ObjectManager implements ActionListener {
	// implements ActionListener
	Runner runner;
	ArrayList<ShortObstacle> shortObstacles = new ArrayList<ShortObstacle>();
	ArrayList<LongObstacle> longObstacles = new ArrayList<LongObstacle>();
	ArrayList<Coins> coins = new ArrayList<Coins>();
	Random rand = new Random();
	Random ran = new Random();
	int lastSpawn = 1;
	//URL soundbyte = new File("yourpath/sound.wav").toURI().toURL();
	//java.applet.AudioClip clip = java.applet.Applet.newAudioClip(soundbyte);
	
	
	
	ObjectManager(Runner runner) {
		this.runner = runner;
		
	}

	void addShort() {
		if (shortObstacles.size() <= 10) {
			int temp = rand.nextInt(3);
			if (lastSpawn != temp) {

				shortObstacles.add(new ShortObstacle(lastSpawn * 150, -50, 150, 50));
				lastSpawn = temp;
			}
		}
	}

	void addLong() {
		if (longObstacles.size() <= 1) {
			longObstacles.add(new LongObstacle(rand.nextInt(3) * 150, -400, 150, 400));
		}
	}

	void addCoins() {
		Coins.setRandomColor ();
		int spawnPos = rand.nextInt(3) * 150;
		for (int i = 1; i < ran.nextInt(6) + 10; i++) {
			coins.add(new Coins(spawnPos + 50, -50 * i, 30, 30));
		}

	}

	void update() {
		runner.update();
		for (int i = 0; i < shortObstacles.size(); i++) {
			shortObstacles.get(i).update();
			if (shortObstacles.get(i).y > TempleRun.HEIGHT) {
				shortObstacles.get(i).isActive = false;
			}
		}
		for (int i = 0; i < longObstacles.size(); i++) {
			longObstacles.get(i).update();
			if (longObstacles.get(i).y > TempleRun.HEIGHT) {
				longObstacles.get(i).isActive = false;
			}
		}
		for (int i = 0; i < coins.size(); i++) {
			coins.get(i).update();
			if (coins.get(i).y > TempleRun.HEIGHT) {
				coins.get(i).isActive = false;
			}
		}
		purgeObjects();
		checkCollisions();
	}

	void draw(Graphics g) {
		for (int i = 0; i < coins.size(); i++) {
			coins.get(i).draw(g);
		}
		for (int i = 0; i < shortObstacles.size(); i++) {
			shortObstacles.get(i).draw(g);
		}

		for (int i = 0; i < longObstacles.size(); i++) {
			longObstacles.get(i).draw(g);
		}
		runner.draw(g);

	}

	void purgeObjects() {
		for (int i = 0; i < longObstacles.size(); i++) {
			if (!longObstacles.get(i).isActive) {
				longObstacles.remove(i);
				i--;
			}
		}
		for (int i = 0; i < shortObstacles.size(); i++) {
			if (!shortObstacles.get(i).isActive) {
				shortObstacles.remove(i);
				i--;
			}
		}
		for (int i = 0; i < coins.size(); i++) {
			if (!coins.get(i).isActive) {
				coins.remove(i);
				i--;
			}
		}
	}

	void checkCollisions() {
		for (int i = 0; i < shortObstacles.size(); i++) {
			if (runner.collisionBox.intersects(shortObstacles.get(i).collisionBox) && !runner.inAir()) {
				shortObstacles.get(i).isActive = false;
				runner.isActive = false;
			}
		}
		for (int i = 0; i < longObstacles.size(); i++) {
			if (runner.collisionBox.intersects(longObstacles.get(i).collisionBox) && !runner.inAir()) {
				longObstacles.get(i).isActive = false;
				runner.isActive = false;
			}
		}
		for (int i = 0; i < coins.size(); i++) {
			if (runner.collisionBox.intersects(coins.get(i).collisionBox)) {
				coins.get(i).isActive = false;
				GamePanel.score+= coins.get(i).pointValue;
				//clip.play();
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == GamePanel.shortSpawn) {
			addShort();
		} else if (e.getSource() == GamePanel.longSpawn) {
			addLong();
		} else if (e.getSource() == GamePanel.coinSpawn) {
			addCoins();
		}
	}

//	@Override
//	public void actionPerformed(ActionEvent arg0) {
//		// TODO Auto-generated method stub
//		addShort();
//		addLong();
//		addCoins ();
//	}
}
