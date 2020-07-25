package spell;

import hero.Hero;
import map.Map;

public abstract class Spell {
	public abstract void doAction(Hero hero, Map map);
}
