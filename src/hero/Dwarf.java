package hero;

public class Dwarf extends Hero {

	public Dwarf(String name, int x, int y) {
		super(name, 2, 2, 7, 3, x, y);
	}

	@Override
	public void print() {
		print("DW");
	}
}
