package com.gameplaystudio.escapegame;

public class ModeDefenseur extends Mode {

	private String codePrecedent;
	private String indicationPrecedent;

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
		String codeSecret = Collecteur.recupererProposition(configuration.getNombredeChiffreCombi(), true);
		setCodeSecretJoueur(codeSecret);
		System.out.println("Nous avons bien reçu votre code secret qui est: " + codeSecret);
		System.out.println("L'ordinateur va maintenant deviner votre code.");
		boolean leJoueurAPerdu = false;
		int nombreEssai = configuration.getNombreEssai();
		int nombreEssaiRestant = nombreEssai;

		while (!leJoueurAPerdu && nombreEssaiRestant > 0) {
			String propositionMachine;
			String comp = "";
			if (nombreEssaiRestant == nombreEssai) {
				propositionMachine = Collecteur.genereCode(configuration.getNombredeChiffreCombi());
				codePrecedent = propositionMachine;
				delay(1000 * 5);
				System.out
						.println("L'ordinateur vient de générer la proposition suivante: " + propositionMachine );
				comp = getMapping(codeSecret, propositionMachine);
				indicationPrecedent = comp;
				System.out.println("Indication: " + comp);
			} else {
				String recup = nextProposition(codePrecedent, indicationPrecedent);
				codePrecedent = recup;
				delay(1000 * 5);
				System.out.println("L'ordinateur vient de générer la proposition suivante: " + recup );
				comp = getMapping(codeSecret, recup);
				indicationPrecedent = comp;
				System.out.println("Indication: " + comp);
			}

			nombreEssaiRestant--;
			if (isPropGagnant(comp)) {
				leJoueurAPerdu = true;
			}
		}
		if (leJoueurAPerdu) {

			System.out.println("L'ordinateur à gagner " + (nombreEssai - nombreEssaiRestant) + " essais");
		} else {

			System.out.println(" L'ordinateur à perdu suite à " + nombreEssai + " essais");
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
