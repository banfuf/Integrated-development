package NASA;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

public class ComplexSnake extends JFrame implements ActionListener, KeyListener {
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	private ArrayList<Point> snake = new ArrayList<>();
	private int direction;
	private Point food;

	private Timer timer;

	public ComplexSnake() {
		setTitle("Complex Snake");
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

		setFocusable(true);
		addKeyListener(this);

		initializeGame();

		timer = new Timer(100, this);
		timer.start();
	}

	private void initializeGame() {
		snake.clear();
		snake.add(new Point(10, 10));
		snake.add(new Point(9, 10));
		snake.add(new Point(8, 10));

		direction = KeyEvent.VK_RIGHT; // start moving to the right

		spawnFood();
	}

	private void spawnFood() {
		Random rand = new Random();
		int x = rand.nextInt(WIDTH / 10);
		int y = rand.nextInt(HEIGHT / 10);
		food = new Point(x, y);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		// Draw snake
		g.setColor(Color.YELLOW);
		for (Point p : snake) {
			g.fillRect(p.x * 10, p.y * 10, 10, 10);
		}

		// Draw food
		g.setColor(Color.RED);
		g.fillRect(food.x * 10, food.y * 10, 10, 10);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		moveSnake();
		checkCollision();
		eatFood();

		repaint();
	}

	private void moveSnake() {
		Point head = snake.get(0);
		Point newHead;
		switch (direction) {
		case KeyEvent.VK_UP:
			newHead = new Point(head.x, head.y - 1);
			break;
		case KeyEvent.VK_DOWN:
			newHead = new Point(head.x, head.y + 1);
			break;
		case KeyEvent.VK_LEFT:
			newHead = new Point(head.x - 1, head.y);
			break;
		case KeyEvent.VK_RIGHT:
			newHead = new Point(head.x + 1, head.y);
			break;
		default:
			newHead = new Point(head.x, head.y);
			break;
		}

		snake.add(0, newHead);
		snake.remove(snake.size() - 1);
	}

	private void checkCollision() {
		Point head = snake.get(0);

		if (head.x < 0 || head.x >= WIDTH / 10 || head.y < 0 || head.y >= HEIGHT / 10) {
			gameOver();
		}

		for (int i = 1; i < snake.size(); i++) {
			if (head.equals(snake.get(i))) {
				gameOver();
			}
		}
	}

	private void eatFood() {
		Point head = snake.get(0);

		if (head.equals(food)) {
			spawnFood();
			snake.add(snake.get(snake.size() - 1));
		}
	}

	private void gameOver() {
		timer.stop();
		JOptionPane.showMessageDialog(this, "Game Over");
		initializeGame();
		timer.start();
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		if ((key == KeyEvent.VK_UP && direction != KeyEvent.VK_DOWN)
				|| (key == KeyEvent.VK_DOWN && direction != KeyEvent.VK_UP)
				|| (key == KeyEvent.VK_LEFT && direction != KeyEvent.VK_RIGHT)
				|| (key == KeyEvent.VK_RIGHT && direction != KeyEvent.VK_LEFT)) {
			direction = key;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	public static void main(String[] args) {
		ComplexSnake game = new ComplexSnake();
		game.setVisible(true);
	}
}