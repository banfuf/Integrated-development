package NASA;
public class zaOver {
	public static int add(int a,int b) {
		return a + b;
	}
	public static double add(double a,int b) {
		return a + b;
	}
	public static double subtract(int a,double b) {
		return a / b;
	}
	public static int subtract(float a,int b) {
		return (int) (a - b);
	}
	public static int add(int a) {
		return 1;
	}
	public static void main(String[] args) {
		System.out.println("调用add(int,int)方法：" + add(3,4));
		System.out.println("调用subtract(int,double)方法：" + subtract(5,3.0));
		System.out.println("调用add(int)方法：" + add(4));
	}
}
