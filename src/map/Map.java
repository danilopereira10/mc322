package map;

import movable.Movable;
import printer.Printer;

public class Map {
	private Object[][] matrix;
	public Map(GameElement[][] matrix) {
		this.matrix = matrix;
	}

	public void put(GameElement gameElement, Position position) {
		matrix[position.getY()][position.getX()] = gameElement;
	}
	
	public void moveUp(Movable movable) {
		int originalX = movable.getX();
		int originalY = movable.getY();
		this.matrix[movable.getY() - 1][movable.getX()] = movable;
		matrix[originalY][originalX] = new EmptySquare(new Position(originalX, originalY));
	}
	
	public void moveLeft(Movable movable) {
		int originalX = movable.getX();
		int originalY = movable.getY();
		this.matrix[movable.getY()][movable.getX() - 1] = movable;
		matrix[originalY][originalX] = new EmptySquare(new Position(originalX, originalY));
	}
	
	public void moveRight(Movable movable) {
		int originalX = movable.getX();
		int originalY = movable.getY();
		this.matrix[movable.getY()][movable.getX() + 1] = movable;
		matrix[originalY][originalX] = new EmptySquare(new Position(originalX, originalY));
	}
	
	public void moveDown(Movable movable) {
		int originalX = movable.getX();
		int originalY = movable.getY();
		this.matrix[movable.getY() + 1][movable.getX()] = movable;
		matrix[originalY][originalX] = new EmptySquare(new Position(originalX, originalY));
	}
	
	public void selectTarget(Position initialPosition) {
		
	}
	
	public void printMap() {
		for (Object[] items : matrix) {
			for (Object item : items) {
				if (item != null) { 
					Printer.getInstance().print(((GameElement)item).print() + " ");
				} else {
					Printer.getInstance().print("-- ");
				}
			}
			Printer.getInstance().printLine();
		}
	}
}
