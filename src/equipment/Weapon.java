package equipment;

public enum Weapon {
	LONG_SWORD(3, 2),
	SHORT_SWORD(2, 1),
	DAGGER(1, 0);
	
	private Weapon(int attackPoints, int neededHands) {
		this.attackDices = attackPoints;
		this.neededHands = neededHands;
	}
	
	private int attackDices;
	
	private int neededHands;
	
	public int getAttackDices() {
		return attackDices;
	}
	
	public int getNeededHands() {
		return neededHands;
	}
}
