package hero;

import java.util.ArrayList;
import java.util.List;

import equipment.Armor;
import equipment.Weapon;
import map.ActionType;
import map.GameElement;
import map.Map;
import movable.MovableGameElement;
import spell.Spell;

public abstract class Hero extends MovableGameElement {
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
	
	public Hero (String name, int attackDices, int defenseDices, int hp, int intelligencePoints, int x, int y,
			List<Weapon> beginningWeapons, List<Spell> spells) {
		super(x, y);
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
		weaponUsingForAttack = weapons.get(weapons.size() - 1);
		armor = Armor.NO_ARMOR;
		this.spells = spells;
	}
	
	public int getAttackPoints() {
		return attackDices + weaponUsingForAttack.getAttackDices();
	}
	
	public void attack(Map map) {
		map.selectTarget(this, position, ActionType.NORMAL_ATTACK);
	}
	
	public boolean died() {
		return hp <= 0;
	}
	
	public void heal() {
		hp += 1;
	}
}