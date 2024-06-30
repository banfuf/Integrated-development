package NASA;
import java.util.*;
import java.text.*;
public class StringFormat {
	public static void main(String[] args) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		System.out.println("日期 " + sdf.format(date));
		System.out.printf("%tF");
	}
}
