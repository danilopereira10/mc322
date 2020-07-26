package hero;

import java.util.List;

import action.ActionType;
import character.MapCharacter;
import equipment.Armor;
import equipment.Weapon;
import exception.CommandCancelledException;
import map.Map;
import map.Position;
import printer.Printer;
import scanner.KeyboardReader;
import spell.Spell;

public abstract class Hero extends MapCharacter {
	private String name;
	private Armor armor;
	private List<Spell> spells;
	
	public Hero (String name, int attackDices, int defenseDices, int hp, int intelligencePoints, Position position, 
			Map map, List<Weapon> beginningWeapons, List<Spell> spells) {
		super(attackDices, defenseDices, hp, intelligencePoints, beginningWeapons, position, map);
		this.name = name;
		armor = Armor.NO_ARMOR;
		this.spells = spells;
	}

	public void attack() {
		try {
			map.selectTarget(this, position, ActionType.NORMAL_ATTACK);
		} catch (CommandCancelledException e) {
			return;
		}
		updateWeapons();
	}
	
	public void heal() {
		hp += 1;
	}
	
	public void useSpell() {
		if (spells.isEmpty()) {
			Printer.getInstance().printLine("No spells to use!");
		} else {
			chooseSpell();
		}
	}
	
	private void chooseSpell() {
		Printer.getInstance().printLine("Choose spell: ");
		int i = 0;
		for (Spell spell : spells) {
			Printer.getInstance().printLine("Type: " + i + " - for: " + spell.toString());
			i++;
		}
		String choosenSpell = KeyboardReader.getInstance().readLineInLowerCase();
		Integer choosenSpellNumber;
		try {
			choosenSpellNumber = Integer.valueOf(choosenSpell);
		} catch (NumberFormatException e) {
			Printer.getInstance().printLine("No spell chosen!");
			return;
		}
		Spell spell = spells.get(choosenSpellNumber);
		try {
			spell.doAction(this, map);
		} catch (CommandCancelledException e) {
			return;
		}
		spells.remove(spell);
	}
	
	public void teleportTo(Position newPosition) {
		map.clear(position.getX(), position.getY());
		position.setX(newPosition.getX());
		position.setY(newPosition.getY());
	}
	
	public void moveRandomly() {
		double movement = Math.floor(Math.random() * 4);
		if (movement == 0) {
			moveUp();
		} else if (movement == 1) {
			moveLeft();
		} else if (movement == 2) {
			moveRight();
		} else {
			moveDown();
		}
	}
}