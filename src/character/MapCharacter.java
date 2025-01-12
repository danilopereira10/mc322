package character;

import java.util.ArrayList;
import java.util.List;

import equipment.Weapon;
import exception.InvalidMovementException;
import exception.InvalidTargetException;
import map.Map;
import map.MapElement;
import map.Position;
import spell.Spell;

public abstract class MapCharacter extends MapElement {
	private int attackDices;
	private int defenseDices;
	protected int hp;
	private int intelligencePoints;
	private List<Weapon> weapons;
	private Weapon weaponUsingForAttack;
	private int usedHands;
	private List<Spell> spells;
	
	public MapCharacter(int attackDices, int defenseDices, int hp, int intelligencePoints,
			List<Weapon> beginningWeapons, List<Spell> spells, Position position, Map map) {
		super(position, map);
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
	
	public void updateWeapons() {
		if (!weaponUsingForAttack.isReusable()) {
			weapons.remove(weaponUsingForAttack);
			chooseWeapon();
		}
	}
	
	public boolean died() {
		return hp <= 0;
	}

	public void moveUp() {
		try {
			map.moveUp(this);
		} catch (ArrayIndexOutOfBoundsException | InvalidMovementException e) {
			return;
		}
		position.setY(position.getY() - 1);
	}
	
	public void moveLeft() {
		try {
			map.moveLeft(this);
		} catch (ArrayIndexOutOfBoundsException | InvalidMovementException e) {
			return;
		}
		position.setX(position.getX() - 1);
	}
	
	public void moveRight() {
		try {
			map.moveRight(this);
		} catch (ArrayIndexOutOfBoundsException | InvalidMovementException e) {
			return;
		}
		position.setX(position.getX() + 1);
	}
	
	public void moveDown() {
		try {
			map.moveDown(this);
		} catch (ArrayIndexOutOfBoundsException | InvalidMovementException e) {
			return;
		}
		position.setY(position.getY() + 1);
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
	
	public void attackRandomly() {
		boolean attacked = false;
		for (int i = position.getX() - 1; i <= position.getX() + 1; i++) {
			for (int j = position.getY() - 1; j <= position.getY() + 1; j++) {
				try {
					map.reportDamage(i, j, this);
					attacked = true;
					break;
				} catch (ArrayIndexOutOfBoundsException | InvalidTargetException e) {
					//keeping "for" block running
				}
			}
			if (attacked) {
				break;
			}
		}
	}

	public void reduceHp(int attackPoints) {
		hp -= attackPoints;
	}
}
