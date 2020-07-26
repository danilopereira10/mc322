package hero;

import java.util.ArrayList;
import java.util.List;

import equipment.Weapon;
import map.Map;
import map.Position;
import spell.Spell;

public class Sorcerer extends Hero {

	public Sorcerer(String name, Position position, Map map, List<Weapon> weapons, List<Spell> spells) {
		super(name, 1, 2, 4, 6, position, map, weapons, spells);
	}

	@Override
	public void print() {
		print("SO");
	}
	
	public static Hero createSorcerer(Map map) {
		List<Weapon> weapons = new ArrayList<>();
		weapons.add(Weapon.DAGGER);
		weapons.add(Weapon.DAGGER);
		weapons.add(Weapon.DAGGER);
		List<Spell> spells = new ArrayList<>();
		spells.add(Spell.MAGIC_MISSILE);
		spells.add(Spell.MAGIC_MISSILE);
		spells.add(Spell.MAGIC_MISSILE);
		spells.add(Spell.FIRE_BALL);
		spells.add(Spell.TELEPORT);
		return new Sorcerer("Danilo", new Position(9, 9), map, weapons, spells);
	}
}
