package map;

import printer.Printable;
import printer.Printer;

public abstract class MapElement implements Printable {
	protected Position position;
	protected Map map;
	
	public MapElement(Position position, Map map) {
		this.position = position;
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
