package NASA;

public class Getifelseif {
	public static void main(String args[]) {
		byte mybyte = 57;
		if (mybyte >= 60) {
			System.out.println("及格");
		} else if (mybyte >= 50) {
			System.out.println("离及格差10分");
		} else if (mybyte >= 40) {
			System.out.println("离及格差20分");
		} else {
			System.out.println("需加油，离及格差30分");
		}
	}
}