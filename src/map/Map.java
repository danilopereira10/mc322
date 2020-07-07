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
		this.matrix[movable.getY() - 1][movable.getX()] = movable;
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
