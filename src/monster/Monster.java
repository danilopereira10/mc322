package monster;

import map.Map;
import map.MapElement;
import map.Position;

public abstract class Monster extends MapElement {
	protected int hp;
	
	public Monster(Position position, Map map) {
		super(position, map);
	}
	
	public void reduceHp(int attackPoints) {
		hp -= attackPoints;
	}
	
	public boolean isDead() {
		return hp <= 0;
	}
}
