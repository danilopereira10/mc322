package movable;

import map.Map;

public interface Movable {
	public void moveUp(Map map);
	public void moveLeft(Map map);
	public void moveRight(Map map);
	public void moveDown(Map map);
	public int getX();
	public int getY();
}
