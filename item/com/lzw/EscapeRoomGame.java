package com.lzw;

import java.util.Scanner;

public class EscapeRoomGame {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// 初始化游戏环境（房间、物品等）

		System.out.println("事情是这样的：");
		System.out.println("有一天，你正在户外打篮球，一个陌生人来到了你所在的地方" + "，他很热情的欢迎你，自称是远方亲戚，邀请你到他家吃顿饭。");

		// 游戏循环开始
		boolean gameRunning = true;
		while (gameRunning) {
			System.out.println("是否到他家去");
			String command = scanner.nextLine();

			// 处理玩家命令
			switch (command) {
			case "查看":
				// 显示房间描述或物品
				break;
			case "使用":
				// 使用物品
				break;
			// 添加更多命令处理
			case "退出":
				gameRunning = false;
				System.out.println("游戏结束。");
				break;
			default:
				System.out.println("不可识别的命令。");
			}
		}
	}
}