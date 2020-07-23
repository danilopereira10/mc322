package monster;

public class Skeleton extends Monster {
	private int hp;
	
	public Skeleton() {
		hp = 1;
	}
	
	@Override
	public String print() {
		return "SK";
	}

}
