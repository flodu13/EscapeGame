package com.gameplaystudio.escapegame;

public class ModeChallenger extends Mode {

	private Configuration configuration;

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
		int proposition = Collecteur.recupererProposition(configuration.getNombredeChiffreCombi());
		System.out.println("Vous avez entré :" + proposition);
	}

	@Override
	void afficherLeResultat() {
		comparaisonCodegenererCodeCodeJoueur();

	}

	@Override
	void afficherDescription() {
		System.out.println(
				"Dans ce mode l'ordinateur va générer un code secret à " + configuration.getNombredeChiffreCombi()
						+ " chiffres,\net vous(joueur) devez deviner cette combinaison.\nNB: vous avez droit à "
						+ configuration.getNombreEssai() + " essais.");
	}

	public void comparaisonCodegenererCodeCodeJoueur() {

		String result = "";
		for (int i = 0; i <= configuration.getNombredeChiffreCombi(); i++) {
			char digitMachine = Integer.toString(getCodeSecretMachine()).charAt(i);
			char digitjoueur = Integer.toString(getCodeSecretJoueur()).charAt(i);
			if (digitMachine == digitjoueur) {
				result = result + '=';
			} else if (digitMachine > digitjoueur) {
				result = result + "-";
			} else {
				result = result + "+";
			}
		}
		System.out.println(result);
	}
}
