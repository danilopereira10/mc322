package monster;

import map.GameElement;

public class Skeleton extends GameElement implements Monster {
	private int hp;
	
	public Skeleton() {
		hp = 1;
	}
	
	@Override
	public String print() {
		return "SK";
	}

}
