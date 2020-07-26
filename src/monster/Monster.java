package monster;

import java.util.List;

import character.MapCharacter;
import equipment.Weapon;
import map.Map;
import map.Position;

public abstract class Monster extends MapCharacter {
	
	public Monster(int attackDices, int defenseDices, int hp, int intelligencePoints,
			List<Weapon> beginningWeapons, Position position, Map map) {
		super(attackDices, defenseDices, hp, intelligencePoints, beginningWeapons, position, map);
	}
}
