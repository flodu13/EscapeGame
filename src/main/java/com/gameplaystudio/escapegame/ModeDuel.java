package com.gameplaystudio.escapegame;

public class ModeDuel extends Mode {

	private Configuration configuration;

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

	}

	@Override
	void afficherLeResultat() {
		// TODO Auto-generated method stub

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

}
