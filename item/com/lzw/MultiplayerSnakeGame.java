package com.lzw;

import java.util.Scanner;

public class MultiplayerSnakeGame {
	public static void main(String[] args) {
		boolean isGameOver = false;
		int[][] board = new int[10][10]; // 游戏面板
		int player1X = 0, player1Y = 0; // 玩家1的初始位置
		int player2X = 9, player2Y = 9; // 玩家2的初始位置

		while (!isGameOver) {
			// 绘制游戏界面
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					if (i == player1X && j == player1Y) {
						System.out.print("1"); // 显示玩家1的贪吃蛇
					} else if (i == player2X && j == player2Y) {
						System.out.print("2"); // 显示玩家2的贪吃蛇
					} else {
						System.out.print("_"); // 显示空格
					}
				}
				System.out.println();
			}
			System.out.println("Player 1: W/A/S/D to move, Q to quit");
			System.out.println("Player 2: I/J/K/L to move, P to quit");

			// 接收玩家输入
			Scanner scanner = new Scanner(System.in);
			String input = scanner.nextLine();

			// 处理玩家输入
			if (input.equalsIgnoreCase("W")) {
				player1X = Math.max(0, player1X - 1); // 玩家1上移
			} else if (input.equalsIgnoreCase("S")) {
				player1X = Math.min(9, player1X + 1); // 玩家1下移
			} else if (input.equalsIgnoreCase("A")) {
				player1Y = Math.max(0, player1Y - 1); // 玩家1左移
			} else if (input.equalsIgnoreCase("D")) {
				player1Y = Math.min(9, player1Y + 1); // 玩家1右移
			} else if (input.equalsIgnoreCase("I")) {
				player2X = Math.max(0, player2X - 1); // 玩家2上移
			} else if (input.equalsIgnoreCase("K")) {
				player2X = Math.min(9, player2X + 1); // 玩家2下移
			} else if (input.equalsIgnoreCase("J")) {
				player2Y = Math.max(0, player2Y - 1); // 玩家2左移
			} else if (input.equalsIgnoreCase("L")) {
				player2Y = Math.min(9, player2Y + 1); // 玩家2右移
			} else if (input.equalsIgnoreCase("Q") || input.equalsIgnoreCase("P")) {
				isGameOver = true; // 退出游戏
			}
		}
	}
}
