package NASA;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MultiplayerSnakeGame extends JPanel implements ActionListener {
	private final int WIDTH = 600;
	private final int HEIGHT = 600;
	private final int DOT_SIZE = 20;
	private final int ALL_DOTS = 900;
	private final int DELAY = 140;

	private final int x[] = new int[ALL_DOTS];
	private final int y[] = new int[ALL_DOTS];

	private int dots;
	private int apple_x;
	private int apple_y;

	private boolean leftDirection = false;
	private boolean rightDirection = true;
	private boolean upDirection = false;
	private boolean downDirection = false;
	private boolean inGame = true;

	private Timer timer;
	private Image ball;
	private Image apple;
	private Image head;

	private final int x2[] = new int[ALL_DOTS];
	private final int y2[] = new int[ALL_DOTS];
	private int dots2;
	private boolean leftDirection2 = true;
	private boolean rightDirection2 = false;
	private boolean upDirection2 = false;
	private boolean downDirection2 = false;

	public MultiplayerSnakeGame() {
		initGame();
	}

	private void initGame() {
		addKeyListener(new TAdapter());
		setBackground(Color.black);
		setFocusable(true);

		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		loadImages();
		initSnake();
		initApple();

		timer = new Timer(DELAY, this);
		timer.start();
	}

	private void loadImages() {
		ImageIcon iid = new ImageIcon("src/resources/dot.png");
		ball = iid.getImage();

		ImageIcon iia = new ImageIcon("src/resources/apple.png");
		apple = iia.getImage();

		ImageIcon iih = new ImageIcon("src/resources/head.png");
		head = iih.getImage();
	}

	private void initSnake() {
		dots = 3;

		for (int z = 0; z < dots; z++) {
			x[z] = 200 - z * DOT_SIZE;
			y[z] = 200;
		}

		dots2 = 3;

		for (int z = 0; z < dots2; z++) {
			x2[z] = 400 + z * DOT_SIZE;
			y2[z] = 400;
		}
	}

	private void initApple() {
		int r = (int) (Math.random() * (WIDTH / DOT_SIZE));
		apple_x = r * DOT_SIZE;

		r = (int) (Math.random() * (HEIGHT / DOT_SIZE));
		apple_y = r * DOT_SIZE;
	}

	private void checkApple() {
		if ((x[0] == apple_x) && (y[0] == apple_y)) {
			dots++;
			initApple();
		}

		if ((x2[0] == apple_x) && (y2[0] == apple_y)) {
			dots2++;
			initApple();
		}
	}

	private void move() {
		for (int z = dots; z > 0; z--) {
			x[z] = x[(z - 1)];
			y[z] = y[(z - 1)];
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

		for (int z = dots2; z > 0; z--) {
			x2[z] = x2[(z - 1)];
			y2[z] = y2[(z - 1)];
		}

		if (leftDirection2) {
			x2[0] -= DOT_SIZE;
		}

		if (rightDirection2) {
			x2[0] += DOT_SIZE;
		}

		if (upDirection2) {
			y2[0] -= DOT_SIZE;
		}

		if (downDirection2) {
			y2[0] += DOT_SIZE;
		}
	}

	private void checkCollision() {
		for (int z = dots; z > 0; z--) {
			if ((z > 4) && (x[0] == x[z]) && (y[0] == y[z])) {
				inGame = false;
			}
		}

		if (y[0] >= HEIGHT) {
			inGame = false;
		}

		if (y[0] < 0) {
			inGame = false;
		}

		if (x[0] >= WIDTH) {
			inGame = false;
		}

		if (x[0] < 0) {
			inGame = false;
		}

		for (int z = dots2; z > 0; z--) {
			if ((z > 4) && (x2[0] == x2[z]) && (y2[0] == y2[z])) {
				inGame = false;
			}
		}

		if (y2[0] >= HEIGHT) {
			inGame = false;
		}

		if (y2[0] < 0) {
			inGame = false;
		}

		if (x2[0] >= WIDTH) {
			inGame = false;
		}

		if (x2[0] < 0) {
			inGame = false;
		}

		if (!inGame) {
			timer.stop();
		}
	}

	private void gameOver(Graphics g) {
		String msg = "Game Over";
		Font small = new Font("Helvetica", Font.BOLD, 14);
		FontMetrics metr = getFontMetrics(small);

		g.setColor(Color.white);
		g.setFont(small);
		g.drawString(msg, (WIDTH - metr.stringWidth(msg)) / 2, HEIGHT / 2);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		doDrawing(g);
	}

	private void doDrawing(Graphics g) {
		if (inGame) {
			g.drawImage(apple, apple_x, apple_y, this);

			for (int z = 0; z < dots; z++) {
				if (z == 0) {
					g.drawImage(head, x[z], y[z], this);
				} else {
					g.drawImage(ball, x[z], y[z], this);
				}
			}

			for (int z = 0; z < dots2; z++) {
				if (z == 0) {
					g.drawImage(head, x2[z], y2[z], this);
				} else {
					g.drawImage(ball, x2[z], y2[z], this);
				}
			}

			Toolkit.getDefaultToolkit().sync();
		} else {
			gameOver(g);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (inGame) {
			checkApple();
			checkCollision();
			move();
		}

		repaint();
	}

	private class TAdapter extends KeyAdapter {
		@Override
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

			if ((key == KeyEvent.VK_A) && (!rightDirection2)) {
				leftDirection2 = true;
				upDirection2 = false;
				downDirection2 = false;
			}

			if ((key == KeyEvent.VK_D) && (!leftDirection2)) {
				rightDirection2 = true;
				upDirection2 = false;
				downDirection2 = false;
			}

			if ((key == KeyEvent.VK_W) && (!downDirection2)) {
				upDirection2 = true;
				rightDirection2 = false;
				leftDirection2 = false;
			}

			if ((key == KeyEvent.VK_S) && (!upDirection2)) {
				downDirection2 = true;
				rightDirection2 = false;
				leftDirection2 = false;
			}
		}
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Multiplayer Snake");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new MultiplayerSnakeGame());
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
