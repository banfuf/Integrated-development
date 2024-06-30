package NASA;

import java.util.Scanner;

public class EscapeRoomGame {
	private static boolean isDoorLocked = true;
	private static boolean hasKey = false;
	private static boolean hasCode = false;
	private static boolean isGameFinished = false;

	public static void main(String[] args) {
		System.out.println("事情是这样的：");
		System.out.println("有一天，你正在户外打篮球，一个陌生人来到了你所在的地方" + "，他很热情的欢迎你，自称是远方亲戚，邀请你到他家吃顿饭。");
		while (!isGameFinished) {
			System.out.println("是否到他家去");
			System.out.println("是");
			System.out.println("否");

			Scanner scanner = new Scanner(System.in);
			String choice = scanner.nextLine();

			switch (choice) {
			case "是":
				searchRoom();
				break;
			case "否":
				useKey();
				break;
			default:
				System.out.println("无效的选择！");
				break;
			}
		}
	}

	private static void searchRoom() {
		if (!hasKey && !hasCode) {
			hasKey = true;
			hasCode = true;
			System.out.println("你在房间里找到了钥匙和密码！");
		} else {
			System.out.println("你已经搜索过房间了！");
		}
	}

	private static void useKey() {
		if (hasKey) {
			isDoorLocked = false;
			System.out.println("你使用钥匙成功打开了门！");
			checkGameStatus();
		} else {
			System.out.println("你没有钥匙！");
		}
	}

	private static void enterCode() {
		if (hasCode) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("请输入密码：");
			String code = scanner.nextLine();

			if (code.equals("1234")) {
				isDoorLocked = false;
				System.out.println("密码正确，门已解锁！");
				checkGameStatus();
			} else {
				System.out.println("密码错误！");
			}
		} else {
			System.out.println("你没有密码！");
		}
	}

	private static void checkGameStatus() {
		if (!isDoorLocked) {
			System.out.println("恭喜你成功逃离后室！");
			isGameFinished = true;
		}
	}

	private static void quitGame() {
		System.out.println("游戏已退出。");
		isGameFinished = true;
	}
}
