package com.gameplaystudio.escapegame;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Configuration {

	public int nombredeChiffreCombi;
	public int nombreEssai;
	public boolean modeDeveloppeur;

	public Configuration() {

		Properties prop = null;
		try {
			prop = new Properties();

			prop.load(Jeu.class.getResourceAsStream("/config.properties"));
			nombreEssai = Integer.valueOf(prop.getProperty("Nombre_essai", "11"));
			nombredeChiffreCombi = Integer.valueOf(prop.getProperty("Taille_combinaison", "4"));
			modeDeveloppeur = Boolean.valueOf(prop.getProperty("Mode_debug", "false"));
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public int getNombredeChiffreCombi() {
		return nombredeChiffreCombi;
	}

	public int getNombreEssai() {
		return nombreEssai;
	}

	public boolean isModeDeveloppeur() {
		return modeDeveloppeur;
	}

	public void showConfiguration() {
		System.out.println("Taille de la combinaison: " + nombredeChiffreCombi);
		System.out.println("Nombre_essai: " + nombreEssai);
		System.out.println("modeDeveloppeur: " + modeDeveloppeur);
	}
}
