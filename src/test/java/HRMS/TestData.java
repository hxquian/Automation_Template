package HRMS;

import java.util.Random;

public class TestData {
	public static final String LoginPage = "http://192.168.88.153:3001/";
	public static final String user = "user06";
	public static final String password = "Quian1997@@";
	
	public static int randomNumber(int range) {
		Random random = new Random();
		return random.nextInt(range);
		
	}
}
