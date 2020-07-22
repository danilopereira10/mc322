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
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Escolha o herói");
		System.out.println("Digite 1 para Bárbaro");
		System.out.println("Digite 2 para Anão");
		System.out.println("Digite 3 para Elfo");
		System.out.println("Digite 4 para Feiticeiro");
		String choosenHero = keyboard.nextLine();
		
		switch (choosenHero) {
		case "1":
			hero = Hero.Barbarian;
			break;
		case "2":
			hero = Hero.Dwarf;
			break;
		case "3":
			hero = Hero.Elf;
			break;
		case "4":
			hero = Hero.Sorcerer;
			break;
		default:
			System.out.println("Hero not choosen. Exiting application");
			System.exit(1);
		}
		
		
		Position initialPosition = new Position(0, 0);
		Hero hero = new Hero("Danilo", 3, 2, 15, 50, initialPosition);
		
		map.put(hero, initialPosition);
		
		
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
			map.printMap();
		}
		keyboard.close();
	}

}
