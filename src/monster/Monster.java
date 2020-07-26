package monster;

import java.util.List;

import character.MapCharacter;
import equipment.Weapon;
import map.Map;
import map.Position;
import spell.Spell;

public abstract class Monster extends MapCharacter {
	
	public Monster(int attackDices, int defenseDices, int hp, int intelligencePoints,
			List<Weapon> beginningWeapons, List<Spell> spells, Position position, Map map) {
		super(attackDices, defenseDices, hp, intelligencePoints, beginningWeapons, spells, position, map);
	}
}
