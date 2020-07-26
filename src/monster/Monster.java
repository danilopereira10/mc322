package monster;

import character.MapCharacter;
import map.Map;
import map.Position;

public abstract class Monster extends MapCharacter {
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
