import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer time;
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = MENU;
	Font font1;
	Font font2;
	Font endFont1;
	Font scoreFont;
	Runner runner = new Runner(250, 850, 50, 50);
	boolean inAir = false;
	long counter = 0;
	final public static int JUMP_TIME = 30;
	ObjectManager manager = new ObjectManager (runner);
	static Timer shortSpawn;
	static Timer longSpawn;
	static Timer coinSpawn;
	public static int score;
	GamePanel() {
		this.time = new Timer(1000 / 60, this);
		time.start();
		this.font1 = new Font("Monospaced", Font.BOLD, 36);
		this.font2 = new Font("Monospaced", Font.ITALIC, 24);
		this.score = 0;
		this.scoreFont = new Font ("Monospaced", Font.PLAIN, 15);
	}

	@Override
	public void paintComponent(Graphics g) {
		if (currentState == MENU) {
			drawMenuState(g);
		} else if (currentState == GAME) {
			drawGameState(g);
		} else if (currentState == END) {
			drawEndState(g);
		}
	}

	public void startGame() {
		
		shortSpawn = new Timer (900, manager);
		longSpawn = new Timer (1000, manager);
		coinSpawn = new Timer (5000, manager);
		shortSpawn.start();
		longSpawn.start();
		coinSpawn.start();
	}

	void updateMenuState() {

	}

	void updateGameState() {
		counter++;
		// System.out.println("CALLING GAME STATE");
		manager.update();
		//manager.purgeObjects();
		if (!runner.isActive) {
			currentState = END;
		}
		//System.out.println(score);
	}

	void updateEndState() {

	}

	void drawMenuState(Graphics g) {
		// Change to TempleRun Thing
		g.setColor(Color.CYAN);
		g.fillRect(0, 0, TempleRun.WIDTH, TempleRun.HEIGHT);
		g.setFont(font1);
		g.setColor(Color.BLACK);
		g.drawString("TEMPLE RUN KNOCKOFF", 9, 100);
		g.drawString("Made by:", 135, 300);
		g.drawString("Kavish Kondap", 90, 375);
		g.setFont(font2);
		g.setColor(Color.DARK_GRAY);
		g.drawString("Press ENTER to Start", 83, 450);
		g.drawString("Press SPACE for Instructions", 24, 600);
		
	}

	void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, TempleRun.WIDTH, TempleRun.HEIGHT);
		manager.draw(g);
		g.setFont(scoreFont);
		g.setColor(Color.WHITE);
		g.drawString("SCORE: " + score, 10, 950);

	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, TempleRun.WIDTH, TempleRun.HEIGHT);
		g.setFont(font1);
		g.setColor(Color.BLACK);
		g.drawString("GAME OVER", 125, 100);
		g.drawString("YOUR SCORE WAS: " + score, 32, 300);
		g.setFont(font2);
		g.setColor(Color.DARK_GRAY);
		g.drawString("Press ENTER to play again", 42, 600);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
	
		if (currentState == MENU) {
			updateMenuState();
		} else if (currentState == GAME) {
			updateGameState();
			
			
			//System.out.println(counter);
//			if (counter % JUMP_TIME == 0 && inAir) {
//				System.out.println("IT IS MOVING DOWN");
//				
//				runner.down();
//				inAir = false;
//			}
		} else if (currentState == END) {
			updateEndState();
		}
		// System.out.println("Action");
		repaint();
     	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		//System.out.println("KEYPRESSING IS COOL");
		// TODO Auto-generated method stub
		if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
			// System.out.println("ENTER WAS PRESSED");
			if (currentState!= GAME) {
			if (currentState == END) {
				currentState = MENU;
				runner = new Runner (250, 850, 50, 50);
				manager = new ObjectManager (runner);
				score = 0;
			} else {
				currentState++;
			}
			}
			if (currentState == GAME) {
				startGame ();
			}else if (currentState == END) {
				shortSpawn.stop();
				longSpawn.stop();
				coinSpawn.stop();
			}
		}
		if (arg0.getKeyCode() == KeyEvent.VK_UP) {
			// System.out.println("UP");
			// runner.up();
		}
		if (arg0.getKeyCode() == KeyEvent.VK_DOWN) {
			// System.out.println("DOWN");
			// runner.down();
		}
		if (arg0.getKeyCode() == KeyEvent.VK_RIGHT) {
			// System.out.println("RIGHT");
			if (runner.x + runner.width < TempleRun.WIDTH && !runner.inAir()) {
				runner.right();
			}
		}

		if (arg0.getKeyCode() == KeyEvent.VK_LEFT&& !runner.inAir()) {
			// System.out.println("LEFT");
			if (runner.x > 0) {
				runner.left();
			}
		}
		if (arg0.getKeyCode() == KeyEvent.VK_SPACE) {
			// System.out.println("SPACE");
			if (currentState == MENU) {
				JOptionPane.showMessageDialog(null,
						"How to play: \nUse the left and right arrow keys to move\nUse the space bar to jump\nDon't get hit by obstacles, and collect coins as you go");
			} else if (currentState == GAME) {
				if (!runner.inAir()) {
				runner.velocity = runner.MAX;
				//counter = 0;
				
//				for (int i = 0; i<50; i++) {
//				
//				runner.y --;
//				}
//				System.out.println("MOVING UP");
//				System.out.println(counter);
				}
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
}