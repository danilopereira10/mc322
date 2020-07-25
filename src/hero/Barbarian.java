package hero;

import java.util.ArrayList;
import java.util.List;

import equipment.Weapon;
import map.Map;
import spell.Spell;

public class Barbarian extends Hero {
	public Barbarian(String name, int x, int y, Map map, List<Weapon> weapons, List<Spell> spells) {
		super(name, 3, 2, 8, 2, x, y, map, weapons, spells);
	}

	@Override
	public void print() {
		print("BA");
	}

	public static Hero createBarbarian(Map map) {
		List<Weapon> barbarianWeapons = new ArrayList<>();
		barbarianWeapons.add(Weapon.LONG_SWORD);
		List<Spell> spells = new ArrayList<>();
		return new Barbarian("Danilo", 0, 0, map, barbarianWeapons, spells);
	}
}
