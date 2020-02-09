package com.gameplaystudio.escapegame;

public class ModeChallenger extends Mode {

	public ModeChallenger(Configuration configuration) {
		this.configuration = configuration;
	}

	@Override
	void quitter() {
		// TODO Auto-generated method stub

	}

	@Override
	void lancer() {
		System.out.println("Lancement du mode challenger");
		charge();
		if (configuration.isShowDescription()) {
			afficherDescription();
		}
		int codeSecret = Collecteur.genereCode(configuration.getNombredeChiffreCombi());
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
			int proposition = Collecteur.recupererProposition(configuration.getNombredeChiffreCombi());
			String comp = getMapping(codeSecret, proposition);
			nombreEssaiRestant--;
			if (isPropGagnant(comp)) {
				leJoueurAGagner = true;
				System.out.println("Vous avez gagnez après " + (nombreEssai - nombreEssaiRestant) + " essai(s).");
			} else {
				System.out.println("Indication: " + comp);
			}
		}
		System.out.println("Vous avez épuise vos " + nombreEssai + " essais");
	}

	@Override
	void afficherLeResultat() {

	}

	@Override
	void afficherDescription() {
		System.out.println(
				"Dans ce mode l'ordinateur va générer un code secret à " + configuration.getNombredeChiffreCombi()
						+ " chiffres,\net vous(joueur) devez deviner cette combinaison.\nNB: vous avez droit à "
						+ configuration.getNombreEssai() + " essais.");
	}

}
