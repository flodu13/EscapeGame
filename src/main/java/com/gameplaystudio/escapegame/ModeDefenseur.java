package com.gameplaystudio.escapegame;

public class ModeDefenseur extends Mode {

	private Configuration configuration;

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

	}

	@Override
	void afficherLeResultat() {
		// TODO Auto-generated method stub

	}

	@Override
	void afficherDescription() {
		System.out.println("Dans ce mode vous entrez un code al�atoire � " + configuration.getNombredeChiffreCombi()
				+ " chiffres,\net l'ordinateur doit deviner cette combinaison.\nNB: l'ordinateur � droit � "
				+ configuration.getNombreEssai() + " essais.");
	}

}
