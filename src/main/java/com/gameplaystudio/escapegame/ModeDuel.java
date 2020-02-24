package com.gameplaystudio.escapegame;

public class ModeDuel extends Mode {
	public ModeDuel(Configuration configuration) {
		this.configuration = configuration;
	}

	@Override
	void quitter() {
		// TODO Auto-generated method stub

	}

	@Override
	void lancer() {
		System.out.println("Lancement du mode duel");
		charge();

		if (configuration.isShowDescription()) {
			afficherDescription();
		}
		System.out
				.println("Veuillez trouver un code secret à " + configuration.getNombredeChiffreCombi() + " chiffres.");

		int codeSecretMachine = Collecteur.genereCode(configuration.getNombredeChiffreCombi());
		setCodeSecretMachine(codeSecretMachine);
		System.out.println("L'ordinateur vient de générer un code secret à " + configuration.getNombredeChiffreCombi()
				+ " chiffres.\n");
		int propositionJoueur = Collecteur.recupererProposition(configuration.getNombredeChiffreCombi());
		System.out.println("Vous avez entré :" + propositionJoueur);
		String compMachinePourJoueur = getMapping(codeSecretMachine, propositionJoueur);
		System.out.println(compMachinePourJoueur);

		int propositionMachine = Collecteur.genereCode(configuration.getNombredeChiffreCombi());
		System.out.println("L'ordinateur vient de générer une proposition à " + configuration.getNombredeChiffreCombi()
				+ " chiffres :\n" + propositionMachine + ".");
		String compJoueurPourMachine = Collecteur.recupererComparaison(configuration.getNombredeChiffreCombi());
		System.out.println(compJoueurPourMachine);
		afficherReplay();
	}

	@Override
	void afficherDescription() {
		System.out.println("Dans ce mode vous (joueur) allez générer un code aléatoire de "
				+ configuration.getNombredeChiffreCombi()
				+ " chiffres\net l’ordinateur va générer un code aléatoire de "
				+ configuration.getNombredeChiffreCombi()
				+ " chiffres. Vous (joueur) et l'ordinateur jouez tour à tour.\nLe premier à trouver la combinaison a "
				+ configuration.getNombredeChiffreCombi() + " chiffres a gagné");

	}

	@Override
	void afficherGagnant(int nombreEssai) {
		System.out.println("Bravo! Vous avez gagné après " + nombreEssai + " essais.");

	}

	@Override
	void afficherPerdant(int nombreEssai) {
		System.out.println("Vous avez perdu après " + nombreEssai + " essais.");

	}

}
