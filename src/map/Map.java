package map;

import java.util.ArrayList;
import java.util.List;

import action.ActionType;
import character.MapCharacter;
import exception.CommandCancelledException;
import exception.InvalidMovementException;
import exception.InvalidTargetException;
import hero.Hero;
import monster.Monster;
import printer.Printer;
import scanner.KeyboardReader;

public class Map {
	private MapElement[][] matrix;
	List<Monster> monsters;
	List<Hero> aiHeros;
	
	public Map(MapElement[][] matrix) {
		this.matrix = matrix;
		monsters = new ArrayList<>();
		initializeMatrix();
	}
	
	private void initializeMatrix() {
		for (int y = 0; y < matrix.length; y++) {
			for (int x = 0; x < matrix[y].length; x++) {
				matrix[y][x] = new EmptySquare(new Position(x, y), this);
			}
		}
	}

	public void put(MapElement gameElement, Position position) {
		matrix[position.getY()][position.getX()] = gameElement;
		if (gameElement instanceof Monster) {
			monsters.add((Monster) gameElement);
		}
	}
	
	public void moveUp(MapElement gameElement) throws InvalidMovementException {
		int x = gameElement.getX();
		int y = gameElement.getY();
		if (!(matrix[y - 1][x] instanceof EmptySquare)) {
			throw new InvalidMovementException();
		}
		this.matrix[y - 1][x] = gameElement;
		clear(x, y);
	}
	
	public void moveLeft(MapElement gameElement) throws InvalidMovementException {
		int x = gameElement.getX();
		int y = gameElement.getY();
		if(!(matrix[y][x - 1] instanceof EmptySquare)) {
			throw new InvalidMovementException();
		}
		this.matrix[y][x - 1] = gameElement;
		clear(x, y);
	}
	
	public void moveRight(MapElement gameElement) throws InvalidMovementException {
		int x = gameElement.getX();
		int y = gameElement.getY();
		if(!(matrix[y][x + 1] instanceof EmptySquare)) {
			throw new InvalidMovementException();
		}
		this.matrix[y][x + 1] = gameElement;
		clear(x, y);
	}
	
	public void moveDown(MapElement gameElement) throws InvalidMovementException {
		int x = gameElement.getX();
		int y = gameElement.getY();
		if(!(matrix[y + 1][x] instanceof EmptySquare)) {
			throw new InvalidMovementException();
		}
		this.matrix[y + 1][x] = gameElement;
		clear(x, y);
	}
	
	public void selectTarget(Hero hero, Position initialPosition, ActionType actionType) throws 
	CommandCancelledException {
		Position actualPosition = new Position(initialPosition.getX(), initialPosition.getY());
		executeAction(actualPosition, hero, actionType);
	}
	
	
	private void moveCursorUp(Position position) {
		if (position.getY() > 0) {
			position.setY(position.getY() - 1);
		}
	}
	
	private void moveCursorLeft(Position position) {
		if (position.getX() > 0) {
			position.setX(position.getX() - 1);
		}
	}
	
	private void moveCursorDown(Position position) {
		if (position.getY() <= matrix.length - 2) {
			position.setY(position.getY() + 1);
		}
	}
	
	private void moveCursorRight(Position position) {
		if (position.getX() <= matrix[0].length - 2) {
			position.setX(position.getX() + 1);
		}
	}
	
	private void executeAction(Position actualPosition, Hero hero, ActionType actionType) throws 
	CommandCancelledException {
		while (true) {
			printMapInSelectTargetMode(actualPosition);
			Printer.getInstance().print("Enter the command : ");
			String command = KeyboardReader.getInstance().readLineInLowerCase();
			
			if (command.compareTo("w") == 0) {
				moveCursorUp(actualPosition);
			} else if (command.compareTo("a") == 0) {
				moveCursorLeft(actualPosition);
			} else if (command.compareTo("s") == 0) {
				moveCursorDown(actualPosition);
			} else if (command.compareTo("d") == 0) {
				moveCursorRight(actualPosition);
			} else if (command.compareTo("f") == 0) {
				try {
					executeAction(actionType, actualPosition, hero);
				} catch (InvalidTargetException e) {
					continue;
				}
				break;
			} else if (command.compareTo("c") == 0) {
				throw new CommandCancelledException();
			}
		}
	}
	
	private void executeAction(ActionType actionType, Position actualPosition, Hero hero) 
			throws InvalidTargetException {
		int x = actualPosition.getX();
		int y = actualPosition.getY();
		switch (actionType) {
		case NORMAL_ATTACK:
			attack(x, y, hero.getAttackPoints());
			hero.updateWeapons();
			break;
		case TELEPORT:
			if (matrix[y][x] instanceof EmptySquare) {
				hero.teleportTo(actualPosition);
				matrix[y][x] = hero;
			} else {
				throw new InvalidTargetException();
			}
			break;
		case SIMPLE_HEAL:
			if (matrix[y][x] instanceof Hero) {
				Hero heroToBeHealed = (Hero) matrix[y][x];
				heroToBeHealed.heal();
			} else {
				throw new InvalidTargetException();
			}
			break;
		case MAGIC_MISSILE:
		case FIRE_BALL:
			attack(x, y, 6);
			break;
		default:
			throw new IllegalArgumentException();
		}
	}
	
	private void attack(int x, int y, int damage) throws InvalidTargetException {
		if (monsters.contains(matrix[y][x])) {
			Monster monster = (Monster) matrix[y][x];
			monster.reduceHp(damage);
			if (monster.died()) {
				matrix[y][x] = new EmptySquare(new Position(x, y), this);
				monsters.remove(monster);
			}
		} else {
			throw new InvalidTargetException();
		}
	}
	
	public boolean allMonstersDestroyed() {
		return monsters.isEmpty();
	}
	
	public void printMapInSelectTargetMode(Position actualPosition) {
		for (int y = 0; y < matrix.length; y++) {
			for (int x = 0; x < matrix[y].length; x++) {
				if (actualPosition.getX() == x && actualPosition.getY() == y) {
					Printer.getInstance().print("   ");
				} else {
					matrix[y][x].print();
				}
			}
			Printer.getInstance().printLine();
		}
	}
	
	public void printMap() {
		for (MapElement[] items : matrix) {
			for (MapElement item : items) {
				item.print();
			}
			Printer.getInstance().printLine();
		}
	}
	
	public void clear(int x, int y) {
		matrix[y][x] = new EmptySquare(new Position(x, y), this);
	}
	
	public void setAiHeros(List<Hero> aiHeros) {
		this.aiHeros = aiHeros;
	}
	
	public void updateEnvironment() {
		for (Hero hero : aiHeros) {
			hero.moveRandomly();
			hero.attackRandomly();
		}
		for (Monster monster : monsters) {
			monster.moveRandomly();
			monster.attackRandomly();
		}
	}
	
	public void reportDamage(int x, int y, MapCharacter attacker) throws InvalidTargetException {
		if (isValidAttack(attacker, matrix[y][x])) {
			MapCharacter defender = (MapCharacter) matrix[y][x];
			defender.reduceHp(attacker.getAttackPoints());
			if (defender.died()) {
				if (monsters.contains(matrix[y][x])) {
					monsters.remove(matrix[y][x]);
				} else if (aiHeros.contains(matrix[y][x])) {
					aiHeros.remove(matrix[y][x]);
				}
				clear(x, y);
			}
		} else {
			throw new InvalidTargetException();
		}
	}
	
	public boolean isValidAttack(MapElement attacker, MapElement defender) {
		return attacker instanceof Hero && monsters.contains(defender)
				|| monsters.contains(attacker) && defender instanceof Hero;
	}
}
