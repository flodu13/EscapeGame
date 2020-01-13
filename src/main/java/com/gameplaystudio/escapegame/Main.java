package com.gameplaystudio.escapegame;

public class Main {

	public static void main(String[] args) {
		Jeu jeu = new Jeu();
		jeu.lancer();
		jeu.afficheMenu();
		int choix = Collecteur.recupererModeChoisi();
		jeu.changerMode(choix);

	}

}
