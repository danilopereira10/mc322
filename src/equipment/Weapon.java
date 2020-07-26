package equipment;

public enum Weapon {
	NO_WEAPON(0, 0, true),
	LONG_SWORD(3, 2, true),
	SHORT_SWORD(2, 1, true),
	DAGGER(1, 0, false);
	
	private Weapon(int attackPoints, int neededHands, boolean reusable) {
		this.attackDices = attackPoints;
		this.neededHands = neededHands;
		this.reusable = reusable;
	}
	
	private int attackDices;
	
	private int neededHands;
	
	private boolean reusable;
	
	public int getAttackDices() {
		return attackDices;
	}
	
	public int getNeededHands() {
		return neededHands;
	}
	
	public boolean isReusable() {
		return reusable;
	}
}
