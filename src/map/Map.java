package map;

import java.util.ArrayList;
import java.util.List;

import exception.CommandCancelledException;
import exception.InvalidAttackException;
import hero.Hero;
import monster.Monster;
import printer.Printer;
import scanner.KeyboardReader;

public class Map {
	private MapElement[][] matrix;
	List<Monster> monsters;
	
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
	
	public void moveUp(MapElement gameElement) {
		int originalX = gameElement.getX();
		int originalY = gameElement.getY();
		this.matrix[gameElement.getY() - 1][gameElement.getX()] = gameElement;
		matrix[originalY][originalX] = new EmptySquare(new Position(originalX, originalY), this);
	}
	
	public void moveLeft(MapElement gameElement) {
		int originalX = gameElement.getX();
		int originalY = gameElement.getY();
		this.matrix[gameElement.getY()][gameElement.getX() - 1] = gameElement;
		matrix[originalY][originalX] = new EmptySquare(new Position(originalX, originalY), this);
	}
	
	public void moveRight(MapElement gameElement) {
		int originalX = gameElement.getX();
		int originalY = gameElement.getY();
		this.matrix[gameElement.getY()][gameElement.getX() + 1] = gameElement;
		matrix[originalY][originalX] = new EmptySquare(new Position(originalX, originalY), this);
	}
	
	public void moveDown(MapElement gameElement) {
		int originalX = gameElement.getX();
		int originalY = gameElement.getY();
		this.matrix[gameElement.getY() + 1][gameElement.getX()] = gameElement;
		matrix[originalY][originalX] = new EmptySquare(new Position(originalX, originalY), this);
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
				executeAction(actionType, actualPosition, hero);
			} else if (command.compareTo("c") == 0) {
				throw new CommandCancelledException();
			}
		}
	}
	
	private boolean executeAction(ActionType actionType, Position actualPosition, Hero hero) {
		int x = actualPosition.getX();
		int y = actualPosition.getY();
		switch (actionType) {
		case NORMAL_ATTACK:
			try {
				attack(x, y, hero.getAttackPoints());
			} catch (InvalidAttackException e) {
				return false;
			}
			hero.updateWeapons();
			return true;
		case TELEPORT:
			if (matrix[y][x] instanceof EmptySquare) {
				hero.teleportTo(actualPosition);
				matrix[y][x] = hero;
				return true;
			}
			return false;
		case SIMPLE_HEAL:
			if (matrix[y][x] instanceof Hero) {
				Hero heroToBeHealed = (Hero) matrix[y][x];
				heroToBeHealed.heal();
				return true;
			}
			return false;
		case MAGIC_MISSILE:
		case FIRE_BALL:
			return attack(x, y, 6);
		default:
			throw new IllegalArgumentException();
		}
	}
	
	private void attack(int x, int y, int damage) throws InvalidAttackException {
		if (matrix[y][x] instanceof Monster) {
			Monster monster = (Monster) matrix[y][x];
			monster.reduceHp(damage);
			if (monster.isDead()) {
				matrix[y][x] = new EmptySquare(new Position(x, y), this);
				monsters.remove(monster);
			}
		}
		throw new InvalidAttackException();
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
}
