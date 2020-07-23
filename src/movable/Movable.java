package movable;

import map.GameElement;
import map.Map;

public interface Movable {
	public void moveUp(Map map);
	public void moveLeft(Map map);
	public void moveRight(Map map);
	public void moveDown(Map map);
}
