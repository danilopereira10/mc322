package monster;

import java.util.ArrayList;
import java.util.List;

import equipment.Weapon;
import map.Map;
import map.Position;
import spell.Spell;

public class Skeleton extends Monster {	
	public Skeleton(List<Weapon> beginningWeapons, List<Spell> spells, Position position, Map map) {
		super(1, 1, 1, 1, beginningWeapons, spells, position, map);
	}
	
	@Override
	public void print() {
		print("SK");
	}
	
	public static Skeleton createNewSkeleton(Position position, Map map) {
		List<Weapon> weapons = new ArrayList<>();
		List<Spell> spells = new ArrayList<>();
		return new Skeleton(weapons, spells, position, map);
	}
}
