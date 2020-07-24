package hero;

import java.util.ArrayList;
import java.util.List;

import equipment.Weapon;

public class Dwarf extends Hero {

	public Dwarf(String name, int x, int y, List<Weapon> weapons) {
		super(name, 2, 2, 7, 3, x, y, weapons);
	}

	@Override
	public void print() {
		print("DW");
	}

	public static Hero createDwarf() {
		List<Weapon> weapons = new ArrayList<>();
		weapons.add(Weapon.SHORT_SWORD);
		return new Dwarf("Danilo", 0, 0, weapons);
	}
}
