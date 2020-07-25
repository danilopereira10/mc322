package map;

public class EmptySquare extends MapElement {	
	public EmptySquare(int x, int y, Map map) {
		super(x, y, map);
	}
	
	@Override
	public void print() {
		print("--");
	}
}
