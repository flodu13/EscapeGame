package com.gameplaystudio.escapegame;

import java.util.Random;
import java.util.Scanner;

public class Collecteur {
	private static Scanner scanner = new Scanner(System.in);

	public static int recupererProposition(int taille) {

		boolean valeurCorecte = false;
		int reponse = 0;
		do {
			System.out.print("Entrez votre proposition: ");
			String saisi = scanner.next();
			try {
				reponse = Integer.parseInt(saisi);
				int tailleEntree = saisi.length();
				if (tailleEntree == taille) {
					valeurCorecte = true;
				} else {
					System.out.println("La taille n'est pas valide");
				}
			} catch (Exception e) {
				System.out.println("La proposition n'est pas correcte");
			}
		} while (!valeurCorecte);
		return reponse;
	}

	public static int genereCode(int taille) {
		return new Random().nextInt((int) Math.pow(10, taille));
	}

	public static int recupererModeChoisi() {

		boolean valeurCorecte = false;
		int reponse = 0;
		do {
			System.out.print("Saisir votre choix: ");
			String saisi = scanner.next();
			try {
				reponse = Integer.parseInt(saisi);
				int tailleEntree = saisi.length();
				if (tailleEntree == 1 && reponse >= 1 && reponse <= 5) {
					valeurCorecte = true;
				} else {
					System.out.println("Veuillez saisir entre 1 et 5");
				}
			} catch (Exception e) {
				System.out.println("La valeur entrée n'est pas correcte");
			}
		} while (!valeurCorecte);
		return reponse;
	}
}
