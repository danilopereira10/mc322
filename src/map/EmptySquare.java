package map;

public class EmptySquare extends GameElement {
	private Position position;
	
	public EmptySquare(int x, int y) {
		super(x, y);
	}
	
	@Override
	public String print() {
		return "--";
	}
}
