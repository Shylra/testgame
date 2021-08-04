package fr.shylra.testgame;

public class LoardGame {
	public static void loardGame(String name) {
		Perso myPerso = null;
		boolean exist = false;
		for (Perso perso : Save.saveList) {
			if (perso.name == name) {
				myPerso = perso;
				exist = true;
			}
		} 
		if (exist) {
			System.out.println("Loarded " + name + " party");
			Game.startGame(myPerso);
		} else {
			System.out.println("Save " + name + " not found creating new party " + name);
			myPerso = new Perso(name);
			Game.startGame(myPerso);
		}
	}
}
