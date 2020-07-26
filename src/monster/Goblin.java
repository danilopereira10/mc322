package monster;

import java.util.ArrayList;
import java.util.List;

import equipment.Weapon;
import map.Map;
import map.Position;
import spell.Spell;

public class Goblin extends Monster {
	public Goblin(List<Weapon> beginningWeapons, List<Spell> spells, Position position, Map map) {
		super(4, 4, 4, 1, beginningWeapons, spells, position, map);
	}
	
	@Override
	public void print() {
		print("GO");
	}
	
	public static Goblin createNewGoblin(Position position, Map map) {
		List<Weapon> weapons = new ArrayList<>();
		weapons.add(Weapon.DAGGER);
		weapons.add(Weapon.DAGGER);
		weapons.add(Weapon.DAGGER);
		List<Spell> spells = new ArrayList<>();
		return new Goblin(weapons, spells, position, map);
	}
}
