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
		logger.info("Sortie du mode défenseur");
		

	}

	@Override
	void lancer() {
		logger.info("Lancement du mode défenseur");
		System.out.println("Lancement du mode défenseur");
		//charge();

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
				propositionMachine = nextProposition(codePrecedent, indicationPrecedent);
			
				codePrecedent = propositionMachine;
				System.out
						.println("L'ordinateur vient de générer la proposition suivante: " + propositionMachine );
				comp = Collecteur.recupererComparaison(getMapping(codeSecret, propositionMachine), configuration.getNombredeChiffreCombi());
			
				indicationPrecedent = comp;
				System.out.println("Indication: " + comp);

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
