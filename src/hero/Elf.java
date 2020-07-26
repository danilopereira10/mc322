package hero;

import java.util.ArrayList;
import java.util.List;

import equipment.Weapon;
import map.Map;
import map.Position;
import spell.Spell;

public class Elf extends Hero {

	public Elf(String name, Position position, Map map, List<Weapon> weapons, List<Spell> spells) {
		super(name, 2, 2, 6, 4, position, map, weapons, spells);
	}

	@Override
	public void print() {
		print("EF");
	}
	
	public static Hero createElf(Map map) {
		List<Weapon> weapons = new ArrayList<>();
		weapons.add(Weapon.SHORT_SWORD);
		List<Spell> spells = new ArrayList<>();
		spells.add(Spell.SIMPLE_HEAL);
		return new Elf("Danilo", new Position(0, 9), map, weapons, spells);
	}
}
