package spell;

import action.ActionType;
import exception.CommandCancelledException;
import hero.Hero;
import map.Map;
import map.Position;

public enum Spell {
	TELEPORT {
		@Override
		public void doAction(Hero hero, Map map) throws CommandCancelledException {
			Position actualPosition = new Position(hero.getX(), hero.getY());
			map.selectTarget(hero, actualPosition, ActionType.TELEPORT);
		}
	},
	FIRE_BALL {
		@Override
		public void doAction(Hero hero, Map map) throws CommandCancelledException {
			Position actualPosition = new Position(hero.getX(), hero.getY());
			map.selectTarget(hero, actualPosition, ActionType.FIRE_BALL);
		}
	},
	MAGIC_MISSILE {
		@Override
		public void doAction(Hero hero, Map map) throws CommandCancelledException {
			Position actualPosition = new Position(hero.getX(), hero.getY());
			map.selectTarget(hero, actualPosition, ActionType.MAGIC_MISSILE);
		}
	},
	SIMPLE_HEAL { 
		@Override
		public void doAction(Hero hero, Map map) throws CommandCancelledException {
			Position actualPosition = new Position(hero.getX(), hero.getY());
			map.selectTarget(hero, actualPosition, ActionType.SIMPLE_HEAL);
		}
	};
	
	public abstract void doAction(Hero hero, Map map) throws CommandCancelledException;
}
