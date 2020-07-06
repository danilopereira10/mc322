package map;

public class Map {
	private GameElement[][] matrix;
	public Map(GameElement[][] matrix) {
		this.matrix = matrix;
	}

	public void printMap(GameElement[][] matrix) {
		for (GameElement[] items : matrix) {
			for (GameElement item : items) {
				if (item != null) { 
					System.out.print(item.toString() + " ");
				} else {
					System.out.print("-- ");
				}
			}
			System.out.println();
		}
	}
}
