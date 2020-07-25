package hero;

import java.util.ArrayList;
import java.util.List;

import equipment.Weapon;
import map.Position;
import spell.Spell;

public class Sorcerer extends Hero {

	public Sorcerer(String name, int x, int y, List<Weapon> weapons, List<Spell> spells) {
		super(name, 1, 2, 4, 6, x, y, weapons, spells);
	}

	@Override
	public void print() {
		print("SO");
	}
	
	public static Hero createSorcerer() {
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
		return new Sorcerer("Danilo", 0, 0, weapons, spells);
	}
}
