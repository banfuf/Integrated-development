package NASA;

import java.util.Scanner;

public class XiaLuoInteractive {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("欢迎来到夏洛的网文本互动！");
		System.out.println("请输入你的名字：");
		String name = scanner.nextLine();

		System.out.println("你好，" + name + "！现在，请选择一个选项：");
		System.out.println("1. 与夏洛对话");
		System.out.println("2. 与其他读者交流");
		System.out.println("3. 查看夏洛的最新章节");

		int choice = scanner.nextInt();

		switch (choice) {
		case 1:
			System.out.println("你选择了与夏洛对话！");
			System.out.println("请输入你想要跟夏洛说的话：");
			scanner.nextLine(); // Consume newline character
			String message = scanner.nextLine();
			System.out.println("夏洛回复：你好，" + name + "，感谢你的留言：" + message);
			break;
		case 2:
			System.out.println("你选择了与其他读者交流！");
			System.out.println("请输入你想要分享的内容：");
			scanner.nextLine(); // Consume newline character
			String content = scanner.nextLine();
			System.out.println("其他读者：" + name + "分享了：" + content);
			break;
		case 3:
			System.out.println("你选择了查看夏洛的最新章节！");
			System.out.println("暂无最新章节，请关注更新！");
			break;
		default:
			System.out.println("无效选项！");
			break;
		}

		scanner.close();
	}
}