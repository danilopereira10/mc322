package spell;

import hero.Hero;
import map.ActionType;
import map.Map;
import map.Position;

public enum Spell {
	TELEPORT {
		@Override
		public void doAction(Hero hero, Map map) {
			Position actualPosition = new Position(hero.getX(), hero.getY());
			map.selectTarget(hero, actualPosition, ActionType.TELEPORT);
		}
	},
	FIRE_BALL {
		@Override
		public void doAction(Hero hero, Map map) {
			// TODO Auto-generated method stub
			
		}
	},
	MAGIC_MISSILE {
		@Override
		public void doAction(Hero hero, Map map) {
			// TODO Auto-generated method stub
			
		}
	},
	SIMPLE_HEAL { 
		@Override
		public void doAction(Hero hero, Map map) {
			Position actualPosition = new Position(hero.getX(), hero.getY());
			map.selectTarget(hero, actualPosition, ActionType.SIMPLE_HEAL);
		}
	};
	
	public abstract void doAction(Hero hero, Map map);
}
