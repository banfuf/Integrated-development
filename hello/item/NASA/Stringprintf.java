package NASA;
import java.util.Date;
public class Stringprintf {
	public static void main(String[] args) {
		Date date = new Date();
		System.out.printf("hello 唐吉乐祺");			
			System.out.printf("\n现在是北京时间 %tF 下午 %tR", 
				date,date);
	}
}
