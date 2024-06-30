package NASA;

public class gef {
	public gef() {
	}

	protected void doSomthing() {
	}

	protected gef doIt() {
		return new gef();
	}

	class gef2 extends gef {
		public gef2() {
			super();
			super.doSomthing();
		}

		public void doSomthingnew() {
		}

		public void doSomthing() {
		}

		protected gef2 doIt() {
			return new gef2();
		}
	}
}
