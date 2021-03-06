import javax.swing.JFrame;

public class TempleRun {
	static JFrame frame;
	public static final int WIDTH = 450;
	public static final int HEIGHT = 1000;
	boolean isClosed;
GamePanel panel;
	TempleRun() {
		this.frame = new JFrame();
		this.panel = new GamePanel ();
	}

	public static void main(String[] args) {
		TempleRun runner = new TempleRun();
		runner.setup();
		GamePanel.playThemeSong ();
	}

	public void setup() {
		frame.setSize(WIDTH, HEIGHT);
		frame.add(panel);
		frame.addKeyListener(panel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		panel.startGame();
	}
}
