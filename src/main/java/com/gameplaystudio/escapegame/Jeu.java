package com.gameplaystudio.escapegame;

public class Jeu {
	private String name;
	private String description;
	private Configuration configuration;

	public Jeu() {
		this.name = "escape game";
		this.configuration = new Configuration();
		this.description = "Ce jeu principe est de résoudre, en équipe, une série d’énigmes scénarisées pour pouvoir sortir de la pièce dans le temps imparti.\r\n";
	}

	public void lancer() {

		System.out.println("=====================================");
		System.out.println("= Bienvenue dans le jeu " + name + " =");
		System.out.println("=====================================");
		System.out.println(description);
		configuration.showConfiguration();
	}

	public void quitter() {
		System.out.println("fin du jeu");
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

}
