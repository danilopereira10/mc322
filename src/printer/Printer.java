package printer;

public class Printer {
	private static Printer instance;
	
	public static Printer getInstance() {
		if (instance == null) {
			instance = new Printer();
		}
		return instance;
	}
	
	public void print(String message) {
		System.out.print(message);
	}
	
	public void printLine() {
		printLine("");
	}
	
	public void printLine(String message) {
		System.out.println(message);
	}
}
