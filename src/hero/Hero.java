package hero;

import java.util.ArrayList;
import java.util.List;

import character.MapCharacter;
import equipment.Armor;
import equipment.Weapon;
import exception.CommandCancelledException;
import map.ActionType;
import map.Map;
import map.Position;
import printer.Printer;
import scanner.KeyboardReader;
import spell.Spell;

public abstract class Hero extends MapCharacter {
	private String name;
	private int attackDices;
	private int defenseDices;
	private int hp;
	private int intelligencePoints;
	private List<Weapon> weapons;
	private Weapon weaponUsingForAttack;
	private int usedHands;
	private Armor armor;
	private List<Spell> spells;
	
	public Hero (String name, int attackDices, int defenseDices, int hp, int intelligencePoints, Position position, 
			Map map, List<Weapon> beginningWeapons, List<Spell> spells) {
		super(position, map);
		this.name = name;
		this.attackDices = attackDices;
		this.defenseDices = defenseDices;
		this.hp = hp;
		this.intelligencePoints = intelligencePoints;
		this.weapons = new ArrayList<>();
		for (Weapon weapon : beginningWeapons) {
			weapons.add(weapon);
			usedHands += weapon.getNeededHands();
		}
		chooseWeapon();
		armor = Armor.NO_ARMOR;
		this.spells = spells;
	}

	private void chooseWeapon() {
		if (!weapons.isEmpty()) {
			weaponUsingForAttack = weapons.get(weapons.size() - 1);
		} else {
			weaponUsingForAttack = Weapon.NO_WEAPON;
		}
	}
	
	public int getAttackPoints() {
		return attackDices + weaponUsingForAttack.getAttackDices();
	}
	
	public void attack() {
		try {
			map.selectTarget(this, position, ActionType.NORMAL_ATTACK);
		} catch (CommandCancelledException e) {
			return;
		}
		updateWeapons();
	}
	
	public void updateWeapons() {
		if (!weaponUsingForAttack.isReusable()) {
			weapons.remove(weaponUsingForAttack);
			chooseWeapon();
		}
	}
	
	public boolean died() {
		return hp <= 0;
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
}