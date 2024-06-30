package Number;

public class MathRandomChar {
	public static char GetRandomChar(char char1, char char2) {
		return (char) (char1 + Math.random() * (char2 - char1 + 1));
	}

	public static void main(String[] args) {
		System.out.println("任意小写字母：" + GetRandomChar('a', 'z'));
		System.out.println("任意大写字母：" + GetRandomChar('A', 'Z'));
		System.out.println("0 - 9任意字符：" + GetRandomChar('0', '9'));
	}
}