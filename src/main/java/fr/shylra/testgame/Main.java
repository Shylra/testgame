package fr.shylra.testgame;

public class Main {

	public static void main(String[] args) {
		if(args[0] == "new") {
			NewGame.newGame(args[1]);
		} else if (args[0] == "loard"){
			LoardGame.loardGame(args[1]);
		} else {
			System.out.println("1er argument incorrect please type \"new\" or \"loard\"");
		}
	}
}
