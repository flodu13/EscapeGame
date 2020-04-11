package com.gameplaystudio.escapegame;

import org.apache.log4j.Logger;

public class ModeDuel extends Mode {

	private String codePrecedent;
	private String indicationPrecedent;
	
	static Logger logger = Logger.getLogger(ModeDuel.class);

	public ModeDuel(Configuration configuration) {
		super(configuration);
	}

	@Override
	void quitter() {
		logger.info("Sortie du mode duel");
		System.out.println("Séquence d'arret du jeu enclenchée");
		System.exit(0);
	}

	@Override
	void lancer() {
		logger.info("Lancement du mode duel");
		System.out.println("Lancement du mode duel");
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
		if (configuration.isModeDeveloppeur()) {
			System.out.println("Le code secret généré par l'ordinateur est: " + codeSecret);
		}
		boolean leJoueurAPerdu = false;
		boolean machineAPerdu = false;
		boolean tourDuJoueur = false;
		int nombreEssai = configuration.getNombreEssai();
		int nombreEssaiRestantDeLaMachine = nombreEssai;
		int nombreEssaiRestantDuJoueur = nombreEssai;

		while (!leJoueurAPerdu && !machineAPerdu
				&& (nombreEssaiRestantDeLaMachine > 0 || nombreEssaiRestantDuJoueur > 0)) 
		
		{
			String comp = "";
			if (!tourDuJoueur) {
				String propositionMachine;
					propositionMachine = nextProposition(codePrecedent, indicationPrecedent);
				codePrecedent = propositionMachine;
				System.out.println("L'ordinateur vient de générer la proposition suivante: " + propositionMachine);
				comp = Collecteur.recupererComparaison(getMapping(codeSecretJoueur, propositionMachine), configuration.getNombredeChiffreCombi());
				indicationPrecedent = comp;
				System.out.println("Indication pour ordinateur: " + comp);

				nombreEssaiRestantDeLaMachine--;
				if (isPropGagnant(comp)) {
					leJoueurAPerdu = true;
				}
				tourDuJoueur = true;
			} else {
				String proposition = Collecteur.recupererProposition(configuration.getNombredeChiffreCombi(), false);
				comp = getMapping(codeSecret, proposition);
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
