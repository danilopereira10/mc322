package map;

import printer.Printable;
import printer.Printer;

public abstract class GameElement implements Printable {
	protected Position position;
	
	public GameElement(int x, int y) {
		this.position = new Position(x, y);
	}
	
	public  int getX() {
		return position.getX();
	}
	public int getY() {
		return position.getY();
	}
	
	@Override
	public void print(String message) {
		Printer.getInstance().print(message + " ");
	}
}
