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
				.println("Veuillez trouver un code secret � " + configuration.getNombredeChiffreCombi() + " chiffres.");

		int codeSecretMachine = Collecteur.genereCode(configuration.getNombredeChiffreCombi());
		setCodeSecretMachine(codeSecretMachine);
		System.out.println("L'ordinateur vient de g�n�rer un code secret � " + configuration.getNombredeChiffreCombi()
				+ " chiffres.\n");
		int propositionJoueur = Collecteur.recupererProposition(configuration.getNombredeChiffreCombi());
		System.out.println("Vous avez entr� :" + propositionJoueur);
		String compMachinePourJoueur = getMapping(codeSecretMachine, propositionJoueur);
		System.out.println(compMachinePourJoueur);

		int propositionMachine = Collecteur.genereCode(configuration.getNombredeChiffreCombi());
		System.out.println("L'ordinateur vient de g�n�rer une proposition � " + configuration.getNombredeChiffreCombi()
				+ " chiffres :\n" + propositionMachine + ".");
		String compJoueurPourMachine = Collecteur.recupererComparaison(configuration.getNombredeChiffreCombi());
		System.out.println(compJoueurPourMachine);
		afficherReplay();
	}

	@Override
	void afficherDescription() {
		System.out.println("Dans ce mode vous (joueur) allez g�n�rer un code al�atoire de "
				+ configuration.getNombredeChiffreCombi()
				+ " chiffres\net l�ordinateur va g�n�rer un code al�atoire de "
				+ configuration.getNombredeChiffreCombi()
				+ " chiffres. Vous (joueur) et l'ordinateur jouez tour � tour.\nLe premier � trouver la combinaison a "
				+ configuration.getNombredeChiffreCombi() + " chiffres a gagn�");

	}

	@Override
	void afficherGagnant(int nombreEssai) {
		System.out.println("Bravo! Vous avez gagn� apr�s " + nombreEssai + " essais.");

	}

	@Override
	void afficherPerdant(int nombreEssai) {
		System.out.println("Vous avez perdu apr�s " + nombreEssai + " essais.");

	}

}
