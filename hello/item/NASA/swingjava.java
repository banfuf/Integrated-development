package NASA;

import javax.swing.*;

public class swingjava extends JFrame {
	public swingjava() {
		setSize(900, 900);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(swingjava::new);
	}
}
