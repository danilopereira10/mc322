package map;

import printer.Printer;

public class Map {
	private GameElement[][] matrix;
	public Map(GameElement[][] matrix) {
		this.matrix = matrix;
		initializeMatrix();
	}
	
	private void initializeMatrix() {
		for (int y = 0; y < matrix.length; y++) {
			for (int x = 0; x < matrix[y].length; x++) {
				matrix[y][x] = new EmptySquare(x, y);
			}
		}
	}

	public void put(GameElement gameElement, Position position) {
		matrix[position.getY()][position.getX()] = gameElement;
	}
	
	public void moveUp(GameElement gameElement) {
		int originalX = gameElement.getX();
		int originalY = gameElement.getY();
		this.matrix[gameElement.getY() - 1][gameElement.getX()] = gameElement;
		matrix[originalY][originalX] = new EmptySquare(originalX, originalY);
	}
	
	public void moveLeft(GameElement gameElement) {
		int originalX = gameElement.getX();
		int originalY = gameElement.getY();
		this.matrix[gameElement.getY()][gameElement.getX() - 1] = gameElement;
		matrix[originalY][originalX] = new EmptySquare(originalX, originalY);
	}
	
	public void moveRight(GameElement gameElement) {
		int originalX = gameElement.getX();
		int originalY = gameElement.getY();
		this.matrix[gameElement.getY()][gameElement.getX() + 1] = gameElement;
		matrix[originalY][originalX] = new EmptySquare(originalX, originalY);
	}
	
	public void moveDown(GameElement gameElement) {
		int originalX = gameElement.getX();
		int originalY = gameElement.getY();
		this.matrix[gameElement.getY() + 1][gameElement.getX()] = gameElement;
		matrix[originalY][originalX] = new EmptySquare(originalX, originalY);
	}
	
	public void selectTarget(Position initialPosition) {
		Position actualPosition = initialPosition;
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
		for (GameElement[] items : matrix) {
			for (GameElement item : items) {
				item.print();
			}
			Printer.getInstance().printLine();
		}
	}
}
