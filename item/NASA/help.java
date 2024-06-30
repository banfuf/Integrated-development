package NASA;

import java.util.Scanner;

public class help {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("事情是这样的：");
		System.out.println("有一天，你正在户外打篮球，一个陌生人来到了你所在的地方" + "，他很热情的欢迎你，自称是远方亲戚，邀请你到他家吃顿饭。");

		System.out.println("是否到他家去");
		String complex = scanner.nextLine();
		switch (complex) {
		case "是":
			System.out.println("你进入了他的家");
			System.out.println("陌生人对你说了一些话：他说" + "，我去买点肉回来，你在家待着。");
			System.out.println("对了，不要去厨房哦。");
			System.out.println("你对这句话感到奇怪...");
			System.out.println("而那个陌生人也没再说什么，出门走了。");
			break;
		case "否":
			System.out.println("游戏结束");
			break;
		}
	}
}
