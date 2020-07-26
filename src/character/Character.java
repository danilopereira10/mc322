package character;

import map.Map;
import map.MapElement;
import map.Position;

public abstract class Character extends MapElement {
	public Character(Position position, Map map) {
		super(position, map);
	}

	public void moveUp() {
		try {
			map.moveUp(this);
		} catch (ArrayIndexOutOfBoundsException e) {
			return;
		}
		position.setY(position.getY() - 1);
	}
	
	public void moveLeft() {
		try {
			map.moveLeft(this);
		} catch (ArrayIndexOutOfBoundsException e) {
			return;
		}
		position.setX(position.getX() - 1);
	}
	
	public void moveRight() {
		try {
			map.moveRight(this);
		} catch (ArrayIndexOutOfBoundsException e) {
			return;
		}
		position.setX(position.getX() + 1);
	}
	
	public void moveDown() {
		try {
			map.moveDown(this);
		} catch (ArrayIndexOutOfBoundsException e) {
			return;
		}
		position.setY(position.getY() + 1);
	}
}
