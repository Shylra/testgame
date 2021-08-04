package fr.shylra.testgame;

public class NewGame {
	public static void newGame(String name) {
		Perso myPerso = new Perso(name);
		Game.startGame(myPerso);
	}
}
