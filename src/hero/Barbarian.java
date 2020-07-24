package hero;

import java.util.ArrayList;
import java.util.List;

import equipment.Weapon;

public class Barbarian extends Hero {
	public Barbarian(String name, int x, int y, List<Weapon> weapons) {
		super(name, 3, 2, 8, 2, x, y, weapons);
	}

	@Override
	public void print() {
		print("BA");
	}

	public static Hero createBarbarian() {
		List<Weapon> barbarianWeapons = new ArrayList<>();
		barbarianWeapons.add(Weapon.LONG_SWORD);
		return new Barbarian("Danilo", 0, 0, barbarianWeapons);
	}
}
