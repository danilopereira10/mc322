package map;

import printer.Printable;

public abstract class GameElement implements Printable {
	protected Position position;
	
	public GameElement(Position position) {
		this.position = position;
	}
	
	public  int getX() {
		return position.getX();
	}
	public int getY() {
		return position.getY();
	}
}
