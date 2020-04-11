package com.gameplaystudio.escapegame;

import org.apache.log4j.Logger;

public class ModeChallenger extends Mode {

	static Logger logger = Logger.getLogger(ModeChallenger.class);

	
	public ModeChallenger(Configuration configuration) {
		super(configuration);
	}

	@Override
	void quitter() {
		logger.info("Sortie du mode challenger");
		System.out.println("Séquence d'arret du jeu enclenchée");
		System.exit(0);

	}

	@Override
	void lancer() {
		logger.info("Lancement du mode challenger");
		System.out.println("Lancement du mode challenger");
		if (configuration.isShowDescription()) {
			afficherDescription();
		}
		String codeSecret = Collecteur.genereCode(configuration.getNombredeChiffreCombi());
		setCodeSecretMachine(codeSecret);
		System.out.println("L'ordinateur vient de générer un code secret à " + configuration.getNombredeChiffreCombi()
				+ " chiffres.\n");
		if (configuration.isModeDeveloppeur()) {
			System.out.println("Le code secret généré par l'ordinateur est: " + codeSecret);
		}
		boolean leJoueurAGagner = false;
		int nombreEssai = configuration.getNombreEssai();
		int nombreEssaiRestant = nombreEssai;
		while (!leJoueurAGagner && nombreEssaiRestant > 0) {
			String proposition = Collecteur.recupererProposition(configuration.getNombredeChiffreCombi(), false);
			String comp = getMapping(codeSecret, proposition);
			nombreEssaiRestant--;
			if (isPropGagnant(comp)) {
				leJoueurAGagner = true;

			} else {
				System.out.println("Indication: " + comp);
			}
		}
		if (!leJoueurAGagner) {
			afficherPerdant(nombreEssai);
		} else {
			afficherGagnant(nombreEssai - nombreEssaiRestant);
		}
		afficherReplay();
	}

	@Override
	void afficherDescription() {
		System.out.println(
				"Dans ce mode l'ordinateur va générer un code secret à " + configuration.getNombredeChiffreCombi()
						+ " chiffres,\net vous(joueur) devez deviner cette combinaison.\nNB: vous avez droit à "
						+ configuration.getNombreEssai() + " essais.");
	}

	@Override
	void afficherGagnant(int nombreEssai) {
		System.out.println("Bravo! Vous avez gagné après " + nombreEssai + " essais.");
	}

	@Override
	void afficherPerdant(int nombreEssai) {
		System.out.println("Vous avez perdu après " + nombreEssai + " essais.");
		System.out.println("Le code secret était : " + getCodeSecretMachine());
	}

}
