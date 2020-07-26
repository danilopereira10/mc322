package map;

public class EmptySquare extends MapElement {	
	public EmptySquare(Position position, Map map) {
		super(position, map);
	}
	
	@Override
	public void print() {
		print("--");
	}
}
