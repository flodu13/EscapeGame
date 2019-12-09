package com.gameplaystudio.escapegame;

import java.util.Scanner;

public class ModeChallenger {
	private StrategieJAttaque strategieJAttaque = new StrategieJAttaque();

	public void jouer(Configuration configuration) {
		int cpt = 0;
		Scanner scanner = new Scanner(System.in);
		String reponseIA;
		do {
			int saisieJoueur = scanner.nextInt();
			reponseIA = strategieJAttaque.verification(saisieJoueur);
			System.out.println(reponseIA);
			cpt++;

		} while (!reponseIA.equals("=") && cpt < configuration.getNombreEssai());

		scanner.close();
	}

//TODO DELETE
	public static void main(String[] args) {
		new ModeChallenger().jouer(new Configuration());
	}
}
