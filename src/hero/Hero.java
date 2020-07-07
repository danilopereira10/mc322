package hero;

import map.GameElement;

public class Hero extends GameElement {
	private String name;
	private int attackDices;
	private int defenseDices;
	private int hp;
	private int intelligencePoints;
	
	public Hero (String name, int attackDices, int defenseDices, int hp, int intelligencePoints) {
		this.name = name;
		this.attackDices = attackDices;
		this.defenseDices = defenseDices;
		this.hp = hp;
		this.intelligencePoints = intelligencePoints;
	}
	
	@Override
	public String print() {
		return "HE";
	}
}
