package com.gameplaystudio.escapegame;

public abstract class Mode {

	protected Configuration configuration;
	protected String description;
	protected int codeSecretMachine;

	public int getCodeSecretMachine() {
		return codeSecretMachine;
	}

	public void setCodeSecretMachine(int codeSecretMachine) {
		this.codeSecretMachine = codeSecretMachine;
	}

	protected int codeSecretJoueur;

	public int getCodeSecretJoueur() {
		return codeSecretJoueur;
	}

	public void setCodeSecretJoueur(int codeSecretJoueur) {
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

	protected String getMapping(int codeSecret, int proposition) {
		String result = "";
		String code = String.valueOf(codeSecret);
		// code = "012345";
		String prop = String.valueOf(proposition);
		for (int i = 0; i < configuration.getNombredeChiffreCombi(); i++) {
			int digitCode = Integer.valueOf(code.charAt(i));
			int digitProp = Integer.valueOf(prop.charAt(i));
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
}
