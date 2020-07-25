package game_element;

import map.Map;
import map.Position;
import printer.Printable;
import printer.Printer;

public abstract class GameElement implements Printable {
	protected Position position;
	protected Map map;
	
	public GameElement(int x, int y, Map map) {
		this.position = new Position(x, y);
		this.map = map;
		map.put(this, position);
	}
	
	public  int getX() {
		return position.getX();
	}
	public int getY() {
		return position.getY();
	}
	
	public Map getMap() {
		return map;
	}
	
	@Override
	public void print(String message) {
		Printer.getInstance().print(message + " ");
	}
}
