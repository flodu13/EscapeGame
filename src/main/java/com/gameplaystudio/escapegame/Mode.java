package com.gameplaystudio.escapegame;

import java.util.Random;

public abstract class Mode {

	protected Configuration configuration;
	protected String description;
	protected String codeSecretMachine;

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

	protected void charge() {

		for (int i = 0; i <= 18; i++) {
			System.out.print("##");
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println();
	}

	protected void delay(int secondes) {

		try {
			Thread.sleep(secondes);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

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
		char[] indications = String.valueOf(indication).toCharArray();
		String chiffres = String.valueOf(code);
		
		StringBuilder proposition = new StringBuilder();
		for (int i = 0; i < indications.length; i++) {
			int chiffre = Character.digit(chiffres.charAt(i), 10);
			String indicatif = String.valueOf(indications[i]);
			int newValue;
			if (indicatif.equalsIgnoreCase("=")) {
				proposition.append(chiffre);
			} else if (indicatif.equalsIgnoreCase("+")) {
				
				int min = (chiffre+1);
				int max = 10;
				newValue = new Random().nextInt((max - min)) + min;
				proposition.append(newValue);
			} else if (indicatif.equalsIgnoreCase("-")) {
				newValue = new Random().nextInt((chiffre));
				proposition.append(newValue);
			}

		}
	
		return proposition.toString();
	}
	
	
}
