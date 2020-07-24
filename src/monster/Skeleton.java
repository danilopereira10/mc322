package monster;

import map.Position;

public class Skeleton extends Monster {
	private int hp;
	private Position position;
	
	public Skeleton(Position position) {
		super(position);
		hp = 1;
	}
	
	@Override
	public String print() {
		return "SK";
	}
}
