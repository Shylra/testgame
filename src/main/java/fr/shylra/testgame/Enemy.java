package fr.shylra.testgame;

import java.util.ArrayList;
import java.util.Random;

public class Enemy {
	String name;
	int lvl;
	int str;
	int con;
	int dex;
	int agi;
	int luck;
	int maxHP;
	int currentHP;
	int maxMP;
	int currentMP;
	ArrayList<Skill> skills = new ArrayList<Skill>();
	ArrayList<Item> inventory = new ArrayList<Item>();
	
	Enemy(String name, int lvl){
		Random random = new Random();
		this.name = name;
		this.lvl = lvl + random.nextInt(2);
		this.str = 10 + random.nextInt(this.lvl / 3);
		this.con = 10 + random.nextInt(this.lvl / 3);
		this.dex = 10 + random.nextInt(this.lvl / 3);
		this.agi = 10 + random.nextInt(this.lvl / 3);
		this.luck = random.nextInt(this.lvl);
		this.maxHP =  this.lvl * 10 + this.con * 5;
		this.currentHP = this.maxHP;
		this.maxMP = this.lvl * 5;// + this.int * 10
		this.currentMP = this.maxMP;
	}
	
	public int lostHP(int life) {
		if (life < this.currentHP) {
			this.currentHP -= life;
			return (1);
		} else {
			return (0);
		}
	}
	
	public int lostMP(int mana) {
		if (mana < this.currentMP) {
			this.currentMP -= mana;
			return (1);
		} else {
			return (0);
		}
	}
	
	//générer l'inventaire nb d'item en fonction du lvl
	
	//générer les skills
}
