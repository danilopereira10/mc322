package main;

import hero.Hero;
import map.GameElement;
import map.Map;
import map.Position;

public class Main {

	public static void main(String[] args) {
		Map map = new Map(new GameElement[10][10]);
		map.printMap();
		Hero hero = new Hero("Danilo", 3, 2, 15, 50);
		Position initialPosition = new Position(0, 0);
		map.put(hero, initialPosition);
	}

}
