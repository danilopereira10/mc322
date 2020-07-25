package game_element;

import map.Position;

public class EmptySquare extends GameElement {
	private Position position;
	
	public EmptySquare(int x, int y) {
		super(x, y);
	}
	
	@Override
	public void print() {
		print("--");
	}
}
