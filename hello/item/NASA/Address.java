package NASA;

import java.net.*;

public class Address {
	public static void main(String[] args) {
		InetAddress IP;
		try {
			IP = InetAddress.getLocalHost();
			String s = IP.getHostAddress();
			System.out.println(s);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
