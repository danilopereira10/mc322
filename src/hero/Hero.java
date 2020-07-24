package hero;

import java.util.ArrayList;
import java.util.List;

import equipment.Armor;
import equipment.Weapon;
import map.GameElement;
import map.Map;
import movable.Movable;

public abstract class Hero extends GameElement implements Movable {
	private String name;
	private int attackDices;
	private int defenseDices;
	private int hp;
	private int intelligencePoints;
	private List<Weapon> weapons;
	private int usedHands;
	private Armor armor;
	
	public Hero (String name, int attackDices, int defenseDices, int hp, int intelligencePoints, int x, int y,
			List<Weapon> beginningWeapons) {
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
		armor = Armor.NO_ARMOR;
	}

	@Override
	public void moveUp(Map map) {
		try {
			map.moveUp(this);
		} catch (ArrayIndexOutOfBoundsException e) {
			return;
		}
		position.setY(position.getY() - 1);
	}
	
	@Override
	public void moveLeft(Map map) {
		try {
			map.moveLeft(this);
		} catch (ArrayIndexOutOfBoundsException e) {
			return;
		}
		position.setX(position.getX() - 1);
	}
	
	@Override
	public void moveRight(Map map) {
		try {
			map.moveRight(this);
		} catch (ArrayIndexOutOfBoundsException e) {
			return;
		}
		position.setX(position.getX() + 1);
	}
	
	@Override
	public void moveDown(Map map) {
		try {
			map.moveDown(this);
		} catch (ArrayIndexOutOfBoundsException e) {
			return;
		}
		position.setY(position.getY() + 1);
	}
	
	public void attack(Map map) {
		map.selectTarget(position);
	}
}