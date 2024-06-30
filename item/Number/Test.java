package Number;

public class Test {
	public Test() {
	}

	protected void doSomething() {
	}

	protected Test doIt() {
		return new Test();
	}

	class Test2 extends Test {
		public Test2() {
			super();
			super.doSomething();
		}

		public void doSomethingnew() {
		}

		public void doSomething() {
		}

		protected Test2 doIt() {
			return new Test2();
		}
	}
}
