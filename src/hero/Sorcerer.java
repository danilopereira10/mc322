package hero;

import java.util.ArrayList;
import java.util.List;

import equipment.Weapon;
import map.Position;

public class Sorcerer extends Hero {

	public Sorcerer(String name, int x, int y, List<Weapon> weapons) {
		super(name, 1, 2, 4, 6, x, y, weapons);
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
		return new Sorcerer("Danilo", 0, 0, weapons);
	}
}
