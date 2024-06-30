package NASA;

import java.util.Scanner;

public class MarioGame {
	public static void main(String[] args) {
		boolean isGameOver = false;
		int marioPosition = 5; // 初始马里奥位置

		while (!isGameOver) {
			// 绘制游戏界面
			for (int i = 0; i < 10; i++) {
				if (i == marioPosition) {
					System.out.print("M"); // 显示马里奥
				} else {
					System.out.print("_"); // 显示地面
				}
			}
			System.out.println("\nUse A and D to move, Q to quit");

			// 接收玩家输入
			Scanner scanner = new Scanner(System.in);
			String input = scanner.nextLine();

			// 处理玩家输入
			if (input.equalsIgnoreCase("A")) {
				marioPosition = Math.max(0, marioPosition - 1); // 左移
			} else if (input.equalsIgnoreCase("D")) {
				marioPosition = Math.min(9, marioPosition + 1); // 右移
			} else if (input.equalsIgnoreCase("Q")) {
				isGameOver = true; // 退出游戏
			}
		}
	}
}
