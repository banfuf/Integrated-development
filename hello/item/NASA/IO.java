package NASA;
import java.io.File;
public class IO {
	public static void main(String[] args) {
		File f = new File("D:/nihao/");
		deleteFolder(f);
	}
	public  static void deleteFolder(File f) {
		File[] files = f.listFiles();
		if(files != null) {
			for(File file:files) {
				if(file.isDirectory()) {
					deleteFolder(file);
				}else {
					file.delete();
				}
			}
		}
		f.delete();
		System.out.println("已删除");
	}
}
