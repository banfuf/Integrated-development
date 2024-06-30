package Number;

public class Accesspropetry {
	static int i = 47;

	public void call() {
		System.out.println("调用call()方法");
		for (i = 0; i < 3; i++) {
			System.out.print(i + " ");
			if (i == 2) {
				System.out.println("\n");
			}
		}
	}

	public Accesspropetry() {
	}

	public static void main(String[] args) {
		Accesspropetry t1 = new Accesspropetry();
		Accesspropetry t2 = new Accesspropetry();
		t2.i = 60;
		System.out.println("第一个实例对象调用变量i的结果：" + t1.i++);
		t1.call();
		System.out.println("第二个实例对象调用变量i的结果：" + t2.i);
		t2.call();
	}
}
