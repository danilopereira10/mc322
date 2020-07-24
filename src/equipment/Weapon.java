package equipment;

public enum Weapon {
	LONG_SWORD(3, 2),
	SHORT_SWORD(2, 1),
	DAGGER(1, 0);
	
	private Weapon(int attackPoints, int neededHands) {
		this.attackPoints = attackPoints;
		this.neededHands = neededHands;
	}
	
	private int attackPoints;
	
	private int neededHands;
	
	public int getAp() {
		return attackPoints;
	}
	
	public int getNeededHands() {
		return neededHands;
	}
}
