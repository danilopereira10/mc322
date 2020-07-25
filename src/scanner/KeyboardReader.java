package scanner;

import java.util.Scanner;

public class KeyboardReader {
	static Scanner scanner;
	
	private void KeyboardReader() {
		//hiding constructor
	}
	
	public static Scanner getScanner() {
		if (scanner == null) {
			scanner = new Scanner(System.in);
		}
		return scanner;
	}
}
