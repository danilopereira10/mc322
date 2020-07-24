package monster;

public class Skeleton extends Monster {	
	public Skeleton(int x, int y) {
		super(x, y);
		hp = 10;
	}
	
	@Override
	public void print() {
		print("SK");
	}
}
