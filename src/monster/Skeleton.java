package monster;

import map.Map;
import map.Position;

public class Skeleton extends Monster {	
	public Skeleton(Position position, Map map) {
		super(position, map);
		hp = 10;
	}
	
	@Override
	public void print() {
		print("SK");
	}
}
