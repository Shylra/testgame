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
	int shield = 0;
	Stuff stuff = new Stuff();
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

	public int useLifePot() {//à refaire : prendre un nom en paramettre et vérif si conso de vie
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

	public int useManaPot() {//à refaire : prendre un nom en paramettre et vérif si conso de mana
		for (Item item : inventory) {
			if (item.name == "ManaPot") {
				this.gainMP(10);
				return (2);
			}
		}
		System.out.println("no manaPot");
		return (2);
	}

	public int Equip(Item item) {
		if (item.slot == "none") {
			System.out.println("This item isn't equipable");
		} else if (item.slot == "rHand") {	
			if (this.stuff.rHand != null) {
				this.stuff.rHand.equiped = false;
				if (this.stuff.rHand.type == "weapon2H") {
					this.stuff.lHand = null;
				}
			}
			this.stuff.rHand = item;
			item.equiped = true;
			if (item.type == "weapon2H") {
				if (this.stuff.lHand != null) {
					this.stuff.lHand.equiped = false;
				}
				this.stuff.lHand = item;
			}
		} else if (item.slot == "lHand") {
			if (this.stuff.lHand != null) {
				this.stuff.lHand.equiped = false;
				if (this.stuff.lHand.type == "weapon2H") {
					this.stuff.rHand = null;
				}
			}
			this.stuff.lHand = item;
			item.equiped = true;
			if (item.type == "weapon2H") {
				if (this.stuff.rHand != null) {
					this.stuff.rHand.equiped = false;
				}
				this.stuff.rHand = item;
			}
		} else if (item.slot == "chest"){
			if (this.stuff.chest != null) {
				this.stuff.chest.equiped = false;
			}
			this.stuff.chest = item;
		} else if (item.slot == "head") {
			if (this.stuff.head != null) {
				this.stuff.head.equiped = false;
			}
			this.stuff.head = item;
		} else if (item.slot == "arms") {
			if (this.stuff.arms != null) {
				this.stuff.arms.equiped = false;
			}
			this.stuff.arms = item;
		} else if (item.slot == "legs") {
			if (this.stuff.legs != null) {
				this.stuff.legs.equiped = false;
			}
			this.stuff.legs = item;
		}
		return(2);
	}
	
	public int Damages(Skill skill) {// à voir pour le nom et les ratio de dégâts
		int damages = 0;
		if (skill.type == "damage") {
			for (int i = 0; i < skill.hits; i++) {
				if (this.stuff.rHand.type == "weapon") {
					damages += this.str + this.stuff.rHand.buffAtt + skill.buffAtt;
					i++;
					if (this.stuff.lHand.type == "weapon") {
						damages += this.str + this.stuff.lHand.buffAtt + skill.buffAtt;
						i++;
					}
				} else if (this.stuff.rHand.type == "weapon2H") {
					damages += this.str * 2 + this.stuff.rHand.buffAtt + skill.buffAtt;
					i++;
				}
			}
		} else if (skill.type =="shield") {
			this.shield += skill.shield;
		}
		return (damages);
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
