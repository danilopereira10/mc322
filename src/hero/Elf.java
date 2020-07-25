package hero;

import java.util.ArrayList;
import java.util.List;

import equipment.Weapon;
import spell.Spell;

public class Elf extends Hero {

	public Elf(String name, int x, int y, List<Weapon> weapons) {
		super(name, 2, 2, 6, 4, x, y, weapons);
	}

	@Override
	public void print() {
		print("EF");
	}
	
	public static Hero createElf() {
		List<Weapon> weapons = new ArrayList<>();
		weapons.add(Weapon.SHORT_SWORD);
		List<Spell> spells = new ArrayList<>();
		spells.add()
		return new Elf("Danilo", 0, 0, weapons);
	}
}
