package monster;

import java.util.ArrayList;
import java.util.List;

import equipment.Weapon;
import map.Map;
import map.Position;

public class Skeleton extends Monster {	
	public Skeleton(List<Weapon> beginningWeapons, Position position, Map map) {
		super(1, 1, 1, 1, beginningWeapons, position, map);
		hp = 10;
	}
	
	@Override
	public void print() {
		print("SK");
	}
	
	public static Skeleton createNewSkeleton(Position position, Map map) {
		List<Weapon> weapons = new ArrayList<>();
		return new Skeleton(weapons, position, map);
	}
}
