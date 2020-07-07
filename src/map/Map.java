package map;

public class Map {
	private GameElement[][] matrix;
	public Map(GameElement[][] matrix) {
		this.matrix = matrix;
	}

	public void put(GameElement gameElement, Position position) {
		matrix[position.getY()][position.getX()] = gameElement;
	}
	
	public void printMap() {
		for (GameElement[] items : matrix) {
			for (GameElement item : items) {
				if (item != null) { 
					System.out.print(item.print() + " ");
				} else {
					System.out.print("-- ");
				}
			}
			System.out.println();
		}
	}
}
