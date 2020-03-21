package com.gameplaystudio.escapegame;

public class Jeu {
	private String name;
	private String description;
	private Mode currentMode;
	private Configuration configuration;

	public Jeu() {
		this.name = "escape game";
		this.configuration = new Configuration();
		this.description = "Le principe de ce jeu est de r�soudre, en �quipe, une s�rie d��nigmes sc�naris�es pour pouvoir sortir de la pi�ce dans le temps imparti.\r\n";
	}

	public void lancer() {

		System.out.println("=====================================");
		System.out.println("= Bienvenue dans le jeu " + name + " =");
		System.out.println("=====================================");
		System.out.println(description);
		// configuration.showConfiguration();
	}

	public void quitter() {
		System.out.println("S�quence d'arret du jeu enclench�e");

		System.exit(0);
	}

	public void changerMode() {
		System.out.println("changement de mode");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void afficheMenu() {
		System.out.println("*************************************");
		System.out.println("Taper 1 pour lancer le mode d�fenseur");
		System.out.println("Taper 2 pour lancer le mode challenger");
		System.out.println("Taper 3 pour lancer le mode duel");
		System.out.println("Taper 4 pour modifier les param�tres du jeu");
		System.out.println("Taper 5 pour quitter le jeu");
		System.out.println("***************************************");
	}

	public void changerMode(int mode) {
		if (mode == 1) {
			currentMode = new ModeDefenseur(configuration);
		} else if (mode == 2) {
			currentMode = new ModeChallenger(configuration);
		} else if (mode == 3) {
			currentMode = new ModeDuel(configuration);
		} else if (mode == 4) {
			System.out.println("Modification des param�tres du jeu");
		} else if (mode == 5) {

			quitter();
		}
		if (currentMode != null) {
			currentMode.lancer();
		}
	}

}
