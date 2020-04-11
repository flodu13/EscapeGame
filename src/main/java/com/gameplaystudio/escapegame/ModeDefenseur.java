package com.gameplaystudio.escapegame;

import org.apache.log4j.Logger;

public class ModeDefenseur extends Mode {

	private String codePrecedent;
	private String indicationPrecedent;
	static Logger logger = Logger.getLogger(ModeDefenseur.class);

	public ModeDefenseur(Configuration configuration) {
		super(configuration);
	}

	@Override
	void quitter() {
		logger.info("Sortie du mode d�fenseur");
		

	}

	@Override
	void lancer() {
		logger.info("Lancement du mode d�fenseur");
		System.out.println("Lancement du mode d�fenseur");
		//charge();

		if (configuration.isShowDescription()) {
			afficherDescription();
		}
		String codeSecret = Collecteur.recupererProposition(configuration.getNombredeChiffreCombi(), true);
		setCodeSecretJoueur(codeSecret);
		System.out.println("Nous avons bien re�u votre code secret qui est: " + codeSecret);
		System.out.println("L'ordinateur va maintenant deviner votre code.");
		boolean leJoueurAPerdu = false;
		int nombreEssai = configuration.getNombreEssai();
		int nombreEssaiRestant = nombreEssai;

		while (!leJoueurAPerdu && nombreEssaiRestant > 0) {
			String propositionMachine;
			String comp = "";
				propositionMachine = nextProposition(codePrecedent, indicationPrecedent);
			
				codePrecedent = propositionMachine;
				System.out
						.println("L'ordinateur vient de g�n�rer la proposition suivante: " + propositionMachine );
				comp = Collecteur.recupererComparaison(getMapping(codeSecret, propositionMachine), configuration.getNombredeChiffreCombi());
			
				indicationPrecedent = comp;
				System.out.println("Indication: " + comp);

			nombreEssaiRestant--;
			
		    	
		    	

			
			if (isPropGagnant(comp)) {
				leJoueurAPerdu = true;
			}
		}
		if (leJoueurAPerdu) {

			System.out.println("L'ordinateur � gagner " + (nombreEssai - nombreEssaiRestant) + " essais");
		} else {

			System.out.println(" L'ordinateur � perdu suite � " + nombreEssai + " essais");
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
