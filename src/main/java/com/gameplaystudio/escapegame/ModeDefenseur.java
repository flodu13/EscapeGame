package com.gameplaystudio.escapegame;

public class ModeDefenseur extends Mode {

	public ModeDefenseur(Configuration configuration) {
		this.configuration = configuration;
	}

	@Override
	void quitter() {
		// TODO Auto-generated method stub

	}

	@Override
	void lancer() {
		System.out.println("Lancement du mode défenseur");
		charge();

		if (configuration.isShowDescription()) {
			afficherDescription();
		}
		int codeSecret = Collecteur.recupererProposition(configuration.getNombredeChiffreCombi());
		setCodeSecretJoueur(codeSecret);
		System.out.println("Nous avons bien reçu votre code secret qui est: " + codeSecret);
		System.out.println("L'ordinateur va maintenant deviner votre code.");
		boolean leJoueurAPerdu = false;
		int nombreEssai = configuration.getNombreEssai();
		int nombreEssaiRestant = nombreEssai;

		while (!leJoueurAPerdu && nombreEssaiRestant > 0) {
			int propositionMachine = Collecteur.genereCode(configuration.getNombredeChiffreCombi());
			System.out.println("L'ordinateur vient de générer une proposition à "
					+ configuration.getNombredeChiffreCombi() + " chiffres :\n" + propositionMachine + ".");
			String comp = Collecteur.recupererComparaison(configuration.getNombredeChiffreCombi());
			nombreEssaiRestant--;
			if (isPropGagnant(comp)) {
				leJoueurAPerdu = true;
			}
			System.out.println(comp);
		}
		if (leJoueurAPerdu) {

			System.out.println("J'ai gagné en " + (nombreEssai - nombreEssaiRestant) + " essais");
		} else {

			System.out.println("J'ai perdu suite à " + nombreEssai + " essais");
		}
		afficherReplay();
	}

	@Override
	void afficherDescription() {
		System.out.println("Dans ce mode vous entrez un code aléatoire à " + configuration.getNombredeChiffreCombi()
				+ " chiffres,\net l'ordinateur doit deviner cette combinaison.\nNB: l'ordinateur à droit à "
				+ configuration.getNombreEssai() + " essais.");
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
