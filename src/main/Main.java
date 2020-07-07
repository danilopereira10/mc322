package main;

import java.util.Scanner;

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
		
		Scanner keyboard = new Scanner(System.in);
		boolean running = true;
		while (running) {
			System.out.print("Enter the command : ");
			String command = keyboard.nextLine();
			
			if (command.compareTo("w") == 0) {
			} else if (command.compareTo("a") == 0) {
			} else if (command.compareTo("s") == 0) {
			} else if (command.compareTo("d") == 0) {
			} else if (command.compareTo("g") == 0) {
			}
		}
		keyboard.close();
	}

}
