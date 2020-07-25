package monster;

import game_element.MapElement;
import map.Map;

public abstract class Monster extends MapElement {
	protected int hp;
	
	public Monster(int x, int y, Map map) {
		super(x, y, map);
	}
	
	public void reduceHp(int attackPoints) {
		hp -= attackPoints;
	}
	
	public boolean isDead() {
		return hp <= 0;
	}
}
