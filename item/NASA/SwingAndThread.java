package NASA;

import java.awt.Container;
import java.net.URL;
import javax.swing.*;

public class SwingAndThread extends JFrame {
	private JLabel jl = new JLabel();
	private static Thread t;
	private int count = 0;
	private Container container = getContentPane();

	public SwingAndThread() {
		setBounds(300, 200, 250, 100);
		container.setLayout(null);
		URL url = SwingAndThread.class.getResource("/飞机活塞发动机.webp");
		Icon icon = new ImageIcon(url);
		jl.setIcon(icon);
		jl.setHorizontalAlignment(SwingConstants.LEFT);
		jl.setBounds(10, 10, 200, 50);
		jl.setOpaque(true);
		t = new Thread(new Runnable() {
			public void run() {
				while (count <= 200) {
					jl.setBounds(count, 10, 200, 50);
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						e.printStackTrace();
					}
					count += 15;
					if (count == 200) {
						count = 10;
					}
				}
			}
		});
		t.start();
		container.add(jl);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new SwingAndThread();
	}
}
