package com.gameplaystudio.escapegame;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class Configuration {

	private int nombredeChiffreCombi;
	private int nombreEssai;
	private boolean modeDeveloppeur;
	private boolean showDescription;

	public boolean isShowDescription() {
		return showDescription;
	}

	public void setShowDescription(boolean showDescription) {
		this.showDescription = showDescription;
	}

	public Configuration() {

		Properties prop = null;
		try {
			String fullPath = getConfigPath();
			File fichierConfig = new File (fullPath);
			System.out.println("*********" + fichierConfig.getPath());
			if (fichierConfig.exists()) {
				prop = new Properties();
				InputStream input = new FileInputStream(fullPath);
				prop.load(input);
				nombreEssai = Integer.valueOf(prop.getProperty("Nombre_essai", "11"));
				nombredeChiffreCombi = Integer.valueOf(prop.getProperty("Taille_combinaison", "4"));
				modeDeveloppeur = Boolean.valueOf(prop.getProperty("Mode_debug", "false"));
				showDescription = Boolean.valueOf(prop.getProperty("ShowDescription", "false"));
			} else {
				prop = new Properties();

				prop.load(Jeu.class.getResourceAsStream("/config.properties"));
				nombreEssai = Integer.valueOf(prop.getProperty("Nombre_essai", "11"));
				nombredeChiffreCombi = Integer.valueOf(prop.getProperty("Taille_combinaison", "4"));
				modeDeveloppeur = Boolean.valueOf(prop.getProperty("Mode_debug", "false"));
				showDescription = Boolean.valueOf(prop.getProperty("ShowDescription", "false"));
				saveConfiguration(nombreEssai,nombredeChiffreCombi, modeDeveloppeur, showDescription);
			}
			
			
			
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	private String getConfigPath() {
		String path = System.getProperty("user.home");
		String fullPath = path +File.separator+ "config.properties";
		return fullPath;
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
	
	public void saveConfiguration (int nbEssais, int tailleCombinaison, boolean modeDebug, boolean showDescription) {
		try (OutputStream output = new FileOutputStream(getConfigPath())) {

            Properties prop = new Properties();

            prop.setProperty("Nombre_essai", String.valueOf(nbEssais));
            prop.setProperty("Taille_combinaison", String.valueOf(tailleCombinaison));
            prop.setProperty("Mode_debug", String.valueOf(modeDebug));
            prop.setProperty("ShowDescription", String.valueOf(showDescription));

            prop.store(output, null);

            System.out.println(prop);

        } catch (IOException io) {
            io.printStackTrace();
        }

	}
}
