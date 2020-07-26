package scanner;

import java.util.Scanner;

public class KeyboardReader {
	private static KeyboardReader instance;
	private static Scanner scanner;
	
	private KeyboardReader() {
		//hiding constructor
	}
	
	public static KeyboardReader getInstance() {
		if (instance == null) {
			instance = new KeyboardReader();
		}
		return instance;
	}
	
	private static Scanner getScanner() {
		if (scanner == null) {
			scanner = new Scanner(System.in);
		}
		return scanner;
	}
	
	public String readLineInLowerCase() {
		return getScanner().nextLine().toLowerCase();
	}
}
