package NASA;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

public class ComplexSnakeGame extends JFrame {

	private final int WIDTH = 800;
	private final int HEIGHT = 600;
	private final int GRID_SIZE = 20;

	private ArrayList<Point> snake;
	private Point food;
	private int direction;
	private Timer timer;

	public ComplexSnakeGame() {
		setTitle("Complex Snake Game");
		setSize(WIDTH, HEIGHT);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		snake = new ArrayList<>();
		snake.add(new Point(10, 10));

		food = new Point(15, 15);

		direction = KeyEvent.VK_RIGHT;

		timer = new Timer(100, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				move();
				checkCollision();
				repaint();
			}
		});

		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if ((e.getKeyCode() == KeyEvent.VK_UP && direction != KeyEvent.VK_DOWN)
						|| (e.getKeyCode() == KeyEvent.VK_DOWN && direction != KeyEvent.VK_UP)
						|| (e.getKeyCode() == KeyEvent.VK_LEFT && direction != KeyEvent.VK_RIGHT)
						|| (e.getKeyCode() == KeyEvent.VK_RIGHT && direction != KeyEvent.VK_LEFT)) {
					direction = e.getKeyCode();
				}
			}
		});

		setFocusable(true);
		timer.start();
	}

	private void move() {
		Point head = snake.get(0);
		Point newHead = new Point(head.x, head.y);

		switch (direction) {
		case KeyEvent.VK_UP:
			newHead.y--;
			break;
		case KeyEvent.VK_DOWN:
			newHead.y++;
			break;
		case KeyEvent.VK_LEFT:
			newHead.x--;
			break;
		case KeyEvent.VK_RIGHT:
			newHead.x++;
			break;
		}

		snake.add(0, newHead);

		if (newHead.equals(food)) {
			food.setLocation(new Random().nextInt(WIDTH / GRID_SIZE), new Random().nextInt(HEIGHT / GRID_SIZE));
		} else {
			snake.remove(snake.size() - 1);
		}
	}

	private void checkCollision() {
		Point head = snake.get(0);

		if (head.x < 0 || head.x >= WIDTH / GRID_SIZE || head.y < 0 || head.y >= HEIGHT / GRID_SIZE
				|| snake.subList(1, snake.size()).contains(head)) {
			timer.stop();
		}
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		g.clearRect(0, 0, WIDTH, HEIGHT);

		g.setColor(Color.RED);
		g.fillRect(food.x * GRID_SIZE, food.y * GRID_SIZE, GRID_SIZE, GRID_SIZE);

		g.setColor(Color.GREEN);
		for (Point p : snake) {
			g.fillRect(p.x * GRID_SIZE, p.y * GRID_SIZE, GRID_SIZE, GRID_SIZE);
		}
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new ComplexSnakeGame().setVisible(true);
			}
		});
	}
}