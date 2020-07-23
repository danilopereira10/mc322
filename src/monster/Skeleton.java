package monster;

import map.Position;

public class Skeleton extends Monster {
	private int hp;
	private Position position;
	
	public Skeleton(Position position) {
		hp = 1;
		this.position = position;
	}
	
	@Override
	public String print() {
		return "SK";
	}

	@Override
	public int getX() {
		return position.getX();
	}

	@Override
	public int getY() {
		return position.getY();
	}

}
