package Number;

public class Text { // 创建类
	public static void main(String args[]) { // 主方法
		String str = "We are students"; // 定义字符串str
		int size = str.lastIndexOf("");
		System.out.println("空字符串str中的索引位置是：" + size);
		System.out.println("字符串str的长度是:" + str.length());
	}
}