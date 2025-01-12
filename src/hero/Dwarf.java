package hero;

import java.util.ArrayList;
import java.util.List;

import equipment.Weapon;
import map.Map;
import map.Position;
import spell.Spell;

public class Dwarf extends Hero {

	public Dwarf(String name, Position position, Map map, List<Weapon> weapons, List<Spell> spells) {
		super(name, 2, 2, 7, 3, position, map, weapons, spells);
	}

	@Override
	public void print() {
		print("DW");
	}

	public static Hero createDwarf(Map map) {
		List<Weapon> weapons = new ArrayList<>();
		weapons.add(Weapon.SHORT_SWORD);
		List<Spell> spells = new ArrayList<>();
		return new Dwarf("Danilo", new Position(9, 0), map, weapons, spells);
	}
}
