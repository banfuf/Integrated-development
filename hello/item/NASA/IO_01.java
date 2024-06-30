package NASA;
import java.io.File;
public class IO_01 {
	public static void main(String[] args) {
		String str = "D:/nihao/bin/";
		File f = new File(str);
		f.mkdirs();
		System.out.println("已创建");
	}
}
