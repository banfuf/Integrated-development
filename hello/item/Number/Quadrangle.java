package Number;
public class Quadrangle{
	private Quadrangle[] qtest = new Quadrangle[6];
	private int nextIndex = 0;
	public void draw(Quadrangle q) {
		if(nextIndex < qtest.length) {
			qtest[nextIndex] = q;
			System.out.println(nextIndex);
			nextIndex++;
		}
	}
	public static void main(String[] args) {
		Quadrangle q = new Quadrangle();
		q.draw(new Square());
		q.draw(new Parallelogram1());
	}
}
class Square extends Quadrangle{
	public Square() {
		System.out.println("正方形");
	}
}
class Parallelogram1 extends Quadrangle{
	public Parallelogram1() {
		System.out.println("平行四边形");
	}
}