package hero;

public class Barbarian extends Hero {

	public Barbarian(String name, int x, int y) {
		super(name, 3, 2, 8, 2, x, y);
	}

	@Override
	public void print() {
		print("BA");
	}
}
