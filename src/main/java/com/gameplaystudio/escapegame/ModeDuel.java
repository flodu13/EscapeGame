package com.gameplaystudio.escapegame;

public class ModeDuel extends Mode {

	private String codePrecedent;
	private String indicationPrecedent;

	public ModeDuel(Configuration configuration) {
		this.configuration = configuration;
	}

	@Override
	void quitter() {
		System.out.println("Séquence d'arret du jeu enclenchée");
		System.exit(0);
	}

	@Override
	void lancer() {
		System.out.println("Lancement du mode duel");
		charge();
		if (configuration.isShowDescription()) {
			afficherDescription();
		}
		String codeSecretJoueur = Collecteur.recupererProposition(configuration.getNombredeChiffreCombi(), true);
		System.out.println("Nous avons bien reçu votre code secret qui est: " + codeSecretJoueur);
		System.out.println("L'ordinateur va maintenant générer son code secret.");
		setCodeSecretJoueur(codeSecretJoueur);
		String codeSecret = Collecteur.genereCode(configuration.getNombredeChiffreCombi());
		setCodeSecretMachine(codeSecret);
		System.out.println("L'ordinateur a déjà générer son code secret.");

		boolean leJoueurAPerdu = false;
		boolean machineAPerdu = false;
		boolean tourDuJoueur = false;
		int nombreEssai = configuration.getNombreEssai();
		int nombreEssaiRestantDeLaMachine = nombreEssai;
		int nombreEssaiRestantDuJoueur = nombreEssai;

		while (!leJoueurAPerdu && !machineAPerdu
				&& (nombreEssaiRestantDeLaMachine > 0 || nombreEssaiRestantDuJoueur > 0)) {
			if (!tourDuJoueur) {
				String propositionMachine;
				if (nombreEssaiRestantDeLaMachine == nombreEssai) {
					propositionMachine = Collecteur.genereCode(configuration.getNombredeChiffreCombi());
				} else {
					propositionMachine = nextProposition(codePrecedent, indicationPrecedent);
				}
				codePrecedent = propositionMachine;
				delay(1000 * 5);
				System.out.println("L'ordinateur vient de générer la proposition suivante: " + propositionMachine);
				String comp = getMapping(codeSecretJoueur, propositionMachine);
				indicationPrecedent = comp;
				System.out.println("Indication pour ordinateur: " + comp);

				nombreEssaiRestantDeLaMachine--;
				if (isPropGagnant(comp)) {
					leJoueurAPerdu = true;
				}
				tourDuJoueur = true;
			} else {
				String proposition = Collecteur.recupererProposition(configuration.getNombredeChiffreCombi(), false);
				String comp = getMapping(codeSecretMachine, proposition);
				nombreEssaiRestantDuJoueur--;
				if (isPropGagnant(comp)) {
					machineAPerdu = true;
				} else {
					System.out.println("Indication pour joueur: " + comp);
				}
				tourDuJoueur = false;
			}
		}
		if (leJoueurAPerdu) {
			System.out.println("L'ordinateur à gagner " + (nombreEssai - nombreEssaiRestantDeLaMachine) + " essais");
		} else if (machineAPerdu) {
			System.out.println("Le joueur à gagner " + (nombreEssai - nombreEssaiRestantDuJoueur) + " essais");
		} else {
			System.out.println("L'ordinateur et le joueur ont perdu suite à " + nombreEssai + " essais");
		}

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
