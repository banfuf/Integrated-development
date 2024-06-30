package Number;

class Parent {
	Parent() {
		System.out.println("调用父类的Parent()构造方法");
	}
}

class SubParent extends Parent {
	SubParent() {
		System.out.println("调用父类的SubParent()构造方法");
	}
}

class Subroutine extends SubParent {
	Subroutine() {
		System.out.println("调用子类的Subroutine()构造方法");
	}

	public static void main(String[] args) {
		Subroutine s = new Subroutine();
	}
}