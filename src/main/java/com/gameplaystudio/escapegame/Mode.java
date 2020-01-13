package com.gameplaystudio.escapegame;

public abstract class Mode {

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

	abstract void afficherLeResultat();

	abstract void afficherDescription();

	public void charge() {

		for (int i = 0; i <= 18; i++) {
			System.out.print("##");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println();
	}
}
