package NASA;

public class StaticTest {
	static double PI = 3.1415;
	static int id;

	public static void method1() {
	}

	public void method2() {
		System.out.println(StaticTest.PI);
		System.out.println(StaticTest.id);
	}

	public static StaticTest method3() {
		method1();
		return null;
	}

}
