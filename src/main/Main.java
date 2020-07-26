package main;

import hero.Barbarian;
import hero.Dwarf;
import hero.Elf;
import hero.Hero;
import hero.Sorcerer;
import map.Map;
import map.MapElement;
import map.Position;
import monster.Skeleton;
import printer.Printer;
import scanner.KeyboardReader;

public class Main {

	public static void main(String[] args) {
		Map map = new Map(new MapElement[10][10]);
		Printer printer = Printer.getInstance();
		
		
		printer.printLine("Escolha o herói");
		printer.printLine("Digite 1 para Bárbaro");
		printer.printLine("Digite 2 para Anão");
		printer.printLine("Digite 3 para Elfo");
		printer.printLine("Digite 4 para Feiticeiro");
		String choosenHero = KeyboardReader.getInstance().readLineInLowerCase();
		Hero hero;
		
		switch (choosenHero) {
		case "1":
			hero = Barbarian.createBarbarian(map);
			break;
		case "2":
			hero = Dwarf.createDwarf(map);
			break;
		case "3":
			hero = Elf.createElf(map);
			break;
		case "4":
			hero = Sorcerer.createSorcerer(map);
			break;
		default:
			hero = null;
			printer.printLine("Hero not choosen. Exiting application");
			System.exit(1);
		}
		
		Skeleton.createNewSkeleton(new Position(2, 2), map);

		boolean won = false;
		boolean lost = false;
		boolean running = true;
		map.printMap();
		while (running) {
			Printer.getInstance().print("Enter the command : ");
			String command = KeyboardReader.getInstance().readLineInLowerCase();
			
			if (command.compareTo("w") == 0) {
				hero.moveUp();
			} else if (command.compareTo("a") == 0) {
				hero.moveLeft();
			} else if (command.compareTo("s") == 0) {
				hero.moveDown();
			} else if (command.compareTo("d") == 0) {
				hero.moveRight();
			} else if (command.compareTo("f") == 0) {
				hero.attack();
			} else if (command.compareTo("g") == 0) {
				hero.useSpell();
			}
			map.printMap();
			won = map.allMonstersDestroyed();
			lost = hero.died();
			if (won || lost) {
				running = false;
			}
		}
		
	}

}
