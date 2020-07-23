package main;

import java.util.Scanner;

import hero.Barbarian;
import hero.Dwarf;
import hero.Elf;
import hero.Hero;
import hero.Sorcerer;
import map.GameElement;
import map.Map;
import map.Position;
import monster.Skeleton;

public class Main {

	public static void main(String[] args) {
		Map map = new Map(new GameElement[10][10]);
		map.printMap();
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Escolha o herói");
		System.out.println("Digite 1 para Bárbaro");
		System.out.println("Digite 2 para Anão");
		System.out.println("Digite 3 para Elfo");
		System.out.println("Digite 4 para Feiticeiro");
		String choosenHero = keyboard.nextLine();
		Hero hero;
		Position initialPosition = new Position(0, 0);
		switch (choosenHero) {
		case "1":
			hero = new Barbarian("Danilo", initialPosition);
			break;
		case "2":
			hero = new Dwarf("Danilo", initialPosition);
			break;
		case "3":
			hero = new Elf("Danilo", initialPosition);
			break;
		case "4":
			hero = new Sorcerer("Danilo", initialPosition);
			break;
		default:
			hero = null;
			System.out.println("Hero not choosen. Exiting application");
			System.exit(1);
		}
		
		map.put(hero, initialPosition);
		Skeleton skeleton = new Skeleton();
		Position position = new Position(2, 2);
		map.put(skeleton, position);
		
		boolean running = true;
		while (running) {
			System.out.print("Enter the command : ");
			String command = keyboard.nextLine();
			
			if (command.compareTo("w") == 0) {
				hero.moveUp(map);
			} else if (command.compareTo("a") == 0) {
				hero.moveLeft(map);
			} else if (command.compareTo("s") == 0) {
				hero.moveDown(map);
			} else if (command.compareTo("d") == 0) {
				hero.moveRight(map);
			} else if (command.compareTo("g") == 0) {
			}
			map.printMap();
		}
		keyboard.close();
	}

}
