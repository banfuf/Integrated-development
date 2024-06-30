package NASA;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SnakeGame extends JFrame {
	private final int WIDTH = 300;
	private final int HEIGHT = 300;

	public SnakeGame() {
		setTitle("Snake Game");
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		SnakePanel panel = new SnakePanel();
		add(panel);

		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				panel.keyPressed(e);
			}
		});

		setFocusable(true);
		setVisible(true);
	}

	public static void main(String[] args) {
		new SnakeGame();
	}
}

class SnakePanel extends JPanel implements ActionListener {
	private final int DOT_SIZE = 10;
	private final int ALL_DOTS = 900;
	private final int RAND_POS = 29;
	private final int DELAY = 140;

	private final int x[] = new int[ALL_DOTS];
	private final int y[] = new int[ALL_DOTS];

	private int dots;
	private int appleX;
	private int appleY;

	private boolean leftDirection = false;
	private boolean rightDirection = true;
	private boolean upDirection = false;
	private boolean downDirection = false;
	private boolean inGame = true;

	private Timer timer;

	public SnakePanel() {
		setBackground(Color.black);
		setPreferredSize(new Dimension(300, 300));

		initGame();
	}

	private void initGame() {
		dots = 3;

		for (int i = 0; i < dots; i++) {
			x[i] = 50 - i * DOT_SIZE;
			y[i] = 50;
		}

		locateApple();

		timer = new Timer(DELAY, this);
		timer.start();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		doDrawing(g);
	}

	private void doDrawing(Graphics g) {
		if (inGame) {
			g.setColor(Color.green);
			g.fillOval(appleX, appleY, DOT_SIZE, DOT_SIZE);

			for (int i = 0; i < dots; i++) {
				if (i == 0) {
					g.setColor(Color.red);
				} else {
					g.setColor(Color.yellow);
				}

				g.fillRect(x[i], y[i], DOT_SIZE, DOT_SIZE);
			}

			Toolkit.getDefaultToolkit().sync();

		} else {
			gameOver(g);
		}
	}

	private void gameOver(Graphics g) {
		String msg = "Game Over";
		Font small = new Font("Helvetica", Font.BOLD, 14);
		FontMetrics metr = getFontMetrics(small);

		g.setColor(Color.LIGHT_GRAY);
		g.setFont(small);
		g.drawString(msg, (300 - metr.stringWidth(msg)) / 2, 150);
	}

	private void checkApple() {
		if ((x[0] == appleX) && (y[0] == appleY)) {
			dots++;
			locateApple();
		}
	}

	private void move() {
		for (int i = dots; i > 0; i--) {
			x[i] = x[i - 1];
			y[i] = y[i - 1];
		}

		if (leftDirection) {
			x[0] -= DOT_SIZE;
		}

		if (rightDirection) {
			x[0] += DOT_SIZE;
		}

		if (upDirection) {
			y[0] -= DOT_SIZE;
		}

		if (downDirection) {
			y[0] += DOT_SIZE;
		}
	}

	private void checkCollision() {
		for (int i = dots; i > 0; i--) {
			if ((i > 4) && (x[0] == x[i]) && (y[0] == y[i])) {
				inGame = false;
			}
		}

		if (y[0] >= 300) {
			inGame = false;
		}

		if (y[0] < 0) {
			inGame = false;
		}

		if (x[0] >= 300) {
			inGame = false;
		}

		if (x[0] < 0) {
			inGame = false;
		}

		if (!inGame) {
			timer.stop();
		}
	}

	private void locateApple() {
		int r = (int) (Math.random() * RAND_POS);
		appleX = ((r * DOT_SIZE));

		r = (int) (Math.random() * RAND_POS);
		appleY = ((r * DOT_SIZE));
	}

	public void actionPerformed(ActionEvent e) {
		if (inGame) {
			checkApple();
			checkCollision();
			move();
		}

		repaint();
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		if ((key == KeyEvent.VK_LEFT) && (!rightDirection)) {
			leftDirection = true;
			upDirection = false;
			downDirection = false;
		}

		if ((key == KeyEvent.VK_RIGHT) && (!leftDirection)) {
			rightDirection = true;
			upDirection = false;
			downDirection = false;
		}

		if ((key == KeyEvent.VK_UP) && (!downDirection)) {
			upDirection = true;
			rightDirection = false;
			leftDirection = false;
		}

		if ((key == KeyEvent.VK_DOWN) && (!upDirection)) {
			downDirection = true;
			rightDirection = false;
			leftDirection = false;
		}
	}
}
