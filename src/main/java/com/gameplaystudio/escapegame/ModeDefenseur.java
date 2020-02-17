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
		System.out.println("Lancement du mode d�fenseur");
		charge();

		if (configuration.isShowDescription()) {
			afficherDescription();
		}
		int codeSecret = Collecteur.recupererProposition(configuration.getNombredeChiffreCombi());
		setCodeSecretJoueur(codeSecret);
		System.out.println("Nous avons bien re�u votre code secret qui est: " + codeSecret);
		System.out.println("L'ordinateur va maintenant deviner votre code.");
		boolean leJoueurAPerdu = false;
		int nombreEssai = configuration.getNombreEssai();
		int nombreEssaiRestant = nombreEssai;

		while (!leJoueurAPerdu && nombreEssaiRestant > 0) {
			int propositionMachine = Collecteur.genereCode(configuration.getNombredeChiffreCombi());
			System.out.println("L'ordinateur vient de g�n�rer une proposition � "
					+ configuration.getNombredeChiffreCombi() + " chiffres :\n" + propositionMachine + ".");
			String comp = Collecteur.recupererComparaison(configuration.getNombredeChiffreCombi());
			nombreEssaiRestant--;
			if (isPropGagnant(comp)) {
				leJoueurAPerdu = true;
			}
			System.out.println(comp);
		}
		if (leJoueurAPerdu) {

			System.out.println("J'ai gagn� en " + (nombreEssai - nombreEssaiRestant) + " essais");
		} else {

			System.out.println("J'ai perdu suite � " + nombreEssai + " essais");
		}
		afficherReplay();
	}

	@Override
	void afficherDescription() {
		System.out.println("Dans ce mode vous entrez un code al�atoire � " + configuration.getNombredeChiffreCombi()
				+ " chiffres,\net l'ordinateur doit deviner cette combinaison.\nNB: l'ordinateur � droit � "
				+ configuration.getNombreEssai() + " essais.");
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
