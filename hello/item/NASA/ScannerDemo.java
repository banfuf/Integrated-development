package NASA;
import java.util.Scanner;
public class ScannerDemo {
	public static void main(String[] args) {
		Scanner san = new Scanner(System.in);
		
		System.out.println("next()方法接收");
		if(san.hasNext()) {
			String str = san.next();
			System.out.println("接收的数据为：" + str);
		}
		san.close();
	}
}
