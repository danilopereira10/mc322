package spell;

import hero.Hero;
import map.Map;
import map.Position;

public enum Spell {
	TELEPORT {
		@Override
		public void doAction(Hero hero, Map map) {
			Position initialPosition = new Position(hero.getX(), hero.getY());
			map.choosePositionForTeleport(initialPosition);
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
			// TODO Auto-generated method stub
			
		}
	};
	
	public abstract void doAction(Hero hero, Map map);
}
