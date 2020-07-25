package map;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
				matrix[y][x] = new EmptySquare(x, y, this);
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
		matrix[originalY][originalX] = new EmptySquare(originalX, originalY, this);
	}
	
	public void moveLeft(MapElement gameElement) {
		int originalX = gameElement.getX();
		int originalY = gameElement.getY();
		this.matrix[gameElement.getY()][gameElement.getX() - 1] = gameElement;
		matrix[originalY][originalX] = new EmptySquare(originalX, originalY, this);
	}
	
	public void moveRight(MapElement gameElement) {
		int originalX = gameElement.getX();
		int originalY = gameElement.getY();
		this.matrix[gameElement.getY()][gameElement.getX() + 1] = gameElement;
		matrix[originalY][originalX] = new EmptySquare(originalX, originalY, this);
	}
	
	public void moveDown(MapElement gameElement) {
		int originalX = gameElement.getX();
		int originalY = gameElement.getY();
		this.matrix[gameElement.getY() + 1][gameElement.getX()] = gameElement;
		matrix[originalY][originalX] = new EmptySquare(originalX, originalY, this);
	}
	
	public void selectTarget(Hero hero, Position initialPosition, ActionType actionType) {
		Position actualPosition = initialPosition;
		boolean choosingPosition = true;
		while (choosingPosition) {
			printMapInSelectTargetMode(actualPosition);
			choosingPosition = stillChoosingPosition(actualPosition, hero, actionType);
		}
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
	
	private boolean stillChoosingPosition(Position actualPosition, Hero hero, ActionType actionType) {
		Scanner scanner = KeyboardReader.getScanner();
		Printer.getInstance().print("Enter the command : ");
		String command = scanner.nextLine().toLowerCase();
		
		if (command.compareTo("w") == 0) {
			moveCursorUp(actualPosition);
		} else if (command.compareTo("a") == 0) {
			moveCursorLeft(actualPosition);
		} else if (command.compareTo("s") == 0) {
			moveCursorDown(actualPosition);
		} else if (command.compareTo("d") == 0) {
			moveCursorRight(actualPosition);
		} else if (command.compareTo("f") == 0) {
			boolean executed = executeAction(actionType, actualPosition, hero);
			return !executed;
		} else if (command.compareTo("c") == 0) {
			return false;
		}
		return true;
	}
	
	private boolean executeAction(ActionType actionType, Position actualPosition, Hero hero) {
		int x = actualPosition.getX();
		int y = actualPosition.getY();
		switch (actionType) {
		case NORMAL_ATTACK:
			return attack(x, y, hero.getAttackPoints());
		case TELEPORT:
			if (matrix[y][x] instanceof EmptySquare) {
				matrix[y][x] = matrix[x][y];
				matrix[x][y] = new EmptySquare(x, y, this);
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
	
	private boolean attack(int x, int y, int damage) {
		if (matrix[y][x] instanceof Monster) {
			Monster monster = (Monster) matrix[y][x];
			monster.reduceHp(damage);
			if (monster.isDead()) {
				matrix[y][x] = new EmptySquare(x, y, this);
				monsters.remove(monster);
			}
			return true;
		}
		return false;
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
}
