package spell;

import hero.Hero;
import map.Map;
import map.Position;

public class Teleport extends Spell {
	public void doAction(Hero hero, Map map) {
		Position initialPosition = new Position(hero.getX(), hero.getY());
		map.choosePositionForTeleport(initialPosition);
	}
}
