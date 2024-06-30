package NASA;

;
public class Getstr {
	public static void main(String args[]) {
		int atm = 10;
		int mvp = 4;
		while (atm <= 90) {
			mvp = atm + mvp;
			atm++;
		}
		System.out.println("mvp = " + atm);
	}
}