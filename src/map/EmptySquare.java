package map;

public class EmptySquare implements GameElement {
	private Position position;
	
	public EmptySquare(Position position) {
		this.position = position;
	}
	
	@Override
	public String print() {
		return "--";
	}

	@Override
	public int getX() {
		return position.getX();
	}

	@Override
	public int getY() {
		return position.getY();
	}

}
