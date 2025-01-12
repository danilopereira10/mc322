package main;

import java.util.ArrayList;
import java.util.List;

import hero.Barbarian;
import hero.Dwarf;
import hero.Elf;
import hero.Hero;
import hero.Sorcerer;
import map.Map;
import map.MapElement;
import map.Position;
import monster.Goblin;
import monster.Skeleton;
import monster.SkeletonWizard;
import printer.Printer;
import scanner.KeyboardReader;

public class Main {

	public static void main(String[] args) {
		Map map = new Map(new MapElement[10][10]);
		Printer printer = Printer.getInstance();
		
		
		printer.printLine("Escolha o her�i");
		printer.printLine("Digite 1 para B�rbaro");
		printer.printLine("Digite 2 para An�o");
		printer.printLine("Digite 3 para Elfo");
		printer.printLine("Digite 4 para Feiticeiro");
		String choosenHero = KeyboardReader.getInstance().readLineInLowerCase();
		Hero hero;
		Hero barbarian = Barbarian.createBarbarian(map);
		Hero dwarf = Dwarf.createDwarf(map);
		Hero elf = Elf.createElf(map);
		Hero sorcerer = Sorcerer.createSorcerer(map);
		switch (choosenHero) {
		case "1":
			hero = barbarian;
			break;
		case "2":
			hero = dwarf;
			break;
		case "3":
			hero = elf;
			break;
		case "4":
			hero = sorcerer;
			break;
		default:
			hero = null;
			printer.printLine("Hero not choosen. Exiting application");
			System.exit(1);
		}
		
		List<Hero> aiHeros = new ArrayList<>();
		aiHeros.add(barbarian);
		aiHeros.add(dwarf);
		aiHeros.add(elf);
		aiHeros.add(sorcerer);
		aiHeros.remove(hero);
		map.setAiHeros(aiHeros);
		
		Skeleton.createNewSkeleton(new Position(2, 2), map);
		SkeletonWizard.createNewSkeletonWizard(new Position(3, 2), map);
		Goblin.createNewGoblin(new Position(2, 4), map);
		Skeleton.createNewSkeleton(new Position(4, 3), map);
		SkeletonWizard.createNewSkeletonWizard(new Position(5, 5), map);
		Goblin.createNewGoblin(new Position(6, 8), map);
		Skeleton.createNewSkeleton(new Position(9, 7), map);

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
			map.updateEnvironment();
			map.printMap();
			won = map.allMonstersDestroyed();
			lost = hero.died();
			if (won || lost) {
				running = false;
			}
		}
		
	}

}
