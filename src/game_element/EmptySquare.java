package game_element;

import map.Map;

public class EmptySquare extends GameElement {	
	public EmptySquare(int x, int y, Map map) {
		super(x, y, map);
	}
	
	@Override
	public void print() {
		print("--");
	}
}
