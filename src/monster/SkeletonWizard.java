package monster;

import java.util.ArrayList;
import java.util.List;

import equipment.Weapon;
import map.Map;
import map.Position;
import spell.Spell;

public class SkeletonWizard extends Monster{
	public SkeletonWizard(List<Weapon> beginningWeapons, List<Spell> spells, Position position, Map map) {
		super(2, 2, 2, 2, beginningWeapons, spells, position, map);
	}
	
	@Override
	public void print() {
		print("SW");
	}
	
	public static SkeletonWizard createNewSkeletonWizard(Position position, Map map) {
		List<Weapon> weapons = new ArrayList<>();
		List<Spell> spells = new ArrayList<>();
		spells.add(Spell.MAGIC_MISSILE);
		return new SkeletonWizard(weapons, spells, position, map);
	}
}
