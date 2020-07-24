package monster;

public class Skeleton extends Monster {
	private int hp;
	
	public Skeleton(int x, int y) {
		super(x, y);
		hp = 1;
	}
	
	@Override
	public String print() {
		return "SK";
	}
}
