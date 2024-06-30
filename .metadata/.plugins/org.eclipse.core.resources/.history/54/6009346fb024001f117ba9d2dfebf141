package com.lzw;

import java.util.Scanner;

public class KunKunGame {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("欢迎来到恐怖坤坤游戏！你有勇气挑战吗？");
		System.out.println("1. 开始游戏");
		System.out.println("2. 退出游戏");

		int choice = scanner.nextInt();

		switch (choice) {
		case 1:
			startGame(scanner);
			break;
		case 2:
			System.out.println("游戏结束！");
			break;
		default:
			System.out.println("请输入有效选项！");
		}
	}

	public static void startGame(Scanner scanner) {
		System.out.println("你发现自己身处一个黑暗的房间...");
		System.out.println("你的眼前突然出现了一个幽灵坤坤...");
		System.out.println("你要选择做什么？");
		System.out.println("1. 与幽灵坤坤搏斗");
		System.out.println("2. 逃跑");

		int choice = scanner.nextInt();

		switch (choice) {
		case 1:
			System.out.println("你选择与幽灵坤坤搏斗...");
			System.out.println("幽灵坤坤向你发起攻击...");
			System.out.println("你需要输入一个数字来躲避攻击（1-10）：");

			int input = scanner.nextInt();
			int attack = (int) (Math.random() * 10) + 1;

			if (input == attack) {
				System.out.println("恭喜！你成功躲避了攻击，并打败了幽灵坤坤！");
			} else {
				System.out.println("很遗憾，你未能躲避攻击，被幽灵坤坤击败了...");
			}

			break;
		case 2:
			System.out.println("你选择逃跑...");
			System.out.println("可惜，你没能逃脱幽灵坤坤的追击，游戏结束！");
			break;
		default:
			System.out.println("请输入有效选项！");
		}
	}
}