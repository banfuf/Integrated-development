package Number;

public class GetDay {
	public static void main(String args[]) {
		int day[] = new int[] { 31, 28, 31, 30, 31, 30, 31, 30, 31, 30, 31, 30 };
		for (int i = 0; i < 12; i++) {
			System.out.println((i + 1) + "月有" + day[i] + "天");
		}
	}
}
