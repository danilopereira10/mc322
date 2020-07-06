package map;

public class Printer {
	private Printer() {}
	
	private static Printer instance;
	
	public static Printer getInstance() {
		if (instance == null) {
			return new Printer();
		}
		return instance;
	}
	
	public void print(String message) {
		System.out.print(message + " ");
	}
	
	public void printLine() {
		printLine("");
	}
	
	public void printLine(String message) {
		System.out.println(message);
	}
	
	public void printBagInfo(int amountOfJewels, int totalScore) {
		printLine("Quantidade de joias: " + amountOfJewels);
		printLine("Pontuação total: " + totalScore);
	}
	
	public void printMap(Element[][] matrix) {
		for (Element[] items : matrix) {
			for (Element item : items) {
				if (item != null) { 
					print(item.toString() + " ");
				} else {
					print("-- ");
				}
			}
			printLine();
		}
	}
}
