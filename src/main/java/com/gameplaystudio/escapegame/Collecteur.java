package com.gameplaystudio.escapegame;

import java.util.Random;
import java.util.Scanner;

public class Collecteur {
	private static Scanner scanner = new Scanner(System.in);

	public static String recupererProposition(int taille, boolean isSecretCode) {
		boolean valeurCorecte = false;
		String saisi;
		do {
			if (isSecretCode) {
				System.out.print("Entrez votre code secret: ");
			} else {
				System.out.print("Entrez votre proposition: ");
			}

			saisi = scanner.next();
			try {
				Integer.valueOf(saisi);
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
		return saisi;
	}

	public static String genereCode(int taille) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < taille; i++) {
			sb.append(String.valueOf((new Random().nextInt(10))));
		}
		return sb.toString();
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

	public static int recupererReplay() {

		boolean valeurCorecte = false;
		int reponse = 0;
		System.out.println("Tapez 1 pour rejouer");
		System.out.println("Tapez 2 pour revenir au menu");
		System.out.println("Tapez 3 pour quitter");
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

	public static String recupererComparaison(String expected, int taille) {
		boolean valeurCorecte = false;
		String saisi = null;
		do {
			System.out.print("Entrez votre comparaison: ");
			saisi = scanner.next();
			int tailleEntree = saisi.length();
			if (tailleEntree == taille) {
				valeurCorecte = true;
				for (int i = 0; i < taille; i++) {
					char letter = saisi.charAt(i);
					if (!(letter == '-' || letter == '+' || letter == '=')) {
						valeurCorecte = false;
						System.out.println("Comparaison invalide, saisir +-=");
						break;
					}
				}
			} else {
				System.out.println("La taille n'est pas valide");
			}
		} while (!valeurCorecte || !expected.equals(saisi));
		return saisi;
	}

	public static int recupererParametreEntier(String message) {
		System.out.print(message);
		String saisi = scanner.next();
		return Integer.parseInt(saisi);
	}
	public static boolean recupererParametreBoolean(String message) {
		System.out.print(message);
		String saisi = scanner.next();
		return Boolean.valueOf(saisi);
	}
}
