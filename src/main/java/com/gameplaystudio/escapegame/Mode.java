package com.gameplaystudio.escapegame;

import java.util.Random;

public abstract class Mode {

	protected Configuration configuration;
	protected String description;
	protected String codeSecretMachine;
	private GenerateCode generateCode;

	protected Mode(Configuration configuration) {
		this.configuration = configuration;
		generateCode = new GenerateCode(configuration.getNombredeChiffreCombi());
	}

	public String getCodeSecretMachine() {
		return codeSecretMachine;
	}

	public void setCodeSecretMachine(String codeSecretMachine) {
		this.codeSecretMachine = codeSecretMachine;
	}

	protected String codeSecretJoueur;

	public String getCodeSecretJoueur() {
		return codeSecretJoueur;
	}

	public void setCodeSecretJoueur(String codeSecretJoueur) {
		this.codeSecretJoueur = codeSecretJoueur;
	}

	abstract void quitter();

	abstract void lancer();

	abstract void afficherGagnant(int nombreEssai);

	abstract void afficherPerdant(int nombreEssai);

	abstract void afficherDescription();

	protected String getMapping(String codeSecret, String proposition) {
		String result = "";
		for (int i = 0; i < configuration.getNombredeChiffreCombi(); i++) {
			int digitCode = Integer.valueOf(codeSecret.charAt(i));
			int digitProp = Integer.valueOf(proposition.charAt(i));
			if (digitCode == digitProp) {
				result = result + '=';
			} else if (digitCode > digitProp) {
				result = result + "+";
			} else {
				result = result + "-";
			}
		}

		return result;
	}

	protected boolean isPropGagnant(String comp) {
		for (char lettre : comp.toCharArray()) {
			if (lettre != '=') {
				return false;
			}
		}
		return true;

	}

	protected void afficherReplay() {
		int replay = Collecteur.recupererReplay();
		if (replay == 1) {
			lancer();
		} else if (replay == 2) {
			Main.main(null);
		} else {
			quitter();
		}

	}

	protected String nextProposition(String code, String indication) {
		return generateCode.generateCode(code, indication);

	}
}
