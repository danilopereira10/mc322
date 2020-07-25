package monster;

import map.Map;

public class Skeleton extends Monster {	
	public Skeleton(int x, int y, Map map) {
		super(x, y, map);
		hp = 10;
	}
	
	@Override
	public void print() {
		print("SK");
	}
}
