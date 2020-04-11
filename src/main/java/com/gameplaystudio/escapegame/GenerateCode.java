package com.gameplaystudio.escapegame;

import java.util.Arrays;
import java.util.Random;

public class GenerateCode {

	private int[] min;
	private int[] max;

	public GenerateCode(int nombreDeChiffreCombi) {

		min = new int[nombreDeChiffreCombi];
		max = new int[nombreDeChiffreCombi];

		Arrays.fill(min, 0);
		Arrays.fill(max, 9);

	}

	public String generateCode(String code, String indication) {
		if (code != null) {

			char[] indications = indication.toCharArray();

			for (int i = 0; i < indications.length; i++) {
				int chiffre = Character.digit(code.charAt(i), 10);
				String indicatif = String.valueOf(indications[i]);
				if (indicatif.equalsIgnoreCase("=")) {
					min[i] = chiffre;
					max[i] = chiffre;
				} else if (indicatif.equalsIgnoreCase("+")) {

					min[i] = (chiffre + 1);

				} else if (indicatif.equalsIgnoreCase("-")) {

					max[i] = (chiffre - 1);
				}

			}

		}

		StringBuilder proposition = new StringBuilder();
		for (int i = 0; i < min.length; i++) {
			if (max[i] == min[i]) {
				proposition.append(max[i]);
			} else {
				proposition.append(new Random().nextInt((max[i] - min[i])) + min[i]);
			}
		}
		return proposition.toString();

	}

}
