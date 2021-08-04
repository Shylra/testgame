package fr.shylra.testgame;

import java.util.ArrayList;
import java.util.Scanner;

public class Perso {
	String name;
	int lvl = 1;
	int exp = 0;
	int str = 10;
	int con = 10;
	int dex = 10;
	int agi = 10;
	int luck = 10;
	int maxHP = this.lvl * 10 + this.con * 5;
	int currentHP = this.maxHP;
	int maxMP = this.lvl * 5;// + this.int * 10
	int currentMP = this.maxMP;
	ArrayList<Skill> skills = new ArrayList<Skill>();
	ArrayList<Item> inventory = new ArrayList<Item>();

	Perso(String name) {
		this.name = name;
	}

	public int lostHP(int life) {
		if (life < this.currentHP) {
			this.currentHP -= life;
			return (1);
		} else {
			return (0);
		}
	}

	public int gainHP(int life) {
		this.currentHP += life;
		if (this.maxHP < this.currentHP) {
			this.currentHP = this.maxHP;
		}
		return (1);
	}

	public int lostMP(int mana) {
		if (mana < this.currentMP) {
			this.currentMP -= mana;
			return (1);
		} else {
			return (0);
		}
	}

	public int gainMP(int mana) {
		this.currentMP += mana;
		if (this.maxMP < this.currentMP) {
			this.currentMP = this.maxMP;
		}
		return (1);
	}

	public int listInventory() {
		for (Item item : inventory) {
			System.out.println(item);
		}
		return (1);
	}

	public int useLifePot() {
		for (Item item : inventory) {
			if (item.name == "lifePot") {
				this.gainHP(20);
				inventory.remove(item);
				return (2);
			}
		}
		System.out.println("no lifePot");
		return (2);
	}

	public int useManaPot() {
		for (Item item : inventory) {
			if (item.name == "ManaPot") {
				this.gainMP(10);
				return (2);
			}
		}
		System.out.println("no manaPot");
		return (2);
	}

	public int gainlvl() {
		boolean bool = false;
		while (!bool) {
			Scanner saisieUtilisateur = new Scanner(System.in);
			System.out.println("Congratulation, LVL UP!\nChoississez une stat à up:\nstr : 1, con : 2, dex : 3, agi : 4");
			int stat = saisieUtilisateur.nextInt();
			saisieUtilisateur.close();
			this.lvl++;
			this.maxHP = this.lvl * 10 + this.con * 5;
			this.currentHP = this.maxHP;
			this.maxMP = this.lvl * 5;// + this.int * 10;
			this.currentMP = this.maxMP;
			switch (stat) {
				case 1:
					this.str++;
					bool = true;
					break;
				case 2:
					this.con++;
					bool = true;
					break;
				case 3:
					this.dex++;
					bool = true;
					break;
				case 4:
					this.agi++;
					bool = true;
					break;
				default:
					System.out.println("please enter 1, 2, 3, or 4");
			}
		}
		return (2);
	}

	public int gainexp(int experience) {
		this.exp += experience;
		if (this.exp >= 100) {
			this.exp -= 100;
			this.gainlvl();
		}
		return (2);
	}
}
