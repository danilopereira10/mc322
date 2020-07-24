package monster;

import map.GameElement;

public abstract class Monster extends GameElement {
	protected int hp;
	
	public Monster(int x, int y) {
		super(x, y);
	}
	
	public void reduceHp(int attackPoints) {
		hp -= attackPoints;
	}
	
	public boolean isDead() {
		return hp <= 0;
	}
}
