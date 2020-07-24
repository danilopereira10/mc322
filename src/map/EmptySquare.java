package map;

public class EmptySquare extends GameElement {
	private Position position;
	
	public EmptySquare(Position position) {
		super(position);
	}
	
	@Override
	public String print() {
		return "--";
	}
}
