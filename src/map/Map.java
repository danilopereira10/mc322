package map;

import printer.Printer;

public class Map {
	private Object[][] matrix;
	public Map(GameElement[][] matrix) {
		this.matrix = matrix;
	}

	public void put(GameElement gameElement, Position position) {
		matrix[position.getY()][position.getX()] = gameElement;
	}
	
	public void moveUp(GameElement gameElement) {
		int originalX = gameElement.getX();
		int originalY = gameElement.getY();
		this.matrix[gameElement.getY() - 1][gameElement.getX()] = gameElement;
		matrix[originalY][originalX] = new EmptySquare(new Position(originalX, originalY));
	}
	
	public void moveLeft(GameElement gameElement) {
		int originalX = gameElement.getX();
		int originalY = gameElement.getY();
		this.matrix[gameElement.getY()][gameElement.getX() - 1] = gameElement;
		matrix[originalY][originalX] = new EmptySquare(new Position(originalX, originalY));
	}
	
	public void moveRight(GameElement gameElement) {
		int originalX = gameElement.getX();
		int originalY = gameElement.getY();
		this.matrix[gameElement.getY()][gameElement.getX() + 1] = gameElement;
		matrix[originalY][originalX] = new EmptySquare(new Position(originalX, originalY));
	}
	
	public void moveDown(GameElement gameElement) {
		int originalX = gameElement.getX();
		int originalY = gameElement.getY();
		this.matrix[gameElement.getY() + 1][gameElement.getX()] = gameElement;
		matrix[originalY][originalX] = new EmptySquare(new Position(originalX, originalY));
	}
	
	public void selectTarget(Position initialPosition) {
		
	}
	
	public void printMap() {
		for (Object[] items : matrix) {
			for (Object item : items) {
				Printer.getInstance().print(((GameElement)item).print() + " ");
			}
			Printer.getInstance().printLine();
		}
	}
}
