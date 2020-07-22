package map;

import movable.Movable;

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
		matrix[originalY][originalX] = new EmptySquare();
	}
	
	public void moveLeft(Movable movable) {
		int originalX = movable.getX();
		int originalY = movable.getY();
		this.matrix[movable.getY()][movable.getX() - 1] = movable;
		matrix[originalY][originalX] = new EmptySquare();
	}
	
	public void moveRight(Movable movable) {
		int originalX = movable.getX();
		int originalY = movable.getY();
		this.matrix[movable.getY()][movable.getX() + 1] = movable;
		matrix[originalY][originalX] = new EmptySquare();
	}
	
	public void moveDown(Movable movable) {
		int originalX = movable.getX();
		int originalY = movable.getY();
		this.matrix[movable.getY() + 1][movable.getX()] = movable;
		matrix[originalY][originalX] = new EmptySquare();
	}
	
	public void printMap() {
		for (Object[] items : matrix) {
			for (Object item : items) {
				if (item != null) { 
					System.out.print(((GameElement)item).print() + " ");
				} else {
					System.out.print("-- ");
				}
			}
			System.out.println();
		}
	}
}
