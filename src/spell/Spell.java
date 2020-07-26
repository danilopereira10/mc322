package spell;

import exception.CommandCancelledException;
import hero.Hero;
import map.ActionType;
import map.Map;
import map.Position;

public enum Spell {
	TELEPORT {
		@Override
		public boolean doAction(Hero hero, Map map) throws CommandCancelledException {
			Position actualPosition = new Position(hero.getX(), hero.getY());
			return map.selectTarget(hero, actualPosition, ActionType.TELEPORT);
		}
	},
	FIRE_BALL {
		@Override
		public boolean doAction(Hero hero, Map map) throws CommandCancelledException {
			Position actualPosition = new Position(hero.getX(), hero.getY());
			return map.selectTarget(hero, actualPosition, ActionType.FIRE_BALL);
		}
	},
	MAGIC_MISSILE {
		@Override
		public boolean doAction(Hero hero, Map map) throws CommandCancelledException {
			Position actualPosition = new Position(hero.getX(), hero.getY());
			return map.selectTarget(hero, actualPosition, ActionType.MAGIC_MISSILE);
		}
	},
	SIMPLE_HEAL { 
		@Override
		public boolean doAction(Hero hero, Map map) throws CommandCancelledException {
			Position actualPosition = new Position(hero.getX(), hero.getY());
			return map.selectTarget(hero, actualPosition, ActionType.SIMPLE_HEAL);
		}
	};
	
	public abstract boolean doAction(Hero hero, Map map) throws CommandCancelledException;
}
