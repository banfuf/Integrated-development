package Number;

import java.util.Date;

public class GetDate {
	public static void main(String args[]) {
		Date date = new Date();
		String hour = String.format("%tH", date);
		String minute = String.format("%tM", date);
		String second = String.format("%tS", date);
		String mous = String.format("%tL", date);
		String hous = String.format("%tN", date);
		System.out.println("现在是：" + hour + "时" + minute + "分" + second + "秒" + mous + "毫秒" + hous + "微妙");
	}
}
